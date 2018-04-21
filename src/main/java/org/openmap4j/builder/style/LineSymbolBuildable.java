package org.openmap4j.builder.style;

import org.openmap4j.builder.geom.LineBuildable;
import org.openmap4j.common.NestedBuildable;
import org.openmap4j.style.LineSymbolizeable;

/**
 * Builds an line symbol.
 * @author mh
 *
 * @param <P> The parent type.
 */
public interface LineSymbolBuildable<P> extends NestedBuildable<P,LineSymbolizeable>, SetLineSymbolizeable<LineSymbolBuildable<P>> {

	LineBuildable< LineSymbolBuildable<P>> line();

	
}
