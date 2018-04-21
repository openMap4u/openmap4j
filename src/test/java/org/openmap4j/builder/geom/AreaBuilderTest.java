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

import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openmap4j.builder.geom.AreaBuilder;

public class AreaBuilderTest {

	AreaBuilder<Shape> ab = null;

	@BeforeEach
	public void before() {
		ab = new AreaBuilder<Shape>();
	}

	@Test
	public void test() {
		Shape path = ab.moveTo(3, 4).lineTo(10, 20).quadTo(30, 40, 50, 60).bezierTo(70, 80, 90, 100, 110, 120).build();
		Path2D path2 = new Path2D.Double();
		path2.moveTo(3, 4);
		path2.lineTo(10, 20);
		path2.quadTo(30, 40, 50, 60);
		path2.curveTo(80, 80, 90, 100, 110, 120);
		assertEquals(path.getBounds(), path2.getBounds());
	}

	@Test
	public void testAdd() {
		Shape path = ab.add(new Area(new Rectangle2D.Double(0, 0, 50, 100))).add(new Area(new Rectangle2D.Double(50, 0, 50, 100))).build();
		Shape path2 = new Rectangle2D.Double(0, 0, 100, 100);
		assertEquals(path.getBounds(),  path2.getBounds());
	}

	@Test
	public void testSubtract() {
		Shape path = ab.add(new Area(new Rectangle2D.Double(0, 0, 100, 100))).subtract(new Area(new Rectangle2D.Double(50, 0, 50, 100)))
				.build();
		Shape path2 = new Rectangle2D.Double(0, 0, 50, 100);
		assertEquals(path.getBounds(), path2.getBounds());
	}

	@Test
	public void testExclusiveOr() {
		Shape path = ab.add(new Area(new Rectangle2D.Double(0, 0, 100, 100))).exclusiveOr(new Area(new Rectangle2D.Double(50, 0, 50, 100)))
				.build();
		Shape path2 = new Rectangle2D.Double(0, 0, 50, 100);
		assertEquals(path.getBounds(),path2.getBounds());
	}
	
	@Test
	public void testIntersect() {
		Shape path = ab.add(new Area(new Rectangle2D.Double(0, 0, 100, 100))).intersect(new Area(new Rectangle2D.Double(50, 0, 50, 100)))
				.build();
		Shape path2 = new Rectangle2D.Double(0, 0, 100, 100);
		assertEquals(path.getBounds(), path2.getBounds());
	}

}
