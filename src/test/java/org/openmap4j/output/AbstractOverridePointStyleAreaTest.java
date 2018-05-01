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
package org.openmap4j.output;

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

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import org.openmap4j.builder.style.StyleBuilderFactory;
import org.openmap4j.mock.MockValue;
import org.openmap4j.style.Symbolizeable;

public abstract class AbstractOverridePointStyleAreaTest extends AbstractOverridePointStyleTest  {
	
	

	@Override
	Symbolizeable[] getSymbol() {
		return new Symbolizeable[] {StyleBuilderFactory.getAreaSymbolBuilder().area(new Rectangle2D.Double(-12.5, -12.5, 25, 25))
				.strokeColor(Color.BLACK).strokeWidth(1).build()
		
		};
	}
	
	@ParameterizedTest
	@MethodSource("mockValueProvider")
	public void testDefault(MockValue mockValue) {
		double y = 50;
		canvas.draw(mockValue.getX(), y);
	}
	
	@ParameterizedTest
	@MethodSource("mockValueProvider")
	public void testOverrideDefault(MockValue mockValue) {
		double y = 150;
		canvas.draw(mockValue.getX(), y,StyleBuilderFactory.getAreaStyleBuilder().strokeColor(mockValue.getStrokeColor()).build());
	}
	
	@ParameterizedTest
	@MethodSource("mockValueProvider")
	public void testOverrideFill(MockValue mockValue) {
		double y = 250;
		canvas.draw(mockValue.getX(), y,StyleBuilderFactory.getAreaStyleBuilder().fill(mockValue.getStrokeColor()).build());
	}


}
