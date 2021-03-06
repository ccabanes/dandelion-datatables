/*
 * [The "BSD licence"]
 * Copyright (c) 2013 Dandelion
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

package com.github.dandelion.datatables.integration.theme;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.dandelion.datatables.integration.JspContextRunner;
import com.github.dandelion.datatables.testing.theme.Bootstrap2BaseIT;
import com.github.dandelion.datatables.testing.utils.Constants;
import com.github.dandelion.datatables.testing.utils.JspTest;

/**
 * Test the Bootstrap2 theme feature.
 *
 * @author Thibault Duchateau
 */
@RunWith(JspContextRunner.class)
@JspTest
public class Bootstrap2IT extends Bootstrap2BaseIT {

	@Test
	public void should_generate_table_markup_using_dom_source() throws IOException, Exception {
		goToPage("themes/bootstrap2_dom");
	
		StringBuilder baseHref = new StringBuilder(getDefaultBaseUrl());
		baseHref.append("/datatablesController/datatables-bootstrap2.css?id=");
		baseHref.append(Constants.TABLE_ID);
		baseHref.append("&c=%2Fthemes%2Fbootstrap2_dom.jsp");
		
		// Custom Bootstrap CSS must exist
		assertThat(getHtmlBody().findFirst("link").getAttribute("href")).isEqualTo(baseHref.toString());
		
		// Looking for the paging div
		assertThat(find("#" + Constants.TABLE_ID + "_wrapper").find("div.paging_bootstrap ")).hasSize(1);
	}
	
	
	@Test
	public void should_generate_table_markup_using_ajax_source() throws IOException, Exception {
		goToPage("themes/bootstrap2_ajax");
	
		StringBuilder baseHref = new StringBuilder(getDefaultBaseUrl());
		baseHref.append("/datatablesController/datatables-bootstrap2.css?id=");
		baseHref.append(Constants.TABLE_ID);
		baseHref.append("&c=%2Fthemes%2Fbootstrap2_ajax.jsp");
		
		// Custom Bootstrap CSS must exist
		assertThat(getHtmlBody().findFirst("link").getAttribute("href")).isEqualTo(baseHref.toString());
		
		// Looking for the paging div
		assertThat(find("#" + Constants.TABLE_ID + "_wrapper").find("div.paging_bootstrap ")).hasSize(1);
	}
}
