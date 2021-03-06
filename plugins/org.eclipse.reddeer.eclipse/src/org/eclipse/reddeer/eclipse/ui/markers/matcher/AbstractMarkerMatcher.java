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

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsEqual;
import org.eclipse.reddeer.core.matcher.AbstractWidgetWithTextMatcher;
import org.eclipse.reddeer.eclipse.ui.views.markers.AbstractMarkersSupportView.Column;

/**
 * Abstract problem matcher is a parent matcher for a specific columns in view supporting markers.
 * Matching works either as precise match on a specified string or by passing proper matcher for matching.
 * 
 * @author mlabuda@redhat.com
 * @since 0.7
 *
 */
public abstract class AbstractMarkerMatcher extends AbstractWidgetWithTextMatcher {

	protected Matcher<String> matcher;
	
	/**
	 * Creates a new marker matcher matching to whole text of a column.
	 * 
	 * @param text whole column text of a problem to match
	 */
	public AbstractMarkerMatcher(String text) {
		this(new IsEqual<String>(text));
	}
	
	/**
	 * Creates a new marker matcher matching with matcher passed as argument.
	 * 
	 * @param matcher matcher to match column of a problem
	 */
	public AbstractMarkerMatcher(Matcher<String> matcher) {
		if (matcher == null) {
			throw new IllegalArgumentException("Matcher cannot be null.");
		}
		this.matcher = matcher;
	}
	
	/**
	 * Gets label of a column of a specific marker.
	 * @return label of a column of a specific marker
	 */
	public abstract Column getColumn();
	
	@Override
	public void describeTo(Description description) {
		description.appendDescriptionOf(matcher);
	}

	@Override
	protected boolean matches(String text) {
		return matcher.matches(text);
	}
}
