package org.openmap4j.mock;

import org.apache.commons.math3.random.RandomDataGenerator;
 
public class Data {
	
	private static final RandomDataGenerator randomDataGenerator ;
	
	
	static {
		/* initialize the random generator and enforce that is always initialized the same way. */
		randomDataGenerator = new RandomDataGenerator();
		randomDataGenerator.reSeed(42);
	}
	
	/**
	 * Get gaussian distribution.
	 * @param mu The mu.
	 * @param sigma The sigma
	 * @param count The number of values.
	 * @return The values.
	 */
	public static double [] getGaussian(double mu, double sigma,int count) {
		double [] gaussian = new double[count];
		for (int i=0;i<count;i++) {
			gaussian[i]= randomDataGenerator.nextGaussian(mu,sigma);
		}
		return gaussian;
	}
 
}
