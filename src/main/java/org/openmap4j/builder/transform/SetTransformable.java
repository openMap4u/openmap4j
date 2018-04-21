package org.openmap4j.builder.transform;

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

interface SetTransformable<B extends  SetTransformable<B>> {
	
	/**
	 * Sets the rotation.
	 * @param theta The rotation.
	 * @return The fluent builder pattern.
	 */
	B rotate(double theta);

	/**
	 * Sets the same scale factor in x and y direction.
	 * @param scale The scale factor (in x and y direction)
	 * 
	 * @return The fluent builder pattern.
	 */
	B scale(double scale);

	/**
	 * Sets the x and y scale factor.
	 * @param scaleX The x scale factor.
	 * @param scaleY The y scale factor.
	 * 
	 * @return The fluent builder pattern.
	 */
	B scale(double scaleX, double scaleY);

	/**
	 * Sets the x and y translation.
	 * @param translateX The x translation.
	 * @param translateY The y translation.
	 * 
	 * @return The fluent builder pattern.
	 */
	B translate(double translateX, double translateY);

	/**
	 * Sets the x and y shear.
	 * @param shearX The x shear.
	 * @param shearY The y shear.
	 * 
	 * @return The fluent builder pattern.
	 */
	B shear(double shearX, double shearY);


}
