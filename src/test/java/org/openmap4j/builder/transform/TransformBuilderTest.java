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
package org.openmap4j.builder.transform;

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

import java.awt.geom.AffineTransform;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openmap4j.builder.transform.TransformBuilder;
import org.openmap4j.builder.transform.TransformableBuilder;

  
public class TransformBuilderTest {
	
	AffineTransform affineTransform = null;
	
	TransformableBuilder<AffineTransform> transformBuilder = null;
	
	@BeforeEach
	public void before() {
		affineTransform = new AffineTransform();
		transformBuilder =  new TransformBuilder<AffineTransform>();
	}

	@Test
	public void testScaleDouble() {
		affineTransform.scale(2, 2);
		assertEquals(transformBuilder.scale(2).build(),affineTransform);
	}
	
	@Test
	public void testScaleDoubleDouble() {
		affineTransform.scale(2, 3);
		assertEquals(transformBuilder.scale(2,3).build(),affineTransform);
	}
	
	@Test
	public void testTranslate() {
		affineTransform.translate(2, 3);
		assertEquals(transformBuilder.translate(2,3).build(),affineTransform);
	}
	
	@Test
	public void testShear() {
		affineTransform.shear(2, 3);
		assertEquals(transformBuilder.shear(2,3).build(),affineTransform);
	}
	
	@Test
	public void testRotate() {
		affineTransform.rotate(0.23);
		assertEquals(transformBuilder.rotate(0.23).build(),affineTransform);
	}
	
	@Test
	public void testNoTransformationAtAll() {
		assertEquals(transformBuilder.build(),new AffineTransform());
	}


}
