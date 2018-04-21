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
import org.openmap4j.style.AreaStyleable;
import org.openmap4j.style.Strokeable.LINE_JOIN;
import org.openmap4j.style.Strokeable.STROKE_CAP;

 class AreaStyleBuilder<P> extends NestedBuilder<P,AreaStyleable> implements AreaStyleBuildeable<P> {
	
	public AreaStyleBuilder() {
		super();
	}

	public AreaStyleBuilder(P parent, String parentMethodName) {
		super(parent, parentMethodName);
	}

	private AreaStyle shapeStyle = new AreaStyle();

	
	
	@Override
	public AreaStyleBuildeable<P> alpha(double alpha) {
		this.shapeStyle.alpha(alpha);
		return this;
	}

	@Override
	public AreaStyleBuildeable<P> visible(boolean visible) {
		this.shapeStyle.visible(visible);
		return this;
	}

	
	
	@Override
	public AreaStyleBuildeable<P> strokeColor(Paint lineColor) {
		this.shapeStyle.strokeColor(lineColor);
		return this;
	}

	@Override
	public AreaStyleBuildeable<P> strokeDashArray(double... segments) {
		this.shapeStyle.strokeDashArray(segments);
		return this;
	}

	@Override
	public AreaStyleBuildeable<P> strokeDashOffset(double lineDashOffset) {
		this.shapeStyle.strokeDashOffset(lineDashOffset);
		return this;
	}

	@Override
	public AreaStyleBuildeable<P> strokeCap(STROKE_CAP strokeCap) {
		this.shapeStyle.strokeCap(strokeCap);
		return this;
	}

	@Override
	public AreaStyleBuildeable<P> strokeJoin(LINE_JOIN lineJoin) {
		this.shapeStyle.strokeJoin(lineJoin);
		return this;
	}

	@Override
	public AreaStyleBuildeable<P> strokeMiterLimit(double mitterLimit) {
		this.shapeStyle.strokeMiterLimit(mitterLimit);
		return this;
	}

	@Override
	public AreaStyleBuildeable<P> strokeWidth(double lineWidth) {
		this.shapeStyle.strokeWidth(lineWidth);
		return this;
	}

	@Override
	public AreaStyleBuildeable<P> fill(Paint fill) {
		this.shapeStyle.fill(fill);
		return this;
	}

	@Override
	protected AreaStyleable buildNested() {
		return this.shapeStyle;
	}


	 

}
