package shapes;

public class Ellipse extends Circle {

	public Ellipse(double radius) {
		super(radius);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected double valueAt(double x, double y) {
		return super.valueAt(x, y/2);
	}

}
