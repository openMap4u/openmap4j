package org.openmap4j.plugin.output.svg;

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

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.openmap4j.common.Base64Image;
import org.openmap4j.style.AreaStyleable;
import org.openmap4j.style.AreaSymbolizeable;
import org.openmap4j.style.ImageStyleable;
import org.openmap4j.style.ImageSymbolizeable;
import org.openmap4j.style.LineStyleable;
import org.openmap4j.style.LineSymbolizeable;
import org.openmap4j.style.Styleable;
import org.openmap4j.style.Symbolizeable;
import org.openmap4j.style.TextStyleable;
import org.openmap4j.style.TextSymbolizeable;

class SvgBuilder {

	private XMLStreamWriter writer = null;
	static final String DEFAULT_DRAWING_UNITS = "px";
	private static final String BLANK = " ";
	private static final String COMMA = ",";
	public static final String DTD = "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">";
	private static final int FIVE = 5;
	private static final int FOUR = 4;
	private static final String G_ELEMENT_NAME = "g";
	private static final String DEFS_ELEMENT_NAME = "defs";
	private static final String STYLE_ELEMENT_NAME = "style";
	private static final String DEFAULT_STYLE = "path{fill:transparent;} symbol{overflow:visible}";
	public static final String HEIGHT = "height";
	private static final String HREF = "href";
	private static final  Logger LOGGER = Logger.getLogger(SvgBuilder.class.getName());
	/* The svg namespace. */
	public static final String NAMESPACE_URI = "http://www.w3.org/2000/svg";
	private static final int ONE = 1;
	public static final String PATH = "path";
	private static final String SHARP = "#";
	private static final int SIX = 6;
	private static final String TEXT_ELEMENT_NAME = "text";
	private static final String IMAGE_ELEMENT_NAME = "image";
	/**
	 * Stores the transfrom attribute name.
	 */
	private static final String STYLE_ATTRIBUTE_NAME = "style";
	public static final String SVG = "svg";
	private static final String SYMBOL_ELEMENT_NAME = "symbol";
	private static final int THREE = 3;
	/**
	 * Stores the transfrom attribute name.
	 */
	private static final String TRANSFORM = "transform";
	private static final int TWO = 2;
	private static final String USE_ELEMENT_NAME = "use";
	public static final String UTF8 = "UTF-8";
	public static final String WIDTH = "width";
	private static final String X = "x";
	public static final String XLINK = "http://www.w3.org/1999/xlink";
	private static final String Y = "y";
	private static final int ZERO = 0;

	private int countG = 0;

	private int symbolId = 0;

	private SvgCssStyleHelper cssStyleHelper = null;

	private Object currentStyle = null;

	public SvgBuilder(XMLStreamWriter writer) {
		this.writer = writer;
		cssStyleHelper = new SvgCssStyleHelper();
	}

