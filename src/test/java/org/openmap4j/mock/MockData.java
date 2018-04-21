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

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.openmap4j.builder.geom.GeomBuilderFactory;
import org.openmap4j.builder.geom.LineBuildable;
import org.openmap4j.builder.style.StyleBuilderFactory;
import org.openmap4j.style.AreaSymbolizeable;
import org.openmap4j.style.ImageSymbolizeable;
import org.openmap4j.style.LineSymbolizeable;
import org.openmap4j.style.TextSymbolizeable;
import org.openmap4j.style.Strokeable.LINE_JOIN;
import org.openmap4j.style.Strokeable.STROKE_CAP;
import org.openmap4j.style.TextStyleable.BASE_LINE;
import org.openmap4j.style.TextStyleable.TEXT_ALIGN;

public class MockData {

	public static final int DEFAULT_CANVAS_WIDTH = 1000;
	public static final int DEFAULT_CANVAS_HEIGHT = 2000;

	public static Shape getRectangle(int width, int height) {
		return new Rectangle2D.Double(0, 0, width, height);
	}

	public static LineSymbolizeable getLineSymbol() {
		return StyleBuilderFactory.getLineSymbolBuilder().strokeColor(Color.BLACK).strokeWidth(1)
				.line(GeomBuilderFactory.getLineBuilder().moveTo(-10, 5).lineTo(-10, -5).lineTo(0, 0).lineTo(10, -5)
						.lineTo(10, 5).build())
				.build();
	}

	public static TextSymbolizeable getTextSymbol() {
		return StyleBuilderFactory.getTextSymbolBuilder().x(0).y(0).baseLine(BASE_LINE.middle).align(TEXT_ALIGN.center).fill(Color.BLACK).fontSize(10).text("M").build();
	}

	public static ImageSymbolizeable getImageSymbol() {
		return StyleBuilderFactory.getImageSymbolBuilder().x(-15).y(-15).imagePath(FileSystems.getDefault().getPath("src","test","image","image.png")).build();
	}

	public static AreaSymbolizeable getAreaSymbol() {
		return StyleBuilderFactory.getAreaSymbolBuilder().strokeColor(Color.BLACK).fill(Color.LIGHT_GRAY).strokeWidth(1)
				.area(GeomBuilderFactory.getAreaBuilder().moveTo(-10, 5).lineTo(-10, -5).lineTo(0, 0).lineTo(10, -5)
						.lineTo(10, 5).lineTo(-10, 5).build())
				.build();
	}

	public static final Shape DEFAULT_CANVAS = getRectangle(DEFAULT_CANVAS_WIDTH, DEFAULT_CANVAS_HEIGHT);

	public static Stream<Double> range(double min, double max, double delta) {
		List<Double> values = new ArrayList<>();
		double value = min;
		while (value <= max) {
			values.add(value);
			value = value + delta;
		}
		return values.stream();
	}

	public static Stream<Point2D> rangePoint(double minX, double maxX, double y, double deltaX) {
		List<Point2D> values = new ArrayList<Point2D>();
		range(minX, maxX, deltaX).forEach(value -> values.add(new Point2D.Double(value, y)));
		return values.stream();
	}

	public static Stream<Path2D> rangeLine(double minX, double maxX, double y, double deltaX) {
		List<Path2D> values = new ArrayList<>();
		range(minX, maxX, deltaX).forEach(value -> values
				.add(GeomBuilderFactory.getLineBuilder().moveTo(value, y - 0.5).lineTo(value, y + 0.5).build()));

		return values.stream();
	}

	/**
	 * Creates a raster for the given width and height and raster width.
	 * 
	 * @param width
	 *            The raster width.
	 * @param height
	 *            The raster height.
	 * @param rasterWidth
	 *            The raster distance.
	 * @return The raster.
	 */
	public static Path2D raster(double width, double height, double rasterWidth) {
		LineBuildable<Path2D> lineBuilder = GeomBuilderFactory.getLineBuilder();
		double x = 0;
		double y = 0;
		while (x <= width) {
			lineBuilder.moveTo(x, 0).lineTo(x, height);
			x = x + rasterWidth;
		}
		while (y <= height) {
			lineBuilder.moveTo(0, y).lineTo(width, y);
			y = y + rasterWidth;
		}
		return lineBuilder.build();
	}

	public static final Path2D DEFAULT_RASTER = raster(DEFAULT_CANVAS_WIDTH, DEFAULT_CANVAS_HEIGHT, 10);

