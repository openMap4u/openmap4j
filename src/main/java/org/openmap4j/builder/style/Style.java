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

import java.util.Optional;

import org.openmap4j.style.Styleable;

class Style<B extends Style<B>> implements Styleable, SetStyleable<B> {

	private Optional<Double> alpha = Optional.empty();

	private Optional<Boolean> isVisible = Optional.empty();

	@Override
	public Optional<Double> getAlpha() {
		return this.alpha;
	}

	@Override
	public Optional<Boolean> isVisible() {
		return this.isVisible;
	}

	@SuppressWarnings("unchecked")
	@Override
	public B alpha(double alpha) {
		if (alpha < 0 || alpha > 1) {
			throw new IllegalArgumentException(String.format("0 <= {%s} <=1.", String.valueOf(alpha)));
		} else {
			this.alpha = Optional.of(alpha);
		}
		return (B) this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public B visible(boolean visible) {
		this.isVisible = Optional.of(visible);
		return (B) this;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (other.getClass() != getClass())
			return false;

		if (!(this.alpha.equals(((Style<B>) other).getAlpha())))
			return false;
		if (!(this.isVisible.equals(((Style<B>) other).isVisible())))
			return false;
		return true;
	}

	 
}
