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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openmap4j.builder.style.LineStyle;
import org.openmap4j.builder.style.LineStyleBuilder;
import org.openmap4j.style.LineStyleable;

public class LineStyleBuilderTest extends AbtractStyleBuilderTest {

	LineStyleable ls  = null;

	@BeforeEach
	public void beforeEach() {
		ls = new LineStyleBuilder<LineStyleable>().alpha(ALPHA).visible(false).strokeCap(STROKE_CAP_VALUE).strokeColor(STROKE_COLOR)
				.strokeDashArray(STROKE_DASHED_ARRAY).strokeDashOffset(STROKE_DASH_OFFSET).strokeJoin(STROKE_LINE_JOIN)
				.strokeMiterLimit(STROKE_MITER_LIMIT).strokeWidth(STROKE_WIDTH).build();
		assertEquals(ls.getAlpha().get(), ALPHA);
	}

	@Test
	public void testSetAll() {
		assertEquals(ls.getAlpha().get(), ALPHA);
		assertEquals(ls.isVisible().get(), false);
		assertEquals(ls.getStrokeCap().get(), STROKE_CAP_VALUE);
		assertEquals(ls.getStrokeColor().get(), STROKE_COLOR);
		assertEquals(ls.getStrokeDashArray().get(), STROKE_DASHED_ARRAY);
		assertEquals(ls.getStrokeDashOffset().get(), STROKE_DASH_OFFSET);
		assertEquals(ls.getStrokeJoin().get(), STROKE_LINE_JOIN);
		assertEquals(ls.getStrokeMiterLimit().get(), STROKE_MITER_LIMIT);
		assertEquals(ls.getStrokeWidth().get(), STROKE_WIDTH);
	}
	
	@Test
 	public void testClone() throws CloneNotSupportedException {
 		LineStyleable cls = (LineStyleable) ls.clone();
 		assertTrue(cls.equals(ls));
 		(( LineStyle)ls).alpha(.123);
 		assertFalse(cls.equals(ls));
 	}

}
