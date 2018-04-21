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

import java.awt.Color;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openmap4j.AbstractTest;
import org.openmap4j.plugin.output.svg.CssStyleBuilder;

 
class CssOverrideVarStyleBuilderTest extends AbstractTest {
	
	private CssStyleBuilder covsb = null;
	
	@BeforeEach
	public void beforeEach() {
		covsb = new CssStyleBuilder("myId", CssStyleBuilder.MODE.OVERRIDE_ELEMENT_STYLE_VARS);
	}

	@Test
	void testOverrideSingleStyle() {
		assertEquals(covsb.strokeWidth(Optional.of(Double.valueOf(2d))).build(),"--myId-stroke-width:2.0;", "override variable");
	}
	
	@Test
	void testOverrideTwoStyles() {
		assertEquals(covsb.strokeWidth(Optional.of(Double.valueOf(2d))).fill(Optional.of(Color.BLACK)).build(),"--myId-stroke-width:2.0;--myId-fill:#000000;", "override variable");
	}

}
