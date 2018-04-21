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
import java.util.Optional;

import org.openmap4j.style.Fillable;

class Fill<B extends Fill<B>> extends Stroke<B> implements Fillable, SetFillable<B> {

	private Optional<Paint> fillColor = Optional.empty();

	@SuppressWarnings("unchecked")
	@Override
	public B fill(Paint fill) {
		this.fillColor = Optional.of(fill);
		return (B) this;
	}

	@Override
	public Optional<Paint> getFill() {
		return this.fillColor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!super.equals(other))
			return false;
		if (!(this.fillColor.equals(((Fill<B>) other).getFill())))
			return false;
		return true;
	}

}
