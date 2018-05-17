/*******************************************************************************
 * Copyright (c) 2017 Red Hat, Inc and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Red Hat, Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.reddeer.eclipse.jst.ejb.ui.project.facet;

import org.eclipse.reddeer.core.reference.ReferencedComposite;
import org.eclipse.reddeer.jface.wizard.WizardPage;
import org.eclipse.reddeer.swt.impl.button.CheckBox;

/**
 * Represents EJBFacetInstallPage.
 * @author rawagner
 *
 */
public class EJBFacetInstallPage extends WizardPage {
	
	public EJBFacetInstallPage(ReferencedComposite referencedComposite) {
		super(referencedComposite);
	}
	
	/**
	 * Enables/disables generation of ejb-jar.xml.
	 * @param toggle toggle generation
	 */
	public EJBFacetInstallPage toggleGenerateEjbJarXml(final boolean toggle) {
		new CheckBox(this, "Generate ejb-jar.xml deployment descriptor").toggle(toggle);
		return this;
	}
	
	/**
	 * Checks if generation of ejb-jar.xml is enabled.
	 * @return true if generation of ejb-jar.xml is enabled, false otherwise
	 */
	public boolean isGenerateEjbJarXml() {
		return new CheckBox(this, "Generate ejb-jar.xml deployment descriptor").isChecked();
	}

}
