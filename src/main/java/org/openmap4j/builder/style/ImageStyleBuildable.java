package org.openmap4j.builder.style;

import org.openmap4j.common.NestedBuildable;
import org.openmap4j.style.ImageStyleable;
/**
 * Builds an image style.
 * @author mh
 *
 * @param <P> The parent type
 */
public interface ImageStyleBuildable<P> extends NestedBuildable<P,ImageStyleable>, SetImageStyleable<ImageStyleBuildable<P>> {

}
