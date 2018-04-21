package org.openmap4j.output;

import java.awt.Shape;

@FunctionalInterface
interface DrawableAtomicConsumer<T extends DrawableAtomicConsumer<T>>  {

	void accept(Shape test, Object ... params);

}
