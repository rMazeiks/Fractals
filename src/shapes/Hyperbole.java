package shapes;

import main.Shape;

public class Hyperbole extends Shape {

	public Hyperbole(double radius) {
		super(radius);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double valueAt(double x, double y) {
		// TODO Auto-generated method stub
		return x*x/2-y*y/2-1;
	}

}
