package org.openmap4j.plugin.interpolate;

import org.openmap4j.scale.AbstractInterpolate;

/**
 * Interpolates between floats.
 * 
 * @author hadrbolec
 *
 */
public class InterpolateFloat extends AbstractInterpolate<Float> {

 
 

	@Override
	protected	double[] vectorize(Float value) {
		return new double[] {value};
	}

	@Override
	protected Float devectorize(double[] vector) {
		return (float)vector[0];
	}

	@Override
	public boolean canInterpolate(Object object) {
		 		return object!=null && object instanceof Float;
		}	 

}
