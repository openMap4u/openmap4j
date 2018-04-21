package org.openmap4j.builder.style;

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

/**
 * Sets the location.
 * @author michael hadrbolec
 *
 * @param <B> The fluent builder type.
 */
interface SetLocation<B extends SetLocation<B>> {

	/**
	 * Sets the x coordinate of the location.
	 * @param x Sets the x coordinate of the location.
	 * @return The fluent builder pattern.
	 */
	B x(double x);

	/**
	 * Sets the y coordinate of the location.
	 * @param y Sets the y coordinate of the location.
	 * @return The fluent builder pattern.
	 */
	B y(double y);

}
