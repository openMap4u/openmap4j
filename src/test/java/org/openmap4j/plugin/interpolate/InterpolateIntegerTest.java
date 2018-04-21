package org.openmap4j.plugin.interpolate;

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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openmap4j.plugin.interpolate.InterpolateInteger;
import org.openmap4j.scale.AbstractInterpolate;
import org.openmap4j.scale.Scaleable;

@DisplayName("Interpolate integer")
class InterpolateIntegerTest {

	 
	private AbstractInterpolate<Integer> linear;

	private AbstractInterpolate<Integer> linearClamp;

	@BeforeEach
	public void beforeEach() {
		linear = new InterpolateInteger().range(100, 200).scale(Scaleable.LINEAR).clamp(false);
		linearClamp = new InterpolateInteger().range(100, 200).scale( Scaleable.LINEAR).clamp( true);
	}

	@ParameterizedTest
	@CsvSource({  "50, -0.5", "100, 0.0", "150,.5", "200,1", "250,1.5" })
	@DisplayName("normalize clamp=false")
	void testNormalize_noClamp(int value, double normalized) {
		assertEquals(linear.normalize(value), normalized);
	}

	@ParameterizedTest
	@CsvSource({ "50, -0.5", "100, 0.0", "150,.5", "200,1", "250,1.5" })
	@DisplayName("denormalize clamp=false")
	void testDenormalize_noClamp(int value, double normalized) {
		assertEquals(linear.denormalize(normalized), Integer.valueOf(value));
	}

	@ParameterizedTest
	@CsvSource({ "50, 0.0", "100, 0.0", "150,.5", "200,1", "250,1.0" })
	@DisplayName("normalize clamp=true")
	void testNormalize_clamp(int value, double normalized) {
		assertEquals(linearClamp.normalize(value),  normalized);
	}

	@ParameterizedTest
	@CsvSource({ "50, -0.5", "100, 0.0", "150,.5", "200,1", "250,1.5" })
	@DisplayName("denormalize clamp=true")
	void testDenormalize_clamp(int value, double normalized) {
		assertEquals(linear.denormalize(normalized), Integer.valueOf(value));
	}

}
