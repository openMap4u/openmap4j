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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openmap4j.builder.style.TextSymbolBuilder;
import org.openmap4j.style.TextStyleable;
import org.openmap4j.style.TextSymbolizeable;

public class TextSymbolBuilderTest extends AbtractStyleBuilderTest {

	private TextSymbolBuilder<TextSymbolizeable> tsb = null;

	@BeforeEach
	public void beforeEach() {
		tsb = new  TextSymbolBuilder<TextSymbolizeable>();
	}

	@Test
	public void testSetAll() {
		TextStyleable ts = tsb.alpha(ALPHA).visible(false).strokeCap(STROKE_CAP_VALUE).strokeColor(STROKE_COLOR)
				.strokeDashArray(STROKE_DASHED_ARRAY).strokeDashOffset(STROKE_DASH_OFFSET).strokeJoin(STROKE_LINE_JOIN)
				.strokeMiterLimit(STROKE_MITER_LIMIT).strokeWidth(STROKE_WIDTH).fill(FILL).align(TEXT_ALIGN_VALUE).baseLine(FONT_BASE_LINE).fontFamily(FONT_FAMILY).fontSize(FONT_SIZE).fontStyle(FONT_STYLE_VALUE).
				text(TEXT_VALUE).x(X).y(Y).
				build();

				
			 
		assertEquals(ts.getAlpha().get(), ALPHA);
		assertEquals(ts.isVisible().get(), false);
		assertEquals(ts.getStrokeCap().get(), STROKE_CAP_VALUE);
		assertEquals(ts.getStrokeColor().get(), STROKE_COLOR);
		assertEquals(ts.getStrokeDashArray().get(), STROKE_DASHED_ARRAY);
		assertEquals(ts.getStrokeDashOffset().get(), STROKE_DASH_OFFSET);
		assertEquals(ts.getStrokeJoin().get(), STROKE_LINE_JOIN);
		assertEquals(ts.getStrokeMiterLimit().get(), STROKE_MITER_LIMIT);
		assertEquals(ts.getStrokeWidth().get(), STROKE_WIDTH);
		assertEquals(ts.getFill().get(), FILL);
		
		assertEquals(ts.getAlign().get(), TEXT_ALIGN_VALUE);
		assertEquals(ts.getBaseLine().get(), FONT_BASE_LINE);
		assertEquals(ts.getFontFamily().get(), FONT_FAMILY);
		assertEquals(ts.getFontSize().get(), FONT_SIZE);
		assertEquals(ts.getFontStyle().get(), FONT_STYLE_VALUE);
	 		
	
	}

}
