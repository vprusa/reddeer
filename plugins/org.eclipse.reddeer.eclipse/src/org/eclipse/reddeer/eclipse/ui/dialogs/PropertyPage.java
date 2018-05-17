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
package org.eclipse.reddeer.eclipse.ui.dialogs;

import org.eclipse.reddeer.core.reference.ReferencedComposite;
import org.eclipse.reddeer.jface.preference.PreferencePage;

/**
 * Represents a general property page.
 * 
 * @author Lucia Jelinkova
 * 
 */
public abstract class PropertyPage extends PreferencePage {

	/**
	 * Instantiates a new property page.
	 *
	 * @param path the path
	 */
	public PropertyPage(ReferencedComposite referencedComposite, String... path) {
		super(referencedComposite, path);
	}
}
