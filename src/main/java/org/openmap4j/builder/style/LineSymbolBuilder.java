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
import java.awt.geom.Path2D;

import org.openmap4j.builder.geom.GeomBuilderFactory;
import org.openmap4j.builder.geom.LineBuildable;
import org.openmap4j.common.NestedBuilder;
import org.openmap4j.style.LineSymbolizeable;
import org.openmap4j.style.Strokeable.LINE_JOIN;
import org.openmap4j.style.Strokeable.STROKE_CAP;

class LineSymbolBuilder<P> extends NestedBuilder<P, LineSymbolizeable> implements LineSymbolBuildable<P> {

	public LineSymbolBuilder() {
		super();
	}

	public LineSymbolBuilder(P parent, String parentMethodName) {
		super(parent, parentMethodName);
	}

	private LineSymbol lineSymbol = new LineSymbol();
	
	@Override
	public LineSymbolBuildable<P> alpha(double alpha) {
		this.lineSymbol.alpha(alpha);
		return this;
	}

	@Override
	public LineSymbolBuildable<P> visible(boolean visible) {
		this.lineSymbol.visible(visible);
		return this;
	}

	@Override
	public LineSymbolBuildable<P> line(Path2D line) {
		lineSymbol.line(line);
		return this;
	}

	@Override
	public LineSymbolBuildable<P> strokeColor(Paint lineColor) {
		lineSymbol.strokeColor(lineColor);
		return this;
	}

	@Override
	public LineSymbolBuildable<P> strokeDashArray(double... segments) {
		lineSymbol.strokeDashArray(segments);
		return this;
	}

	@Override
	public LineSymbolBuildable<P> strokeDashOffset(double lineDashOffset) {
		lineSymbol.strokeDashOffset(lineDashOffset);
		return this;
	}

	@Override
	public LineSymbolBuildable<P> strokeCap(STROKE_CAP strokeCap) {
		lineSymbol.strokeCap(strokeCap);
		return this;
	}

	@Override
	public LineSymbolBuildable<P> strokeJoin(LINE_JOIN lineJoin) {
		lineSymbol.strokeJoin(lineJoin);
		return this;
	}

	@Override
	public LineSymbolBuildable<P> strokeMiterLimit(double mitterLimit) {
		lineSymbol.strokeMiterLimit(mitterLimit);
		return this;
	}

	@Override
	public LineSymbolBuildable<P> strokeWidth(double lineWidth) {
		lineSymbol.strokeWidth(lineWidth);
		return this;
	}

	@Override
	protected LineSymbolizeable buildNested() {
		return this.lineSymbol;
	}

	@Override
	public LineBuildable<LineSymbolBuildable<P>> line() {
 		return GeomBuilderFactory.getLineBuilder(this,"line");
	}



}
