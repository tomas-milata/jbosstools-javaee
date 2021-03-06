/*******************************************************************************
 * Copyright (c) 2011-2012 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributor:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.jsf.test;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.jboss.tools.common.base.test.kb.QueryParticipantTestUtils;
import org.jboss.tools.common.base.test.kb.QueryParticipantTestUtils.MatchStructure;
import org.jboss.tools.jst.web.kb.refactoring.ELReferencesQueryParticipant;
import org.jboss.tools.test.util.ProjectImportTestSetup;

public class ELReferencesQueryParticipantTest extends TestCase{
	static String projectName = "JSF2ComponentsValidator";
	static IProject project;
	
	public ELReferencesQueryParticipantTest(){
		super("ELReferencesQueryParticipantTest");
	}
	
	protected void setUp() throws Exception {
		project = ProjectImportTestSetup.loadProject(projectName);
	}
	
	public void testELReferencesQueryParticipantForType() throws CoreException{
		ArrayList<MatchStructure> matches = new ArrayList<MatchStructure>();
		
		matches.add(new MatchStructure("/JSF2ComponentsValidator/WebContent/pages/greeting.xhtml", "person"));
		matches.add(new MatchStructure("/JSF2ComponentsValidator/WebContent/resources/demo/input.xhtml", "person"));
		matches.add(new MatchStructure("/JSF2ComponentsValidator/WebContent/resources/demo/input.xhtml", "person"));
		
		matches.add(new MatchStructure("/JSF2ComponentsValidator/WebContent/resources/type/type.xhtml", "person"));
		matches.add(new MatchStructure("/JSF2ComponentsValidator/WebContent/resources/type/type.xhtml", "person"));
		
		matches.add(new MatchStructure("/JSF2ComponentsValidator/WebContent/resources/data/data.xhtml", "person"));
		matches.add(new MatchStructure("/JSF2ComponentsValidator/WebContent/resources/data/data.xhtml", "person"));
		
		matches.add(new MatchStructure("/JSF2ComponentsValidator/WebContent/resources/nmbr/nmbr.xhtml", "person"));
		matches.add(new MatchStructure("/JSF2ComponentsValidator/WebContent/resources/nmbr/nmbr.xhtml", "person"));
		
		QueryParticipantTestUtils.testSearchParticipant(project,
				"JavaSource/demo/Person.java",
				QueryParticipantTestUtils.TYPE_SEARCH,
				"Person",
				"",
				new ELReferencesQueryParticipant(),
				matches);
	}
	
	public void testELReferencesQueryParticipantForMethod() throws CoreException{
		ArrayList<MatchStructure> matches = new ArrayList<MatchStructure>();
		
		matches.add(new MatchStructure("/JSF2ComponentsValidator/WebContent/pages/greeting.xhtml", "name"));
		matches.add(new MatchStructure("/JSF2ComponentsValidator/WebContent/resources/demo/input.xhtml", "name"));
		matches.add(new MatchStructure("/JSF2ComponentsValidator/WebContent/resources/type/type.xhtml", "name"));
		matches.add(new MatchStructure("/JSF2ComponentsValidator/WebContent/resources/data/data.xhtml", "name"));
		matches.add(new MatchStructure("/JSF2ComponentsValidator/WebContent/resources/nmbr/nmbr.xhtml", "name"));
		
		QueryParticipantTestUtils.testSearchParticipant(project,
				"JavaSource/demo/Person.java",
				QueryParticipantTestUtils.METHOD_SEARCH,
				"getName",
				"",
				new ELReferencesQueryParticipant(),
				matches);
	}
}
