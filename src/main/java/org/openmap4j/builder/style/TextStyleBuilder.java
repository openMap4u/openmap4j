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
import org.openmap4j.style.TextStyleable;
import org.openmap4j.style.Strokeable.LINE_JOIN;
import org.openmap4j.style.Strokeable.STROKE_CAP;
import org.openmap4j.style.TextStyleable.BASE_LINE;
import org.openmap4j.style.TextStyleable.FONT_STYLE;
import org.openmap4j.style.TextStyleable.TEXT_ALIGN;

class TextStyleBuilder<P> extends NestedBuilder<P, TextStyleable> implements TextStyleBuildable<P> {

	public TextStyleBuilder() {
		super();
	}

	public TextStyleBuilder(P parent, String parentMethodName) {
		super(parent, parentMethodName);
	}

	private TextStyle textSymbol = new TextStyle();

	@Override
	public TextStyleBuildable<P> fill(Paint fill) {
		this.textSymbol.fill(fill);
		return this;
	}
	
	@Override
	public TextStyleBuildable<P> align(TEXT_ALIGN textAlign) {
		this.textSymbol.align(textAlign);
		return this;
	}

	@Override
	public TextStyleBuildable<P> baseLine(BASE_LINE baseLine) {
		this.textSymbol.baseLine(baseLine);
		return this;
	}

	@Override
	public TextStyleBuildable<P> fontFamily(String fontFamily) {
		this.textSymbol.fontFamily(fontFamily);
		return this;
	}

	@Override
	public TextStyleBuildable<P> fontSize(double fontSize) {
		this.textSymbol.fontSize(fontSize);
		return this;
	}

	@Override
	public TextStyleBuildable<P> fontStyle(FONT_STYLE fontStyle) {
		this.textSymbol.fontStyle(fontStyle);
		return this;
	}

	@Override
	public TextStyleBuildable<P> alpha(double alpha) {
		this.textSymbol.alpha(alpha);
		return this;
	}

	@Override
	public TextStyleBuildable<P> visible(boolean visible) {
		this.textSymbol.visible(visible);
		return this;
	}

	@Override
	protected TextStyleable buildNested() {
		return this.textSymbol;
	}

	@Override
	public TextStyleBuildable<P> strokeColor(Paint lineColor) {
		this.textSymbol.strokeColor(lineColor);
		return this;
	}

	@Override
	public TextStyleBuildable<P> strokeDashArray(double... segments) {
		this.textSymbol.strokeDashArray(segments);
		return this;
	}

	@Override
	public TextStyleBuildable<P> strokeDashOffset(double lineDashOffset) {
		this.textSymbol.strokeDashOffset(lineDashOffset);
		return this;
	}

	@Override
	public TextStyleBuildable<P> strokeCap(STROKE_CAP strokeCap) {
		this.textSymbol.strokeCap(strokeCap);
		return this;
	}

	@Override
	public TextStyleBuildable<P> strokeJoin(LINE_JOIN lineJoin) {
		this.textSymbol.strokeJoin(lineJoin);
		return this;
	}

	@Override
	public TextStyleBuildable<P> strokeMiterLimit(double mitterLimit) {
		this.textSymbol.strokeMiterLimit(mitterLimit);
		return this;
	}

	@Override
	public TextStyleBuildable<P> strokeWidth(double lineWidth) {
		this.textSymbol.strokeWidth(lineWidth);
		return this;
	}

	

}
