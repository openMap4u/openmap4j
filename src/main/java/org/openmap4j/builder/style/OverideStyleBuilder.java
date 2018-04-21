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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.openmap4j.style.AreaStyleable;
import org.openmap4j.style.ImageStyleable;
import org.openmap4j.style.LineStyleable;
import org.openmap4j.style.Styleable;
import org.openmap4j.style.TextStyleable;

 class OverideStyleBuilder implements OverrideStyleBuildable  {

	private List<Optional<Styleable>> overrideStyles = new ArrayList<>();
	
	 public void  add(LineStyle overridenStyle) {
		this.overrideStyles.add(Optional.of(overridenStyle));
	}
	 
	 public void  add(AreaStyle overridenStyle) {
			this.overrideStyles.add(Optional.of(overridenStyle));
		}
	 
	 public void  add(TextStyle overridenStyle) {
			this.overrideStyles.add(Optional.of(overridenStyle));
		}
	 public void  add(ImageStyle overridenStyle) {
			this.overrideStyles.add(Optional.of(overridenStyle));
		}
	
	@Override
	public List<Optional<Styleable>> build() {
		return overrideStyles ;
	}

	@Override
	public OverrideStyleBuildable doNotOverride() {
		this.overrideStyles.add(Optional.empty());
		return this;
	}

	@Override
	public OverrideStyleBuildable overrideLineStyle(LineStyleable lineStyle) {
		this.overrideStyles.add(Optional.of(lineStyle));
		return this;
	}
	
 

	@Override
	public LineStyleBuildable<OverrideStyleBuildable> line() {
		return new LineStyleBuilder<>(this,"add");
	}

	@Override
	public OverrideStyleBuildable overrideAreaStyle(AreaStyleable lineStyle) {
		this.overrideStyles.add(Optional.of(lineStyle));
		return this;
	}

	@Override
	public AreaStyleBuildeable<OverrideStyleBuildable> area() {
		return new AreaStyleBuilder<> (this,"add");
	}

	@Override
	public OverrideStyleBuildable overrideImageStyle(ImageStyleable imageStyle) {
		this.overrideStyles.add(Optional.of(imageStyle));
		return this;
	}

	@Override
	public ImageStyleBuildable<OverrideStyleBuildable> imageStyle() {
		return new ImageStyleBuilder<>(this,"add");
	}

	@Override
	public OverrideStyleBuildable overrideTextStyle(TextStyleable textStyle) {
		this.overrideStyles.add(Optional.of(textStyle));
		return this;
	}

	@Override
	public TextStyleBuildable<OverrideStyleBuildable> text() {
		return new TextStyleBuilder<>(this,"add");
	}

}
