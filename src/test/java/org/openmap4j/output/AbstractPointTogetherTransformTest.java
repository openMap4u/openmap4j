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
package org.openmap4j.output;

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
import java.awt.geom.Rectangle2D;
import java.nio.file.FileSystems;

import org.openmap4j.builder.geom.GeomBuilderFactory;
import org.openmap4j.builder.style.StyleBuilderFactory;
import org.openmap4j.style.Symbolizeable;

public abstract class AbstractPointTogetherTransformTest extends AbstractPointTransformTest  {

	@Override
	Symbolizeable[] getSymbol() {
		return new Symbolizeable[] {StyleBuilderFactory.getAreaSymbolBuilder().area(new Rectangle2D.Double(-12.5, -12.5, 25, 25))
				.strokeColor(Color.BLACK).strokeWidth(1).build(),
				StyleBuilderFactory.getImageSymbolBuilder().imagePath(FileSystems.getDefault().getPath("src","test","resources","image","image.png")).build(),
				 StyleBuilderFactory.getTextSymbolBuilder().text("Hello").fontSize(20).fill(Color.BLACK).x(0).y(0)
						.build(),
						StyleBuilderFactory.getLineSymbolBuilder()
						.line(GeomBuilderFactory.getLineBuilder().moveTo(-25, 0).lineTo(0,25).lineTo(0,-25).lineTo(25,0).build()).strokeColor(Color.BLACK)
						.strokeWidth(3).build()
		
		};
	}

}
