package org.openmap4j.builder.style;

import org.openmap4j.style.AreaStyleable;
import org.openmap4j.style.AreaSymbolizeable;
import org.openmap4j.style.ImageStyleable;
import org.openmap4j.style.ImageSymbolizeable;
import org.openmap4j.style.LineStyleable;
import org.openmap4j.style.LineSymbolizeable;
import org.openmap4j.style.TextStyleable;
import org.openmap4j.style.TextSymbolizeable;

public class StyleBuilderFactory {
	
	private StyleBuilderFactory() {}
	
	public static final LineStyleBuildable<LineStyleable> getLineStyleBuilder() {
		return new LineStyleBuilder<>();
	}
	
	public static final LineSymbolBuildable<LineSymbolizeable> getLineSymbolBuilder() {
		return new LineSymbolBuilder<>();
	}
	
	public static final AreaStyleBuildeable<AreaStyleable> getAreaStyleBuilder() {
		return new AreaStyleBuilder<>();
	}
	
	public static final AreaSymbolBuildable<AreaSymbolizeable> getAreaSymbolBuilder() {
		return new AreaSymbolBuilder<>();
	}
	
	public static final ImageStyleBuildable<ImageStyleable> getImageStyleBuilder() {
		return new ImageStyleBuilder<>();
	}
	
	public static final ImageSymbolBuildable<ImageSymbolizeable> getImageSymbolBuilder() {
		return new ImageSymbolBuilder<>();
	}
	
	public static final TextStyleBuildable<TextStyleable> getTextStyleBuilder() {
		return new TextStyleBuilder<>();
	}
	
	public static final TextSymbolBuildable<TextSymbolizeable> getTextSymbolBuilder() {
		return new TextSymbolBuilder<>();
	}
	
	public static final OverrideStyleBuildable  getOverrideStyleBuilder() {
		return new OverideStyleBuilder ();
	}

}
