package de.tudarmstadt.dvs.ukuflow.handler;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//import org.jdom2.
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.internal.WorkbenchMessages;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.dialogs.EventLoopProgressMonitor;
import org.eclipse.ui.internal.misc.StatusUtil;
import org.eclipse.ui.model.WorkbenchPartLabelProvider;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;

import de.tudarmstadt.dvs.ukuflow.converter.Activator;
import de.tudarmstadt.dvs.ukuflow.preference.UkuPreference;
import de.tudarmstadt.dvs.ukuflow.script.generalscript.ScopeManager;
import de.tudarmstadt.dvs.ukuflow.tools.Base64Converter;
import de.tudarmstadt.dvs.ukuflow.tools.QuickFileReader;
import de.tudarmstadt.dvs.ukuflow.tools.debugger.BpmnLog;
import de.tudarmstadt.dvs.ukuflow.validation.ErrorManager;
import de.tudarmstadt.dvs.ukuflow.validation.ErrorMessage;
import de.tudarmstadt.dvs.ukuflow.validation.UkuProcessValidation;
import de.tudarmstadt.dvs.ukuflow.xml.BPMN2XMLParser;
import de.tudarmstadt.dvs.ukuflow.xml.ProcessOptimizer;
import de.tudarmstadt.dvs.ukuflow.xml.entity.ElementVisitorImpl;
import de.tudarmstadt.dvs.ukuflow.xml.entity.UkuElement;
import de.tudarmstadt.dvs.ukuflow.xml.entity.UkuEntity;
import de.tudarmstadt.dvs.ukuflow.xml.entity.UkuProcess;

