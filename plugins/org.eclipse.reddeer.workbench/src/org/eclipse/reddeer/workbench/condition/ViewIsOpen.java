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
package org.eclipse.reddeer.workbench.condition;

import org.eclipse.reddeer.common.condition.AbstractWaitCondition;
import org.eclipse.reddeer.workbench.api.View;

/**
 * Wait condition for views checking whether specified view is open
 * 
 * @author rawagner@redhat.com
 */
public class ViewIsOpen extends AbstractWaitCondition{
	
	private View view;
	private View resultView;
	
	/**
	 * Checks whether specified view is open
	 * @param view view to check if it is open
	 */
	public ViewIsOpen(View view) {
		this.view = view;
	}

	@Override
	public boolean test() {
		if (view.isOpen()) {
			this.resultView = view;
			return true;
		}
		return false;
	}
	
	@Override
	public String description() {
		return "'"+view.getClass()+"' view is open";
	}
	
	@Override
	public String errorMessageUntil() {
		return "'"+view.getClass()+"' view is not open";
	}
	
	
	@Override
	public String errorMessageWhile() {
		return "'"+view.getTitle()+"' view is still open";
	}
	
	@SuppressWarnings("unchecked")
	@Override 
	public View getResult() {
		return this.resultView;
	}

}
