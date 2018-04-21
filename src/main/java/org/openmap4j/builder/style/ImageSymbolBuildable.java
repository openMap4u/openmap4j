package org.openmap4j.builder.style;

import org.openmap4j.common.NestedBuildable;
import org.openmap4j.style.ImageSymbolizeable;

/**
 * Builds an image symbol.
 * @author mh
 *
 * @param <P> The parent type.
 */
public interface ImageSymbolBuildable<P> extends NestedBuildable<P,ImageSymbolizeable>, SetImageSymbolizeable<ImageSymbolBuildable<P>> {

}
