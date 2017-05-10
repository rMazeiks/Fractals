package shapes;

import main.Shape;

public class Circle extends Shape {

	public Circle(double radius) {
		super(radius);
	}

	@Override
	protected double valueAt(double x, double y) {
		return(Math.hypot(x, y));
	}

}
