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
package org.eclipse.reddeer.eclipse.test.rse.ui.view;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.eclipse.reddeer.eclipse.exception.EclipseLayerException;
import org.eclipse.reddeer.eclipse.rse.ui.view.System;
import org.eclipse.reddeer.eclipse.rse.ui.wizards.newconnection.RSEMainNewConnectionWizard;
import org.eclipse.reddeer.eclipse.rse.ui.wizards.newconnection.RSENewConnectionWizardSelectionPage.SystemType;
import org.eclipse.reddeer.swt.api.Shell;
import org.eclipse.reddeer.swt.impl.shell.DefaultShell;
import org.junit.Test;

public class SystemViewTest extends SystemViewTestCase {
	
	private static final String SYSTEM_A = "Test Remote System A";
	private static final String SYSTEM_B = "Test Remote System B";

	
	@Test
	public void newConnection(){
		wizardDialog = remoteSystemView.newConnection();
		
		Shell shell = new DefaultShell();
		assertThat(shell.getText(), is(RSEMainNewConnectionWizard.TITLE));
	}
	
	@Test
	public void getSystems_noRemoteSystem(){
		
		List<System> systems = remoteSystemView.getSystems();
		assertThat(systems.size(), is(1)); //only predefined local system
	}
	
	@Test
	public void getSystems(){
		createSystem("localhost", SYSTEM_A, SystemType.SSH_ONLY);
		createSystem("127.0.0.1", SYSTEM_B, SystemType.SSH_ONLY);
		
		List<System> systems = remoteSystemView.getSystems();
		assertThat(systems.size(), is(3)); //+ predefined local
		assertThat(systems.get(1).getLabel(), is(SYSTEM_A));
		assertThat(systems.get(2).getLabel(), is(SYSTEM_B));
	}
	
	@Test(expected=EclipseLayerException.class)
	public void getSystem_noRemoteSystem(){
		remoteSystemView.getSystem("NO Remote System");
	}
	
	@Test(expected=EclipseLayerException.class)
	public void getSystem_notFound(){
		createSystem("127.0.0.1", SYSTEM_A, SystemType.SSH_ONLY);
		remoteSystemView.getSystem("No Remote System");
	}
	
	@Test
	public void getSystem(){
		createSystem("localhost", SYSTEM_A, SystemType.SSH_ONLY);
		createSystem("127.0.0.1", SYSTEM_B, SystemType.SSH_ONLY);

		System system = remoteSystemView.getSystem(SYSTEM_A);
		assertNotNull(system);
		assertThat(system.getLabel(), is(SYSTEM_A));
	}
	
}
