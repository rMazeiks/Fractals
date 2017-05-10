package main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.sql.Time;
import java.util.Timer;

import transformations.*;

public class Grapher extends BufferedImage {

	public int w, h;
	public int iterations = 10;

	double scale;
	double translateX, translateY;
	Main main;

	public Grapher(int w, int h, int arg2, Main m) {
		super(w, h, arg2);
		this.w = w;
		this.h = h;

		this.scale = w / 4;

		main = m;
	}

	void generate(int samples) {
		long startTime = System.nanoTime();
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				main.colorMap.clear();
				for (int n = 0; n < samples; n++) {
					main.colorMap.addValue(sample(random() + x - w / 2,
							random() + y - h / 2));
				}
				this.setRGB(x, y, main.colorMap.getColor());
			}
		}
		long stopTime = System.nanoTime();
		long sec = stopTime-startTime;
	}

	private double random() {
		return (Math.random() - 0.5);
	}

	int sample(double r, double i) {
		double a = 1; // eksperiments, piem 0.1
		Complex c = new Mandelbrot((r - translateX) / scale, (i - translateY)
				/ scale);
		// Complex c = new PowThree((r - translateX) / scale, (i - translateY) /
		// scale);

		if (!main.shape.hasPoint(c)) {
			return 0;
		}
		double origR = c.real;
		double origI = c.img;
		for (int n = 0; n < iterations; n++) {
			c.transform(origR, origI);
			c.real = (c.real * a + origR * (1 - a));
			c.img = (c.img * a + origI * (1 - a));

			if (!main.shape.hasPoint(c)) {
				return n + 1;
			}
		}
		return -1;
	}

	public void zoomIn() {
		scale *= 2;
		translateX *= 2;
		translateY *= 2;
	}

	public void move(int x, int y) {
		translateX += (double) x / Math.log(scale);
		translateY += (double) y / Math.log(scale);

	}

	public void zoomOut() {
		scale /= 2;
		translateX /= 2;
		translateY /= 2;
	}
}
