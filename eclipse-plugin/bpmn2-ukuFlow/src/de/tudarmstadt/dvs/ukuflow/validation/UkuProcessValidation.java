package de.tudarmstadt.dvs.ukuflow.validation;


import de.tudarmstadt.dvs.ukuflow.script.UkuConstants;
import de.tudarmstadt.dvs.ukuflow.script.generalscript.ScopeManager;
import de.tudarmstadt.dvs.ukuflow.script.generalscript.functions.ComputationalFunction;
import de.tudarmstadt.dvs.ukuflow.script.generalscript.functions.LocalFunction;
import de.tudarmstadt.dvs.ukuflow.script.generalscript.functions.ScopeFunction;
import de.tudarmstadt.dvs.ukuflow.script.generalscript.functions.TaskScriptFunction;
import de.tudarmstadt.dvs.ukuflow.tools.exception.ScopeNotExistException;
import de.tudarmstadt.dvs.ukuflow.xml.entity.*;

public class UkuProcessValidation {
	UkuProcess process = null;
	//UkuErrorReporter reporter;
	//UkuConsole console = UkuConsole.getConsole();
	//public Set<ErrorMessage> errors = new HashSet<ErrorMessage>();
	//public Set<WarningMessage> warnings = new HashSet<WarningMessage>();

	public UkuProcessValidation(UkuProcess process) {
		this.process = process;
		//reporter = UkuErrorReporter.getInstance();
	}

	public boolean validate() {
		/*
		for(UkuEntity e : process.getElements()){
			if(e instanceof UkuGateway){
				((UkuGateway)e).selfValidate();
			}
		}*/
		for (UkuEntity e : process.getEntities()) {
			if (e instanceof UkuEvent) {
				validate((UkuEvent) e);
			} else if (e instanceof UkuExecuteTask) {
				validate((UkuExecuteTask) e);
			} else if (e instanceof UkuScope) {
				validate((UkuScope) e);
			} else if (e instanceof UkuSequenceFlow) {
				validate((UkuSequenceFlow) e);
			} else if (e instanceof UkuGateway) {
				validate((UkuGateway) e);
			} else {
				System.err.println(e);
			}
		}
		/**
		for (UkuEntity e : process.getEntities()) {
			errors.addAll(e.getError());
			warnings.addAll(e.getWarnings());
		}
		for (ErrorMessage em : errors) {
			console.error("ERROR", em.location, em.message);
		}
		for (WarningMessage wm : warnings) {
			console.warn("WARNING", wm.location, wm.message);
		}*/
		/**
		if (errors.size() != 0)
			return false;
			*/
		return true;

	}

	private void validate(UkuEvent event) {
		switch (event.getType()) {
		case UkuConstants.END_EVENT:
			if (event.getIncomingID().size() == 0)
				event.addErrorMessage("End event should have at least one incoming connection");
			if (event.getOutgoingID().size() > 0)
				event.addErrorMessage("End Event cannot have outoging connection");
			break;
		case UkuConstants.START_EVENT:
			if (event.getOutgoingID().size() == 0)
				event.addErrorMessage("StartEvent should have at least one outgoing connection");
			if (event.getIncomingID().size() > 0)
				event.addErrorMessage("StartEvent cannot have incoming connection");
			break;
		default:
			event.addErrorMessage("this type of event is not supported yet");
			break;
		}
	}

	private void validate(UkuExecuteTask task) {
		if (task.getIncomingID().size() != 1 || task.getOutgoingID().size() != 1)
			task.addErrorMessage("A Script task must have exactly one incoming and one outgoing connection");
		if(!task.hasScript()){
			task.addErrorMessage("has no script");
		} else {
			for(TaskScriptFunction tsf : task.getStatements()){
				validate(task,tsf);
			}
		}
	}
	private void validate(UkuExecuteTask parent, TaskScriptFunction tsf){
		if(tsf instanceof ComputationalFunction){
			//TODO anything to validate?
		} else if(tsf instanceof LocalFunction){
			//TODO anything to validate?
		} else if(tsf instanceof ScopeFunction){
			String sName = ((ScopeFunction) tsf).getScopeName();
			try {
				ScopeManager.getInstance().getScopeID(sName);
			} catch (ScopeNotExistException e) {
				parent.addErrorMessage("couldn't found the declaration for scope " + sName);
			}
		}
	}
	public void validate(UkuScope scope) {
		// nothing do validate with scope.
	}

	public void validate(UkuGateway gway) {
		gway.selfValidate();		
		if (gway.ukuGatewayType == UkuConstants.INCLUSIVE_DECISION_GATEWAY) {
			if (gway.getDefaultGway() == null);
				//gway.addErrorMessage("inclusive decision gateway should have a default gateway");
		}
	}

	public void validate(UkuSequenceFlow sef) {
		if (sef.getSourceEntity() instanceof UkuGateway) {
			UkuGateway sourceGway = (UkuGateway) sef.getSourceEntity();
			switch (sourceGway.ukuGatewayType) {
			case UkuConstants.INCLUSIVE_DECISION_GATEWAY:
			case UkuConstants.EXCLUSIVE_DECISION_GATEWAY:
				if(!sef.hasCondition() && !sef.isDefault()){
					sef.addErrorMessage("sequence Flow has no condition or condition expression has incorrect syntax");
				}
				break;
			case UkuConstants.EVENT_BASED_EXCLUSIVE_DECISION_GATEWAY:
				if (sef.hasCondition()) {
					sef.addErrorMessage("this sequence flow shouldn't have condition");
				}
			default:
				break;
			}
		}
	}
}
