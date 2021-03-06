/******************************************************************************* 
 * Copyright (c) 2007-2009 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.seam.vpe.template;

/**
 * @author yzhishko
 */

import static org.jboss.tools.vpe.xulrunner.util.XPCOM.queryInterface;

import org.jboss.tools.vpe.editor.context.VpePageContext;
import org.jboss.tools.vpe.editor.template.VpeCreationData;
import org.jboss.tools.vpe.editor.util.HTML;
import org.mozilla.interfaces.nsIDOMDocument;
import org.mozilla.interfaces.nsIDOMElement;
import org.mozilla.interfaces.nsIDOMNode;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class SeamPdfFooterTemplate extends SeamPdfAbstractTemplate {

	private nsIDOMElement visualElement;
	private Element sourceElement;

	public VpeCreationData create(VpePageContext pageContext, Node sourceNode,
			nsIDOMDocument visualDocument) {
		sourceElement = (Element) sourceNode;
		nsIDOMNode visualNode = visualDocument.createElement(HTML.TAG_DIV);
		visualElement = queryInterface(visualNode, nsIDOMElement.class);
		SeamUtil.setAlignment(sourceElement, visualElement);
		Node parentFontNode = SeamUtil.getParentByName(pageContext, sourceNode,
				"p:font"); //$NON-NLS-1$
		String styleAttr = SeamUtil.getStyleAttr(parentFontNode);
		if (styleAttr != null && !"".equals(styleAttr)) { //$NON-NLS-1$
			visualElement.setAttribute(HTML.ATTR_STYLE, styleAttr);
		}
		visualElement.setAttribute(SeamUtil.SEAM_ATTR_TYPE_ID,
				SeamUtil.SEAM_ATTR_TYPE_ID_VALUE_PDF_FOOTER);
		return new VpeCreationData(visualElement);
	}

}
