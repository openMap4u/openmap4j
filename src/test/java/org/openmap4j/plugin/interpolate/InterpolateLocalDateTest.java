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

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openmap4j.plugin.interpolate.InterpolateLocalDate;
import org.openmap4j.scale.Interpolateable;
import org.openmap4j.scale.Scaleable;

@DisplayName("Interpolate local date")
class InterpolateLocalDateTest {

	 
	private Interpolateable<LocalDate> localDate;

	private Interpolateable<LocalDate> localDateClamp;
	
	
	
	 		
		private enum LocalDateParamsNoClamp {
			LEFT_OUTSIDE( LocalDate.of(2017,1,15),-.5),
			LEFT(LocalDate.of(2017,1,16),0.0),
			MIDDLE(LocalDate.of(2017,1,17),0.5),
			RIGHT(LocalDate.of(2017,1,18),1.0),
			RIGHT_OUTSIDE(LocalDate.of(2017,1,19),1.5);
			
			LocalDate localDate;
			double normalized;
			private LocalDateParamsNoClamp(LocalDate localDate, double normalized) {
				this.localDate=localDate;
				this.normalized=normalized;
			}
		}
		
		private enum NormalizeLocalDateParamsClamp {
			LEFT_OUTSIDE( LocalDate.of(2017,1,15),0.0),
			LEFT(LocalDate.of(2017,1,16),0.0),
			MIDDLE(LocalDate.of(2017,1,17),0.5),
			RIGHT(LocalDate.of(2017,1,18),1.0),
			RIGHT_OUTSIDE(LocalDate.of(2017,1,19),1.0);
			
			LocalDate localDate;
			double normalized;
			private NormalizeLocalDateParamsClamp(LocalDate localDate, double normalized) {
				this.localDate=localDate;
				this.normalized=normalized;
			}
		}
		
		private enum DenormalizeLocalDateParamsClamp {
			LEFT_OUTSIDE( LocalDate.of(2017,1,16),-0.5),
			LEFT(LocalDate.of(2017,1,16),0.0),
			MIDDLE(LocalDate.of(2017,1,17),0.5),
			RIGHT(LocalDate.of(2017,1,18),1.0),
			RIGHT_OUTSIDE(LocalDate.of(2017,1,18),1.5);
			
			LocalDate localDate;
			double normalized;
			private DenormalizeLocalDateParamsClamp(LocalDate localDate, double normalized) {
				this.localDate=localDate;
				this.normalized=normalized;
			}
		}
	
	 
	@BeforeEach
	public void beforeEach() {
		localDate = new InterpolateLocalDate().range(LocalDateParamsNoClamp.LEFT.localDate, LocalDateParamsNoClamp.RIGHT.localDate).scale( Scaleable.LINEAR).clamp( false);
		localDateClamp = new InterpolateLocalDate().range(NormalizeLocalDateParamsClamp.LEFT.localDate, NormalizeLocalDateParamsClamp.RIGHT.localDate).scale( Scaleable.LINEAR).clamp( true);
	}

	@ParameterizedTest
	@EnumSource(LocalDateParamsNoClamp.class)
	@DisplayName("normalize clamp=false")
	void testNormalize_noClamp(LocalDateParamsNoClamp testParam) {
		assertEquals(localDate.normalize(testParam.localDate), testParam.normalized);
	}

	@ParameterizedTest
	@EnumSource(LocalDateParamsNoClamp.class)
	@DisplayName("denormalize clamp=false")
	void testDenormalize_noClamp(LocalDateParamsNoClamp testParam) {
		assertEquals(localDate.denormalize(testParam.normalized), testParam.localDate);
	}

	@ParameterizedTest
	@EnumSource(NormalizeLocalDateParamsClamp.class)
	@DisplayName("normalize clamp=true")
	void testNormalize_clamp(NormalizeLocalDateParamsClamp testParam) {
		assertEquals(localDateClamp.normalize(testParam.localDate),  testParam.normalized);
	}

	@ParameterizedTest
	@EnumSource(DenormalizeLocalDateParamsClamp.class)
	@DisplayName("denormalize clamp=true")
	void testDenormalize_clamp(DenormalizeLocalDateParamsClamp testParam) {
		assertEquals(localDateClamp.denormalize(testParam.normalized), testParam.localDate);
	}

}
