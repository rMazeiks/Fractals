package main;

public abstract class Shape {
	public double radius;

	public Shape(double radius) {
		this.radius = radius;
	}

	/**
	 * Evaluates whether a point is within the shape
	 * 
	 * @param x
	 *            the x value of the point
	 * @param y
	 *            the y value of the point
	 * @return true if the point is within the shape, false if it is on the edge
	 *         or outside
	 */
	public boolean hasPoint(double x, double y) {
		return valueAt(x, y) < radius;
	}

	/**
	 * Evaluates whether a complex number is within the shape
	 * 
	 * @param c
	 *            the number
	 * @return true if the number is within the shape, false if it is on the
	 *         edge or outside
	 */
	public boolean hasPoint(Complex c) {
		return valueAt(c.real, c.img) < radius;
	}

	protected abstract double valueAt(double x, double y);
}
