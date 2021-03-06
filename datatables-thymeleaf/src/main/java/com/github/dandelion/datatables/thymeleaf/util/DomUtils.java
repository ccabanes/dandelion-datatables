/*
 * [The "BSD licence"]
 * Copyright (c) 2012 Dandelion
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 3. Neither the name of Dandelion nor the names of its contributors 
 * may be used to endorse or promote products derived from this software 
 * without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.github.dandelion.datatables.thymeleaf.util;

import org.thymeleaf.dom.Element;
import org.thymeleaf.dom.Node;

/**
 * Utility methods to manipulate the DOM.
 * 
 * @author Thibault Duchateau
 */
public class DomUtils {

	public static void insertScriptTag(String src, Element element){
		Element script = new Element("script");
		script.setAttribute("src", src);
		element.insertChild(element.getChildren().size(), script);
	}
	
	public static void insertLinkTag(String src, Element element){
		Element link = new Element("link");
		link.setAttribute("href", src);
		link.setAttribute("rel", "stylesheet");
		element.insertChild(element.getChildren().size(), link);
	}
	

	public static Element getParentAsElement(Element element) {
		return (Element) element.getParent();
	}

	public static Element getGrandParentAsElement(Element element) {
		return (Element) element.getParent().getParent();
	}

	public static Element getParent(Element element) {
		if (element.hasParent()) {
			return (Element) getParent(element);
		} else {
			return element;
		}
	}


	/**
	 * Recursively search a node by its type inside a root node.
	 * 
	 * @param nodeClass
	 *            The class to look for.
	 * @return The first node corresponding to the searched class.
	 */
	public static Node getNodeByType(Element root, Class<? extends Node> nodeClass) {

		Node retval = null;

		if (root != null && root.hasChildren()) {
			for (Node node : root.getChildren()) {
				if (node.getClass().equals(nodeClass)) {
					retval = node;
					break;
				}
			}
			if (retval == null) {
				retval = getNodeByType(root.getFirstElementChild(), nodeClass);
			}
		}

		return retval;
	}
	
	
	/**
	 * Recursive search for an element within the given node in the DOM tree.
	 * Many thanks to Emanuel Rabina :-)
	 * 
	 * @param element
	 *            Node to initiate the search from.
	 * @param name
	 *            Name of the element to look for.
	 * @return Element with the given name, or <tt>null</tt> if the element
	 *         could not be found.
	 */
	public static Element findElement(Element element, String name) {

		if (element.getOriginalName().equals(name)) {
			return element;
		}
		for (Element child: element.getElementChildren()) {
			Element result = findElement(child, name);
			if (result != null) {
				return result;
			}
		}
		return null;
	}
}