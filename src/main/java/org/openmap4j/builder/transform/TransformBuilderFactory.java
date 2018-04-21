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

/**
 * Factory to create a transform builder.
 * @author mh
 *
 */
public class TransformBuilderFactory {
	
	private TransformBuilderFactory() {}
	
	/**
	 * Gets a transform builder.
	 * @return The transfrom builder.
	 */
	public static TransformableBuilder<AffineTransform> getTransformBuilder() {
		return new TransformBuilder<>();
	}

}
