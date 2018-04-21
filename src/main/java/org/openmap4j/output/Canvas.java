package org.openmap4j.output;

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

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openmap4j.builder.geom.GeomUtil;
import org.openmap4j.builder.style.StyleBuilderFactory;
import org.openmap4j.common.Plugable;
import org.openmap4j.style.AreaStyleable;
import org.openmap4j.style.ImageStyleable;
import org.openmap4j.style.LineStyleable;
import org.openmap4j.style.Styleable;
import org.openmap4j.style.Symbolizeable;
import org.openmap4j.style.TextStyleable;

/**
 * All output formats are derived from this base class.
 * 
 * @author mh
 *
 */
public abstract class Canvas implements Drawable, Plugable {

	private Shape canvasArea = null;
	private LineStyleable lineStyle = StyleBuilderFactory.getLineStyleBuilder().strokeColor(Color.BLACK).strokeWidth(1)
			.build();
	private AreaStyleable areaStyle = StyleBuilderFactory.getAreaStyleBuilder().strokeColor(Color.BLACK).strokeWidth(1)
			.fill(Color.LIGHT_GRAY).build();
	private ImageStyleable imageStyle = StyleBuilderFactory.getImageStyleBuilder().build();
	private TextStyleable textStyle = StyleBuilderFactory.getTextStyleBuilder().fill(Color.BLACK).build();
	private Symbolizeable[] pointStyle = new Symbolizeable[] { StyleBuilderFactory.getAreaSymbolBuilder().build() };

	public Canvas(Shape canvasArea) {
		this.canvasArea = canvasArea;
	}

	/**
	 * Creates a rectangular canvas with the given width and height.
	 * 
	 * @param width
	 *            The width.
	 * @param height
	 *            The height.
	 */
	public Canvas(double width, double height) {
		this.canvasArea = new Rectangle2D.Double(0, 0, width, height);
	}

	/**
	 * Gets the currenCanvas active line style.
	 * 
	 * @return The currenCanvas line style.
	 */
	protected final LineStyleable getLineStyle() {
		return this.lineStyle;
	}

	/**
	 * Gets the currenCanvas area style.
	 * 
	 * @return The currenCanvas area style.
	 */
	protected final AreaStyleable getAreaStyle() {
		return areaStyle;
	}

	/**
	 * Gets the currenCanvas image style.
	 * 
	 * @return The currenCanvas image style.
	 */
	protected final ImageStyleable getImageStyle() {
		return imageStyle;
	}

	/**
	 * Gets the currenCanvas texCanvas style.
	 * 
	 * @return The currenCanvas texCanvas style.
	 */
	protected final TextStyleable getTextStyle() {
		return textStyle;
	}

	/**
	 * Gets the currenCanvas poinCanvas style.
	 * 
	 * @return The currenCanvas poinCanvas style.
	 */
	protected final Symbolizeable[] getPointStyle() {
		return this.pointStyle;
	}

