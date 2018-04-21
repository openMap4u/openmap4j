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
package org.openmap4j.output;

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
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openmap4j.builder.geom.GeomBuilderFactory;
import org.openmap4j.builder.style.StyleBuilderFactory;
import org.openmap4j.builder.transform.TransformBuilderFactory;
import org.openmap4j.mock.MockData;

@TestInstance(Lifecycle.PER_CLASS)
public abstract class AbstractLineStyleTest extends CanvasTest<Point2D> {

	@Override
	protected Shape getCanvasSize() {
		return MockData.DEFAULT_CANVAS;
	}

	@Test
	public void testWriteLine_DefaultLineStyle_no_params() {
		double y = 50;
		canvas.draw("Default line style no params", 5, y - 20);
		Arrays.stream(MockData.X_COORDINATES).forEach(value -> canvas.draw(value, y));
	}

	@Test
	public void testWrite_alphaStyle_param() {
		double y = 150;
		canvas.draw("Default style alpha param", 5, y - 20);
		for (int i = 0; i < 10; i++) {
			canvas.draw(i * 100 + 50, y,
					StyleBuilderFactory.getLineStyleBuilder().alpha(MockData.ALPHA[i]).build());
		}

	}

	@Test
	public void testWrite_visibleStyle_param() {
		double y = 250;
		canvas.draw("Default style visible param", 5, y - 20);
		for (int i = 0; i < 10; i++) {
			canvas.draw(i * 100 + 50, y,
					StyleBuilderFactory.getLineStyleBuilder().visible(MockData.VISIBLE[i]).build());
		}
	}

	@Test
	public void testWrite_strokeWidth_param() {
		double y = 350;
		canvas.draw("Default style stroke width", 5, y - 20);
		for (int i = 0; i < 10; i++) {
			canvas.draw(i * 100 + 50, y,
					StyleBuilderFactory.getLineStyleBuilder().strokeWidth(MockData.STROKE_WIDTH[i]).build());
		}
	}

	@Test
	public void testWrite_strokeColor_param() {
		double y = 450;
		canvas.draw("Default style stroke width =20  and color param", 5, y - 20);
		for (int i = 0; i < 10; i++) {
			canvas.draw(i * 100 + 50, y,
					StyleBuilderFactory.getLineStyleBuilder().strokeWidth(20).strokeColor(MockData.COLORS[i]).build());
		}
	}

	@Test
	public void testWrite_strokeDashOffset_param() {
		double y = 550;
		canvas.draw("Default style stroke width =20  and dash offset param", 5, y - 20);
		for (int i = 0; i < 10; i++) {
			canvas.draw(i * 100 + 50, y, StyleBuilderFactory.getLineStyleBuilder().strokeWidth(20)
					.strokeDashOffset(MockData.DASH_OFFSET[i]).build());
		}
	}

	@Test
	public void testWrite_strokeDashArray_param() {
		double y = 650;
		canvas.draw("Default style stroke width =20  and stroke dash array param", 5, y - 20);
		for (int i = 0; i < 10; i++) {
			canvas.draw(i * 100 + 50, y, StyleBuilderFactory.getLineStyleBuilder().strokeWidth(20)
					.strokeDashArray(MockData.DASH_ARRAY[i]).build());
		}
	}

	@Test
	public void testWrite_strokeCap_param() {
		double y = 750;
		canvas.draw("Default style stroke width =20  and stroke cap param", 5, y - 20);
		for (int i = 0; i < 10; i++) {
			canvas.draw(i * 100 + 50, y,
					StyleBuilderFactory.getLineStyleBuilder().strokeWidth(20).strokeCap(MockData.STROKECAP[i]).build());
		}
	}

	@Test
	public void testWrite_strokeLineJoin_param() {
		double y = 850;
		canvas.draw("Default style stroke width =20  and stroke join param", 5, y - 20);
		for (int i = 0; i < 10; i++) {
			canvas.draw(i * 100 + 50, y,
					StyleBuilderFactory.getLineStyleBuilder().strokeWidth(20).strokeJoin(MockData.LINEJOIN[i]).build());
		}
	}

	@Test
	public void testWrite_strokeMiterLimit_param() {
		double y = 950;
		canvas.draw("Default style stroke width =20  and miter limitparam", 5, y - 20);
		for (int i = 0; i < 10; i++) {
			canvas.draw(i * 100 + 50, y, StyleBuilderFactory.getLineStyleBuilder().strokeWidth(20)
					.strokeMiterLimit(MockData.MITER_LIMIT[i]).build());
		}
	}

	@Test
	public void testWrite_translateX_param() {
		double y = 1050;
		canvas.draw("Default style and translateX", 5, y - 20);
		for (int i = 0; i < 10; i++) {
			canvas.draw(i * 100 + 50, y,
					TransformBuilderFactory.getTransformBuilder().translate(MockData.X_TRANSLATE[i], 0).build());
		}
	}

	@Test
	public void testWrite_translateY_param() {
		double y = 1150;
		canvas.draw("Default style and translateY", 5, y - 20);
		for (int i = 0; i < 10; i++) {
			canvas.draw(i * 100 + 50, y,
					TransformBuilderFactory.getTransformBuilder().translate(0, MockData.Y_TRANSLATE[i]).build());
		}
	}

	@Test
	public void testWrite_shearX_param() {
		double y = 1250;
		canvas.draw("Default style and shearX", 5, y - 20);
		for (int i = 0; i < 10; i++) {
			canvas.draw(i * 100 + 50, y,
					TransformBuilderFactory.getTransformBuilder().shear(MockData.X_SHEAR[i], 0).build());
		}
	}

	@Test
	public void testWrite_shearY_param() {
		double y = 1350;
		canvas.draw("Default style and shearY", 5, y - 20);
		for (int i = 0; i < 10; i++) {
			canvas.draw(i * 100 + 50, y,
					TransformBuilderFactory.getTransformBuilder().shear(0, MockData.Y_SHEAR[i]).build());
		}
	}

	@Test
	public void testWrite_scaleX_param() {
		double y = 1450;
		canvas.draw("Default style and scaleX", 5, y - 20);
		for (int i = 0; i < 10; i++) {
			canvas.draw(i * 100 + 50, y,
					TransformBuilderFactory.getTransformBuilder().scale(MockData.X_SCALE[i], 1).build());
		}
	}

	@Test
	public void testWrite_scaleY_param() {
		double y = 1550;
		canvas.draw("Default style and scaleY", 5, y - 20);
		for (int i = 0; i < 10; i++) {
			canvas.draw(i * 100 + 50, y,
					TransformBuilderFactory.getTransformBuilder().scale(1, MockData.Y_SCALE[i]).build());
		}
	}

	@Override
	protected Writer getWriter() throws IOException {
		return super.getFile("LineSymbolTest.svg");
	}

	@BeforeAll
	public void beforeAll() {
		canvas = getCanvas(getCanvasSize());
		canvas.style(StyleBuilderFactory.getLineSymbolBuilder()
				.line(GeomBuilderFactory.getLineBuilder().moveTo(-40, 0).lineTo(40, 0).build()).strokeColor(Color.BLACK)
				.strokeWidth(4).build());
	}

	@AfterAll
	public void after() throws IOException {
		canvas.write(getWriter());
	}

	Point2D getGeometry(double x, double y) {
		return GeomBuilderFactory.getPointBuilder().x(x).y(y).build();
	}

}
