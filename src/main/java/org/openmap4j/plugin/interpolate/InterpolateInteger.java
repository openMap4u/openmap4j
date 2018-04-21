package org.openmap4j.plugin.interpolate;

import org.openmap4j.scale.AbstractInterpolate;

/**
  * Interpolates between integers.
  * 
 * @author hadrbolec
 *
 */
public class InterpolateInteger extends AbstractInterpolate<Integer> {

 

	 

	@Override
	protected double[] vectorize(Integer value) {
		return new double[] {value};
	}

	@Override
	protected Integer devectorize(double[] vector) {
		return (int)vector[0];
	}
	
	@Override
	public boolean canInterpolate(Object object) {
		return  object!=null && object instanceof Integer;
	}

}
