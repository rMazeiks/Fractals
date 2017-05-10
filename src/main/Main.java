package main;

import java.awt.image.BufferedImage;

import colorMaps.*;
import shapes.*;

public class Main {
	public MyWindow window;
	public Grapher grapher;
	public Shape shape;
	public EventHandler eventHandler;
	public ColorMap colorMap;
	public ControlPanel controlPanel;

	public static void main(String[] a) {
		Main m = new Main();
	}

	public Main() {

		shape = new Horizontal((double) 2);
		grapher = new Grapher(800, 800, BufferedImage.TYPE_INT_RGB, this);
		window = new MyWindow(this);
		eventHandler = new EventHandler(this);
		colorMap = new Rainbow(this);
		controlPanel = new ControlPanel(this);
		
		controlPanel.create();

		window.addMouseListener(eventHandler);
		window.addKeyListener(eventHandler);

		window.refresh(4);
	}

}
