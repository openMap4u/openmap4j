package org.openmap4j.scale;

/**
 * Interpolates between the given type.
 * 
 * @author hadrbolec
 *
 * @param <T> The type to interpolate between.
 */
public interface Interpolateable<T>   {

	/**
	 * Sets the interpolation range.
	 * 
	 * @param fromValue
	 *            From value.
	 * @param toValue
	 *            To value.
	 * @return The fluent builder pattern.
	 */
	Interpolateable<T> range(T fromValue, T toValue);

	Interpolateable<T> scale(Scaleable scale);
	
	Interpolateable<T> clamp(boolean clamp);
	
    boolean canInterpolate(Object object);

	double normalize(T value2Normalize);

	T denormalize(double value);

}
