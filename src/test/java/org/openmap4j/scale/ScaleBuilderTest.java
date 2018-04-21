package org.openmap4j.scale;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openmap4j.scale.ScaleBuilder;
import org.openmap4j.scale.Scaleable;

class ScaleBuilderTest {
	
 	
	@BeforeEach
	void beforeEach() {
	 
	}

	@ParameterizedTest
	@CsvSource({  "0.0, 0.0", "25.0, 50.0", "100.0, 100.0" })
	@DisplayName("normalize clamp=false")
	void testDoubleDoubleSqrt(Double inputValue, Double outputValue) {
		Function<Double,Double> scale =  new ScaleBuilder<Double,Double>().from(0d,100d).scale(Scaleable.SQRT).to(0d,100d).build();
		assertEquals(scale.apply(inputValue),outputValue);
	  
	}
	
	
	@ParameterizedTest
	@CsvSource({  "10.0, 100.0", "15.0, 150.0", "16.0, 160.0", "20.0, 200.0"  })
	@DisplayName("normalize clamp=false")
	void testDoubleDoubleScale(Double inputValue, Double outputValue) {
		Function<Double,Double> scale =  new ScaleBuilder<Double,Double>().from(10d,20d).to(100d,200d).build();
		assertEquals(scale.apply(inputValue),outputValue);
	  
	}

}
