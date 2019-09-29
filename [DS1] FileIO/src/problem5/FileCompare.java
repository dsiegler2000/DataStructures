package problem5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileCompare {

	public static void main(String[] args) {
		
		if(args.length < 2 || args[0].length() == 0 || args[1].length() == 0){
			
			System.out.println("Now really? Trying to pass less than 2 arguments? You troll");
			System.exit(1);
			
		}
		
		System.out.println("The 2 given files " + (areFilesEqual(args[0], args[1]) ? "are " : " are not") + " equal.");
		
	}
	
	/**
	 * Checks to see if two files' data are exactly equal. 
	 * @param filepath1 The path to the first file.
	 * @param filepath2 The path to the second file.
	 * @return True if all of the (text) data of the files are equal, false otherwise.
	 */
	public static boolean areFilesEqual(String filepath1, String filepath2){
		
		File file1 = new File(filepath1);
		File file2 = new File(filepath2);
		
		FileReader reader1 = null;
		FileReader reader2 = null;
		
		try {
			
			reader1 = new FileReader(file1);
			reader2 = new FileReader(file2);
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			System.out.println("You tried to pass an invalid file path. You troll!");
			System.exit(1);
			
		}
		
		BufferedReader bufferedReader1 = new BufferedReader(reader1);
		BufferedReader bufferedReader2 = new BufferedReader(reader2);
				
		try {
			
			while(bufferedReader1.ready() && bufferedReader2.ready()){
				
				String line1 = bufferedReader1.readLine();
				String line2 = bufferedReader2.readLine();
				
				if(!line1.equals(line2)){
					
					return false;
					
				}
				
			}
			
			if(bufferedReader1.ready() || bufferedReader2.ready()){
				
				return false;
				
			}
			
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("Well. I don't even know what went wrong");
			System.exit(1);
			
		}
		
		return true;
		
	}

}
