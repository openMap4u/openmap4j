package org.openmap4j.plugin.output.svg;

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

import java.awt.Color;
import java.awt.Paint;
import java.util.Arrays;
import java.util.Optional;

import org.openmap4j.common.Buildable;
import org.openmap4j.style.Strokeable.LINE_JOIN;
import org.openmap4j.style.Strokeable.STROKE_CAP;
import org.openmap4j.style.TextStyleable.BASE_LINE;
import org.openmap4j.style.TextStyleable.FONT_STYLE;


class CssStyleBuilder implements Buildable<String> {

	private static final String FILL = "fill";
	private static final String STROKE = "stroke";
	private static final String STROKE_WIDTH = "stroke-width";
	private static final String OPACITY = "opacity";
	private static final String VISIBILITY = "visibility";
	private static final String HIDDEN = "hidden";
	private static final String VISIBLE = "visible";


	private static final String STROKE_LINE_CAP = "stroke-linecap";
	private static final String STROKE_DASH_ARRY = "stroke-dasharray";
	private static final String LINE_DASH_OFFSET = "stroke-dashoffset";
	private static final String STROKE_LINE_JOIN = "stroke-linejoin";
	private static final String STROKE_MITER_LIMIT = "stroke-miterlimit";

	private static final String FONT_SIZE = "font-size";
	private static final String FONT_FAMILY = "font-family";
	private static final String FONT_STYLE = "font-style";
	
	static enum MODE {CSS_STYLESHEET_WITH_VARS, OVERRIDE_ELEMENT_STYLE_VARS, ELEMENT_STYLE}
	
	private String id = null;
	private MODE cssMode = null;
	private StringBuilder sb = new StringBuilder();

	public CssStyleBuilder() {
		this.cssMode=MODE.ELEMENT_STYLE;
	}
	
	public CssStyleBuilder(String id, MODE mode) {
		this.id=id;
		this.cssMode=mode;
		if (this.cssMode==MODE.CSS_STYLESHEET_WITH_VARS) {
			sb.append(".").append(id).append("{");
		}
	}

	
	 CssStyleBuilder add( String key, Object value)  {
		 switch (this.cssMode) {
		 case CSS_STYLESHEET_WITH_VARS  :
				sb.append(key).append(":").append(" var(").append("--").append(id).append("-").append(key).append(" ,").append(value.toString()).append(");");
			    break;
			case OVERRIDE_ELEMENT_STYLE_VARS:
				sb.append("--").append(id).append("-").append(key).append(":").append(value.toString()).append(";");
			    break;
			case ELEMENT_STYLE:
				sb.append(key).append(":").append(value.toString()).append(";");
			    break;
		 };
		 return this;
			 
	 }

	
	public CssStyleBuilder stroke(Optional<Paint> strokeColor) {
		if (strokeColor.isPresent()) {
			return add(STROKE, getPaint(strokeColor.get()));
		} else {
			return this;
		}
	}

	String getPaint(Paint paint) {
		if (paint instanceof Color) {
			return getColor((Color) paint);
		} else {
			throw new UnsupportedOperationException("currently not supported");
		}
	}

	/**
	 * Converts the color into a svg hex value.
	 * 
	 * @param color
	 *            The color.
	 * @return The svg color as hex value.
	 */
	public String getColor(Color color) {
		return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
	}

	public CssStyleBuilder fill(Optional<Paint> fillColor) {
		if (fillColor.isPresent()) {
			return add(FILL, getPaint(fillColor.get()));
		} else {
			return add(FILL,"transparent");
		}
	}

	
	public CssStyleBuilder strokeWidth(Optional<Double> strokeWidth) {
		if (strokeWidth.isPresent()) {
			return add(STROKE_WIDTH, strokeWidth.get());
		} else {
			return this;
		}
	}

	/**
	 * Specifies the opacity.
	 * 
	 * @param opacity
	 *            The opacity. From 0.0 (fully transparent) to 1.0 (fully
	 *            opaque).
	 * @return The css style builder (Fluent builder pattern).
	 */
	
	public CssStyleBuilder opacity(Optional<Double> alpha) {
		// is only written when below 1.
		if (alpha.isPresent()) {
			return add(OPACITY, alpha.get());
		} else {
			return  this;
		}
	}

	
	public CssStyleBuilder visible(Optional<Boolean> isVisible) {
		// only written if not visible.
		if (isVisible.isPresent()) {
			if (isVisible.get()==Boolean.TRUE) {
				return add(VISIBILITY,VISIBLE);
			} else {
			return add(VISIBILITY, HIDDEN);
			}
		} else {
			return this;
		}
	}



	
	public CssStyleBuilder strokeLineCap(Optional<STROKE_CAP> lineCap) {
		if (lineCap.isPresent()) {
			return add(STROKE_LINE_CAP, lineCap.get().name());
		} else {
			return this;
		}
	}

	
	public CssStyleBuilder strokeDashArray(Optional<double[]> lineDash) {
		if (lineDash.isPresent()) {
			return add(STROKE_DASH_ARRY, Arrays.toString(lineDash.get()).replaceAll("\\[", "").replaceAll("\\]", ""));
		} else {
			return this;
		}
	}

	
	public CssStyleBuilder strokeLineOffset(Optional<Double> lineDashOffset) {
		if (lineDashOffset.isPresent()) {
			return add(LINE_DASH_OFFSET, lineDashOffset.get());
		} else {
			return this;
		}
	}

	
	public CssStyleBuilder strokeLineJoin(Optional<LINE_JOIN> lineJoin) {
		if (lineJoin.isPresent()) {
			return add(STROKE_LINE_JOIN, lineJoin.get().name());
		} else {
			return this;
		}
	}

	
	public CssStyleBuilder strokeMitterLimit(Optional<Double> mitterLimit) {
		if (mitterLimit.isPresent()) {
			return add(STROKE_MITER_LIMIT, mitterLimit.get());
		} else {
			return this;
		}
	}

	
	public CssStyleBuilder fontBaseLine(Optional<BASE_LINE> baseLine) {
		if (baseLine.isPresent()) {
			return this;
		} else {
			return this;
		}
	}

	
	public CssStyleBuilder fontSize(Optional<Double> fontSize) {
		if (fontSize.isPresent()) {
			return add(FONT_SIZE, fontSize.get()+"px");
		} else {
			return this;
		}
	}

	
	public CssStyleBuilder fontFamily(Optional<String> fontFamily) {
		if (fontFamily.isPresent()) {
			return add(FONT_FAMILY, fontFamily.get());
		} else {
			return this;
		}
	}

	
	public CssStyleBuilder fontStyle(Optional<FONT_STYLE> fontStyle) {
		if (fontStyle.isPresent()) {
			return add(FONT_STYLE, fontStyle.get().name());
		} else {
			return this;
		}
	}

	@Override
	public String build() {
		if (cssMode ==MODE.CSS_STYLESHEET_WITH_VARS) {
			sb.append("}");
		}
		return  sb.toString();
	}
 
}
