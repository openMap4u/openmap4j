package org.openmap4j.plugin.output.svg;

import org.openmap4j.style.AreaStyleable;
import org.openmap4j.style.AreaSymbolizeable;
import org.openmap4j.style.Fillable;
import org.openmap4j.style.ImageSymbolizeable;
import org.openmap4j.style.LineStyleable;
import org.openmap4j.style.LineSymbolizeable;
import org.openmap4j.style.Strokeable;
import org.openmap4j.style.Styleable;
import org.openmap4j.style.TextStyleable;

class SvgCssStyleHelper {
	
 
	
	public String getCssStyle(Styleable style,CssStyleBuilder.MODE mode, String id) {
		if(style instanceof TextStyleable) {
			return getTextSymbolCssStyle((TextStyleable) style,mode,id);
		} else if (style instanceof AreaSymbolizeable) {
			return getShapeSymbolCssStyle((AreaSymbolizeable) style,mode,id);
		} else if (style instanceof LineSymbolizeable) {
			return getLineSymbolCssStyle((LineSymbolizeable) style,mode,id);
		} else if (style instanceof ImageSymbolizeable) {
			return getImageSymbolCssStyle((ImageSymbolizeable) style,mode,id);
		} else if (style instanceof AreaStyleable) {
			return getShapeStyleCssStyle((AreaStyleable) style,mode,id);
		} else if (style instanceof LineStyleable) {
			return getLineStyleCssStyle((LineStyleable) style,mode,id);
		} else {
			throw new IllegalArgumentException(String.format("Unsupported style {}",style));
		}
	 
	}
	
	
	public String getImageSymbolCssStyle(ImageSymbolizeable imageStyle,CssStyleBuilder.MODE mode, String id) {
		return createBuilder(imageStyle,mode,id).build();
	}

	public String getTextSymbolCssStyle(TextStyleable textStyle,CssStyleBuilder.MODE mode, String id) {
		return getFillStyleBuilder(textStyle,mode,id)
				.fontBaseLine(textStyle.getBaseLine())
				.fontSize(textStyle.getFontSize())
				.fontFamily(textStyle.getFontFamily())
				.fontStyle(textStyle.getFontStyle())
				.build();
	} 
	
	public String getLineStyleCssStyle(LineStyleable lineStyle, CssStyleBuilder.MODE mode, String id) {
		return getLineStyleBuilder(lineStyle,mode,id).build();
	}
	
	public String getLineSymbolCssStyle(LineSymbolizeable lineSymbol, CssStyleBuilder.MODE mode, String id) {
		return getStrokeStyleBuilder(lineSymbol,mode,id).build();
	}
	
	public String getShapeStyleCssStyle(AreaStyleable style,CssStyleBuilder.MODE mode, String id) {
		return getShapeStyleBuilder(style,mode,id).build();
	}
	
	public String getShapeSymbolCssStyle(AreaSymbolizeable shapeSymbol, CssStyleBuilder.MODE mode, String id) {
		return getFillStyleBuilder(shapeSymbol,mode,id).build();
	}
	
	 CssStyleBuilder getStrokeStyleBuilder(Strokeable strokeStyle, CssStyleBuilder.MODE mode, String id) {
		return createBuilder(strokeStyle,mode,id)
				.stroke(strokeStyle.getStrokeColor())
				.strokeWidth(strokeStyle.getStrokeWidth())
				.strokeLineCap(strokeStyle.getStrokeCap())
				.strokeDashArray(strokeStyle.getStrokeDashArray())
				.strokeLineOffset(strokeStyle.getStrokeDashOffset())
				.strokeLineJoin(strokeStyle.getStrokeJoin())
				.strokeMitterLimit(strokeStyle.getStrokeMiterLimit());
	}
	
	 CssStyleBuilder getFillStyleBuilder(Fillable fillStyle,CssStyleBuilder.MODE mode, String id) {
		return getStrokeStyleBuilder(fillStyle,mode,id).fill(fillStyle.getFill());
	}
	
	CssStyleBuilder getLineStyleBuilder(LineStyleable lineStyle, CssStyleBuilder.MODE mode, String id) {
		return createBuilder(lineStyle,mode,id)
				.stroke(lineStyle.getStrokeColor())
				.strokeWidth(lineStyle.getStrokeWidth())
				.strokeLineCap(lineStyle.getStrokeCap())
				.strokeDashArray(lineStyle.getStrokeDashArray())
				.strokeLineOffset(lineStyle.getStrokeDashOffset())
				.strokeLineJoin(lineStyle.getStrokeJoin())
				.strokeMitterLimit(lineStyle.getStrokeMiterLimit());
	}
	
	CssStyleBuilder getShapeStyleBuilder(AreaStyleable shapeStyle,CssStyleBuilder.MODE mode, String id) {
		return getFillStyleBuilder(shapeStyle,mode,id);
	}
	
	CssStyleBuilder createBuilder(Styleable style, CssStyleBuilder.MODE mode, String id) {
		return new CssStyleBuilder(id, mode).opacity(style.getAlpha()).visible(style.isVisible());
	}
	
	



}
