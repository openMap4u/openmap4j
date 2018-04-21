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

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.openmap4j.AbstractTest;
import org.openmap4j.builder.geom.GeomBuilderFactory;
import org.openmap4j.style.Strokeable.LINE_JOIN;
import org.openmap4j.style.Strokeable.STROKE_CAP;
import org.openmap4j.style.TextStyleable.BASE_LINE;
import org.openmap4j.style.TextStyleable.FONT_STYLE;
import org.openmap4j.style.TextStyleable.TEXT_ALIGN;


public class AbtractStyleBuilderTest extends AbstractTest {

	public static final double X=.3;
	public static final double Y=.25;
	public static final STROKE_CAP STROKE_CAP_VALUE = STROKE_CAP.round;
	public static final Color STROKE_COLOR = Color.BLACK;
	public static final Double STROKE_DASH_OFFSET = .5;
	public static final double[] STROKE_DASHED_ARRAY = new double[] { 1., 2., 3. };
	public static final LINE_JOIN STROKE_LINE_JOIN = LINE_JOIN.miter;
	public  static final Double STROKE_MITER_LIMIT = 0.;
	public static final Double STROKE_WIDTH = .3;
	public static final Double ALPHA=.5;
	public static final Path2D LINE_SYMBOL = GeomBuilderFactory.getLineBuilder().moveTo(0,.5).lineTo(0,-.5).build();
	public static final Shape AREA_SYMBOL = new Rectangle2D.Double(-.25,-.25,.5,.5);
	public static final Color FILL = Color.GREEN;
	public static Path IMAGE_PATH=FileSystems.getDefault().getPath("test","test.png");

	public static final TEXT_ALIGN TEXT_ALIGN_VALUE = TEXT_ALIGN.center;
	public static final BASE_LINE FONT_BASE_LINE=BASE_LINE.bottom;
	public static final String FONT_FAMILY = "Arial";
public static final  Double FONT_SIZE =10d;
public static final   FONT_STYLE FONT_STYLE_VALUE = FONT_STYLE.italic ;
public static final String TEXT_VALUE="hello world";
 	
}
