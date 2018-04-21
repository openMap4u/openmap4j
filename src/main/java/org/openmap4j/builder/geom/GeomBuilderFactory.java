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

import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class GeomBuilderFactory {
	
	private GeomBuilderFactory() {}
	
	/**
	 * Gets the line builder.
	 * @return The line builder.
	 */
	public static LineBuildable<Path2D> getLineBuilder() {
		return new LineBuilder<>();
	}
	

	/**
	 * 
	 * @param parent The parent builder.
	 * @param method The method to call on the parent builder.
	 * @return The line builder.
	 */
	public static <P> LineBuildable<P> getLineBuilder(P parent, String method) {
		return new LineBuilder<>(parent,method);
	}
	
	
	/**
	 * Gets the area builder.
	 * @return The area builder.
	 */
	public static AreaBuildable<Area> getAreaBuilder() {
		return new AreaBuilder<>();
	}
	

	/**
	 * Gets the area builder.
	 * @param parent The parent builder.
	 * @param methodName The method to call on the parent builder.
	 * @return The area builder.
	 */
	public static <P> AreaBuildable<P> getAreaBuilder(P parent , String methodName) {
		return new AreaBuilder<>(parent,methodName);
	}
	
	/**
	 * Gets the point builder.
	 * @return The point builder.
	 */
	public static PointBuildable<Point2D> getPointBuilder() {
		return new PointBuilder<>();
	}

}
