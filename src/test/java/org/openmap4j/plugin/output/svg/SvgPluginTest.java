/**
 * openmap4u-core - Parent pom providing dependency and plugin management for applications
		built with Maven
 * Copyright © ${project.inceptionYear} Michael Hadrbolec (openmap4u@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.openmap4j.mock.MockData.DEFAULT_CANVAS;
import static org.openmap4j.mock.MockData.DEFAULT_CANVAS_HEIGHT;
import static org.openmap4j.mock.MockData.DEFAULT_CANVAS_WIDTH;
import static org.openmap4j.mock.MockData.DEFAULT_RASTER;
import static org.openmap4j.mock.MockData.rangeLine;
import static org.openmap4j.mock.MockData.rangePoint;
import static org.openmap4j.mock.MockData.rangeShape;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openmap4j.AbstractTest;
import org.openmap4j.builder.style.StyleBuilderFactory;
import org.openmap4j.plugin.output.svg.SvgCanvasPlugin;
import org.openmap4j.style.Strokeable.STROKE_CAP;

 
public class SvgPluginTest extends AbstractTest {

    private SvgCanvasPlugin svg = null;

    private Stream<Point2D> points = null;

    protected Writer writer = null;

    @BeforeEach
    public void before() {
        try {
            writer = new FileWriter(new File("SvgPuginTest.svg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        svg = new SvgCanvasPlugin(DEFAULT_CANVAS);
        svg.style(StyleBuilderFactory.getLineStyleBuilder().strokeColor(Color.LIGHT_GRAY).strokeWidth(.5).alpha(.5).build());
        svg.draw(DEFAULT_RASTER);
    }

    @Test
    public void test() throws IOException {
        svg.write(writer);
        assumeTrue(writer.toString().contains("svg"));
    }

    @Test
    public void testLine() throws IOException {
       rangeLine(DEFAULT_CANVAS_WIDTH,DEFAULT_CANVAS_HEIGHT, 1, 1).forEach(line -> svg.draw(line, StyleBuilderFactory.getLineStyleBuilder().strokeColor(Color.BLACK).strokeWidth(.3).strokeCap(STROKE_CAP.round).build()));
        svg.write(writer);
        System.out.println(writer.toString());
    }

    @Test
    public void testShape() throws IOException {
      rangeShape(2, 19, 1, 1).forEach(shape -> svg.draw(shape, StyleBuilderFactory.getAreaStyleBuilder().strokeColor(Color.BLACK).strokeWidth(.03).strokeCap(STROKE_CAP.round).fill(Color.LIGHT_GRAY).build()));
        svg.write(writer);
        System.out.println(writer.toString());
    }

    @Test
    public void testPoint() throws IOException {
        svg.style(StyleBuilderFactory.getAreaSymbolBuilder().area(new Rectangle2D.Double(-.2, -.2, .4, .4)).strokeColor(Color.RED).strokeWidth(.1).fill(Color.green).alpha(.5).build());
       rangePoint(2, 19, 1, 1).forEach(point -> svg.draw(point.getX(),point.getY()));
        svg.write(writer);
        System.out.println(writer.toString());
    }

}
