package org.openmap4j.style;

import java.awt.Color;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Map;

public class Colors {

	/**
	 * Stores the color brewer color maps.
	 */
	private Map<Integer,Map<String,Map<String,List<Color>>>> colorBrewer = new HashMap<>();

	enum SchemeType {
		QUALITATIVE, SEQUENTIAL, DIVERGING
	}

	enum ColorName {

	}

	public static void main(String[] args) {
		Colors col = new Colors();
		col.readValuesFromCsv();
	}

	void readValuesFromCsv() {
		try (BufferedReader in = new BufferedReader(
				new FileReader(Colors.class.getClassLoader().getResource("color-brewer/cb.csv").getFile()));) {
			String line = "";
			String colorName = null;
			int numberOfColors = 0;
			String type = null;
			String critVal = null;
			int colorNum = 0;
			int c = 0;
			int m = 0;
			int y = 0;
			int k = 0;
			String colorScheme = null;
			String colorLetter = null;
			// skip the header
			in.readLine();
			while ((line = in.readLine()) != null) {
				String[] vals = line.split(",");
				if (vals[0].length() > 0) {
					colorName = vals[0];
					System.out.println(colorName);
				}
				if (vals[1].length() > 0) {
					numberOfColors = Integer.parseInt(vals[1]);
				}
				if (vals[2].length() > 0) {
					type = vals[2];
				}
				if (vals[3].length() > 0) {
					critVal = vals[3];
				}
				if (vals[4].length() > 0) {
					colorNum = Integer.parseInt(vals[4]);
				}
				if (vals[5].length() > 0) {
					colorLetter = vals[5];
				}
				if (vals[6].length() > 0) {
					c = Integer.parseInt(vals[6]);
				}
				if (vals[7].length() > 0) {
					m = Integer.parseInt(vals[7]);
				}
				if (vals[8].length() > 0) {
					y = Integer.parseInt(vals[8]);
				}
				if (vals[9].length() > 0) {
					k = Integer.parseInt(vals[9]);
				}
				if (vals.length == 11) {
					colorScheme = vals[10];
				}

			//	System.out.println(colorName + " " + numberOfColors + " " + type + " " + critVal + " " + colorNum + " "
			//			+ colorLetter + " " + getColor(c, m, y, k));
			}
		} catch (IOException e) {

		}
	}

	/**
	 * Gest the rgb color from a cmyk value.
	 * @param cyan The cyan value.
	 * @param magenta The magenta value.
	 * @param yellow The yeallow value
	 * @param black The black value.
	 * @return The rgb value.
	 */
	Color getColor(float cyan, float magenta, float yellow, float black) {
		if (black != 255) {
			int r = (int) ((255 - cyan) * (255 - black)) / 255;
			int g = (int) ((255 - magenta) * (255 - black)) / 255;
			int b = (int) ((255 - yellow) * (255 - black)) / 255;
			return new Color(r, g, b);
		} else {
			int r = (int) (255 - cyan);
			int g = (int) (255 - magenta);
			int b = (int) (255 - yellow);
			return new Color(r, g, b);
		}
	}

	List<Color> getColors(int number, ColorName colorName, SchemeType schemeType) {
	//	List<Color> colors = new ArrayList<>();
		return null;
	}
	

	
	
}
