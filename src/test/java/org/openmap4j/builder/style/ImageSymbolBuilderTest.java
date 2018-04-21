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
package org.openmap4j.builder.style;

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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.geom.Point2D;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openmap4j.builder.style.ImageSymbol;
import org.openmap4j.builder.style.ImageSymbolBuilder;
import org.openmap4j.style.ImageSymbolizeable;

 
public class ImageSymbolBuilderTest extends AbtractStyleBuilderTest {
	
	
	private ImageSymbolizeable is = null;
	
	@BeforeEach
	public void beforeEach() {
		is =  new ImageSymbolBuilder<ImageSymbolizeable>().alpha(ALPHA).visible(false).imagePath(IMAGE_PATH).x(X).y(Y).build();
	}

 	@Test
	public void testSetAll() {
		assertEquals(is.getAlpha().get(), ALPHA);
		assertEquals(is.isVisible().get(), false);
		assertEquals(is.getPoint(),new Point2D.Double(X,Y));
	 	assertEquals(is.getImagePath(), IMAGE_PATH);
	}
 	
	 
 	
 	@Test
 	public void testClone() throws CloneNotSupportedException {
 		ImageSymbolizeable cis = (ImageSymbolizeable) is.clone();
 		assertTrue(cis.equals(is));
 		((ImageSymbol)is).alpha(.123);
 		assertFalse(cis.equals(is));
 	}

}
