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

import java.awt.geom.Path2D;

import org.openmap4j.style.LineSymbolizeable;
import org.openmap4j.style.Symbolizeable;

class LineSymbol extends Stroke<LineSymbol> implements Symbolizeable, LineSymbolizeable,SetLineSymbolizeable<LineSymbol> {
	
	private Path2D line=null;

	@Override
	public LineSymbol line(Path2D line) {
		this.line=line;
		return this;
	}

	@Override
	public Path2D getLine() {
		return this.line;
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other) 
		      return true; 
		   if (!super.equals(other)) 
		      return false;
			if (!(this.line.equals(((LineSymbol) other).getLine())))
				return false;
		   return true;
			
	}

}
