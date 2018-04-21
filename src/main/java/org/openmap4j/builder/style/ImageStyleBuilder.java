package org.openmap4j.builder.style;

import org.openmap4j.common.NestedBuilder;
import org.openmap4j.style.ImageStyleable;

class ImageStyleBuilder<P> extends NestedBuilder<P,ImageStyleable> implements ImageStyleBuildable<P> {

	public ImageStyleBuilder() {
		super();
	}

	public ImageStyleBuilder(P parent, String parentMethodName) {
		super(parent, parentMethodName);
	}

	private ImageStyle imageStyle = new ImageStyle();

	@Override
	public ImageStyleBuildable<P> alpha(double alpha) {
		this.imageStyle.alpha(alpha);
		return this;
	}

	@Override
	public ImageStyleBuildable<P> visible(boolean visible) {
		this.imageStyle.visible(visible);
		return this;
	}

	@Override
	protected ImageStyleable buildNested() {
 		return imageStyle;
	}
	 
 







	

}
