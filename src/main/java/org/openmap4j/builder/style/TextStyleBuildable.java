package org.openmap4j.builder.style;

import org.openmap4j.common.NestedBuildable;
import org.openmap4j.style.TextStyleable;

/**
 * Builds a text style.
 * @author mh
 *
 * @param <P> The parent type
 */
public interface TextStyleBuildable<P> extends NestedBuildable<P,TextStyleable>, SetTextStyleable<TextStyleBuildable<P>> {

}
