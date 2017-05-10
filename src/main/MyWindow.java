package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyWindow extends JFrame {
	Main main;

	public MyWindow(Main m) {
		super();
		main = m;

		this.setResizable(false);
	}

	void refresh(int samples) {
		
		this.getContentPane().removeAll();
		this.add(new JLabel(new ImageIcon((Image) main.grapher)));
		
		this.pack();
		this.setVisible(true);
		
		main.grapher.generate(samples);
		
		System.out.println("Translate x:\t" + main.grapher.translateX
				+ "\ty:\t" + main.grapher.translateY + "\tScale:\t"
				+ main.grapher.scale + "\tShape radius:\t"
				+ main.shape.radius);
	}

}
