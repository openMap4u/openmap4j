package org.openmap4j.output;

import org.openmap4j.style.Styleable;

/**
 * Sets the default style for a line, area, image, text.
 * @author hadrbolec
 * 
 * @param <T>
 */
@FunctionalInterface
interface StyleableConsumer<T extends StyleableConsumer<T>>    {
	
	/**
	 * Sets the current default style for line, area, image and or text.
	 * @param style The default style
	 */
	void accept(Styleable defaultStyle) ;



}
