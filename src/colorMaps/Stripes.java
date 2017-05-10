package colorMaps;

import java.awt.Color;

import main.ColorMap;
import main.Main;

public class Stripes extends ColorMap {

	public Stripes(Main m) {
		super(m);
	}

	@Override
	public int value(int i) {
		return i%2==0? 0: Color.WHITE.getRGB();
	}

}
