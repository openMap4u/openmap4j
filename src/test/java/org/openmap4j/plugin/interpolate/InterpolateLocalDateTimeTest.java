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

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openmap4j.plugin.interpolate.InterpolateLocalDateTime;
import org.openmap4j.scale.Interpolateable;
import org.openmap4j.scale.Scaleable;

@DisplayName("Interpolate local date time")
class InterpolateLocalDateTimeTest {

	 
	private Interpolateable<LocalDateTime> localDateTime;

	private Interpolateable<LocalDateTime> localDateTimeClamp;
	
	
	
	 		
		private enum LocalDateTimeParamsNoClamp {
			LEFT_OUTSIDE( LocalDateTime.of(2017,1,15,12,00),-.5),
			LEFT(LocalDateTime.of(2017,1,16,12,00),0.0),
			MIDDLE(LocalDateTime.of(2017,1,17,12,00),0.5),
			RIGHT(LocalDateTime.of(2017,1,18,12,00),1.0),
			RIGHT_OUTSIDE(LocalDateTime.of(2017,1,19,12,00),1.5);
			
			LocalDateTime  localDateTime;
			double normalized;
			private LocalDateTimeParamsNoClamp(LocalDateTime localDateTime, double normalized) {
				this.localDateTime=localDateTime;
				this.normalized=normalized;
			}
		}
		
		private enum NormalizeLocalDateTimeParamsClamp {
			LEFT_OUTSIDE( LocalDateTime.of(2017,1,15,12,00),0.0),
			LEFT(LocalDateTime.of(2017,1,16,12,00),0.0),
			MIDDLE(LocalDateTime.of(2017,1,17,12,00),0.5),
			RIGHT(LocalDateTime.of(2017,1,18,12,00),1.0),
			RIGHT_OUTSIDE(LocalDateTime.of(2017,1,19,12,00),1.0);
			
			LocalDateTime localDateTime;
			double normalized;
			private NormalizeLocalDateTimeParamsClamp(LocalDateTime localDateTime, double normalized) {
				this.localDateTime=localDateTime;
				this.normalized=normalized;
			}
		}
	
	 
	private enum DenormalizeLocalDateTimeParamsClamp {
			LEFT_OUTSIDE( LocalDateTime.of(2017,1,16,12,00),-0.5),
			LEFT(LocalDateTime.of(2017,1,16,12,00),0.0),
			MIDDLE(LocalDateTime.of(2017,1,17,12,00),0.5),
			RIGHT(LocalDateTime.of(2017,1,18,12,00),1.0),
			RIGHT_OUTSIDE(LocalDateTime.of(2017,1,18,12,00),1.5);
			
			LocalDateTime localDateTime;
			double normalized;
			private DenormalizeLocalDateTimeParamsClamp(LocalDateTime localDateTime, double normalized) {
				this.localDateTime=localDateTime;
				this.normalized=normalized;
			}
		}

	@BeforeEach
	public void beforeEach() {
		localDateTime = new InterpolateLocalDateTime().range(LocalDateTimeParamsNoClamp.LEFT.localDateTime, LocalDateTimeParamsNoClamp.RIGHT.localDateTime).scale( Scaleable.LINEAR).clamp( false);
		localDateTimeClamp = new InterpolateLocalDateTime().range(NormalizeLocalDateTimeParamsClamp.LEFT.localDateTime, NormalizeLocalDateTimeParamsClamp.RIGHT.localDateTime).scale( Scaleable.LINEAR).clamp( true);
	}

	@ParameterizedTest
	@EnumSource(LocalDateTimeParamsNoClamp.class)
	@DisplayName("normalize clamp=false")
	void testNormalize_noClamp(LocalDateTimeParamsNoClamp testParam) {
		assertEquals(localDateTime.normalize(testParam.localDateTime), testParam.normalized);
	}

	@ParameterizedTest
	@EnumSource(LocalDateTimeParamsNoClamp.class)
	@DisplayName("denormalize clamp=false")
	void testDenormalize_noClamp(LocalDateTimeParamsNoClamp testParam) {
		assertEquals(localDateTime.denormalize(testParam.normalized), testParam.localDateTime);
	}

	@ParameterizedTest
	@EnumSource(NormalizeLocalDateTimeParamsClamp.class)
	@DisplayName("normalize clamp=true")
	void testNormalize_clamp(NormalizeLocalDateTimeParamsClamp testParam) {
		assertEquals(localDateTimeClamp.normalize(testParam.localDateTime),  testParam.normalized);
	}

	@ParameterizedTest
	@EnumSource(DenormalizeLocalDateTimeParamsClamp.class)
	@DisplayName("denormalize clamp=true")
	void testDenormalize_clamp(DenormalizeLocalDateTimeParamsClamp testParam) {
		assertEquals(localDateTimeClamp.denormalize(testParam.normalized), testParam.localDateTime);
	}

}
