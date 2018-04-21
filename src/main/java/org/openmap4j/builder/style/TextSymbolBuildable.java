package org.openmap4j.builder.style;

import org.openmap4j.common.NestedBuildable;
import org.openmap4j.style.TextSymbolizeable;

/**
 * Builds a text symbol.
 * @author mh
 *
 * @param <P> The parent type.
 */
public interface TextSymbolBuildable<P> extends NestedBuildable<P,TextSymbolizeable>, SetTextSymbolizeable< TextSymbolBuildable<P>> {

}