@SuppressWarnings("restriction")
public class ConvertCommand extends AbstractHandler {
	/**
	 * Console name
	 */
	private static BpmnLog log = BpmnLog.getInstance(ConvertCommand.class
			.getSimpleName());
	private static UkuConsole console = UkuConsole.getConsole();
	/**
	 * 
	 * @param file
	 */
	private static void deleteMarker(IFile file) {
		try {
			file.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		boolean validateonly = new Boolean(
				event.getParameter("de.tudarmstadt.dvs.ukuflow.convert.validateonly"));		
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil
				.getActiveMenuSelection(event);
		Object firstElement = selection.getFirstElement();
		if (selection.size() != 1) {
			MessageDialog.openInformation(HandlerUtil.getActiveShell(event),
					"Information", "Please choose just one BPMN2 file");
			return null;
		}

		if (firstElement instanceof IFile) {
			IFile file = (IFile) firstElement;
			return convert(file,!validateonly);			
		} else {
			MessageDialog.openInformation(HandlerUtil.getActiveShell(event),
					"Information", "Please select a BPMN or BPMN2 source file");
		}
		return null;
	}
	public static boolean convert(IFile file, boolean saveOutput) {
		//project = file.getProject();
		//folder = file.getParent();
		//System.out.println(folder);
		deleteMarker(file);
		boolean saved = saveAllResources(file);
		if (!saved)
			return false;
		
		return convert(file, file.getLocation().toOSString(),file.getFileExtension(), saveOutput);

	}

	public static int getProcessID(IFile file) {
		// deleteMarker
		String extension = file.getFileExtension();
		if (extension.equals("bpmn") || extension.equals("bpmn2")) {
			BPMN2XMLParser parser = new BPMN2XMLParser(file.getLocation()
					.toOSString());
			return parser.getProcessID();
		} else if (extension.equals("uku64")) {
			String s = QuickFileReader.getFileContent(file.getLocation()
					.toOSString());
			return Base64Converter.decodeFrom(s)[2];
		} else if (extension.equals("uku")) {
			String s = QuickFileReader.getFileContent(file.getLocation()
					.toOSString());
			return Integer.valueOf(s.split(" ")[2]);
		}
		throw new NullPointerException("unsupported file type : ."
				+ file.getFileExtension());
	}

	/**
	 * 
	 * @param process
	 * @param em
	 * @param sm
	 * @return false if process contain some error, true if everything is fine
	 */
	private static boolean reporting(UkuProcess process, ErrorManager em,
			ScopeManager sm) {
		console.println();
		console.info("Validator", "checking process " + process.name);
		em.exportTo(console);
		console.info("Validator", "Report:");
		console.info("Validator", "Issued " + em.getWarnings().size()
				+ (em.getWarnings().size() == 1 ? " warming" : " warnings "));
		if (!em.isValid()) {
			console.info("Validator", "There are(is) " + em.getErrors().size()
					+ " errors in the diagram, please fix them (it) first");
			return false;
		}
		return true;
	}

	private static boolean convert(IFile file, String oFileLocation, String extension,
			boolean saveOutput) {
		
		// String extension = file.getFileExtension();
		// String oFileLocation = file.getLocation().toOSString();
		
		//String nfileLocation = oFileLocation + "\n";
		//String nfileLocation64 = oFileLocation + "\n";
		//nfileLocation = nfileLocation.replace(extension + "\n", "uku");
		//nfileLocation64 = nfileLocation64.replace(extension + "\n", "uku64");

		if (extension.equals("bpmn") || extension.equals("bpmn2")) {
			ErrorManager em = ErrorManager.getInstance();
			ScopeManager sm = ScopeManager.getInstance();
			BPMN2XMLParser parser = new BPMN2XMLParser(oFileLocation);
			/* fetching & set references */
			parser.executeFetch();
			List<UkuProcess> processes = parser.getProcesses();
			UkuProcess process = processes.get(0);
			if (processes.size() > 1) {
				em.addError(new ErrorMessage(
						oFileLocation,
						processes.size()
								+ " processes are found. Just one process is supported.\n"
								+ "\t Trying to convert the first process"));
			}
			/* checking cycles */

			/* split mixed */
			boolean valid = new ProcessOptimizer(process).optimize();
			/* checking each element, cycle and balancing(if valid==true) */			
			new UkuProcessValidation(process).validate(valid);

			boolean isValid = reporting(process, em, sm);
			em.reset();
			sm.reset();
			if (!isValid) {
				return false;
			}
			/* set ID & visit & writing output to file */
			if (saveOutput)
				visiting(file, process);
		}
		return true;
	}

	private static void visiting(IFile file, UkuProcess process) {		
		/*
		 * set workflow-element-id for each element this id will be used later
		 * in the bytecode format output
		 */
		byte id = 0;
		for (UkuEntity ue : process.getEntities()) {
			if (ue instanceof UkuElement) {
				((UkuElement) ue).setWorkflowElementID(id);
				id++;
			}
		}
		ElementVisitorImpl visitor = new ElementVisitorImpl();

		visitor.reset();
		process.accept(visitor);
		InputStream istream = new ByteArrayInputStream(visitor.getOutputString64().getBytes());
		console.info("Output", visitor.getOutputString64());
		String fname = file.getName()+"\n";
		String newfname = fname.replace(file.getFileExtension()+"\n","uku64");
		String outputFolder = Activator.getDefault().getPreferenceStore().getString(UkuPreference.OUTPUT_DIR);
		if(!outputFolder.matches("[a-zA-Z][a-zA-Z0-9]*"))
			outputFolder = "";
		try {
			IFile newFile = null;
			IContainer container = file.getParent();			
			if(container instanceof IFolder){
				IFolder folder = (IFolder)container;
				if(outputFolder!=null && outputFolder != ""){
					folder = folder.getFolder(outputFolder);
					if(!folder.exists())
						folder.create(true,true,new NullProgressMonitor());
				}
				newFile = folder.getFile(newfname);
			} else if (container instanceof IProject){
				IProject project = (IProject)container;				
				if(outputFolder!=null && outputFolder != ""){
					IFolder folder =null;
					folder = project.getFolder(outputFolder);
					if(!folder.exists())
						folder.create(true, true, new NullProgressMonitor());
					newFile = folder.getFile(newfname);
				} else {
					newFile = ((IProject)container).getFile(newfname);
				}
			} else {
				console.error("SYSTEM","file container has type of "+container.getClass().getSimpleName() );
			}
			
			if(!newFile.exists())
				newFile.create(istream, IResource.FORCE, new NullProgressMonitor());
			else {
				newFile.delete(true,new NullProgressMonitor());
				
				newFile.create(istream, IResource.FORCE, new NullProgressMonitor());
			}
		} catch (CoreException e1) {
			e1.printStackTrace();
		}
		visitor = null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean saveAllResources(IFile file) {

		List selected = new LinkedList();
		Set<IEditorInput> inputs = new HashSet<IEditorInput>();
		List result = new LinkedList();
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow[] windows = workbench.getWorkbenchWindows();
		for (IWorkbenchWindow window : windows) {
			IWorkbenchPage[] pages = window.getPages();
			for (IWorkbenchPage page : pages) {
				IEditorPart[] editors = page.getDirtyEditors();
				for (IEditorPart editor : editors) {
					IEditorInput input = editor.getEditorInput();
					if (input instanceof IFileEditorInput) {
						IFileEditorInput fileInput = (IFileEditorInput) input;
						if (file.equals(fileInput.getFile()))
							selected.add(editor);
						// if (files.contains(fileInput.getFile())) {
						if (!inputs.contains(input)) {
							inputs.add(input);
							result.add(editor);
						}
						// }
					}
				}
			}
		}
		final IWorkbenchWindow iwindow = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		ListSelectionDialog lsd = new ListSelectionDialog(
				windows[0].getShell(), result, new ArrayContentProvider(),
				new WorkbenchPartLabelProvider(), "message");
		if (result.isEmpty())
			return true;
		// if(selected)
		lsd.setInitialElementSelections(selected);
		if (lsd.open() == Window.CANCEL)
			return false;
		result = Arrays.asList(lsd.getResult());
		if (result.isEmpty())
			return true;
		final List finalModels = result;
		IRunnableWithProgress progressOp = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) {
				IProgressMonitor monitorWrap = new EventLoopProgressMonitor(
						monitor);
				monitorWrap.beginTask(WorkbenchMessages.Saving_Modifications,
						finalModels.size());
				for (Iterator i = finalModels.iterator(); i.hasNext();) {
					IEditorPart model = (IEditorPart) i.next();
					// handle case where this model got saved as a result of
					// saving another
					if (!model.isDirty()) {
						monitor.worked(1);
						continue;
					}
					model.doSave(monitorWrap);
					if (monitorWrap.isCanceled()) {
						break;
					}
				}
				monitorWrap.done();
			}
		};

		return runProgressMonitorOperation(WorkbenchMessages.Save_All,
				progressOp, iwindow, iwindow);
	}

	private static boolean runProgressMonitorOperation(String opName,
			final IRunnableWithProgress progressOp,
			final IRunnableContext runnableContext,
			final IShellProvider shellProvider) {
		final boolean[] success = new boolean[] { false };
		IRunnableWithProgress runnable = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException, InterruptedException {
				progressOp.run(monitor);
				// Only indicate success if the monitor wasn't canceled
				if (!monitor.isCanceled())
					success[0] = true;
			}
		};

		try {
			runnableContext.run(false, true, runnable);
		} catch (InvocationTargetException e) {
			String title = NLS.bind(
					WorkbenchMessages.EditorManager_operationFailed, opName);
			Throwable targetExc = e.getTargetException();
			WorkbenchPlugin.log(title, new Status(IStatus.WARNING,
					PlatformUI.PLUGIN_ID, 0, title, targetExc));
			StatusUtil.handleStatus(title, targetExc, StatusManager.SHOW,
					shellProvider.getShell());
		} catch (InterruptedException e) {

		} catch (OperationCanceledException e) {

		}
		return success[0];
	}

}
