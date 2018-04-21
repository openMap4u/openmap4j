package org.openmap4j.builder.style;

import org.openmap4j.style.ImageStyleable;

class ImageStyle extends Style<ImageStyle> implements ImageStyleable, SetImageStyleable<ImageStyle> {

	@Override
	public boolean equals(Object other) {
		if (this == other) 
		      return true; 
		   if (!super.equals(other)) 
		      return false;
		   return true;
	}

}
