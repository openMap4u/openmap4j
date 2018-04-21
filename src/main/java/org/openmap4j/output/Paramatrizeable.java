package org.openmap4j.output;

import java.awt.geom.AffineTransform;
import java.util.Optional;

public interface Paramatrizeable<S> {
	
	Optional<AffineTransform> getTransform();
	
	Optional<S> getStyle();
	
	void setStyle(S style);
	
	void setTransform(AffineTransform transfrom);
	
	

}
