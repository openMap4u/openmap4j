/**
 * openmap4u-core - Parent pom providing dependency and plugin management for applications
		built with Maven
 * Copyright © ${project.inceptionYear} Michael Hadrbolec (openmap4u@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.openmap4j.plugin.output.svg;

/*-
 * #%L
 * openmap4u-core
 * %%
 * Copyright (C) 2014 - 2017 openMap4u
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openmap4j.AbstractTest;
import org.openmap4j.builder.style.StyleBuilderFactory;
import org.openmap4j.plugin.output.svg.SvgCssStyleHelper;
import org.openmap4j.plugin.output.svg.CssStyleBuilder.MODE;

public class SvgCssStyleHelperTest extends AbstractTest {

	private SvgCssStyleHelper cssHelper = null;
	
	@BeforeEach
	public void setUp() {
		cssHelper = new SvgCssStyleHelper();
	}
	
	@Test
	public void testGetAlphaCssStyle_empty() {
		assertEquals(cssHelper.getImageSymbolCssStyle(StyleBuilderFactory.getImageSymbolBuilder().build(),MODE.ELEMENT_STYLE,null),"");
	}
	
	@Test
	public void testGetAlphaCssStyle_valid() {
		assertEquals(cssHelper.getImageSymbolCssStyle(StyleBuilderFactory.getImageSymbolBuilder().alpha(0.3).build(),MODE.ELEMENT_STYLE,null),"opacity:0.3;");
	}
	
	@Test
	public void testGetAlphaCssStyle_invalid_greater_1() {
		assertThrows( IllegalArgumentException.class, () -> {
			cssHelper.getImageSymbolCssStyle(StyleBuilderFactory.getImageSymbolBuilder().alpha(2.3).build(),MODE.ELEMENT_STYLE,null);
		  });
		
	}
	
	@Test
	public void testGetAlphaCssStyle_invalid_less_0() {
		assertThrows( IllegalArgumentException.class, () -> {
			cssHelper.getImageSymbolCssStyle(StyleBuilderFactory.getImageSymbolBuilder().alpha(2.3).build(),MODE.ELEMENT_STYLE,null);
		  });	}
	
	@Test
	public void testGetVisibleCssStyle_empty() {
		assertEquals(cssHelper.getImageSymbolCssStyle(StyleBuilderFactory.getImageSymbolBuilder().build(),MODE.ELEMENT_STYLE,null),"");
	}
	
	@Test
	public void testGeVisibleCssStyle_valid_false() {
		assertEquals(cssHelper.getImageSymbolCssStyle(StyleBuilderFactory.getImageSymbolBuilder().visible(true).build(),MODE.ELEMENT_STYLE,null),"visibility:visible;");
	}
	
	@Test
	public void testGetVisibleCssStyle_valid_true() {
		assertEquals(cssHelper.getImageSymbolCssStyle(StyleBuilderFactory.getImageSymbolBuilder().visible(false).build(),MODE.ELEMENT_STYLE,null),"visibility:hidden;");
	}
	
	 

}
