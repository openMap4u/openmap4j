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
import java.util.Optional;

import org.openmap4j.style.Strokeable;

class Stroke<B extends Stroke<B>> extends Style<B> implements Strokeable, SetStrokeable<B> {

	private Optional<STROKE_CAP> lineCap = Optional.empty();
	private Optional<Paint> lineColor = Optional.empty();
	private Optional<double[]> lineDash = Optional.empty();
	private Optional<Double> lineDashOffset = Optional.empty();
	private Optional<LINE_JOIN> lineJoin = Optional.empty();
	private Optional<Double> lineWidth = Optional.empty();
	private Optional<Double> mitterLimit = Optional.empty();

	public Stroke() {
		super();
	}

	/**
	 * @return the lineCap
	 */
	public Optional<STROKE_CAP> getStrokeCap() {
		return lineCap;
	}

	/**
	 * @return the lineColor
	 */
	public Optional<Paint> getStrokeColor() {
		return this.lineColor;
	}

	/**
	 * @return the lineDash
	 */
	public Optional<double[]> getStrokeDashArray() {
		return this.lineDash;
	}

	/**
	 * @return the lineDashOffset
	 */
	public Optional<Double> getStrokeDashOffset() {
		return this.lineDashOffset;
	}

	/**
	 * @return the lineJoin
	 */
	public Optional<LINE_JOIN> getStrokeJoin() {
		return lineJoin;
	}

	/**
	 * @return the lineWidth
	 */
	public Optional<Double> getStrokeWidth() {
		return lineWidth;
	}

	/**
	 * @return the mitterLimit
	 */
	public Optional<Double> getStrokeMiterLimit() {
		return mitterLimit;
	}

	@SuppressWarnings("unchecked")
	public B strokeColor(Paint lineColor) {
		this.lineColor = Optional.of(lineColor);
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	public B strokeDashArray(double... segments) {
		this.lineDash = Optional.of(segments);
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	public B strokeDashOffset(double lineDashOffset) {
		this.lineDashOffset = Optional.of(lineDashOffset);
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	public B strokeCap(STROKE_CAP lineCap) {
		this.lineCap = Optional.of(lineCap);
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	public B strokeJoin(LINE_JOIN lineJoin) {
		this.lineJoin = Optional.of(lineJoin);
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	public B strokeMiterLimit(double mitterLimit) {
		this.mitterLimit = Optional.of(mitterLimit);
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	public B strokeWidth(double lineWidth) {
		this.lineWidth = Optional.of(lineWidth);
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!super.equals(other))
			return false;
		if (!(this.lineCap.equals(((Stroke<B>) other).getStrokeCap())))
			return false;
		if (!(this.lineColor.equals(((Stroke<B>) other).getStrokeColor())))
			return false;
		if (!(this.lineDash.equals(((Stroke<B>) other).getStrokeDashArray())))
			return false;
		if (!(this.lineDashOffset.equals(((Stroke<B>) other).getStrokeDashOffset())))
			return false;
		if (!(this.lineJoin.equals(((Stroke<B>) other).getStrokeJoin())))
			return false;
		if (!(this.lineWidth.equals(((Stroke<B>) other).getStrokeWidth())))
			return false;
		if (!(this.mitterLimit.equals(((Stroke<B>) other).getStrokeMiterLimit())))
			return false;
		return true;
	}

}
