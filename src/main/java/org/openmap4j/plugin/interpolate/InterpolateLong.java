package org.openmap4j.plugin.interpolate;

import org.openmap4j.scale.AbstractInterpolate;

/**
 * Interpolates between long.
 * @author hadrbolec
 *
 */
public class InterpolateLong extends AbstractInterpolate<Long> {

	 

	 

	@Override
	protected double[] vectorize(Long value) {
		return new double[] {value};
	}

	@Override
	protected Long devectorize(double[] vector) {
		return (long)vector[0];
	}

	@Override
	public boolean canInterpolate(Object object) {
		return  object!=null && object instanceof Long;
	}

}
