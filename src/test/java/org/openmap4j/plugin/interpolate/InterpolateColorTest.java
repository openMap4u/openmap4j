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

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openmap4j.plugin.interpolate.InterpolateColor;
import org.openmap4j.scale.Interpolateable;
import org.openmap4j.scale.Scaleable;

@DisplayName("Interpolate color")
class InterpolateColorTest {

	 
	private Interpolateable<Color> linear;

	private Interpolateable<Color> linearClamp;
	
	@BeforeEach
	public void beforeEach() {
		linear = new InterpolateColor().range(NormalizeColorTestParamNoClamp.LEFT.color, NormalizeColorTestParamNoClamp.RIGHT.color).scale(Scaleable.LINEAR).clamp(false) ;
		linearClamp = new InterpolateColor().range(NormalizeColorTestParamClamp.LEFT.color, NormalizeColorTestParamClamp.RIGHT.color).scale(Scaleable.LINEAR).clamp(true);
	}

 	
	
	 		
		private enum NormalizeColorTestParamNoClamp {
			LEFT_OUTSIDE(new Color(0,0,0,0),-.5),
			LEFT(new Color((int)255/4,(int)255/4,(int)255/4,(int)1/4),0),
			MIDDLE(new Color(126,126,126,(int)1/2),0.5),
			RIGHT(new Color((int)255/4*3,(int)255/4*3,(int)255/4*3,(int)1/4*3),1.0),
			RIGHT_OUTSIDE(new Color(255,255,255,1),1.5238095238095237);
			
			Color color;
			double normalized;
			private NormalizeColorTestParamNoClamp(Color color, double normalized) {
				this.color=color;
				this.normalized=normalized;
			}
		}
		
		
		private enum NormalizeColorTestParamClamp {
			LEFT_OUTSIDE(new Color(0,0,0,0),0.0),
			LEFT(new Color((int)255/4,(int)255/4,(int)255/4,(int)1/4),0),
			MIDDLE(new Color( 126,126,126,(int)1/2),0.5),
			RIGHT(new Color((int)255/4*3,(int)255/4*3,(int)255/4*3,(int)1/4*3),1.0),
			RIGHT_OUTSIDE(new Color(255,255,255,1),1.0);
			
			Color color;
			double normalized;
			private NormalizeColorTestParamClamp(Color color, double normalized) {
				this.color=color;
				this.normalized=normalized;
			}
		}
	 
	 	 
	private enum DenormalizeColorTestParamClamp {
			LEFT_OUTSIDE(new Color((int)255/4,(int)255/4,(int)255/4,(int)1/4),-0.5),
			LEFT(new Color((int)255/4,(int)255/4,(int)255/4,(int)1/4),0),
			MIDDLE(new Color(126,126,126,(int)1/2),0.5),
			RIGHT(new Color((int)255/4*3,(int)255/4*3,(int)255/4*3,(int)1/4*3),1.0),
			RIGHT_OUTSIDE(new Color((int)255/4*3,(int)255/4*3,(int)255/4*3,(int)1/4*3) ,1.5);
			
			Color color;
			double normalized;
			private DenormalizeColorTestParamClamp(Color color, double normalized) {
				this.color=color;
				this.normalized=normalized;
			}
		}
	
	private enum DenormalizeColorTestParamNoClamp {
		LEFT_OUTSIDE(new Color(0,0,0,(int)1/4),-0.5),
		LEFT(new Color((int)255/4,(int)255/4,(int)255/4,(int)1/4),0),
		MIDDLE(new Color(126,126,126,(int)1/2),0.5),
		RIGHT(new Color((int)255/4*3,(int)255/4*3,(int)255/4*3,(int)1/4*3),1.0),
		RIGHT_OUTSIDE(new Color(252,252,252,(int)1/4*3) ,1.5);
		
		Color color;
		double normalized;
		private DenormalizeColorTestParamNoClamp(Color color, double normalized) {
			this.color=color;
			this.normalized=normalized;
		}
	}



	@ParameterizedTest
	@EnumSource(NormalizeColorTestParamNoClamp.class)
	@DisplayName("normalize clamp=false")
	void testNormalize_noClamp(NormalizeColorTestParamNoClamp testParam) {
		assertEquals(linear.normalize(testParam.color), testParam.normalized);
	}

	@ParameterizedTest
	@EnumSource(DenormalizeColorTestParamNoClamp.class)
	@DisplayName("denormalize clamp=false")
	void testDenormalize_noClamp(DenormalizeColorTestParamNoClamp testParam) {
		assertEquals(linear.denormalize(testParam.normalized), testParam.color);
	}

	@ParameterizedTest
	@EnumSource(NormalizeColorTestParamClamp.class)
	@DisplayName("normalize clamp=true")
	void testNormalize_clamp(NormalizeColorTestParamClamp testParam) {
		assertEquals(linearClamp.normalize(testParam.color),  testParam.normalized);
	}

	@ParameterizedTest
	@EnumSource(DenormalizeColorTestParamClamp.class)
	@DisplayName("denormalize clamp=true")
	void testDenormalize_clamp(DenormalizeColorTestParamClamp testParam) {
		assertEquals(linearClamp.denormalize(testParam.normalized), testParam.color);
	}
	

}
