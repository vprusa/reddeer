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
package org.eclipse.reddeer.common.matcher;

import java.util.Arrays;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * Matcher matching conjunctive satisfaction of all matchers.<br>
 * 
 * Provides logical operation AND for Matcher.
 * 
 * @author Jiri Peterka
 * @author Radoslav Rabara
 */
@SuppressWarnings("rawtypes")
public class AndMatcher extends BaseMatcher {

	private Matcher[] matchers;
	
	/**
	 * Constructs new AndMatcher.
	 * 
	 * @param matchers matchers to be evaluated conjunctively
	 */
	public AndMatcher(Matcher... matchers) {
		if(matchers == null)
			throw new NullPointerException("matchers");
		this.matchers = matchers;
	}
	
	/* (non-Javadoc)
	 * @see org.hamcrest.Matcher#matches(java.lang.Object)
	 */
	@Override
	public boolean matches(Object item) {
		for (Matcher m : matchers) {
			if (!m.matches(item))
				return false;
		}
		return true;
	}

	/**
	 * Returns all matchers in AndMatcher.
	 *
	 * @return all matchers
	 */
	public Matcher[] getMatchers() {
		return matchers;
	}
	
	/* (non-Javadoc)
	 * @see org.hamcrest.SelfDescribing#describeTo(org.hamcrest.Description)
	 */
	@Override
	public void describeTo(Description description) {
		description.appendList("(", " " + "and" + " ", ")", Arrays.asList(matchers));
	}
	
	/* (non-Javadoc)
	 * @see org.hamcrest.BaseMatcher#toString()
	 */
	@Override
	public String toString() {
		return "Matcher matching when all matchers match: " + Arrays.toString(matchers);
	}
}