	public static Stream<Shape> rangeShape(double minX, double maxX, double y, double deltaX) {
		List<Shape> values = new ArrayList<>();
		range(minX, maxX, deltaX).forEach(value -> values.add(GeomBuilderFactory.getAreaBuilder().moveTo(value - .2, y)
				.lineTo(value + .2, y - .2).lineTo(value + .2, y + .2).lineTo(value - .2, y).build()));
		return values.stream();
	}

	public static final Color[] COLORS = new Color[] { new Color(165, 0, 38), new Color(215, 48, 39),
			new Color(244, 109, 67), new Color(253, 174, 97), new Color(254, 224, 139), new Color(217, 239, 139),
			new Color(166, 217, 106), new Color(102, 189, 99), new Color(26, 152, 80), new Color(0, 104, 55) };

	/**
	 * The default x coordinates.
	 */
	public static final double[] X_COORDINATES = new double[] { 50.0, 150.0, 250.0, 350.0, 450.0, 550.0, 650.0, 750.0,
			850.0, 950.0 };

	public static final double[] X_SCALE = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0 };
	public static final double[] Y_SCALE = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0 };
	public static final double[] ROTATE = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0 };
	public static final double[] X_SHEAR = new double[] { -1.0, -.7, -.3, -0.1, 0, 0, 0.1, 0.3, .7, 1.0 };
	public static final double[] Y_SHEAR = new double[] { -1.0, -.7, -.3, -0.1, 0, 0, 0.1, 0.3, .7, 1.0 };
	public static final double[] X_TRANSLATE = new double[] { -10.0, -7.0, -3.0, -1.0, 0, 0, 1.0, 3.0, 7.0, 10.0 };
	public static final double[] Y_TRANSLATE = new double[] {-10.0, -7.0, -3.0, -1.0, 0, 0, 1.0, 3.0, 7.0, 10.0 };
	public static final double[] ALPHA = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.70, .8, 0.9, 1.0 };
	public static final boolean[] VISIBLE = new boolean[] { true, false, true, false, true, false, true, false, true,
			false };

	public static final double[] STROKE_WIDTH = new double[] { 0.5, 1, 1.5, 2, 2.5, 3, 3.5, 4, 4.5, 5 };

	public static final double[] DASH_OFFSET = new double[] { 0, 5, 10, 15, 20, 25, 30, 35, 40, 45 };
	public static final double[] MITER_LIMIT = new double[] { 0, 5, 10, 15, 20, 25, 30, 35, 40, 45 };
	public static final LINE_JOIN[] LINEJOIN = new LINE_JOIN[] { LINE_JOIN.bevel, LINE_JOIN.miter, LINE_JOIN.round,
			LINE_JOIN.bevel, LINE_JOIN.miter, LINE_JOIN.round, LINE_JOIN.bevel, LINE_JOIN.miter, LINE_JOIN.round,
			LINE_JOIN.bevel, };
	public static final STROKE_CAP[] STROKECAP = new STROKE_CAP[] { STROKE_CAP.butt, STROKE_CAP.round,
			STROKE_CAP.square, STROKE_CAP.butt, STROKE_CAP.round, STROKE_CAP.square, STROKE_CAP.butt, STROKE_CAP.round,
			STROKE_CAP.square, STROKE_CAP.butt, STROKE_CAP.round };;

	public static final double[] DASH_ARRAY = new double[] { 0, 5, 10, 15, 20, 25, 30, 35, 40, 45 };

	static MockValue getMockValue(int x) {
		MockValue mv = new MockValue();
		mv.setX(X_COORDINATES[x]);
		//mv.setY(50 + y * 100);
		mv.setVisible(VISIBLE[x]);
		mv.setAlpha(ALPHA[x]);
		mv.setStrokeWidth(STROKE_WIDTH[x]);
		mv.setStrokeColor(COLORS[x]);
		mv.setFill(COLORS[ x]);
		mv.setScaleX(X_SCALE[x]);
		mv.setScaleY(Y_SCALE[x]);
		mv.setRotate(ROTATE[x]);
		mv.setShearX(X_SHEAR[x]);
		mv.setShearY(Y_SHEAR[x]);
		mv.setTranslateX(X_TRANSLATE[x]);
		mv.setTranslateY(Y_TRANSLATE[x]);

		return mv;
	}

	public static final List<MockValue> getMockValues() {
		List<MockValue> data = new ArrayList<>();
			for (int x = 0; x < 10; x++) {
				data.add(getMockValue(x));
			}
		return data;
	}

}
