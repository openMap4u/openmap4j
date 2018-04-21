package org.openmap4j.builder.geom;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

import org.junit.jupiter.api.Test;
import org.openmap4j.builder.geom.GeomBuilderFactory;
import org.openmap4j.builder.geom.GeomUtil;

class GeomUtilTest {

	@Test
	void testIsArea_Line() {
		Path2D path = new Path2D.Double();
		path.moveTo(20, 12);
		path.lineTo(34, 56);
		assertFalse(GeomUtil.isArea(path));
	}
	
	 
	
	@Test
	void testIsArea_Rectangle2D() {
		assertTrue(GeomUtil.isArea(new Rectangle2D.Double(10,20,30,40)));
	}
	
	@Test
	void testIsArea_StartIsEndpoint() {
		Path2D path = new Path2D.Double();
		path.moveTo(0, 0);
		path.lineTo(20, 0);
		path.lineTo(10, 10);
		path.lineTo(0,0);
		assertTrue(GeomUtil.isArea(path));
	}
	
	@Test
	void testIsArea_ClosesLine_Parth2D() {
		Path2D path = new Path2D.Double();
		path.moveTo(0, 0);
		path.lineTo(20, 0);
		path.lineTo(10, 10);
		path.closePath();
		assertFalse(GeomUtil.isArea(path));
	}
	
	
	@Test
	void testIsArea_ClosedLine() {
		  Area path = GeomBuilderFactory.getAreaBuilder().moveTo(0, 0).lineTo(20, 0).lineTo(10, 10).close().build();
	 		assertTrue(GeomUtil.isArea(path));
	}
	
	@Test
	void testIsArea_NotClosedLine() {
		  Area path = GeomBuilderFactory.getAreaBuilder().moveTo(0, 0).lineTo(20, 0).lineTo(10, 10).build();
	 		assertTrue(GeomUtil.isArea(path));
	}

}
