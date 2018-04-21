package org.openmap4j.style;

import java.awt.Color;
import java.awt.color.ColorSpace;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Pattern;

public class Colors {
	
	private Pattern RGB_PATTERN = Pattern.compile("rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)");


	enum SchemeType {
		QUALITATIVE, SEQUENTIAL,DIVERGING	}
	
	enum ColorName {
	
	}
	
	public static void main(String [] args) {
		Colors col = new Colors();
		col.readValuesFromCsv();
	}
	
	void readValuesFromCsv() {
		try ( BufferedReader in = new BufferedReader( new FileReader(Colors.class.getClassLoader().getResource("color-brewer/cb.csv").getFile()));) {
			 String line = "";
			 String colorName=null;
			 int numberOfColors=0;
			 String type=null;
			 String critVal=null;
			 int colorNum=0;
			 int c=0;
			 int m=0;
			 int y=0;
			 int k=0;
			 String colorScheme=null;
			 String colorLetter = null;
			 // skip the header
			 in.readLine();
			 while ((line = in.readLine()) != null) {
                    String[] vals = line.split(",");
                     if (vals[0].length()>0) {
                    	 colorName = vals[0];
                     }
                     if (vals[1].length()>0) {
                    	 numberOfColors = Integer.parseInt(vals[1]);
                     }
                     if (vals[2].length()>0) {
                    	 type = vals[2];
                     }
                     if (vals[3].length()>0) {
                    	 critVal = vals[3];
                     }
                     if (vals[4].length()>0) {
                    	 colorNum = Integer.parseInt(vals[4]);
                     }
                     if (vals[5].length()>0) {
                    	 colorLetter = vals[5];
                     }
                     if (vals[6].length()>0) {
                    	 c = Integer.parseInt(vals[6]);
                     }
                     if (vals[7].length()>0) {
                    	 m = Integer.parseInt(vals[7]);
                     }
                     if (vals[8].length()>0) {
                    	 y = Integer.parseInt(vals[8]);
                     } 
                     if (vals[9].length()>0) {
                    	 k = Integer.parseInt(vals[9]);
                     }
                     if (vals.length==11 ) {
                    	 colorScheme = vals[10];
                     }
                     
	 System.out.println(colorName+" "+numberOfColors+" "+type+" "+critVal+" "+colorNum+" "+colorLetter+ " "+new Color(ColorSpace.getInstance(ColorSpace.TYPE_CMYK), new float[] {c,m,y,k},1f));
	            }
		} catch (IOException e) {
			
		}    
	}
	
	Color getCmykColor(float c, float m, float y, float k) {
		
	}

	Color[] getColors(int number, ColorName colorName, SchemeType schemeType) {
		return null;
	}

}
