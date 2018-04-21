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

import java.awt.Paint;

import org.openmap4j.style.Strokeable.LINE_JOIN;
import org.openmap4j.style.Strokeable.STROKE_CAP;

interface SetStrokeable<B extends SetStrokeable<B>> extends SetStyleable<B> {

	/**
	 * Sets the stroke color.
	 *
	 * @param strokeColor The stroke color.<br>
	 * <br>
	 * Example:<br>
	 * <table summary="">
	 * <tr>
	 * <td><code>myBuilder.color(Color.RED)</code>=</td>
	 * <td><img alt="" src="./doc-files/lineColor_red.png"></td>
	 * <td><code>myBuilder.color(Color.GREEN)</code>=</td>
	 * <td><img alt="" src="./doc-files/lineColor_green.png"></td>
	 * <td><code>myBuilder.color(Color.BLUE)</code>=</td>
	 * <td><img alt="" src="./doc-files/lineColor_blue.png"></td>
	 * </tr>
	 * </table>
	 * @return The builder itself (fluent interface pattern).
	 */
	B strokeColor(Paint strokeColor);

	B strokeDashArray(double ... segments);

	B strokeDashOffset(double lineDashOffset);

	/**
	 * Sets the stroke cap.
	 * @param strokeCap The stroke cap.
	 * @return The builder itself (fluent builder pattern).
	 */
	B strokeCap(STROKE_CAP strokeCap);

	B strokeJoin(LINE_JOIN lineJoin);

	B strokeMiterLimit(double mitterLimit);

	/**
	 * Sets the stroke size in stroke units.
	 *
	 * @param strokeWidth The stroke size in stroke units.<br>
	 * <br>
	 * Example:<br>
	 * <table summary="">
	 * <tr>
	 * <td><code>myBuilder.size(.5)</code>=</td>
	 * <td><img alt="" src="./doc-files/lineSize_1.png"></td>
	 * <td><code>myBuilder.size(1)</code>=</td>
	 * <td><img alt="" src="./doc-files/lineSize_2.png"></td>
	 * <td><code>myBuilder.size(1.5)</code>=</td>
	 * <td><img alt="" src="./doc-files/lineSize_3.png"></td>
	 * </tr>
	 * </table>
	 * @return The builder itself (fluent builder pattern).
	 */
	B strokeWidth(double strokeWidth);

}
