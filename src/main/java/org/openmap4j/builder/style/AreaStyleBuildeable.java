package org.openmap4j.builder.style;

import org.openmap4j.common.NestedBuildable;
import org.openmap4j.style.AreaStyleable;

/**
 * Builds an area style.
 * @author mh
 *
 * @param <P> The parent type.
 */
public interface AreaStyleBuildeable<P> extends NestedBuildable<P,AreaStyleable>, SetAreaStyleable<AreaStyleBuildeable<P>> {

}
