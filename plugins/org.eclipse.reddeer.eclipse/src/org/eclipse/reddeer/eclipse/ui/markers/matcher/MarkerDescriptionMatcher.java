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
package org.eclipse.reddeer.eclipse.ui.markers.matcher;

import org.hamcrest.Matcher;
import org.eclipse.reddeer.eclipse.ui.views.markers.AbstractMarkersSupportView.Column;
/**
 * Marker matcher for column Descripton of a view supporting markers.
 * 
 * @author mlabuda@redhat.com
 * @since 0.7
 */
public class MarkerDescriptionMatcher extends AbstractMarkerMatcher {

	/**
	 * Creates a new marker matcher matching to whole text of Description column.
	 * 
	 * @param text whole Description column text of a marker to match
	 */
	public MarkerDescriptionMatcher(String text) {
		super(text);
	}
	
	/**
	 * Creates a new marker matcher matching with matcher for Description column.
	 * 
	 * @param matcher matcher to match Description column of a marker
	 */
	public MarkerDescriptionMatcher(Matcher<String> matcher) {
		super(matcher);
	}
	
	@Override
	public Column getColumn() {
		return Column.DESCRIPTION;
	}
}
