package org.openmap4j.output;

import java.awt.geom.AffineTransform;
import java.util.Optional;

public class Parameters<S> implements Paramatrizeable<S> {
	
	private Optional<AffineTransform> transform = Optional.empty();

	private Optional<S> style = Optional.empty();

	
	@Override
	public Optional<AffineTransform> getTransform() {
		return this.transform;
	}

	@Override
	public Optional<S> getStyle() {
		return this.style;
	}

	@Override
	public void setStyle(S style) {
		this.style= Optional.of(style);
		
	}

	@Override
	public void setTransform(AffineTransform transform) {
	this.transform= Optional.of(transform);
		
	}

}
