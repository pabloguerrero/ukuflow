/*******************************************************************************
 * Copyright (c) 2011 Red Hat, Inc.
 *  All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 *
 * @author Bob Brodt
 ******************************************************************************/

package org.eclipse.bpmn2.modeler.ui.adapters.properties;

import org.eclipse.bpmn2.Bpmn2Package;
import org.eclipse.bpmn2.modeler.core.adapters.ExtendedPropertiesAdapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Bob Brodt
 *
 */
public class ActivityPropertiesAdapter extends ExtendedPropertiesAdapter {

	/**
	 * @param adapterFactory
	 * @param object
	 */
	public ActivityPropertiesAdapter(AdapterFactory adapterFactory, EObject object) {
		super(adapterFactory, object);
    	setProperty(Bpmn2Package.ACTIVITY__LOOP_CHARACTERISTICS, ExtendedPropertiesAdapter.UI_CAN_CREATE_NEW, Boolean.FALSE);
    	setProperty(Bpmn2Package.ACTIVITY__LOOP_CHARACTERISTICS, ExtendedPropertiesAdapter.UI_CAN_EDIT, Boolean.FALSE);
	}

}
