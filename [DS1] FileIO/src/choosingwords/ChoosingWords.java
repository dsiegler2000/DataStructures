package choosingwords;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class ChoosingWords {
	
	private static final int[] ACCEPTABLE_LENGTHS = {3, 4, 5};
	
	private static File RAMBLECSDICTIONARY;
	
	public static void main(String[] args) throws IOException{
		
		if(args.length == 0){
			
			System.out.println("I thought you were passing words.txt as an argument.");
			
		}
				
		File wordsF = new File(args[0]);
		
		RAMBLECSDICTIONARY = new File("RamblecsDictionary.java");
				
		if(!RAMBLECSDICTIONARY.createNewFile()){
			
			System.out.println("RamblecsDictionary already exsists at " + RAMBLECSDICTIONARY.getAbsolutePath() + 
					". Overwriting it.");
			
		}
		
		System.out.println("RamblecsDictionary.java is at " + RAMBLECSDICTIONARY.getAbsolutePath());
		
		ArrayList<String> words = new ArrayList<>();
		Scanner scanner = new Scanner(wordsF);
		
		FileWriter output = new FileWriter(RAMBLECSDICTIONARY, true);
		PrintWriter writer = new PrintWriter(output);
		
		while(scanner.hasNextLine()){
			
			words.add(scanner.nextLine());
			
		}
		
		scanner.close();
		
		String[] wordsArr = words.toArray(new String[words.size()]);
		String[] acceptableWords = getWords(ACCEPTABLE_LENGTHS, wordsArr);
		
		long startTime = System.nanoTime();
		
		writer.println("package choosingwords;");
		writer.println();
		writer.println("public class RamblecsDictionary{");
		writer.println("\t@SuppressWarnings(\"unused\")"); //Have to suppress the warning, of course.
		writer.println("\tprivate String[] words = ");
		writer.println("\t{");
		
		for(String w : acceptableWords){
			
			writer.println("\t\t\"" + w.toUpperCase() + "\",");
			
		}
		
		writer.println("\t};");
		writer.println();
		writer.println("}");
		writer.close();
		
		long endTime = System.nanoTime();
		
		System.out.println("Writing to RamblecsDictionary.java took " + (endTime - startTime) + " nanoseconds.");
				
	}
	
	/**
	 * Returns an array of all of the words that have one of the lengths in {@code wordLength}.
	 * @param wordLengths The acceptable lengths for the words.
	 * @param words The words to check.
	 * @return An array of all of the words that have one of the lengths in {@code wordLength}.
	 */
	public static String[] getWords(int[] wordLengths, String[] words){
		
		ArrayList<String> acceptableWords = new ArrayList<>();
		
		for(String w : words){
			
			for(int i = 0; i < wordLengths.length; i++){
				
				if(w.length() == wordLengths[i]){
					
					acceptableWords.add(w);
					
				}
				
			}
						
		}
		
		return acceptableWords.toArray(new String[acceptableWords.size()]);
		
	}

}
