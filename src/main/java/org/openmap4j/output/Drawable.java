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

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import org.openmap4j.common.Plugable;
import org.openmap4j.style.AreaStyleable;
import org.openmap4j.style.ImageStyleable;
import org.openmap4j.style.LineStyleable;
import org.openmap4j.style.Styleable;
import org.openmap4j.style.Symbolizeable;
import org.openmap4j.style.TextStyleable;
import org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean;

/**
 * The canvas to draw on.
 * 
 * @author hadrbolec
 *
 */
interface Drawable extends Plugable, StyleableConsumer<Drawable>, SymbolizeableConsumer<Drawable>,
		DrawableSymbolConsumer<Drawable> {

	String UNSUPPORTED_PARAMETER = "Unsupported parameter {%s} ";

	/**
	 * Draw a point.
	 * 
	 * @param x
	 *            The x coordinate.
	 * @param y
	 *            The y coordinate.
	 * @param otionalParams
	 *            The optional parameters (like Symbol [either for a single symbol
	 *            or a List for multiple], AffineStransformation, ...).
	 * @return The fluent builder pattern.
	 */
	Drawable draw(double x, double y, Object... otionalParams);

	/**
	 * Draws a line.
	 * 
	 * @param line
	 *            The line to draw.
	 * @param otionalParams
	 *            The optional parameters.
	 * @return The fluent builder pattern.
	 */
	Drawable draw(Shape line, Object... otionalParams);

	/**
	 * Draws an area.
	 * 
	 * @param area
	 *            The area to draw.
	 * @param optionalParams
	 *            The optional parameters.
	 * @return Fluent builder pattern.
	 */
	Drawable draw(Area area, Object... optionalParams);

	void write(Writer out) throws IOException;

	/**
	 * A poinCanvas is visualized with one or more symbols (e.g.
	 * {@link org.openmap4j.style.LineSymbolizeable},{@link org.openmap4j.style.AreaSymbolizeable},
	 * {@link org.openmap4j.style.ImageSymbolizeable},
	 * {@link org.openmap4j.style.TextSymbolizeable}).
	 * 
	 * @param symbols
	 *            Or more symbols to display a point.
	 * @return The fluenCanvas builder.
	 */
	Drawable style(Symbolizeable... symbols);

	/**
	 * Sets the area style.
	 * 
	 * @param areaStyle
	 *            The area style.
	 * @return FluenCanvas builder pattern.
	 */
	Drawable style(AreaStyleable areaStyle);

	/**
	 * Sets the image style.
	 * 
	 * @param imageStyle
	 *            The image style.
	 * @return FluenCanvas builder pattern.
	 */
	Drawable style(ImageStyleable imageStyle);

	/**
	 * Sets the line style.
	 * 
	 * @param lineStyle
	 *            The line style.
	 * @return FluenCanvas builder pattern.
	 */
	Drawable style(LineStyleable lineStyle);

	/**
	 * Sets the texCanvas style.
	 * 
	 * @param textStyle
	 *            The texCanvas style.
	 * @return FluenCanvas builder pattern.
	 */
	Drawable style(TextStyleable textStyle);

	Drawable draw(Area area, double x, double y, Object... optionalParams);

	Drawable draw(Path image, double x, double y, Object... optionalParams);

	Drawable draw(Shape line, double x, double y, Object... optionalParams);

	Drawable draw(String text, double x, double y, Object... optionalParams);

	/**
	 * Parses the optional parameters.
	 * @param type The type of the style.
	 * @param optionalParams The optional parameters to be parsed.
	 * @return The result in an way that it can be easily processed further.
	 */
	default <S extends Styleable> Optional<Paramatrizeable<S>> parse(Class<S> type, Object... optionalParams) {
		if (  optionalParams.length==0) {
			return Optional.empty();
		} else {
			Parameters<S> params = new Parameters<>();
			for (Object param : optionalParams) {
				if (param instanceof AffineTransform) {
					params.setTransform((AffineTransform) param);
				} else if (param instanceof Styleable) {
					params.setStyle(((S) param));
				} else {
					throw new IllegalArgumentException(String.format(UNSUPPORTED_PARAMETER, param.toString()));
				}
			}
			return Optional.of(params);
		}
	}

	default Optional<Paramatrizeable<List<Symbolizeable>>> parse(double x, double y, Object... optionalParams) {
		return null;
	}

}
