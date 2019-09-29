package problem6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class DoubleSum {
	
	public static void main(String[] args) throws IOException{
		
		if(args.length < 1){
			
			System.err.println("Pass a file!");
			System.exit(1);
			
		}
		
		Scanner in = new Scanner(new File(args[0]));
		ArrayList<Double> list = new ArrayList<>();
		
		while(in.hasNextLine()){
			
			try{
				
				list.add(Double.parseDouble(in.nextLine()));
				
			}catch(NumberFormatException e){
				
				System.out.println("NaN found!");
				
			}
			
		}
		
		File out = new File("output6.txt");
		System.out.println("Outputing to " + out.getAbsolutePath());
		System.out.print("Also the sum2 is " + sum2(list));
		FileWriter fw = new FileWriter(out);

		fw.write(String.valueOf(sum2(list)));
		
		in.close();
		fw.close();
		
	}
	
	/**
	 * Sums the products of adjacent pairs of doubles and returns them.
	 * @param list The list to sum products of adjacent pairs. 
	 * @return The sum of products of adjacent pairs of the list. 
	 */
	public static double sum2(List<Double> list){
		
		double sum = 0;
		
		ListIterator<Double> listIter = list.subList(0, list.size() - 1).listIterator();
		
		while(listIter.hasNext()){
			
			double next = listIter.next();
			
			ListIterator<Double> secondIter = list.listIterator(listIter.nextIndex()); 
			
			while(secondIter.hasNext()){
				
				double secondNext = secondIter.next();
				sum += secondNext * next;
				
			}
			
		}
		
		return sum;
		
	}

}
