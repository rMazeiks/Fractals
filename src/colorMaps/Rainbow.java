package colorMaps;

import java.awt.Color;

import main.ColorMap;
import main.Main;

public class Rainbow extends ColorMap {

	public Rainbow(Main m) {
		super(m);
		// TODO Auto-generated constructor stub
	}



	@Override
	public int value(int i) {
		if(i==-1)  {
			return 0;
		}
		return Color.HSBtoRGB(((float)i)/6, 1, 1);
	}

}
