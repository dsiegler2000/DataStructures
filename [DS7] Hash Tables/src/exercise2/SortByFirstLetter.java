package exercise2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SortByFirstLetter {
	
	public static void main(String[] args){
		
		File f = new File(args[0]);
		
		Scanner scanner = null;
		
		try {
			
			scanner = new Scanner(f);
			
		} catch (FileNotFoundException e) {
			
			System.out.println("File at " + f.getAbsolutePath() + " doesn't exist!");
		
		}
		
		ArrayList<String> in = new ArrayList<String>();
		
		while(scanner.hasNextLine()){
			
			in.add(scanner.nextLine());
			
		}
		
		System.out.println(sortByFirstLetter(in));
		
	}
	
	public static List<String> sortByFirstLetter(List<String> words){
		
		ArrayList<Queue<String>> queues = new ArrayList<Queue<String>>();
		
		for(int i = 0; i < 26; i++){
			
			queues.add(new LinkedList<String>());
			
		}
		
		for(String s : words){
			
			try{
				
				queues.get((int) s.charAt(0) - 65).add(s);
				
			} catch(Exception e){
				
				throw new IllegalArgumentException("There is something wrong with the argument.");
				
			}
			
		}
		
		LinkedList<String> out = new LinkedList<>();
		
		for(Queue<String> q : queues){
			
			for(String s : q){
				
				out.add(s);
				
			}
			
		}
		
		return out;
		
	}

}
