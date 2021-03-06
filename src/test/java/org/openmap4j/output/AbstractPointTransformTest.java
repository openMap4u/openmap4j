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

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openmap4j.builder.transform.TransformBuilderFactory;
import org.openmap4j.mock.MockData;
import org.openmap4j.mock.MockValue;

public abstract class AbstractPointTransformTest  extends AbstractPointTest  {

	@Override
	protected Shape getCanvasSize() {
		return new Rectangle2D.Double(0, 0, MockData.DEFAULT_CANVAS_WIDTH, MockData.DEFAULT_CANVAS_HEIGHT);
	}

	@ParameterizedTest
	@MethodSource("mockValueProvider")
	public void testDefault(MockValue mockValue) {
		double y = 50;
	//	canvas.drawText("default", mockValue.getX(), y - 20);
		canvas.draw(mockValue.getX(), y);
	}

	@ParameterizedTest
	@MethodSource("mockValueProvider")
	public void testScaleX(MockValue mockValue) {
		double y = 150;
		//canvas.drawText("scaleX " + mockValue.getScaleX(), mockValue.getX(), y - 20);
		canvas.draw(mockValue.getX(), y,
				TransformBuilderFactory.getTransformBuilder().scale(mockValue.getScaleX(), 1).build());
	}

	@ParameterizedTest
	@MethodSource("mockValueProvider")
	public void testScaleY(MockValue mockValue) {
		double y = 250;
		//canvas.drawText("scaleY " + mockValue.getScaleY(), mockValue.getX(), y - 20);
		canvas.draw(mockValue.getX(), y,
				TransformBuilderFactory.getTransformBuilder().scale(1, mockValue.getScaleY()).build());
	}

	@ParameterizedTest
	@MethodSource("mockValueProvider")
	public void testShearX(MockValue mockValue) {
		double y = 350;
		//canvas.drawText("shearX " + mockValue.getShearX(), mockValue.getX(), y - 20);
		canvas.draw(mockValue.getX(), y,
				TransformBuilderFactory.getTransformBuilder().shear(mockValue.getShearX(), 0).build());
	}

	@ParameterizedTest
	@MethodSource("mockValueProvider")
	public void testShearY(MockValue mockValue) {
		double y = 450;
		//canvas.drawText("shearY " + mockValue.getShearY(), mockValue.getX(), y - 20);
		canvas.draw(mockValue.getX(), y,
				TransformBuilderFactory.getTransformBuilder().shear(0, mockValue.getShearY()).build());
	}

	@ParameterizedTest
	@MethodSource("mockValueProvider")
	public void testTranslateX(MockValue mockValue) {
		double y = 550;
		//canvas.drawText("translateX  " + mockValue.getTranslateX(), mockValue.getX(), y - 20);
		canvas.draw(mockValue.getX(), y,
				TransformBuilderFactory.getTransformBuilder().translate(mockValue.getTranslateX(), 0).build());
	}

	@ParameterizedTest
	@MethodSource("mockValueProvider")
	public void testTranslateY(MockValue mockValue) {
		double y = 650;
		//canvas.drawText("translateY " + mockValue.getTranslateY(), mockValue.getX(), y - 20);
		canvas.draw(mockValue.getX(), y,
				TransformBuilderFactory.getTransformBuilder().translate(0, mockValue.getTranslateY()).build());
	}

	@ParameterizedTest
	@MethodSource("mockValueProvider")
	public void testRotate(MockValue mockValue) {
		double y = 750;
		//canvas.drawText("rotate " + mockValue.getRotate(), mockValue.getX(), y - 20);
		canvas.draw(mockValue.getX(), y,
				TransformBuilderFactory.getTransformBuilder().rotate(mockValue.getRotate()).build());
	}

	@ParameterizedTest
	@MethodSource("mockValueProvider")
	public void testAlltogether(MockValue mockValue) {
		double y = 850;
		//canvas.drawText("together", mockValue.getX(), y - 20);
		canvas.draw(mockValue.getX(), y);
	}

}
