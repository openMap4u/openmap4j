package org.openmap4j.scale;

/**
 * Scales a double.
 * @author hadrbolec
 *
 */
@FunctionalInterface
public interface Scaleable {
	
	
	/**
	 * Scales exponential.
	 */
	Scaleable EXP= Math::exp;
	/**
	 * Scales linear (= Default).
	 */
	Scaleable LINEAR = s -> s;
	/**
	 * Scales log.
	 */
	Scaleable LOG = Math::log;
	/**
	 * scales log10
	 */
	Scaleable LOG10 = Math::log10;
	/**
	 * scales log1p.
	 */
	Scaleable LOG1P = Math::log1p;
	/**
	 * scales sqrt.
	 */
	Scaleable SQRT = Math::sqrt;
	
	
	/**
	 * The default scale (is linear).
	 */
	Scaleable DEFAULT=LINEAR;


	/**
	 * Scales a value with the given function.
	 * @param value2Scale The value to scale.
	 * @return The scaled value.
	 */
	double scale(double value2Scale);

}
