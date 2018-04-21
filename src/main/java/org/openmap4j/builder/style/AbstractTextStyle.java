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

import org.openmap4j.style.TextStyleable;

class AbstractTextStyle<B extends AbstractTextStyle<B>> extends Fill<B> implements TextStyleable, SetTextStyleable<B> {

	private Optional<TEXT_ALIGN> align = Optional.empty();
	private Optional<BASE_LINE> baseLine = Optional.empty();
	private Optional<String> fontFamily = Optional.empty();
	private Optional<Double> fontSize = Optional.empty();

	private Optional<FONT_STYLE> fontStyle = Optional.empty();

	@Override
	public Optional<TEXT_ALIGN> getAlign() {
		return this.align;
	}

	@Override
	public Optional<BASE_LINE> getBaseLine() {
		return this.baseLine;
	}

	@Override
	public Optional<String> getFontFamily() {
		return this.fontFamily;
	}

	@Override
	public Optional<Double> getFontSize() {
		return this.fontSize;
	}

	@Override
	public Optional<FONT_STYLE> getFontStyle() {
		return this.fontStyle;
	}

	@SuppressWarnings("unchecked")
	@Override
	public B align(TEXT_ALIGN textAlign) {
		this.align=Optional.of(textAlign);
		return (B)this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public B baseLine(BASE_LINE baseLine) {
	this.baseLine=Optional.of(baseLine);
		return (B)this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public B fontFamily(String fontFamily) {
		this.fontFamily=Optional.of(fontFamily);
		return (B)this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public B fontSize(double fontSize) {
		this.fontSize=Optional.of(fontSize);
		return (B)this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public B fontStyle(FONT_STYLE fontStyle) {
		this.fontStyle=Optional.of(fontStyle);
		return (B)this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!super.equals(other))
			return false;
		if (!(this.align.equals(((AbstractTextStyle<B>) other).getAlign())))
			return false;
		if (!(this.baseLine.equals(((AbstractTextStyle<B>) other).getBaseLine())))
			return false;
		if (!(this.fontFamily.equals(((AbstractTextStyle<B>) other).getFontFamily())))
			return false;
		if (!(this.fontSize.equals(((AbstractTextStyle<B>) other).getFontSize())))
			return false;
		if (!(this.fontStyle.equals(((AbstractTextStyle<B>) other).getFontStyle())))
			return false;
 		return true;
	}

}
