package problem6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class BabyGrep {

	public static void main(String[] args) {

		if(args.length < 2 || args[0].length() == 0 || args[1].length() == 0){
			
			System.out.println("Now really? Trying to pass less than 2 arguments? You troll.");
			System.exit(1);
			
		}
				
		String[] hits = basicGrep(args[0], args[1]);
		
		if(hits.length == 0){
			
			System.out.println(args[0] + " not found");
			
		}
		
		for(String s : hits){
			
			System.out.println(s);
			
		}
		
	}
	
	/**
	 * Searches the file at {@code filepath} for {@code phrase} and returns an array with all of the hits.
	 * @param phrase The phrase to search for.
	 * @param filepath The file to search.
	 * @return An array of all of the hits of the phrase in the file. 
	 */
	public static String[] basicGrep(String phrase, String filepath){
		
		File file = new File(filepath);
		FileReader reader = null;
		
		try {
			
			reader = new FileReader(file);
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			System.out.println("You tried to pass an invalid file path. You troll!");
			System.exit(1);
			
		}
		
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		ArrayList<String> hits = new ArrayList<>();
		int lineOn = 1;
		
		try {
			
			while(bufferedReader.ready()){
				
				String line = bufferedReader.readLine();
				
				for(int i = 0; i <= line.length() - phrase.length(); i++){
										
					if(phrase.equals(line.substring(i, i + phrase.length()))){
						
						hits.add("Line " + lineOn + ": [ " + line + " ]");
						
					}
					
				}
				
				lineOn++;
				
			}
			
		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("Well I don't even know what went wrong!");
			System.exit(1);
			
		}
		
		return hits.toArray(new String[hits.size()]);
		
	}

}