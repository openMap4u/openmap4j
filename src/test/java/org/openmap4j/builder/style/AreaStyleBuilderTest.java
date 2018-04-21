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

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openmap4j.builder.style.AreaStyle;
import org.openmap4j.builder.style.AreaStyleBuilder;
import org.openmap4j.style.AreaStyleable;

public class AreaStyleBuilderTest extends AbtractStyleBuilderTest {

	AreaStyleable as = null;

	@BeforeEach
	public void beforeEach() {
		as = new  AreaStyleBuilder<AreaStyleable>().alpha(ALPHA).visible(false).strokeCap(STROKE_CAP_VALUE).strokeColor(STROKE_COLOR)
				.strokeDashArray(STROKE_DASHED_ARRAY).strokeDashOffset(STROKE_DASH_OFFSET).strokeJoin(STROKE_LINE_JOIN)
				.strokeMiterLimit(STROKE_MITER_LIMIT).strokeWidth(STROKE_WIDTH).fill(FILL).build();
	}

	@Test
	public void testSetAll() {
		assertEquals(as.getAlpha().get(), ALPHA);
		assertEquals(as.isVisible().get(), false);
		assertEquals(as.getStrokeCap().get(), STROKE_CAP_VALUE);
		assertEquals(as.getStrokeColor().get(), STROKE_COLOR);
		assertEquals(as.getStrokeDashArray().get(), STROKE_DASHED_ARRAY);
		assertEquals(as.getStrokeDashOffset().get(), STROKE_DASH_OFFSET);
		assertEquals(as.getStrokeJoin().get(), STROKE_LINE_JOIN);
		assertEquals(as.getStrokeMiterLimit().get(), STROKE_MITER_LIMIT);
		assertEquals(as.getStrokeWidth().get(), STROKE_WIDTH);
		assertEquals(as.getFill().get(), FILL);
	
	}
	
	
	@Test
 	public void testClone() throws CloneNotSupportedException {
 		AreaStyleable asc = (AreaStyleable) as.clone();
 		assertTrue(asc.equals(as));
 		(( AreaStyle)as).fill(Color.RED);
 		assertFalse(asc.equals(as));
 	}


}
