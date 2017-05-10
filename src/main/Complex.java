package main;

public abstract class Complex {

	protected double real;
	protected double img;

	public Complex(double real, double img) {
		super();
		this.real = real;
		this.img = img;
	}
	
	public abstract void transform(double or, double oi);
}
