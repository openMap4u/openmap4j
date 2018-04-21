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
import java.nio.file.Path;

import org.openmap4j.style.ImageSymbolizeable;

class ImageSymbol extends Style<ImageSymbol>  implements ImageSymbolizeable,SetImageSymbolizeable<ImageSymbol> {
	
	private Path path=null;
	private Point2D point = new Point2D.Double(0, 0);

	@Override
	public Path getImagePath() {
		return this.path;
	}

	@Override
	public ImageSymbol imagePath(Path path2imageFile) {
		this.path=path2imageFile;
		return this;
	}

	@Override
	public  ImageSymbol x(double x) {
		this.point.setLocation(x, this.point.getY());
		return this;
	}

	@Override
	public  ImageSymbol y(double y) {
		this.point.setLocation(this.point.getX(), y);
		return this;
	}

	@Override
	public Point2D getPoint() {
		return this.point;
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other) 
		      return true; 
		   if (!super.equals(other)) 
		      return false;
			if (!(this.path.equals(((ImageSymbol) other).getImagePath())))
				return false;
			if (!(this.point.equals(((ImageSymbol) other).getPoint())))
				return false;
			return true;
	}

}
