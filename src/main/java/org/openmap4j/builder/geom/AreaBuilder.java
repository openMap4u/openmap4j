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

import java.awt.geom.Area;

/**
 * Builds a polygon.
 * 
 * @author mh
 *
 */
class AreaBuilder<P> extends AbstractLineBuilder<P,AreaBuildable<P>,Area> implements AreaBuildable<P> {
	
	public AreaBuilder() {
		super();
	}

	public AreaBuilder(P parent, String parentMethodName) {
		super(parent, parentMethodName);
	}

	/**
	 * Gets the area (for internal purposes only).
	 * @return The area.
	 */
	protected Area getArea() {
		return new Area(this.getPath());
	}

	@Override
	public AreaBuildable<P> add(Area shape) {
		Area area = getArea();
		area.add(shape);
		setPath(area);
		return this;
	}

	@Override
	public AreaBuildable<P> intersect(Area shape) {
		Area area = getArea();
		area.intersect(shape);
		return this;
	}

	@Override
	public AreaBuildable<P> subtract(Area shape) {
		Area area = getArea();
		area.subtract(shape);
		setPath(area);
		return this;
	}

	@Override
	public AreaBuildable<P> exclusiveOr(Area shape) {
		Area area = getArea();
		area.exclusiveOr(shape);
		setPath(area);
		return this;
	}

	@Override
	public AreaBuildable<P> close() {
		getPath().closePath();
		return this;
	}
	
	@Override
	protected Area buildNested() {
		return getArea();
	}



}
