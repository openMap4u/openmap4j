package org.openmap4j.output;

@FunctionalInterface
 interface DrawableSymbolConsumer<T extends DrawableSymbolConsumer<T>>    {
	
	void accept(Object symbol, double x, double y, Object ... params);

}
