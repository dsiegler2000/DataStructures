package problem4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class BracesChecker {
		
	public static void main(String[] args){
		
		if(args.length == 0){
			
			System.out.println("Now really? Trying to pass 0 arguments? You troll");
			System.exit(1);
			
		}
		
		System.out.println(areBracesBalanced(args[0]));
		
	}
	
	/**
	 * Checks to see if the braces are balanced in the Java source file at {@code filepath}. Braces are 
	 * balanced if and only if for every open curly braces { there is a close curly braces }.
	 * @param filepath The file path to the source file.
	 * @return True if the braces are balanced, false otherwise.
	 */
	public static boolean areBracesBalanced(String filepath){
		
		FileReader fileReader = null;
		Scanner reader = null;
		
		Stack<Integer> braces = new Stack<>();
		
		try{
			
			File source = new File(filepath);
			fileReader = new FileReader(source);
			reader = new Scanner(fileReader);
			
		} catch(FileNotFoundException e){
			
			e.printStackTrace();
			System.out.println("You are trying to troll me by passing a file that doesn't exsist.");
			System.exit(1);
			
		}
		
		while(reader.hasNext()){
												
			String line = reader.nextLine();

			for(int i = 0; i < line.length(); i++){
								
				if(line.substring(i, i + 1).equals("{")){
					
					braces.push(1);
					
				}
				
				if(line.substring(i, i + 1).equals("}")){
					
					
					try{
						
						braces.pop();
						
					} catch(EmptyStackException e){
						
						return false;
						
					}
					
				}
				
			}
			
		}
		
		return braces.size() == 0;
		
	}

}
