package lab4;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BouncingCircles {

	public static void main(String args[]) {
				
		String nCirclesStr = JOptionPane.showInputDialog("Select the number of circles");
		
		int nCircles = 0;
		
		try{
			
			nCircles = Integer.parseInt(nCirclesStr);
			
		}catch(NumberFormatException e){
			
			System.exit(0);
			
		}
		
		String circleDiameterString = JOptionPane.showInputDialog("Select the diameter of the circles");
		
		int diameter = 0;
		
		try{
			
			diameter = Integer.parseInt(circleDiameterString);
			
		}catch(NumberFormatException e){
			
			System.exit(0);
			
		}
		
		GfxApp gfx = new GfxApp(nCircles, diameter);
		gfx.setSize(800, 600);
		
		gfx.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				
				System.exit(0);
					
			}
			
		});

		
		gfx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
}