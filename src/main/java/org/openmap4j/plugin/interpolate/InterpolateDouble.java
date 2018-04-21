package org.openmap4j.plugin.interpolate;

import org.openmap4j.scale.AbstractInterpolate;

/**
 * Interpolates between doubles.
 * 
 * @author hadrbolec
 *
 */
public class InterpolateDouble extends AbstractInterpolate<Double> {

	
	 
	 

	@Override
	protected double[] vectorize(Double value) {
		return new double[] {value};
	}

	@Override
	protected Double devectorize(double[] vector) {
		return vector[0];
	}
	
	@Override
	public boolean canInterpolate(Object object) {
		return object!=null && object instanceof Double;
	}

}
