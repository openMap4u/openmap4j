package org.openmap4j.common;

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

import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

 
public class Base64Image {
	
	private static final Logger LOGGER = Logger.getLogger(Base64Image.class.getName());
	
	private Base64Image() {}
	
	public static String encoder(Path imagePath) {
		StringBuilder base64Image = new StringBuilder("data:image/").append("png").append(";base64,");
		try (InputStream in = Files.newInputStream(imagePath)) {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			for(int b = in.read(); b > -1; b = in.read()) {
			  out.write(b);
			}
			base64Image.append(Base64.getEncoder().encodeToString(out.toByteArray()));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE,"Unable to encode image ",e);
        }
 		return base64Image.toString();
	}
	
 
	
	public static RenderedImage read(Path imagePath) throws IOException {
		return ImageIO.read( Files.newInputStream(imagePath));
	}
	
	public static String imgToBase64String(final RenderedImage img, final String formatName) {
	    final ByteArrayOutputStream os = new ByteArrayOutputStream();
	    try {
	        ImageIO.write(img, formatName, Base64.getEncoder().wrap(os));
	        return new StringBuilder("data:image/").append(formatName).append(";base64,").append(os.toString(StandardCharsets.UTF_8.name())).toString();
	    } catch (final IOException ioe) {
	        throw new UncheckedIOException(ioe);
	    }
	}

}
