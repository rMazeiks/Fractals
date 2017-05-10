package shapes;

import main.Shape;

public class Parabola extends Shape {

	public Parabola(double radius) {
		super(radius);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double valueAt(double x, double y) {
		return (x*x-y-1);
	}

}
