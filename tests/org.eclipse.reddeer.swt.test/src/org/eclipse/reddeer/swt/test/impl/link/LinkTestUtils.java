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
package org.eclipse.reddeer.swt.test.impl.link;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.reddeer.common.util.Display;
import org.eclipse.reddeer.common.util.ResultRunnable;

public class LinkTestUtils {

	public static Link createLink(final Shell parent, final String text){
		return Display.syncExec(new ResultRunnable<Link>() {
			@Override
			public Link run() {
				Link link = new Link(parent, SWT.NONE);
				link.setSize(100, 30);
				link.setText(text);
				return link;
			}
		});
	}
}
