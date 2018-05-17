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
package org.eclipse.reddeer.swt.impl.ccombo;

import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.hamcrest.Matcher;
import org.eclipse.reddeer.common.logging.Logger;
import org.eclipse.reddeer.common.util.Display;
import org.eclipse.reddeer.core.handler.CComboHandler;
import org.eclipse.reddeer.core.reference.ReferencedComposite;
import org.eclipse.reddeer.swt.api.CCombo;
import org.eclipse.reddeer.swt.widgets.AbstractControl;

/**
 * Abstract class for all CCombo implementations
 * 
 * @author Andrej Podhradsky
 * 
 */
public abstract class AbstractCCombo extends AbstractControl<org.eclipse.swt.custom.CCombo> implements CCombo {

	private static final Logger log = Logger.getLogger(AbstractCCombo.class);

	protected AbstractCCombo(ReferencedComposite refComposite, int index, Matcher<?>... matchers) {
		super(org.eclipse.swt.custom.CCombo.class, refComposite, index, matchers);
	}
	
	protected AbstractCCombo(org.eclipse.swt.custom.CCombo widget){
		super(widget);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.reddeer.swt.api.CCombo#setText(java.lang.String)
	 */
	@Override
	public void setText(String str) {
		log.info("Set text of CCombo " + getText() + " to:" + str);
		CComboHandler.getInstance().setText(swtWidget, str);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.reddeer.swt.api.CCombo#setSelection(int)
	 */
	@Override
	public void setSelection(int index) {
		log.info("Set selection of CCombo " + getText() + " to index: " + index);
		CComboHandler.getInstance().setSelection(swtWidget, index);
		notifyCCombo(createEventForCCombo(SWT.Selection));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.reddeer.swt.api.CCombo#setSelection(java.lang.String)
	 */
	@Override
	public void setSelection(String selection) {
		log.info("Set selection of CCombo " + getText() + " to selection: " + selection);
		CComboHandler.getInstance().setSelection(swtWidget, selection);
		notifyCCombo(createEventForCCombo(SWT.Selection));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.reddeer.swt.api.CCombo#getSelection()
	 */
	@Override
	public String getSelection() {
		return CComboHandler.getInstance().getSelection(swtWidget);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.reddeer.swt.api.CCombo#getSelectionIndex()
	 */
	@Override
	public int getSelectionIndex() {
		return CComboHandler.getInstance().getSelectionIndex(swtWidget);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.reddeer.swt.api.CCombo#getText()
	 */
	@Override
	public String getText() {
		return CComboHandler.getInstance().getText(swtWidget);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.reddeer.swt.api.CCombo#getItems()
	 */
	@Override
	public List<String> getItems() {
		return Arrays.asList(CComboHandler.getInstance().getItems(swtWidget));
	}

	/**
	 * Creates event for CCombo with specified type
	 * 
	 * @param type
	 * @return event
	 */
	private Event createEventForCCombo(int type) {
		Event event = new Event();
		event.type = type;
		event.display = Display.getDisplay();
		event.time = (int) System.currentTimeMillis();
		event.widget = swtWidget;
		return event;
	}

	/**
	 * Notifies CCombo listeners about event event.type field has to be properly
	 * set
	 * 
	 * @param event event
	 */
	private void notifyCCombo(final Event event) {
		Display.syncExec(new Runnable() {
			public void run() {
				swtWidget.notifyListeners(event.type, event);
			}
		});
	}
}
