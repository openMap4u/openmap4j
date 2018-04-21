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
package org.openmap4j.builder.geom;

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

import java.awt.geom.Point2D;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openmap4j.AbstractTest;
import org.openmap4j.builder.geom.PointBuildable;
import org.openmap4j.builder.geom.PointBuilder;

@DisplayName("PointBuilder")
public class PointBuilderTest extends AbstractTest {
	
	private PointBuildable<Point2D> pB = null;
	
	@BeforeEach
	public void before() {
		pB = new PointBuilder<>();
	}
	
	@Test
	@DisplayName("only x coordinate provided")
	public void testX() {
		Point2D point = pB.x(32.4).build();
		assertEquals(point.getX(),32.4);
		assertEquals(point.getY(),0);
	}
	
	@Test
	@DisplayName("only y coordinate provided")
	public void testY() {
		Point2D point = pB.y(16.7).build();
		assertEquals(point.getX(),0);
		assertEquals(point.getY(),16.7);
	}
	
	@Test
	@DisplayName("x and y coordinate provided")
	public void testXY() {
		Point2D point = pB.x(1.0).y(2.0).build();
		assertEquals(point.getX(),1.0);
		assertEquals(point.getY(),2.0);
	}
	
	@Test
	@DisplayName("Neither x nor y coordinate provided")
	public void testNull() {
		Point2D point = pB.build();
		assertEquals(point.getX(),0);
		assertEquals(point.getY(),0);
	}

}
