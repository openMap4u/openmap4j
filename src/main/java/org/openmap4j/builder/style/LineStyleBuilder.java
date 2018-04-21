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

import org.openmap4j.common.NestedBuilder;
import org.openmap4j.style.LineStyleable;
import org.openmap4j.style.Strokeable.LINE_JOIN;
import org.openmap4j.style.Strokeable.STROKE_CAP;

class LineStyleBuilder<P> extends NestedBuilder<P,LineStyleable> implements LineStyleBuildable<P> {
	
	public LineStyleBuilder() {
		super();
	}

	public LineStyleBuilder(P parent, String parentMethodName) {
		super(parent, parentMethodName);
	}

	private LineStyle lineStyle = new LineStyle();

	@Override
	public LineStyleBuildable<P> alpha(double alpha) {
		lineStyle.alpha(alpha);
		return this;
	}

	@Override
	public LineStyleBuildable<P> visible(boolean visible) {
		lineStyle.visible(visible);
		return this;
	}

	@Override
	public LineStyleBuildable<P> strokeColor(Paint strokeColor) {
		lineStyle.strokeColor(strokeColor);
		return this;
	}

	@Override
	public LineStyleBuildable<P> strokeDashArray(double... segments) {
		lineStyle.strokeDashArray(segments);
		return this;
	}

	@Override
	public LineStyleBuildable<P> strokeDashOffset(double strokeDashOffset) {
		lineStyle.strokeDashOffset(strokeDashOffset);
		return this;
	}

	@Override
	public LineStyleBuildable<P> strokeCap(STROKE_CAP strokeCap) {
		lineStyle.strokeCap(strokeCap);
		return this;
	}

	@Override
	public LineStyleBuildable<P> strokeJoin(LINE_JOIN strokeJoin) {
		lineStyle.strokeJoin(strokeJoin);
		return this;
	}

	@Override
	public LineStyleBuildable<P> strokeMiterLimit(double mitterLimit) {
		lineStyle.strokeMiterLimit(mitterLimit);
		return this;
	}

	@Override
	public LineStyleBuildable<P> strokeWidth(double lineWidth) {
		lineStyle.strokeWidth(lineWidth);
		return this;
	}

	@Override
	protected LineStyleable buildNested() {
		return this.lineStyle;
	}

	
}
