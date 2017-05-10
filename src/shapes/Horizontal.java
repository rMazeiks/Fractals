package shapes;

import main.Shape;

public class Horizontal extends Shape {

	public Horizontal(double radius) {
		super(radius);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double valueAt(double x, double y) {
		// TODO Auto-generated method stub
		return Math.abs(x);
	}

}
