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

import java.awt.Shape;

import org.openmap4j.style.AreaSymbolizeable;

class AreaSymbol extends Fill<AreaSymbol> implements AreaSymbolizeable, SetAreaSymbolizeable<AreaSymbol> {

	private Shape shape = null;

	public Shape getArea() {
		return this.shape;
	}

	@Override
	public AreaSymbol area(Shape shape) {
		this.shape = shape;
		return this;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!super.equals(other))
			return false;

		if (!(this.shape.equals(((AreaSymbol) other).getArea())))
			return false;

		return true;
	}

}