	/**
	 * {@inheritDoc}
	 */
	public final Drawable style(LineStyleable lineStyle) {
		this.lineStyle = lineStyle;
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	public final Drawable style(AreaStyleable areaStyle) {
		this.areaStyle = areaStyle;
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	public final Drawable style(ImageStyleable imageStyle) {
		this.imageStyle = imageStyle;
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	public final Drawable style(TextStyleable textStyle) {
		this.textStyle = textStyle;
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	public final Drawable style(Symbolizeable... pointStyle) {
		this.pointStyle = pointStyle;
		return this;
	}

	/**
	 * Gets the currenCanvas drawing area.
	 * 
	 * @return The currenCanvas drawing area.
	 */
	protected final Shape getDrawingArea() {
		return canvasArea;
	}

	@Override
	public final Drawable draw(String text, double x, double y, Object... optionalParams) {
		Optional<AffineTransform> transform = Optional.empty();
		Optional<TextStyleable> style = Optional.empty();
		for (Object param : optionalParams) {
			if (param instanceof AffineTransform) {
				transform = Optional.of((AffineTransform) param);
			} else if (param instanceof TextStyleable) {
				style = Optional.of((TextStyleable) param);
			} else {
				throw new IllegalArgumentException(String.format(UNSUPPORTED_PARAMETER, param.toString()));
			}
		}
		drawInternText(text, x, y, style, transform);
		return this;
	}

	/**
	 * Draws a text.
	 * 
	 * @param text
	 *            The text.
	 * @param x
	 *            The x coordinate.
	 * @param y
	 *            The y coordinate.
	 * @param style
	 *            The optional custom style.
	 * @param transform
	 *            The optional transformation.
	 */
	protected abstract void drawInternText(String text, double x, double y, Optional<TextStyleable> style,
			Optional<AffineTransform> transform);

	@Override
	public final Drawable draw(Path imagePath, double x, double y, Object... optionalParams) {
		Optional<AffineTransform> transform = Optional.empty();
		Optional<ImageStyleable> style = Optional.empty();
		for (Object param : optionalParams) {
			if (param instanceof AffineTransform) {
				transform = Optional.of((AffineTransform) param);
			} else if (param instanceof ImageStyleable) {
				style = Optional.of((ImageStyleable) param);
			} else {
				throw new IllegalArgumentException(String.format(UNSUPPORTED_PARAMETER, param.toString()));
			}
		}
		drawInternImage(imagePath, x, y, style, transform);

		return this;
	}

	/**
	 * Draws an image.
	 * 
	 * @param imagePath
	 *            The path to the image.
	 * @param x
	 *            The x coordinate.
	 * @param y
	 *            The y coordinate.
	 * @param style
	 *            The optional style.
	 * @param transform
	 *            The optional transformation.
	 */
	protected abstract void drawInternImage(Path imagePath, double x, double y, Optional<ImageStyleable> style,
			Optional<AffineTransform> transform);

	@Override
	public final Drawable draw(Shape line, Object... optionalParams) {
		if (GeomUtil.isArea(line)) {
			return draw(new Area(line), optionalParams);
		} else {
			Optional<AffineTransform> transform = Optional.empty();
			Optional<LineStyleable> style = Optional.empty();
			if (optionalParams != null) {
				for (Object param : optionalParams) {
					if (param instanceof AffineTransform) {
						transform = Optional.of((AffineTransform) param);
					} else if (param instanceof LineStyleable) {
						style = Optional.of((LineStyleable) param);
					} else {
						throw new IllegalArgumentException(String.format("Unsupported parameter %s ", param));
					}
				}
			}
			drawInternLine(line, style, transform);
			return this;
		}
	}

	@Override
	public final Drawable draw(Shape line, double x, double y, Object... optionalParams) {
		if (GeomUtil.isArea(line)) {
			return draw(new Area(line), x, y, optionalParams);
		} else {
			return draw(line, addTranslation2OptionalParams(x, y, optionalParams));
		}
	}

	/**
	 * Draws a line.
	 * 
	 * @param line
	 *            The line.
	 * @param style
	 *            The optional custom style.
	 * @param transform
	 *            The optional transformation.
	 */
	protected abstract void drawInternLine(Shape line, Optional<LineStyleable> style,
			Optional<AffineTransform> transform);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Drawable draw(Area area, Object... optionalParams) {
		Optional<AffineTransform> transform = Optional.empty();
		Optional<AreaStyleable> style = Optional.empty();
		for (Object param : optionalParams) {
			if (param instanceof AffineTransform) {
				transform = Optional.of((AffineTransform) param);
			} else if (param instanceof AreaStyleable) {
				style = Optional.of((AreaStyleable) param);
			} else {
				throw new IllegalArgumentException(String.format(UNSUPPORTED_PARAMETER, param.toString()));
			}
		}
		drawInternArea(area, style, transform);
		return this;
	}

	@Override
	public final Drawable draw(Area area, double x, double y, Object... optionalParams) {
		return draw(area, addTranslation2OptionalParams(x, y, optionalParams));
	}

	Object[] addTranslation2OptionalParams(double translateX, double translateY, Object[] optionalParams) {
		AffineTransform transform = new AffineTransform(0, 0, 0, 0, translateX, translateY);
		if (optionalParams == null) {
			return new Object[] { transform };
		} else {
			boolean containsTransform = false;
			for (int i = 0; i < optionalParams.length; i++) {
				if (optionalParams[i] instanceof AffineTransform) {
					transform.concatenate((AffineTransform) optionalParams[i]);
					optionalParams[i] = transform;
					containsTransform = true;
				}
			}
			if (!containsTransform) {
				optionalParams = Arrays.copyOf(optionalParams, optionalParams.length + 1);
				optionalParams[optionalParams.length - 1] = transform;
			}
			return optionalParams;
		}
	}

	/**
	 * Draws an area.
	 * 
	 * @param area
	 *            The area.
	 * @param style
	 *            The optional custom style.
	 * @param transform
	 *            The optional transformation.
	 */
	protected abstract void drawInternArea(Shape area, Optional<AreaStyleable> style,
			Optional<AffineTransform> transform);

	@SuppressWarnings("unchecked")
	@Override
	public final Drawable draw(double x, double y, Object... optionalParams) {
		Optional<AffineTransform> transform = Optional.empty();
		Optional<List<Optional<Styleable>>> style = Optional.empty();
		for (Object param : optionalParams) {
			if (param instanceof AffineTransform) {
				transform = Optional.of((AffineTransform) param);
			} else if (param instanceof Styleable) {
				style = Optional.of(Arrays.asList(Optional.of((Styleable) param)));
			} else if (param instanceof List) {
				style = Optional.of((List<Optional<Styleable>>) param);
			} else {
				throw new IllegalArgumentException(String.format(UNSUPPORTED_PARAMETER, param.toString()));
			}
		}
		drawInternPoint(x, y, style, transform);
		return this;
	}

	/**
	 * Draws a point symbol.
	 * 
	 * @param x
	 *            The x coordinate.
	 * @param y
	 *            The y coordinate.
	 * @param style
	 *            The optional custom style.
	 * @param transform
	 *            The optional transformation.
	 */
	protected abstract void drawInternPoint(double x, double y, Optional<List<Optional<Styleable>>> style,
			Optional<AffineTransform> transform);

	/**
	 * {@inheritDoc}
	 */
	public void accept(Object symbol, double x, double y, Object... params) {
		if (symbol instanceof Area) {
			draw((Area) symbol, x, y, params);
		} else if (symbol instanceof Shape) {
			draw((Shape) symbol, x, y, params);
		} else if (symbol instanceof String) {
			draw((String) symbol, x, y, params);
		} else if (symbol instanceof Path) {
			draw((Path) symbol, x, y, params);
		} else {
			throw new IllegalArgumentException("Unsupported symbol " + symbol);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void accept(Symbolizeable... symbol) {
		style(symbol);
	}

	/**
	 * {@inheritDoc}
	 */
	public void accept(Styleable defaultStyle) {
		if (defaultStyle instanceof LineStyleable) {
			style((LineStyleable) defaultStyle);
		} else if (defaultStyle instanceof AreaStyleable) {
			style((AreaStyleable) defaultStyle);
		} else if (defaultStyle instanceof TextStyleable) {
			style((TextStyleable) defaultStyle);
		} else if (defaultStyle instanceof ImageStyleable) {
			style((ImageStyleable) defaultStyle);
		} else {
			throw new IllegalArgumentException("Unsupported style " + defaultStyle);
		}
	}

}
