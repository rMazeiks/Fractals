package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventHandler implements KeyListener, MouseListener {
	Main main;

	public EventHandler(Main main) {
		super();
		this.main = main;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	private int startX, startY;

	@Override
	public void mousePressed(MouseEvent e) {
		startX = e.getX();
		startY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		main.grapher.move(e.getX() - startX, e.getY() - startY);
		main.window.refresh(main.controlPanel.normalSamples);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		boolean rf = true;
		if (arg0.isActionKey()) {
			int i = main.window.getWidth() / 4;
			switch (arg0.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				main.grapher.move(-i, 0);
				break;
			case KeyEvent.VK_LEFT:
				main.grapher.move(i, 0);
				break;
			case KeyEvent.VK_DOWN:
				main.grapher.move(0, -i);
				break;
			case KeyEvent.VK_UP:
				main.grapher.move(0, i);
				break;
			default:
				rf = false;
			}
		} else {
			switch (arg0.getKeyChar()) {
			case '=':
				main.grapher.zoomIn();
				break;
			case '-':
				main.grapher.zoomOut();
				break;
			case '}':
			case ']':
				main.grapher.iterations++;
				break;
			case '{':
			case '[':
				main.grapher.iterations = Math.max(main.grapher.iterations - 1,
						1);
				break;
			case '9':
			case '(':
				main.shape.radius *= 0.9;
				break;
			case '0':
			case ')':
				main.shape.radius /= 0.9;
				break;
			default:
				rf = false;
				break;
			}
		}
		if (rf) {
			main.window.refresh(main.controlPanel.normalSamples);
		}
	}
}
