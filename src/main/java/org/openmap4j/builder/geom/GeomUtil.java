package org.openmap4j.builder.geom;

import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.PathIterator;
import java.util.Arrays;

public class GeomUtil {

	public static boolean isArea(Shape shape) {
		if (shape instanceof Area)	{
			return true;
		} else {
			return isArea(shape.getPathIterator(null));
		}
	}

	public static boolean isArea(Area shape) {
		return true;
	}

	public static boolean isArea(PathIterator shape) {
		double[] startCoords = new double[6];
		double[] coords = new double[6];
		while (!shape.isDone()) {
			int type = shape.currentSegment(coords);
			if (type == PathIterator.SEG_MOVETO  ) {
				shape.currentSegment(startCoords);
			}
			shape.next();			
		}
		return Arrays.equals(startCoords,coords);

	}

}
