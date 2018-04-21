package org.openmap4j.scale;

import java.util.ServiceLoader;
import java.util.function.Function;

/**
 * The implementation of the scale buildable interfaces.
 * 
 * @author hadrbolec
 *
 * @param <I> The input type.
 * @param <O> The output type.
 */
public class ScaleBuilder<I, O> implements ScaleBuildable<I, O> {

	private I fromInput;
	private I toInput;
	private O fromOutput;
	private O toOutput;

	private boolean clamp = false;

	/**
	 * The default scaling method is linear.
	 */
	private Scaleable scale = Scaleable.LINEAR;


	@SuppressWarnings("rawtypes")
	private static ServiceLoader<Interpolateable> serviceLoader = ServiceLoader.load(Interpolateable.class);

	@SuppressWarnings("unchecked")
	protected <T> Interpolateable<T> getInstance(T value) {
		for (@SuppressWarnings("rawtypes") Interpolateable interpolate : serviceLoader) {
			System.out.println( interpolate);
			if (interpolate.canInterpolate(value)) {
				try {
					return (Interpolateable<T>) interpolate.getClass().newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		throw new IllegalArgumentException(String.format("Unsupported data type %s", value));
	}

	/**
	 * Return a function, that interpolates between the given input and output type.
	 */
	@Override
	public Function<I, O> build() {

		Interpolateable<I> interpolateFrom = getInstance(this.fromInput).range(this.fromInput, this.toInput)
				.scale(this.scale).clamp(this.clamp);
		Interpolateable<O> interpolateTo = getInstance(this.fromOutput).range(this.fromOutput, this.toOutput)
				.scale(Scaleable.LINEAR);

		return new Function<I, O>() {

			@Override
			public O apply(I value) {
				System.out.println("normalize " + interpolateFrom.normalize(value));
				System.out.println("denormalize " + interpolateTo.denormalize(interpolateFrom.normalize(value)));
				return interpolateTo.denormalize(interpolateFrom.normalize(value));
			}
		};
	}

	@Override
	public ScaleBuildable<I, O> scale(Scaleable scale) {
		this.scale = scale;
		return this;
	}

	@Override
	public ScaleBuildable<I, O> clamp(boolean clamp) {
		this.clamp = clamp;
		return this;
	}

	public ScaleBuildable<I, O> from(I fromValue, I toValue) {
		this.fromInput = fromValue;
		this.toInput = toValue;
		return this;
	}

	public ScaleBuildable<I, O> to(O fromValue, O toValue) {
		this.fromOutput = fromValue;
		this.toOutput = toValue;
		return this;
	}

}
