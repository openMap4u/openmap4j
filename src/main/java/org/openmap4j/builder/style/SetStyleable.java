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

interface SetStyleable<S extends SetStyleable<S>> {

	/**
	 * Sets the opacity value of the primitive. 0 is fully transparent (= not
	 * visible at all). 1 is complete solid (= not transparent at all).)
	 * 
	 * @param alpha
	 *            The alpha value. Valid values range from 0 to 1.
	 * @return Method chaining pattern.
	 */
	S alpha(double alpha);

	/**
	 * Sets the visibility.
	 * 
	 * @param visible
	 *            The visibility (true ... visible, false ... not visible).
	 * @return Method chaining pattern.
	 */
	S visible(boolean visible);

}
