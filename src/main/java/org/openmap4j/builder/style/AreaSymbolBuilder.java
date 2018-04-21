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

import java.awt.Paint;
import java.awt.Shape;

import org.openmap4j.builder.geom.AreaBuildable;
import org.openmap4j.builder.geom.GeomBuilderFactory;
import org.openmap4j.common.NestedBuilder;
import org.openmap4j.style.AreaSymbolizeable;
import org.openmap4j.style.Strokeable.LINE_JOIN;
import org.openmap4j.style.Strokeable.STROKE_CAP;

class AreaSymbolBuilder<P> extends NestedBuilder<P,AreaSymbolizeable> implements AreaSymbolBuildable<P> {
	
	private AreaSymbol shapeSymbol = new AreaSymbol();

	
	@Override
	public AreaSymbolBuildable<P> visible(boolean visible) {
		this.shapeSymbol.visible(visible);
		return this;
	}

	@Override
	public AreaSymbolBuildable<P> alpha(double alpha) {
		this.shapeSymbol.alpha(alpha);
		return this;
	}
	
	
	@Override
	public AreaSymbolBuildable<P> area(Shape shape) {
		this.shapeSymbol.area(shape);
		return this;
	}
	
	public AreaBuildable< AreaSymbolBuildable<P>> area() {
		return GeomBuilderFactory.getAreaBuilder(this, "area");
	}

	@Override
	public AreaSymbolBuildable<P> strokeColor(Paint lineColor) {
		this.shapeSymbol.strokeColor(lineColor);
		return this;
	}

	@Override
	public AreaSymbolBuildable<P> strokeDashArray(double... segments) {
		this.shapeSymbol.strokeDashArray(segments);
		return this;
	}

	@Override
	public AreaSymbolBuildable<P> strokeDashOffset(double lineDashOffset) {
		this.shapeSymbol.strokeDashOffset(lineDashOffset);
		return this;
	}

	@Override
	public AreaSymbolBuildable<P> strokeCap(STROKE_CAP strokeCap) {
		this.shapeSymbol.strokeCap(strokeCap);
		return this;
	}

	@Override
	public AreaSymbolBuildable<P> strokeJoin(LINE_JOIN lineJoin) {
		this.shapeSymbol.strokeJoin(lineJoin);
		return this;
	}

	@Override
	public AreaSymbolBuildable<P> strokeMiterLimit(double mitterLimit) {
		this.shapeSymbol.strokeMiterLimit(mitterLimit);
		return this;
	}

	@Override
	public AreaSymbolBuildable<P> strokeWidth(double lineWidth) {
		this.shapeSymbol.strokeWidth(lineWidth);
		return this;
	}

	@Override
	public AreaSymbolBuildable<P> fill(Paint fill) {
		this.shapeSymbol.fill(fill);
		return this;
	}

	@Override
	protected AreaSymbolizeable buildNested() {
		return this.shapeSymbol;
	}
}
