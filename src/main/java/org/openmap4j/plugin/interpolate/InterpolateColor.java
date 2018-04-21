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

import java.awt.Color;

import org.openmap4j.scale.AbstractInterpolate;

/**
 * Interpolates between colors.
 * 
 * @author hadrbolec
 *
 */
public class InterpolateColor extends AbstractInterpolate<Color> {

 
	 

	@Override
	protected double[] vectorize(Color value) {
		return new double[] {value.getRed(),value.getGreen(),value.getBlue(),value.getAlpha()};
	}

	@Override
	protected Color devectorize(double[] vector) {
		return new Color((int)vector[0],(int)vector[1],(int)vector[2],(int)vector[3]);
	}

	@Override
	public boolean canInterpolate(Object object) {
		return object!=null && object instanceof Color;
	}

}
