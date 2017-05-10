package transformations;

import main.Complex;

public class Mandelbrot extends Complex {

	public Mandelbrot(double real, double img) {
		super(real, img);
	}

	@Override
	public void transform(double or, double oi) { // z^2 + c
		double r = real*real - img*img +or;
		img = 2*real*img + oi;
		real = r;
	}
	
}
