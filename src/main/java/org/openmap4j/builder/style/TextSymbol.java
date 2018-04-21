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

import java.awt.geom.Point2D;

import org.openmap4j.style.TextSymbolizeable;

class TextSymbol extends AbstractTextStyle<TextSymbol>
		implements TextSymbolizeable, SetTextSymbolizeable<TextSymbol> {

	private String text = null;

	private Point2D point = new Point2D.Double(0, 0);

	@Override
	public TextSymbol text(String text) {
		this.text = text;
		return this;
	}

	@Override
	public String getText() {
		return this.text;
	}

	@Override
	public Point2D getPoint() {
		return this.point;
	}

	@Override
	public TextSymbol x(double x) {
		this.point.setLocation(x, this.point.getY());
		return this;
	}

	@Override
	public TextSymbol y(double y) {
		this.point.setLocation(this.point.getX(), y);
		return this;
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!super.equals(other))
			return false;
		if (!(this.point.equals(((TextSymbol) other).getPoint())))
			return false;
		if (!(this.text.equals(((TextSymbol) other).getText())))
			return false;

	return true;
	}

}
