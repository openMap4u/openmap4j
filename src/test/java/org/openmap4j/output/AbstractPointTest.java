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

import static org.openmap4j.mock.MockData.DEFAULT_RASTER;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openmap4j.builder.style.StyleBuilderFactory;
import org.openmap4j.mock.MockData;
import org.openmap4j.mock.MockValue;
import org.openmap4j.style.Symbolizeable;

@TestInstance(Lifecycle.PER_CLASS)
public abstract class AbstractPointTest  extends CanvasTest<Point2D> {

	Point2D getPoint(double x, double y) {
		return new Point2D.Double(x, y);
	}

	abstract Symbolizeable[] getSymbol();

	@BeforeAll
	public void beforeAll() {
		canvas = getCanvas(getCanvasSize());
	      canvas.style(StyleBuilderFactory.getLineStyleBuilder().strokeColor(Color.LIGHT_GRAY).strokeWidth(.5).alpha(.5).build());
	        canvas.draw(DEFAULT_RASTER);
	  
		canvas.style(getSymbol());
	}

	@AfterAll
	public void after() throws IOException {
		canvas.write(getWriter());
	}

	/**
	 * Provides the mock values for the parametrized tests.
	 * 
	 * @return The mock values.
	 */
	protected static Stream<MockValue> mockValueProvider() {
		return MockData.getMockValues().stream();
	}

}
