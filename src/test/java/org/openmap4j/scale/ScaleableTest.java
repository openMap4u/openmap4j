package org.openmap4j.scale;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openmap4j.scale.Scaleable;

class ScaleableTest {

	@Test
	void testEXP() {
		assertEquals(Scaleable.EXP.scale(10.0), Math.exp(10.0));
	}
	
	@Test
	void testLINEAR() {
		assertEquals(Scaleable.LINEAR.scale(10.0), 10.0);
	}
	
	@Test
	void testLOG() {
		assertEquals(Scaleable.LOG.scale(10), Math.log(10));
	}
	
	@Test
	void testLOG10() {
		assertEquals(Scaleable.LOG10.scale(10), Math.log10(10));
	}
	
	@Test
	void testLOG1P() {
		assertEquals(Scaleable.LOG1P.scale(10), Math.log1p(10));
	}
	
	@Test
	void testSQRT() {
		assertEquals(Scaleable.SQRT.scale(10), Math.sqrt(10));
	}

}
