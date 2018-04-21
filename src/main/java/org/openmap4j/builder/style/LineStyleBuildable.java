package org.openmap4j.builder.style;

import org.openmap4j.common.NestedBuildable;
import org.openmap4j.style.LineStyleable;

/**
 * Builds an image style.
 * @author mh
 *
 * @param <P> The parent type.
 */
public interface LineStyleBuildable<P> extends NestedBuildable<P,LineStyleable>, SetLineStyleable<LineStyleBuildable<P>> {
 
} 
