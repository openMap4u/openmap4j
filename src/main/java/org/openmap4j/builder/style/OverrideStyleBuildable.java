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

import java.util.List;
import java.util.Optional;

import org.openmap4j.common.Buildable;
import org.openmap4j.style.AreaStyleable;
import org.openmap4j.style.ImageStyleable;
import org.openmap4j.style.LineStyleable;
import org.openmap4j.style.Styleable;
import org.openmap4j.style.TextStyleable;

public interface OverrideStyleBuildable extends Buildable<List<Optional<Styleable>>> {
	
	OverrideStyleBuildable doNotOverride();
	
	OverrideStyleBuildable overrideLineStyle(LineStyleable lineStyle);
	
	LineStyleBuildable<OverrideStyleBuildable> line();
	
	
	OverrideStyleBuildable overrideAreaStyle(AreaStyleable lineStyle);
	
	AreaStyleBuildeable<OverrideStyleBuildable> area();

	OverrideStyleBuildable overrideImageStyle(ImageStyleable lineStyle);
	
	
	ImageStyleBuildable<OverrideStyleBuildable> imageStyle();
	
	OverrideStyleBuildable overrideTextStyle(TextStyleable lineStyle);
	

	TextStyleBuildable<OverrideStyleBuildable> text();

	
	
}
