package shapes;

import main.Shape;

public class Square extends Shape {
	
	public Square(double radius) {
		super(radius);
	}

	@Override
	protected double valueAt(double x, double y) {
		return (Math.max(Math.abs(x), Math.abs(y)));
	}
}
