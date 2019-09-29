package lab4;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;

public class Circle {
	
	private int tlX; // top-left X coordinate
	private int tlY; // top-left Y coordinate
	private int incX; // increment movement of X coordinate
	private int incY; // increment movement of Y coordinate
	private boolean addX; // flag to determine add/subtract of increment for X
	private boolean addY; // flag to determine add/subtract of increment for Y
	private int size; // diameter of the circle
	private int timeDelay; // time delay until next circle is drawn
	private int nCircles;
	
	Queue<Integer> tlXQueue;
	Queue<Integer> tlYQueue;

	public Circle(Graphics g, int s, int x, int y, int td, int nCircles) {
		
		incX = x;
		incY = y;
		size = s;
		addX = true;
		addY = false;
		tlX = 400;
		tlY = 300;
		timeDelay = td;
		
		tlXQueue = new LinkedList<>();
		tlYQueue = new LinkedList<>();
		
		this.nCircles = nCircles;
		
	}

	public void delay(int n) {
		
		try {
			
			Thread.sleep(n);
			
		} catch (InterruptedException e) {

			e.printStackTrace();
			
		}
		
	}
	
	public void eraseCircle(int x, int y, Graphics g){
		
		g.setColor(Color.white);
		g.drawOval(x, y, size, size);
		
	}

	public int getTLX(){
		
		return tlX - size;
		
	}
	
	public int getTLY(){
		
		return tlY - size;
		
	}

	public void drawCircle(Graphics g) {
		
		tlXQueue.add(tlX);
		tlYQueue.add(tlY);

		g.setColor(Color.blue);
		g.drawOval(tlX, tlY, size, size);
		delay(timeDelay);
		
		if(tlXQueue.size() > nCircles){
			
			int dequedX = tlXQueue.remove();
			int dequedY = tlYQueue.remove();
			
			eraseCircle(dequedX, dequedY, g);
			
		}
				
		if (addX) {
			
			tlX += incX;
			
		} 
		
		else {
			
			tlX -= incX;
			
		}
		
		if (addY) {
			
			tlY += incY;
			
		} 
		
		else {
			
			tlY -= incY;
			
		}
	
	}

	public void newData() {
		
		incX = (int) Math.round(Math.random() * 7 + 5);
		incY = (int) Math.round(Math.random() * 7 + 5);
				
	}

	public void hitEdge()
	{
		boolean flag = false;
		if (tlX < incX)
		{
			addX = true;
			flag = true;
		}
		if (tlX > 800 - (30 + incX))  
		{
			addX = false;
			flag = true;
		}
		if (tlY < incY + 30)  // The +30 is due to the fact that the title bar covers the top 30 pixels of the window
		{
			addY = true;
			flag = true;
		}
		if (tlY > 600 - (30 + incY))  
		{
			addY = false;
			flag = true;
		}
		if (flag)
			newData();
	}


}