package org.openmap4j.builder.style;

import org.openmap4j.style.TextStyleable;

class TextStyle<B extends TextStyle<B>> extends AbstractTextStyle<B>
		implements TextStyleable, SetTextStyleable<B> {

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!super.equals(other))
			return false;
		return true;
	}

}
