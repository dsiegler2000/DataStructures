package sorting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NumGenerator {
	
	public static void main(String[] args) throws IOException{
		
		FileWriter fw = new FileWriter(new File("src/sorting/large.txt"));
		
		for(int i = 0; i < 400000; i++){
			
			fw.write((int) (Math.random() * Integer.MAX_VALUE) + "\n");
			
		}
		
		fw.close();
		
	}

}
