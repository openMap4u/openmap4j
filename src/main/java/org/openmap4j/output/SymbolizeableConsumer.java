package org.openmap4j.output;

import org.openmap4j.style.Symbolizeable;

@FunctionalInterface
interface SymbolizeableConsumer<T extends SymbolizeableConsumer<T>> {
	
	/**
	 * A poinCanvas is visualized with one or more symbols (e.g.
	 * {@link org.openmap4j.style.LineSymbolizeable},{@link org.openmap4j.style.AreaSymbolizeable},
	 * {@link org.openmap4j.style.ImageSymbolizeable},
	 * {@link org.openmap4j.style.TextSymbolizeable}).
	 * @param symbols
	 *            Or more symbols to display a point.
	 */
	void accept(Symbolizeable ... symbol);

}
