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

import java.nio.file.Path;

import org.openmap4j.common.NestedBuilder;
import org.openmap4j.style.ImageSymbolizeable;

class ImageSymbolBuilder<P> extends NestedBuilder<P,ImageSymbolizeable> implements ImageSymbolBuildable<P> {

	private ImageSymbol imageSymbol = new ImageSymbol();
	 
	@Override
	public ImageSymbolBuildable<P> imagePath(Path path2imageFile) {
		this.imageSymbol.imagePath(path2imageFile);
		return this;
	}



	@Override
	public ImageSymbolBuildable<P> alpha(double alpha) {
		this.imageSymbol.alpha(alpha);
		return this;
	}



	@Override
	public ImageSymbolBuildable<P> visible(boolean visible) {
		this.imageSymbol.visible(visible);
		return this;
	} 

	@Override
	protected ImageSymbolizeable buildNested() {
		return imageSymbol;
	}
	
	@Override
	public ImageSymbolBuildable<P> x(double x) {
		this.imageSymbol.x(x);
		return this;
	}

	@Override
	public ImageSymbolBuildable<P> y(double y) {
		this.imageSymbol.y(y);
		return this;
	}



	

}
