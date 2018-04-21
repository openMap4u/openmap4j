package org.openmap4j.builder.geom;

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

import java.awt.geom.Point2D;

import org.openmap4j.common.NestedBuilder;

class PointBuilder<P> extends NestedBuilder<P,Point2D> implements PointBuildable<P> {

	private double x;
	private double y;

	@Override
	public PointBuildable<P> x(double x) {
		this.x = x;
		return this;
	}

	@Override
	public PointBuildable<P> y(double y) {
		this.y = y;
		return this;
	}

	@Override
	protected Point2D buildNested() {
		return new Point2D.Double(this.x, this.y);
	}

}
