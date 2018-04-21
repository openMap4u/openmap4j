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
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

import org.openmap4j.output.Canvas;
import org.openmap4j.style.AreaStyleable;
import org.openmap4j.style.ImageStyleable;
import org.openmap4j.style.LineStyleable;
import org.openmap4j.style.Styleable;
import org.openmap4j.style.TextStyleable;

public class SvgCanvasPlugin extends Canvas  {

	private static final Logger LOGGER = Logger.getLogger(SvgCanvasPlugin.class.getName());

	/**
	 * Stores the temp file.
	 */
	private File tempSvgFile = null;
	
	private SvgBuilder svgBuilder = null;

	public SvgCanvasPlugin(double width, double height) {
		super(width, height);
	}

	public SvgCanvasPlugin(Shape canvasArea) {
		super(canvasArea);
		init();
	}

	void init() {
		try {
			tempSvgFile = File.createTempFile(UUID.randomUUID().toString(), "xml");
			svgBuilder = new SvgBuilder(XMLOutputFactory.newInstance()
					.createXMLStreamWriter(new FileOutputStream(this.tempSvgFile), SvgBuilder.UTF8));
			svgBuilder.writeStartDocument();
			svgBuilder.writeSvgStartElement(getDrawingArea(), SvgBuilder.DEFAULT_DRAWING_UNITS);
		} catch (XMLStreamException | FactoryConfigurationError | IOException e) {
			LOGGER.log(Level.SEVERE,"Unable to create temp svg file ",e);
		}
	}

	@Override
	protected void drawInternText(String text, double x, double y, Optional<TextStyleable> style,
			Optional<AffineTransform> transform) {
		this.svgBuilder.drawText(getTextStyle(), text,x,y, style, transform);	}

	@Override
	protected void drawInternImage(Path imagePath, double x, double y, Optional<ImageStyleable> style,
			Optional<AffineTransform> transform) {
		this.svgBuilder.drawImage(getImageStyle(), imagePath,x,y, style, transform);
	}

	@Override
	protected void drawInternLine(Shape line, Optional<LineStyleable> style, Optional<AffineTransform> transform) {
		this.svgBuilder.drawLine(getLineStyle(), line, style, transform);
	}

	@Override
	protected void drawInternArea(Shape area, Optional<AreaStyleable> style, Optional<AffineTransform> transform) {
		this.svgBuilder.drawArea(getAreaStyle(), area, style, transform);
	}

	@Override
	protected void drawInternPoint(double x, double y, Optional<List<Optional<Styleable>>> style, Optional<AffineTransform> transform) {
		this.svgBuilder.drawPoint(this.getPointStyle(), x, y,   style, transform);
	}

	@Override
	public void write(Writer outputWriter) throws IOException {
		try {
			svgBuilder.writeEndDocument();
			/* Stream the file to thegiven output stream */
			copyCompletely(new FileReader(this.tempSvgFile), outputWriter);
		} finally {
			cleanup();
		}
	}

	/**
	 * Utility to copy the temp file.
	 * 
	 * @param input
	 *            The input reader.
	 * @param output
	 *            The output writer.
	 * @throws IOException
	 *             Is thrown in the case an error occurs.
	 */
	void copyCompletely(Reader input, Writer output) throws IOException {
		char[] buf = new char[1024];
		while (true) {
			int length = input.read(buf);
			if (length < 0)
				break;
			output.write(buf, 0, length);
		}

		try {
			input.close();
		} catch (IOException ignore) {
		}
		try {
			output.close();
		} catch (IOException ignore) {
		}
	}

	void cleanup() {
		if (tempSvgFile.exists()) {
			tempSvgFile.delete();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		cleanup();
	}

}
