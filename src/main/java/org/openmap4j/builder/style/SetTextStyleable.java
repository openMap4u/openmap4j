package org.openmap4j.builder.style;

import org.openmap4j.style.TextStyleable.BASE_LINE;
import org.openmap4j.style.TextStyleable.FONT_STYLE;
import org.openmap4j.style.TextStyleable.TEXT_ALIGN;

interface SetTextStyleable<S extends SetTextStyleable<S>> extends  SetStrokeable<S>,SetFillable<S>,SetStyleable<S>{

	S align(TEXT_ALIGN textAlign);

	S baseLine(BASE_LINE baseLine);

	S fontFamily(String fontFamily);

	S fontSize(double fontSize);

	S fontStyle(FONT_STYLE fontStyle);
	

}
