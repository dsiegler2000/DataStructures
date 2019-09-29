package problem5;

import java.util.LinkedList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MergeLists {
	
	public static void main(String[] args) throws IOException{
		
		if(args.length < 2){
			
			System.err.println("Must pass 2 files");
			System.exit(1);
			
		}
		
		File f1 = new File(args[0]);
		File f2 = new File(args[1]);
		
		Scanner s1 = new Scanner(f1);
		Scanner s2 = new Scanner(f2);
		
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		
		while(s1.hasNext()){
			
			list1.add(s1.nextLine());
			list2.add(s2.nextLine());
			
		}
		
		System.out.println("Output at " + new File("output5.txt").getAbsolutePath());
		FileWriter out = new FileWriter(new File("output5.txt"));
		LinkedList<String> l = mix(list1, list2);
		
		for(String s: l){
			
			out.write(s + "\n");
			
		}
		
		out.close();
		s1.close();
		s2.close();
		
	}
	
	/**
	 * Takes 2 lists of equal size and weaves them together, taking one from {@code list1} then 
	 * one from {@code list2}, etc.
	 * @param list1 The first list.
	 * @param list2 The second list.
	 * @return The lists mixed together. 
	 */
	public static LinkedList<String> mix(List<String> list1, List<String> list2){
		
		Iterator<String> iter1 = list1.iterator();
		Iterator<String> iter2 = list2.iterator();
		
		LinkedList<String> out = new LinkedList<String>();
		
		while(iter1.hasNext() && iter2.hasNext()){
			
			out.add(iter1.next());
			out.add(iter2.next());
			
		}
		
		return out;
		
	}

}
