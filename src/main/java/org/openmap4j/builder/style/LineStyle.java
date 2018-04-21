package org.openmap4j.builder.style;

import org.openmap4j.style.LineStyleable;

class LineStyle extends Stroke<LineStyle> implements LineStyleable {
	
	@Override
	public boolean equals(Object other) {
		if (this == other) 
		      return true; 
		else   if (!super.equals(other)) 
		      return false;
		else
			return true;
	}
}
