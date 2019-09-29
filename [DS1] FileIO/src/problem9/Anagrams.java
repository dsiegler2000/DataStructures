package problem9;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {
	
	public static void main(String[] args){
		System.out.println(args.length);
		
		if(args.length == 1){
			
			System.out.println("I am presuming that you want me to print out (e). If you would like (f), give me"
					+ " THREE (or more) arguments.");
			
			printAllAnagrams(getDictionaryFromFile(args[0]), "RAMBLECS");
			
		}
		
		else if(args.length == 2){
			
			System.out.println("I am running the regular and part (f)\n");
			
			printAllAnagrams(getDictionaryFromFile(args[1]), args[0]);
			System.out.println();
			printAllAnagramsP(getDictionaryFromFile(args[1]), args[0]);
			
		}
		
		else{
			
			System.out.println("Aren't you going to pass at least a path to the dictionary?");
			
		}
				
	}
	
	/**
	 * Converts a dictionary file with one word per line into a {@code String} array.
	 * @param filepath The dictionary file path.
	 * @return An array of each line of the dictionary file.
	 */
	public static String[] getDictionaryFromFile(String filepath){
		
		File file = new File(filepath);
		Scanner scanner = null;
		
		try {
			
			scanner = new Scanner(file);
			
		} catch (FileNotFoundException e) {
			
			System.out.println("You troll. That's all I'm going to say.");
			e.printStackTrace();
			System.exit(1);
			
		}
		
		ArrayList<String> words = new ArrayList<>();
		
		while(scanner.hasNextLine()){
			
			words.add(scanner.nextLine().toUpperCase());
			
		}
		
		return words.toArray(new String[words.size()]);
		
	}
	
	/**
	 * Converts a word to an array of numbers where the ith index represents the count of the 
	 * ith letter of the alphabet.
	 * @param word The word to convert to a letter count.
	 * @return An array of numbers where the ith index represents the count of the 
	 * ith letter of the alphabet.
	 */
	public static int[] wordToLetterCount(String word){
		
		int[] letterCount = new int[26];
				
		for(char c : word.toUpperCase().toCharArray()){
			
			try{
			
				letterCount[c - 'A']++;
				
			}catch(ArrayIndexOutOfBoundsException e){
				
				System.out.println("The character " + c + " is not a letter so it will be excluded.");
				
			}
			
		}
		
		return letterCount;
		
	}
	
	/**
	 * Calls {@code Arrays.equals(arr1, arr2)} but I was forced to make this.
	 * @param arr1 "
	 * @param arr2 "
	 * @return {@code Arrays.equals(arr1, arr2)}.
	 */
	public static boolean areTwoArraysEqual(int[] arr1, int[] arr2){
		
		return Arrays.equals(arr1, arr2); //Do I really need to write a for loop an check all the numbers?
		
	}
	
	/**
	 * Prints all anagrams of the target in {@code dictionary}.
	 * @param dictionary The dictionary of words to search.
	 * @param target The target to search for (anagrams of).
	 */
	public static void printAllAnagrams(String[] dictionary, String target){
		
		int[] targetCount = wordToLetterCount(target.toUpperCase());
		
		for(String s : dictionary){
			
			if(areTwoArraysEqual(wordToLetterCount(s), targetCount) && !s.toUpperCase().equals(target.toUpperCase())){
				
				System.out.println(s + " is an anagram.");
				
			}
			
		}
		
	}
	
	/**
	 * Prints all anagrams of the target in {@code dictionary} using the method described in (f).
	 * @param dictionary The dictionary of words to search.
	 * @param target The target to search for (anagrams of).
	 */
	public static void printAllAnagramsP(String[] dictionary, String target){
		
		char[] targetCharArray = target.toUpperCase().toCharArray();
		Arrays.sort(targetCharArray);
		String sortedTarget = new String(targetCharArray);
		
		for(String s : dictionary){
			
			char[] sCharArray = s.toUpperCase().toCharArray();
			Arrays.sort(sCharArray);
			String sSorted = new String(sCharArray);
			
			if(sSorted.equals(sortedTarget)  && !s.toUpperCase().equals(target.toUpperCase())){
				
				System.out.println(s + " is an anagram using method in part (f).");
				
			}
			
			
		}
		
	}

}
