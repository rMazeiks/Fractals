package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import shapes.*;

import colorMaps.*;

public class ControlPanel extends JFrame implements ActionListener,
		ChangeListener {
	Main main;

	private String[] cNames = { "Black and white", "Rainbow", "stripes" };
	private ColorMap[] cObjects = { new Binary(main), new Rainbow(main),
			new Stripes(main) };
	int cDefault = 1;

	private String[] sNames = { "Circle", "Oval", "Horiszon",
			"Hiperbole", "Parabole", "Rhombus", "Square" };
	private Shape[] sObjects = { new Circle(2), new Ellipse(2),
			new Horizontal(2), new Hyperbole(2), new Parabola(2),
			new Rhombus(2), new Square(2) };

	public int normalSamples = 4;

	public ControlPanel(Main m) {
		main = m;
	}

	public void create() {
		BoxLayout b = new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS);
		setLayout(b);

		this.add(new JLabel("Samples:"));
		
		JSlider normalSamples = new JSlider(JSlider.HORIZONTAL, 1, 100, 4);
		normalSamples.setMajorTickSpacing(10);
		normalSamples.setMinorTickSpacing(5);
		normalSamples.setPaintTicks(true);
		normalSamples.setPaintLabels(true);
		normalSamples.setName("nSamples");
		normalSamples.addChangeListener(this);
		this.add(normalSamples);


		JButton render = new JButton("100 samples");
		render.setActionCommand("render");
		render.addActionListener(this);
		this.add(render);

		this.add(new JLabel("Colors:"));
		
		JComboBox colorMaps = new JComboBox(cNames);
		colorMaps.setActionCommand("color");
		colorMaps.addActionListener(this);
		this.add(colorMaps);

		this.add(new JLabel("Shape:"));
		
		JComboBox shapes = new JComboBox(sNames);
		shapes.setActionCommand("shape");
		shapes.addActionListener(this);
		this.add(shapes);
		
		this.add(new JLabel("Radius:"));
		
		JSlider radius = new JSlider(JSlider.HORIZONTAL, 0, 5, 2);
		radius.setMajorTickSpacing(1);
		radius.setPaintTicks(true);
		radius.setPaintLabels(true);
		radius.setName("radius");
		radius.addChangeListener(this);
		this.add(radius);

		this.addKeyListener(main.eventHandler);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String c = e.getActionCommand();

		if (c.equals("render")) {
			main.window.refresh(100);

		} else if (c.equals("color")) {
			main.colorMap = cObjects[((JComboBox) e.getSource())
					.getSelectedIndex()];
			main.window.refresh(normalSamples);

		} else if (c.equals("shape")) {
			main.shape = sObjects[((JComboBox) e.getSource())
					.getSelectedIndex()];
			main.window.refresh(normalSamples);
		}

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider src = ((JSlider) e.getSource());
		String sourceName = src.getName();
		if (sourceName.equals("nSamples")) {
			normalSamples = ((JSlider) e.getSource()).getValue();
		} else if (sourceName.equals("radius"))  {
			main.shape.radius = src.getValue();
			main.window.refresh(normalSamples);
		}
	}
}
