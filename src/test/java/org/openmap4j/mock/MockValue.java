/**
 * openmap4u-core - Parent pom providing dependency and plugin management for applications
		built with Maven
 * Copyright © ${project.inceptionYear} Michael Hadrbolec (openmap4u@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.openmap4j.mock;

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

import org.openmap4j.style.Strokeable.LINE_JOIN;
import org.openmap4j.style.Strokeable.STROKE_CAP;
import org.openmap4j.style.TextStyleable.BASE_LINE;
import org.openmap4j.style.TextStyleable.FONT_STYLE;
import org.openmap4j.style.TextStyleable.TEXT_ALIGN;

public class MockValue {

	private boolean visible;
	private double alpha;
	private Paint strokeColor;
	private STROKE_CAP strokeCap;
	private LINE_JOIN lineJoin;
	private double[] strokeDashArea;
	private double strokeDashOffset;
	private double strokeMiterLimit;
	private double strokeWidth;

	private Paint fill;
	private BASE_LINE baseLine;
	private FONT_STYLE fontStyle;
	private TEXT_ALIGN textAlign;
	private String fontFamily;
	private String fontSize;

	private double x;
	private double y;
	
	private double translateX;
	private double translateY;
	private double rotate;
	private double scaleX;
	private double scaleY;
	private double shearX;
	private double shearY;
	
	public MockValue( )	{
	}
	
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public double getAlpha() {
		return alpha;
	}
	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}
	public Paint getStrokeColor() {
		return strokeColor;
	}
	public void setStrokeColor(Paint strokeColor) {
		this.strokeColor = strokeColor;
	}
	public STROKE_CAP getStrokeCap() {
		return strokeCap;
	}
	public void setStrokeCap(STROKE_CAP strokeCap) {
		this.strokeCap = strokeCap;
	}
	public double[] getStrokeDashArea() {
		return strokeDashArea;
	}
	public void setStrokeDashArea(double[] strokeDashArea) {
		this.strokeDashArea = strokeDashArea;
	}
	public double getStrokeDashOffset() {
		return strokeDashOffset;
	}
	public void setStrokeDashOffset(double strokeDashOffset) {
		this.strokeDashOffset = strokeDashOffset;
	}
	public double getStrokeMiterLimit() {
		return strokeMiterLimit;
	}
	public void setStrokeMiterLimit(double strokeMiterLimit) {
		this.strokeMiterLimit = strokeMiterLimit;
	}
	public double getStrokeWidth() {
		return strokeWidth;
	}
	public void setStrokeWidth(double strokeWidth) {
		this.strokeWidth = strokeWidth;
	}
	public Paint getFill() {
		return fill;
	}
	public void setFill(Paint fill) {
		this.fill = fill;
	}
	public BASE_LINE getBaseLine() {
		return baseLine;
	}
	public void setBaseLine(BASE_LINE baseLine) {
		this.baseLine = baseLine;
	}
	public FONT_STYLE getFontStyle() {
		return fontStyle;
	}
	public void setFontStyle(FONT_STYLE fontStyle) {
		this.fontStyle = fontStyle;
	}
	public TEXT_ALIGN getTextAlign() {
		return textAlign;
	}
	public void setTextAlign(TEXT_ALIGN textAlign) {
		this.textAlign = textAlign;
	}
	public String getFontFamily() {
		return fontFamily;
	}
	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}
	public String getFontSize() {
		return fontSize;
	}
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getTranslateX() {
		return translateX;
	}
	public void setTranslateX(double translateX) {
		this.translateX = translateX;
	}
	public double getTranslateY() {
		return translateY;
	}
	public void setTranslateY(double translateY) {
		this.translateY = translateY;
	}
	public double getRotate() {
		return rotate;
	}
	public void setRotate(double rotate) {
		this.rotate = rotate;
	}
	public double getScaleX() {
		return scaleX;
	}
	public void setScaleX(double scaleX) {
		this.scaleX = scaleX;
	}
	public double getScaleY() {
		return scaleY;
	}
	public void setScaleY(double scaleY) {
		this.scaleY = scaleY;
	}
	public LINE_JOIN getLineJoin() {
		return lineJoin;
	}
	public void setLineJoin(LINE_JOIN lineJoin) {
		this.lineJoin = lineJoin;
	}

	public double getShearX() {
		return shearX;
	}

	public void setShearX(double shearX) {
		this.shearX = shearX;
	}

	public double getShearY() {
		return shearY;
	}

	public void setShearY(double shearY) {
		this.shearY = shearY;
	}

}
