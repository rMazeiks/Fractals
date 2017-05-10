package shapes;

import main.Shape;

public class Rhombus extends Shape {

	public Rhombus(double radius) {
		super(radius);
	}
	private double rootTwo = Math.sqrt(2);
	@Override
	protected double valueAt(double x, double y) {
		return (Math.abs(x)+Math.abs(y))/rootTwo;
	}

}
