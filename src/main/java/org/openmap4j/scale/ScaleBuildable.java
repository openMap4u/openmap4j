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

import java.util.function.Function;

import org.openmap4j.common.Buildable;
/**
 * Builder to build a scaling function between the given input and output type.
 * @author hadrbolec
 *
 * @param <I> The input type.
 * @param <O> The output type.
 */
public interface ScaleBuildable<I,O> extends Buildable<Function<I,O>> {
	
	/**
	 * Scales the input type.
	 * @param scale How to scale the input type.
	 * @return The fluent builder pattern.
	 */
	ScaleBuildable<I,O> scale(Scaleable scale);

	/**
	 * The values to scale the input from.
	 * @param fromValue The minimal input value.
	 * @param toValue The maximal input value.
	 * @return The fluent builder pattern.
	 */
	ScaleBuildable<I,O> from(I fromValue, I toValue);
	
	/**
	 * The values to scale the output from.
	 * @param fromValue The minimal output value.
	 * @param toValue The maximal output value.
	 * @return The fluent builder pattern.
	 */
	ScaleBuildable<I,O> to(O fromValue, O toValue);
 
  
	/**
	 * Whether to clamp the values. Which means whether to extrapolate or not.
	 * @param clamp false if you want to extrapolate (= default value), true if not.
	 * @return The fluent builder pattern.
	 */
	ScaleBuildable<I,O> clamp(boolean clamp);


	
	
}
