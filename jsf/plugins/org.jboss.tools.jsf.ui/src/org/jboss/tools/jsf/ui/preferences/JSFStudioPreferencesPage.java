/*******************************************************************************
 * Copyright (c) 2007 Exadel, Inc. and Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Exadel, Inc. and Red Hat, Inc. - initial API and implementation
 ******************************************************************************/ 
package org.jboss.tools.jsf.ui.preferences;

import org.jboss.tools.common.model.ui.preferences.CompanyPreferencesPage;

public class JSFStudioPreferencesPage extends CompanyPreferencesPage {
	
	public static final String ID = "org.jboss.tools.jsf.ui"; //$NON-NLS-1$
	
	@Override
	protected String getPrefsName() {
		return Messages.getString("JSFSTUDIO"); //$NON-NLS-1$
	}

}
