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
import java.awt.geom.Path2D;

import org.openmap4j.common.NestedBuilder;
 
 
 abstract class AbstractLineBuilder<P,B extends AbstractLineBuildable<P,B,T>,T> extends NestedBuilder<P,T> implements AbstractLineBuildable<P,B,T> {


	public AbstractLineBuilder(P parent, String parentMethodName) {
		super(parent, parentMethodName);
		resetPath();
	}

	
	public AbstractLineBuilder() {
		resetPath();
	}

	
	/**
	 * Stores a reference to the path.
	 */
	private Path2D.Double path = null;
	 
	
	/**
	 * For extension developer only (resets the path).
	 *
	 * @return
	 */
	protected void resetPath() {
		this.path=new Path2D.Double(Path2D.WIND_EVEN_ODD);
	}
	
	/**
	 * Gets the path (for internal purposes only).
	 *
	 * @return The path.
	 */
	protected Path2D.Double getPath() {
		return this.path;
	}
	
	protected void setPath(Shape shape) {
		this.path = new Path2D.Double(shape);
	}

	
	

	

	@SuppressWarnings("unchecked")
	@Override
	public B bezierTo(double cp1x, double cp1y, double cp2x, double cp2y, double toX, double toY) {
		this.path.curveTo(cp1x, cp1y, cp2x, cp2y, toX, toY);
		return (B)this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public B lineTo(double toX, double toY) {
		this.path.lineTo(toX, toY);
		return (B)this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public B moveTo(double toX, double toY) {
		this.path.moveTo(toX, toY);
		return (B)this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public B quadTo(double cpX, double cpY, double toX, double toY) {
		this.path.quadTo(cpX, cpY, toX, toY);
		return (B)this;
	}



 
	
}
