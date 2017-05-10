package transformations;

import main.Complex;

public class PowThree extends Complex {

	public PowThree(double real, double img) {
		super(real, img);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void transform(double or, double oi) {// z^3+c
		double r = real*real*real- 3*real*img*img + or;
		img = -img*img*img + 3*real*real*img + oi;
		real = r;
	}

}
