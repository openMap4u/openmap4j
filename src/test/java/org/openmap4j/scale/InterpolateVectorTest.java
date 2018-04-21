package org.openmap4j.scale;

/*-
 * #%L
 * openmap4u-core
 * %%
 * Copyright (C) 2014 - 2018 openMap4u
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
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openmap4j.scale.AbstractInterpolate;

class InterpolateVectorTest {
	
	private double[] a =null;
	private double[] b =null;
	
	@BeforeEach
	void beforeEach() {
		a = new double[] {2,3,4};
		b = new double[] {5,7,11};
		
		
	}

	@Test
	void testAdd() {
		 assertTrue(Arrays.equals(AbstractInterpolate.add(a, b),new double[] {7.0,10.0,15.0}));
	}
	
	@Test
	void testSubtract() {
		 assertTrue(Arrays.equals(AbstractInterpolate.subtract(a, b),new double[] {-3.0,-4.0,-7.0}));
	}
	
	@Test
	void testLerp() {
		 assertTrue(Arrays.equals(AbstractInterpolate.lerp(0,a, b),a));
		 assertTrue(Arrays.equals(AbstractInterpolate.lerp(1,a, b),b));
	}
	
	@Test
	void testMagnitude() {
		 assertEquals(AbstractInterpolate.magnitude(a),Math.sqrt(2.0*2.0+3.0*3.0+4.0*4.0));
	}

	@Test
	void testProject() {
		
		double test1 = AbstractInterpolate.project(a, a,b);
		System.out.println(test1);
		double test2 = AbstractInterpolate.project(b, a,b);
		System.out.println(test2);
 
		 assertEquals(AbstractInterpolate.magnitude(a),Math.sqrt(2.0*2.0+3.0*3.0+4.0*4.0));
	}

	
}
