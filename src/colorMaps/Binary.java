package colorMaps;

import java.awt.Color;

import main.ColorMap;
import main.Main;

public class Binary extends ColorMap {

	public Binary(Main m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int value(int i) {
		if(i>-1)  return Color.WHITE.getRGB();
		return 0;
	}

}
