package main;

import java.awt.Color;
import java.util.ArrayList;

public abstract class ColorMap {
	Main main;
	private ArrayList<Integer> list = new ArrayList<Integer>();

	public ColorMap(Main m) {
		main = m;
	}

	public void clear() {
		list.clear();
	}

	public void addValue(int sample) {
		list.add(new Integer(sample));
	}

	public abstract int value(int i);

	public int getColor() {
		float r = 0, g = 0, b = 0;
		for (Integer i : list) {
			Color c = new Color(value(i.intValue()));
			r += c.getRed();
			g += c.getGreen();
			b += c.getBlue();
		}
		r /= list.size();
		g /= list.size();
		b /= list.size();
		return new Color((int)r, (int)g, (int)b).getRGB();
	}

}
