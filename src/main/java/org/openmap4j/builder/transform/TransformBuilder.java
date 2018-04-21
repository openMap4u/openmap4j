package org.openmap4j.builder.transform;

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

import java.awt.geom.AffineTransform;

import org.openmap4j.common.NestedBuilder;

/**
 * 
 * @author zwotti
 *
 */
final class TransformBuilder<P> extends NestedBuilder<P, AffineTransform> implements TransformableBuilder<P> {


	private AffineTransform transform = new AffineTransform();

	public TransformBuilder(P parent, String parentMethodName) {
		super(parent, parentMethodName);
	}

	protected TransformBuilder() {
		super();
	}

	@Override
	public TransformableBuilder<P> rotate(double theta) {
		this.transform.rotate(theta);
		return this;
	}

	@Override
	public TransformableBuilder<P> scale(double scale) {
		return this.scale(scale, scale);
	}

	@Override
	public TransformableBuilder<P> scale(double scaleX, double scaleY) {
		this.transform.scale(scaleX, scaleY);
		return this;
	}

	@Override
	public TransformableBuilder<P> translate(double translateX, double translateY) {
		this.transform.translate(translateX, translateY);
		return this;
	}

	@Override
	public TransformableBuilder<P> shear(double shearX, double shearY) {
		this.transform.shear(shearX, shearY);
		return this;
	}

	@Override
	protected AffineTransform buildNested() {
		return transform;
	}

}