	public void writeStartDocument() {
		try {
			writer.writeStartDocument(UTF8, "1.0");
			writer.writeDTD(DTD);
		} catch (XMLStreamException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public void writeSvgStartElement(Shape shape, String drawingUnits) {
		try {
			writer.writeStartElement(SVG);
			writer.writeNamespace("xmlns", NAMESPACE_URI);
			writer.writeNamespace("xlink", XLINK);
			writer.writeAttribute("version", "1.1");
			Rectangle2D bounds = shape.getBounds2D();
			writer.writeAttribute(WIDTH, bounds.getWidth() + drawingUnits);
			writer.writeAttribute(HEIGHT, bounds.getHeight() + drawingUnits);
			writer.writeAttribute("viewBox", "0 0 " + bounds.getWidth() + " " + bounds.getHeight());
			writer.writeStartElement(DEFS_ELEMENT_NAME);
			writer.writeStartElement(STYLE_ELEMENT_NAME);
			writer.writeAttribute("type","text/css");
			writer.writeCData(DEFAULT_STYLE);
			writer.writeEndElement();

			writer.writeEndElement();
		} catch (XMLStreamException e) {
			LOGGER.log(Level.SEVERE,"Unable to write start element",e);
		}
	}

	public SvgBuilder attribute(String attributeName, String attributeValue) {
		try {
			writer.writeAttribute(attributeName, attributeValue);
		} catch (XMLStreamException e) {
			LOGGER.log(Level.SEVERE,"Unable to write attribute",e);
		}
		return this;
	}

	public SvgBuilder endElement() {
		try {
			writer.writeEndElement();
		} catch (XMLStreamException e) {
			LOGGER.log(Level.SEVERE,"Unable to write end element",e);
		}
		return this;
	}

	public SvgBuilder startElement(String elementName) {
		try {
			writer.writeStartElement(elementName);
		} catch (XMLStreamException e) {
			LOGGER.log(Level.SEVERE, "Unable to write start element", e);
		}
		return this;
	}

	public void writeEndDocument() {
		try {
			writer.writeEndDocument();
		} catch (XMLStreamException e) {
			LOGGER.log(Level.SEVERE,"Unable to write end document",e);
		}

	}

	public void drawArea(AreaStyleable defaultStyle, Shape area, Optional<AreaStyleable> style,
			Optional<AffineTransform> transform) {
		if (!defaultStyle.equals(this.currentStyle)) {
			drawG(defaultStyle);
			this.currentStyle = defaultStyle;
		}
		drawArea(area, style, transform, Optional.empty(),Optional.empty());
	}

	/**
	 * Draws a g element.
	 * 
	 * @param style
	 *            The style.
	 */
	void drawG(Styleable style) {
		closeAllG();
		this.writeStartElement(G_ELEMENT_NAME);
		this.writeStyleAttribute(style);
		this.countG++;// increment the g counter.
	}

	/**
	 * Writes a start element.
	 * 
	 * @param elementName
	 *            The element name.
	 */
	void writeStartElement(String elementName) {
		try {
			this.writer.writeStartElement(elementName);
		} catch (XMLStreamException e) {
			LOGGER.log(Level.SEVERE,"Unable to write start element",e);
		}
	}

	/**
	 * Writes an attribute.
	 * 
	 * @param attributeName
	 *            The attribute name.
	 * @param attributValue
	 *            The attribute value.
	 */
	void writeAttribute(String attributeName, String attributValue) {
		try {
			System.out.println(attributeName+ " "+ attributValue);
			this.writer.writeAttribute(attributeName, attributValue);
		} catch (XMLStreamException e) {
			LOGGER.log(Level.SEVERE,"Unable to write attribute",e);
		}
	}

	/**
	 * Writes the style attribute.
	 * 
	 * @param style
	 *            The style attribute.
	 */
	void writeStyleAttribute(Styleable style) {
		this.writeAttribute(STYLE_ATTRIBUTE_NAME, cssStyleHelper.getCssStyle(style,CssStyleBuilder.MODE.ELEMENT_STYLE,null));
	}

	<T extends Styleable> void writeStyleAttribute(Optional<T> style) {
		style.ifPresent(this::writeStyleAttribute);
	}

	void writeTransformAttribute(AffineTransform transform) {
		this.writeAttribute(TRANSFORM,
				new StringBuilder("matrix(").append(transform.getScaleX()).append(",").append(transform.getShearY())
						.append(",").append(transform.getShearX()).append(",").append(transform.getScaleY()).append(",")
						.append(transform.getTranslateX()).append(",").append(transform.getTranslateY()).append(")")
						.toString());
	}

	void writeTransformAttribute(Optional<AffineTransform> transform) {
		transform.ifPresent(this::writeTransformAttribute);
	}

	void closeAllG() {
		while (this.countG > 0) {
			this.writeEndElement();
			this.countG--;// decrement the g counter.
		}
	}

	void writeEndElement() {
		try {
			this.writer.writeEndElement();
		} catch (XMLStreamException e) {
			LOGGER.log(Level.SEVERE,"Unable to write end element",e);
		}
	}
	
	void writeId(Optional<String> id) {
		if (id.isPresent()) {
		this.writeAttribute("id", id.get());
		}
	}
	
	void writeClass(Optional<String> cssClass) {
		if (cssClass.isPresent()) {
		this.writeAttribute("class", cssClass.get());
		}
	}

	public void drawArea(Shape area, Optional<AreaStyleable> style, Optional<AffineTransform> transform, Optional<String> id,Optional<String> cssClass) {
		this.writeStartElement(PATH);
		this.writeId(id);
		this.writeClass(cssClass);
		this.writeStyleAttribute(style);
		this.writePathAttribute(area);
		this.writeTransformAttribute(transform);
		this.writeEndElement();
	}

	void writePathAttribute(Shape path) {
		writeAttribute("d", createPathGeometry(path));
	}

	/**
	 * Internal helper to write the path.
	 *
	 * @param shape
	 *            The shape to write.
	 * @return The String representing the path.
	 */
	final String createPathGeometry(Shape shape) {
		StringBuilder sb = new StringBuilder();
		PathIterator pi = shape.getPathIterator(null);
		double[] coords = new double[SIX];
		while (!pi.isDone()) {
			int type = pi.currentSegment(coords);
			switch (type) {
			case PathIterator.SEG_MOVETO:
				sb.append("M");
				writeCoordinatePair(coords[ZERO], coords[ONE], sb);
				break;
			case PathIterator.SEG_LINETO:
				sb.append("L");
				writeCoordinatePair(coords[ZERO], coords[ONE], sb);
				break;
			case PathIterator.SEG_QUADTO:
				sb.append("Q");
				writeCoordinatePair(coords[ZERO], coords[ONE], sb);
				writeCoordinatePair(coords[TWO], coords[THREE], sb);
				break;
			case PathIterator.SEG_CUBICTO:
				sb.append("C");
				writeCoordinatePair(coords[ZERO], coords[ONE], sb);
				writeCoordinatePair(coords[TWO], coords[THREE], sb);
				writeCoordinatePair(coords[FOUR], coords[FIVE], sb);
				break;
			default:
				break;
			}
			pi.next();
		}
		return sb.toString();
	}

	final StringBuilder writeCoordinatePair(double x, double y, StringBuilder builder) {
		return builder.append(x).append(COMMA).append(y).append(BLANK);
	}

	public void drawImage(ImageStyleable defaultStyle, Path imagePath, double x, double y,
			Optional<ImageStyleable> style, Optional<AffineTransform> transform) {
		if (!defaultStyle.equals(this.currentStyle)) {
			drawG(defaultStyle);
			this.currentStyle = defaultStyle;
		}
		drawImage(imagePath, x, y, style, transform,Optional.empty(),Optional.empty());

	}

	public void drawImage(Path imagePath, double x, double y, Optional<ImageStyleable> style,
			Optional<AffineTransform> transform, Optional<String> id,Optional<String> cssClass) {
		this.writeStartElement(IMAGE_ELEMENT_NAME);
		this.writeId(id);
		this.writeClass(cssClass);
		
		try {
			RenderedImage img = Base64Image.read(imagePath);
			this.writeAttribute(XLINK, HREF, Base64Image.imgToBase64String(img, "png"));
			this.writeAttribute(WIDTH, String.valueOf(img.getWidth()));
			this.writeAttribute(HEIGHT, String.valueOf(img.getHeight()));
		} catch (IOException e) {
			throw new IllegalArgumentException(String.format("Unsupported parameter {%s} ", imagePath.toString()));
		}
		this.writeStyleAttribute(style);
		this.writeTransformAttribute(transform);
		this.writeEndElement();

	}

	public void drawLine(LineStyleable defaultStyle, Shape line, Optional<LineStyleable> style,
			Optional<AffineTransform> transform) {
		if (!defaultStyle.equals(this.currentStyle)) {
			drawG(defaultStyle);
			this.currentStyle = defaultStyle;
		}
		drawLine(line, style, transform,Optional.empty(),Optional.empty());

	}

	public void drawLine(Shape line, Optional<LineStyleable> style, Optional<AffineTransform> transform,Optional<String> id, Optional<String> cssClass) {
		this.writeStartElement(PATH);
		this.writeId(id);
		this.writeClass(cssClass);
		this.writeStyleAttribute(style);
		this.writePathAttribute(line);
		this.writeTransformAttribute(transform);
		this.writeEndElement();
	}

	public void drawText(TextStyleable defaultStyle, String text, double x, double y, Optional<TextStyleable> style,
			Optional<AffineTransform> transform) {
		if (!defaultStyle.equals(this.currentStyle)) {
			drawG(defaultStyle);
			this.currentStyle = defaultStyle;
		}
		drawText(text, x, y, style, transform,Optional.empty());
	}

	public void drawText(String text, double x, double y, Optional<TextStyleable> style,
			Optional<AffineTransform> transform, Optional<String> id) {
		this.writeStartElement(TEXT_ELEMENT_NAME);
		this.writeAttribute(X, String.valueOf(x));
		this.writeAttribute(Y, String.valueOf(y));
		this.writeStyleAttribute(style);
		this.writeText(text);
		this.writeTransformAttribute(transform);
		this.writeEndElement();
	}

	void writeText(String text) {
		try {
			this.writer.writeCharacters(text);
		} catch (XMLStreamException e) {
			LOGGER.log(Level.SEVERE, "unable tot write text", e);
		}
	}

	public void drawPoint(Symbolizeable[] defaultStyle, double x, double y,Optional< List<Optional<Styleable>>> style,
			Optional<AffineTransform> transform) {
		// close all g
		closeAllG();
		
		if (this.currentStyle==null ||!this.currentStyle.getClass().isArray() || !Arrays.equals(defaultStyle,(Object[]) this.currentStyle)) {
			symbolId++; // increment symbol id.
			drawSymbol(defaultStyle,  getSymbolId());
		}
		writeStartElement(USE_ELEMENT_NAME);
		writeAttribute(XLINK, HREF, new StringBuilder(SHARP).append( getSymbolId()).toString());
		/* only if there is no transform */
		if (!transform.isPresent()) {
			writeAttribute(X, String.valueOf(x));
			writeAttribute(Y, String.valueOf(y));
			/* otherwise we have to add the transform in advance */
		} else {
			AffineTransform transf = new AffineTransform();
			transf.translate(x, y);
			transf.concatenate(transform.get());
			this.writeTransformAttribute(transf);
		}
		/* you can only override the defualt style as long the new style has as many entries as the original symbol. */
		if(style.isPresent() && defaultStyle.length == style.get().size()) {
				writeAttribute("style",getIndividualPointStyles(style.get(),  getSymbolId()));
				}
		writeEndElement();
	}
	
	String getSymbolId() {
		return new StringBuilder("s").append(this.symbolId).toString();
	}
	
	public String getIndividualPointStyles(List<Optional<Styleable>> styles, String id) {
		StringBuilder sb = new StringBuilder();
		int subCount=0;
		for(Optional<Styleable> style: styles) {
			if ( style.isPresent()) {
			sb.append(cssStyleHelper.getCssStyle(style.get(),CssStyleBuilder.MODE.OVERRIDE_ELEMENT_STYLE_VARS,getPointSymbolId(id,subCount)));
			}
			subCount++;
			
		}
		return sb.toString();
	}
	
	 

	void writeAttribute(String namespaceURI, String localName, String value) {
		try {
			this.writer.writeAttribute(namespaceURI, localName, value);
		} catch (XMLStreamException e) {
			LOGGER.log(Level.SEVERE,"Unable to write attribute",e);
		}
	}

	void drawSymbol(Symbolizeable[] symbol, String id) {
		this.writeStartElement(SYMBOL_ELEMENT_NAME);
		this.writeAttribute("id", id);
		int subCounter = 0;
		Optional<String> subId = Optional.empty();
		StringBuilder cssSymbolStyle = new StringBuilder();
		for (Symbolizeable symbolPrimitive : symbol) {
			 subId = Optional.of(getPointSymbolId(id, subCounter));
			if (symbolPrimitive instanceof AreaSymbolizeable) {
				AreaSymbolizeable as =(AreaSymbolizeable) symbolPrimitive;
				cssSymbolStyle.append(cssStyleHelper.getCssStyle(as,CssStyleBuilder.MODE.CSS_STYLESHEET_WITH_VARS,subId.get())) ;
				drawArea(as.getArea(), Optional.empty(),Optional.empty(),Optional.empty(),subId );
			} else if (symbolPrimitive instanceof LineSymbolizeable) {
				LineSymbolizeable ls = (LineSymbolizeable) symbolPrimitive;
				cssSymbolStyle.append(cssStyleHelper.getCssStyle(ls,CssStyleBuilder.MODE.CSS_STYLESHEET_WITH_VARS,subId.get())) ;
				drawLine(ls.getLine(), Optional.empty(), Optional.empty(),Optional.empty(),subId);
			} else if (symbolPrimitive instanceof ImageSymbolizeable) {
				ImageSymbolizeable is = (ImageSymbolizeable) symbolPrimitive;
				cssSymbolStyle.append(cssStyleHelper.getCssStyle(is,CssStyleBuilder.MODE.CSS_STYLESHEET_WITH_VARS,subId.get())) ;
				drawImage(is.getImagePath(), is.getPoint().getX(), is.getPoint().getY(), Optional.empty(),
						Optional.empty(),Optional.empty(),subId);
			} else if (symbolPrimitive instanceof TextSymbolizeable) {
				TextSymbolizeable ts = (TextSymbolizeable) symbolPrimitive;
				cssSymbolStyle.append(cssStyleHelper.getCssStyle(ts,CssStyleBuilder.MODE.CSS_STYLESHEET_WITH_VARS,subId.get())) ;
				drawText(ts.getText(), ts.getPoint().getX(), ts.getPoint().getY(), Optional.empty(), Optional.empty(),subId);
			} else {
				throw new IllegalArgumentException(String.format("Unsupported Symbol {}", symbolPrimitive));
			}
	 		subCounter++;// increment the subcounter
		}
		this.currentStyle=symbol;
	 	this.writeEndElement();
		/* write the style with var */
		this.writeStartElement("style");
		this.writeAttribute("type", "text/css");
		this.writeText(cssSymbolStyle.toString());
		this.writeEndElement();
	}

	private String getPointSymbolId(String id, int subCounter) {
		return new StringBuilder("x").append(id).append("x").append(subCounter).toString();
	}

}
