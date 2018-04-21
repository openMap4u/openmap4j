package org.openmap4j.builder.style;

import org.openmap4j.builder.geom.AreaBuildable;
import org.openmap4j.common.NestedBuildable;
import org.openmap4j.style.AreaSymbolizeable;

/**
 * Builds an area symbol.
 * @author mh
 *
 * @param <P> The parent type.
 */
public interface AreaSymbolBuildable<P> extends NestedBuildable<P,AreaSymbolizeable>, SetAreaSymbolizeable<AreaSymbolBuildable<P>> {
	
	AreaBuildable< AreaSymbolBuildable<P>> area();

}
