/**
 */
package eventbase.provider;

import eventbase.util.EventbaseAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EventbaseItemProviderAdapterFactory extends EventbaseAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventbaseItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.ESequenceFlow} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESequenceFlowItemProvider eSequenceFlowItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.ESequenceFlow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createESequenceFlowAdapter() {
		if (eSequenceFlowItemProvider == null) {
			eSequenceFlowItemProvider = new ESequenceFlowItemProvider(this);
		}

		return eSequenceFlowItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EPeriodicEG} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EPeriodicEGItemProvider ePeriodicEGItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EPeriodicEG}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEPeriodicEGAdapter() {
		if (ePeriodicEGItemProvider == null) {
			ePeriodicEGItemProvider = new EPeriodicEGItemProvider(this);
		}

		return ePeriodicEGItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EPatternedEG} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EPatternedEGItemProvider ePatternedEGItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EPatternedEG}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEPatternedEGAdapter() {
		if (ePatternedEGItemProvider == null) {
			ePatternedEGItemProvider = new EPatternedEGItemProvider(this);
		}

		return ePatternedEGItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EDistributionEG} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EDistributionEGItemProvider eDistributionEGItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EDistributionEG}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEDistributionEGAdapter() {
		if (eDistributionEGItemProvider == null) {
			eDistributionEGItemProvider = new EDistributionEGItemProvider(this);
		}

		return eDistributionEGItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.ESimpleFilterConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ESimpleFilterConstraintItemProvider eSimpleFilterConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.ESimpleFilterConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createESimpleFilterConstraintAdapter() {
		if (eSimpleFilterConstraintItemProvider == null) {
			eSimpleFilterConstraintItemProvider = new ESimpleFilterConstraintItemProvider(this);
		}

		return eSimpleFilterConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EventGenerator} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventGeneratorItemProvider eventGeneratorItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EventGenerator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEventGeneratorAdapter() {
		if (eventGeneratorItemProvider == null) {
			eventGeneratorItemProvider = new EventGeneratorItemProvider(this);
		}

		return eventGeneratorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EGNonRecurring} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EGNonRecurringItemProvider egNonRecurringItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EGNonRecurring}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEGNonRecurringAdapter() {
		if (egNonRecurringItemProvider == null) {
			egNonRecurringItemProvider = new EGNonRecurringItemProvider(this);
		}

		return egNonRecurringItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EGImmediate} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EGImmediateItemProvider egImmediateItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EGImmediate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEGImmediateAdapter() {
		if (egImmediateItemProvider == null) {
			egImmediateItemProvider = new EGImmediateItemProvider(this);
		}

		return egImmediateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EGAbsolute} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EGAbsoluteItemProvider egAbsoluteItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EGAbsolute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEGAbsoluteAdapter() {
		if (egAbsoluteItemProvider == null) {
			egAbsoluteItemProvider = new EGAbsoluteItemProvider(this);
		}

		return egAbsoluteItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EGOffset} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EGOffsetItemProvider egOffsetItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EGOffset}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEGOffsetAdapter() {
		if (egOffsetItemProvider == null) {
			egOffsetItemProvider = new EGOffsetItemProvider(this);
		}

		return egOffsetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EGRelative} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EGRelativeItemProvider egRelativeItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EGRelative}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEGRelativeAdapter() {
		if (egRelativeItemProvider == null) {
			egRelativeItemProvider = new EGRelativeItemProvider(this);
		}

		return egRelativeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EGRecurring} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EGRecurringItemProvider egRecurringItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EGRecurring}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEGRecurringAdapter() {
		if (egRecurringItemProvider == null) {
			egRecurringItemProvider = new EGRecurringItemProvider(this);
		}

		return egRecurringItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EGPeriodic} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EGPeriodicItemProvider egPeriodicItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EGPeriodic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEGPeriodicAdapter() {
		if (egPeriodicItemProvider == null) {
			egPeriodicItemProvider = new EGPeriodicItemProvider(this);
		}

		return egPeriodicItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EGPatterned} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EGPatternedItemProvider egPatternedItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EGPatterned}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEGPatternedAdapter() {
		if (egPatternedItemProvider == null) {
			egPatternedItemProvider = new EGPatternedItemProvider(this);
		}

		return egPatternedItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EGDistribution} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EGDistributionItemProvider egDistributionItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EGDistribution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEGDistributionAdapter() {
		if (egDistributionItemProvider == null) {
			egDistributionItemProvider = new EGDistributionItemProvider(this);
		}

		return egDistributionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EventFilter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventFilterItemProvider eventFilterItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EventFilter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEventFilterAdapter() {
		if (eventFilterItemProvider == null) {
			eventFilterItemProvider = new EventFilterItemProvider(this);
		}

		return eventFilterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFSimple} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFSimpleItemProvider efSimpleItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFSimple}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFSimpleAdapter() {
		if (efSimpleItemProvider == null) {
			efSimpleItemProvider = new EFSimpleItemProvider(this);
		}

		return efSimpleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFComposite} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFCompositeItemProvider efCompositeItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFComposite}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFCompositeAdapter() {
		if (efCompositeItemProvider == null) {
			efCompositeItemProvider = new EFCompositeItemProvider(this);
		}

		return efCompositeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFStatusEvent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFStatusEventItemProvider efStatusEventItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFStatusEvent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFStatusEventAdapter() {
		if (efStatusEventItemProvider == null) {
			efStatusEventItemProvider = new EFStatusEventItemProvider(this);
		}

		return efStatusEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFLogic} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFLogicItemProvider efLogicItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFLogic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFLogicAdapter() {
		if (efLogicItemProvider == null) {
			efLogicItemProvider = new EFLogicItemProvider(this);
		}

		return efLogicItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFProcessing} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFProcessingItemProvider efProcessingItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFProcessing}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFProcessingAdapter() {
		if (efProcessingItemProvider == null) {
			efProcessingItemProvider = new EFProcessingItemProvider(this);
		}

		return efProcessingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFTemporal} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFTemporalItemProvider efTemporalItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFTemporal}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFTemporalAdapter() {
		if (efTemporalItemProvider == null) {
			efTemporalItemProvider = new EFTemporalItemProvider(this);
		}

		return efTemporalItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFLogicAnd} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFLogicAndItemProvider efLogicAndItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFLogicAnd}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFLogicAndAdapter() {
		if (efLogicAndItemProvider == null) {
			efLogicAndItemProvider = new EFLogicAndItemProvider(this);
		}

		return efLogicAndItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFLogicOr} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFLogicOrItemProvider efLogicOrItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFLogicOr}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFLogicOrAdapter() {
		if (efLogicOrItemProvider == null) {
			efLogicOrItemProvider = new EFLogicOrItemProvider(this);
		}

		return efLogicOrItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFLogicNot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFLogicNotItemProvider efLogicNotItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFLogicNot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFLogicNotAdapter() {
		if (efLogicNotItemProvider == null) {
			efLogicNotItemProvider = new EFLogicNotItemProvider(this);
		}

		return efLogicNotItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFProcessingMin} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFProcessingMinItemProvider efProcessingMinItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFProcessingMin}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFProcessingMinAdapter() {
		if (efProcessingMinItemProvider == null) {
			efProcessingMinItemProvider = new EFProcessingMinItemProvider(this);
		}

		return efProcessingMinItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFProcessingMax} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFProcessingMaxItemProvider efProcessingMaxItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFProcessingMax}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFProcessingMaxAdapter() {
		if (efProcessingMaxItemProvider == null) {
			efProcessingMaxItemProvider = new EFProcessingMaxItemProvider(this);
		}

		return efProcessingMaxItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFProcessingSum} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFProcessingSumItemProvider efProcessingSumItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFProcessingSum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFProcessingSumAdapter() {
		if (efProcessingSumItemProvider == null) {
			efProcessingSumItemProvider = new EFProcessingSumItemProvider(this);
		}

		return efProcessingSumItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFProcessingCount} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFProcessingCountItemProvider efProcessingCountItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFProcessingCount}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFProcessingCountAdapter() {
		if (efProcessingCountItemProvider == null) {
			efProcessingCountItemProvider = new EFProcessingCountItemProvider(this);
		}

		return efProcessingCountItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFProcessingAvg} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFProcessingAvgItemProvider efProcessingAvgItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFProcessingAvg}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFProcessingAvgAdapter() {
		if (efProcessingAvgItemProvider == null) {
			efProcessingAvgItemProvider = new EFProcessingAvgItemProvider(this);
		}

		return efProcessingAvgItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFProcessingStDev} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFProcessingStDevItemProvider efProcessingStDevItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFProcessingStDev}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFProcessingStDevAdapter() {
		if (efProcessingStDevItemProvider == null) {
			efProcessingStDevItemProvider = new EFProcessingStDevItemProvider(this);
		}

		return efProcessingStDevItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFTemporalSequence} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFTemporalSequenceItemProvider efTemporalSequenceItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFTemporalSequence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFTemporalSequenceAdapter() {
		if (efTemporalSequenceItemProvider == null) {
			efTemporalSequenceItemProvider = new EFTemporalSequenceItemProvider(this);
		}

		return efTemporalSequenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFChangeEvent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFChangeEventItemProvider efChangeEventItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFChangeEvent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFChangeEventAdapter() {
		if (efChangeEventItemProvider == null) {
			efChangeEventItemProvider = new EFChangeEventItemProvider(this);
		}

		return efChangeEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFChangeIncrease} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFChangeIncreaseItemProvider efChangeIncreaseItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFChangeIncrease}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFChangeIncreaseAdapter() {
		if (efChangeIncreaseItemProvider == null) {
			efChangeIncreaseItemProvider = new EFChangeIncreaseItemProvider(this);
		}

		return efChangeIncreaseItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFChangeDecrease} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFChangeDecreaseItemProvider efChangeDecreaseItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFChangeDecrease}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFChangeDecreaseAdapter() {
		if (efChangeDecreaseItemProvider == null) {
			efChangeDecreaseItemProvider = new EFChangeDecreaseItemProvider(this);
		}

		return efChangeDecreaseItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link eventbase.EFChangeRemain} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFChangeRemainItemProvider efChangeRemainItemProvider;

	/**
	 * This creates an adapter for a {@link eventbase.EFChangeRemain}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEFChangeRemainAdapter() {
		if (efChangeRemainItemProvider == null) {
			efChangeRemainItemProvider = new EFChangeRemainItemProvider(this);
		}

		return efChangeRemainItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (eSequenceFlowItemProvider != null) eSequenceFlowItemProvider.dispose();
		if (ePeriodicEGItemProvider != null) ePeriodicEGItemProvider.dispose();
		if (ePatternedEGItemProvider != null) ePatternedEGItemProvider.dispose();
		if (eDistributionEGItemProvider != null) eDistributionEGItemProvider.dispose();
		if (eSimpleFilterConstraintItemProvider != null) eSimpleFilterConstraintItemProvider.dispose();
		if (eventGeneratorItemProvider != null) eventGeneratorItemProvider.dispose();
		if (egNonRecurringItemProvider != null) egNonRecurringItemProvider.dispose();
		if (egImmediateItemProvider != null) egImmediateItemProvider.dispose();
		if (egAbsoluteItemProvider != null) egAbsoluteItemProvider.dispose();
		if (egOffsetItemProvider != null) egOffsetItemProvider.dispose();
		if (egRelativeItemProvider != null) egRelativeItemProvider.dispose();
		if (egRecurringItemProvider != null) egRecurringItemProvider.dispose();
		if (egPeriodicItemProvider != null) egPeriodicItemProvider.dispose();
		if (egPatternedItemProvider != null) egPatternedItemProvider.dispose();
		if (egDistributionItemProvider != null) egDistributionItemProvider.dispose();
		if (eventFilterItemProvider != null) eventFilterItemProvider.dispose();
		if (efSimpleItemProvider != null) efSimpleItemProvider.dispose();
		if (efCompositeItemProvider != null) efCompositeItemProvider.dispose();
		if (efStatusEventItemProvider != null) efStatusEventItemProvider.dispose();
		if (efLogicItemProvider != null) efLogicItemProvider.dispose();
		if (efProcessingItemProvider != null) efProcessingItemProvider.dispose();
		if (efTemporalItemProvider != null) efTemporalItemProvider.dispose();
		if (efLogicAndItemProvider != null) efLogicAndItemProvider.dispose();
		if (efLogicOrItemProvider != null) efLogicOrItemProvider.dispose();
		if (efLogicNotItemProvider != null) efLogicNotItemProvider.dispose();
		if (efProcessingMinItemProvider != null) efProcessingMinItemProvider.dispose();
		if (efProcessingMaxItemProvider != null) efProcessingMaxItemProvider.dispose();
		if (efProcessingSumItemProvider != null) efProcessingSumItemProvider.dispose();
		if (efProcessingCountItemProvider != null) efProcessingCountItemProvider.dispose();
		if (efProcessingAvgItemProvider != null) efProcessingAvgItemProvider.dispose();
		if (efProcessingStDevItemProvider != null) efProcessingStDevItemProvider.dispose();
		if (efTemporalSequenceItemProvider != null) efTemporalSequenceItemProvider.dispose();
		if (efChangeEventItemProvider != null) efChangeEventItemProvider.dispose();
		if (efChangeIncreaseItemProvider != null) efChangeIncreaseItemProvider.dispose();
		if (efChangeDecreaseItemProvider != null) efChangeDecreaseItemProvider.dispose();
		if (efChangeRemainItemProvider != null) efChangeRemainItemProvider.dispose();
	}

}
