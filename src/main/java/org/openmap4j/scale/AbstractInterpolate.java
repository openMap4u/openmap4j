package org.openmap4j.scale;

import org.openmap4j.common.Plugable;

/**
 * All implementations of the interpolateable interface are derived from this base class.
 * @author hadrbolec
 *
 * @param <T> The type to interpolate between.
 */
public abstract class AbstractInterpolate<T> implements Interpolateable<T>, Plugable {

	private T from;
	private T to;
	private double[] internalFrom;
	private double[] internalTo;
	private double[] vector;
	private int vectorSize = 0;
	private boolean clamp=false;
	private Scaleable scale= Scaleable.LINEAR;

	 

	double[] scale(double[] value) {
		double[] result = new double[this.vectorSize];
		for (int i = 0; i < this.vectorSize; i++) {
			result[i] = scale.scale(value[i]);
		}
		return result;
	}

	public double normalize(T value2Normalize) {
		double result = project(scaleVector(vectorize(value2Normalize),this.scale), this.internalFrom, this.internalTo);
		if (clamp && result <= 0.0) {
			return 0;
		} else if (clamp && result >= 1.0) {
			return 1.0;
		} else {
			return result;
		}

	}

	public T denormalize(double value) {
		if (clamp && value <= 0.0) {
			return this.from;
		} else if (clamp && value >= 1) {
			return this.to;
		} else {
			return devectorize(lerp(value, this.internalFrom, this.internalTo));
		}
	}

	static double magnitude(double[] value) {
		double tmpResult = 0;
		for (int i = 0; i < value.length; i++) {
			tmpResult = tmpResult + Math.pow(value[i], 2);
		}
		return Math.sqrt(tmpResult);
	}

	static double[] multiply(double factor, double[] value) {
		double[] result = new double[value.length];
		for (int i = 0; i < value.length; i++) {
			result[i] = factor * value[i];
		}
		return result;
	}

	static double[] add(double[] a, double[] b) {
		double[] result = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			result[i] = a[i] + b[i];
		}
		return result;
	}

	static double[] subtract(double[] a, double[] b) {
		double[] result = new double[a.length];
		for (int i = 0; i < a.length; i++) {
			result[i] = a[i] - b[i];
		}
		return result;
	}

	static double[] lerp(double t, double[] a, double[] b) {
		return add(multiply(1.0 - t, a), multiply(t, b));
	}

	static double dot(double[] a, double[] b) {
		double result = 0;
		for (int i = 0; i < a.length; i++) {
			result = result + a[i] * b[i];
		}
		return result;
	}
	
	static double[] scaleVector(double [] vector, Scaleable scale) {
		double[] scaled = new double[vector.length];
		for(int i=0;i<vector.length;i++) {
			scaled[i]=scale.scale(vector[i]);
		}
		return scaled;
	}

	static double project(double[] c, double[] a, double[] b) {
		double dA = magnitude(subtract(c, b));
		double dB = magnitude(subtract(c, a));
		double dC = magnitude(subtract(b, a));
		double alpha = Math.acos((dB * dB + dC * dC - dA * dA) / (2 * dB * dC));
		if (Double.isNaN(alpha)) {
			return 0;
		} else {
			return dB * Math.cos(alpha) / dC;
		}
	}

	/**
	 * Converts the value into a vector.
	 * 
	 * @return The vector representation.
	 */
	protected abstract double[] vectorize(T value);

	/**
	 * Converts the vector representation back into a value.
	 * 
	 * @param value
	 *            The vector to convert
	 * @return The value.
	 */
	protected abstract T devectorize(double[] vector);

	public AbstractInterpolate<T> clamp(boolean clamp) {
		this.clamp = clamp;
		return this;
	}

	public AbstractInterpolate<T> scale(Scaleable scale) {
		this.scale = scale;
		this.internalFrom = scaleVector(vectorize(from),this.scale);
		this.internalTo = scaleVector(vectorize(to),this.scale);
		this.vectorSize = this.internalFrom.length;
		this.vector = new double[this.internalFrom.length];
		for (int i = 0; i < this.vectorSize; i++) {
			this.vector[i] = (this.internalTo[i] - this.internalFrom[i]);
		}
		return this;
	}

	public AbstractInterpolate<T> range(T fromValue, T toValue) {
		this.from = fromValue;
		this.to=toValue;
		return this;
	}

	
	 

}
