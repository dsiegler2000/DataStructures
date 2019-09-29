package lab4;

import java.awt.Graphics;

import javax.swing.JFrame;

public class GfxApp extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private int nCircles;
	private int diameter;
			
	public GfxApp(int nCircles, int diameter) {
		
		super("Bounding Circles");
		
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		this.nCircles = nCircles;
		this.diameter = diameter;
						
	}

	public void paint(Graphics g) {

		int incX = 5;
		int incY = 5;
		int timeDelay = 10;

		Circle c = new Circle(g, diameter, incX, incY, timeDelay, nCircles);
				
		for (int k = 1; k <= 2000; k++) {
			
			c.drawCircle(g);
			c.hitEdge();
						
		}

	}

}