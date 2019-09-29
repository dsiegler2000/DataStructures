package exercise4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RadixSort {
	
	private static final int NUM_BUCKETS = 256;
	
	public static void main(String[] args){
				
		if(args.length < 1){
			
			System.out.println("Must pass the file path!");
			System.exit(1);
			
		}
		
		ArrayList<String> arr = new ArrayList<>();
		
		try(Scanner scan = new Scanner(new File(args[0]))){
			
			while(scan.hasNextLine()){
				
				arr.add(scan.nextLine());
				
			}
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			
		}

		int len = arr.size();
		long startTime = System.currentTimeMillis();
		
		System.out.println("Sorts the array using radix sort assuming each element that is less than maximum length is padded at the beginning with spaces");
		System.out.println(Arrays.toString(radixSort(arr.toArray(new String[arr.size()]))));
		System.out.println("It took " + (System.currentTimeMillis() - startTime) + " milliseconds to sort " + len + " elements.");
				
	}
	
	public static String[] radixSort(String[] arr){
		
		int maxLen = Integer.MIN_VALUE;
						
		for(String s : arr){
						
			maxLen = (s.length() > maxLen ? s.length() : maxLen);
			
		}
		
		for(int i = 0; i < arr.length; i++){
			
			if(arr[i].length() < maxLen){
				
				for(int j = 0; j + arr[i].length() < maxLen; j++){
					
					arr[i] = arr[i].toLowerCase();
					
					while(arr[i].length() != maxLen){
						
						arr[i] = " " + arr[i];
						
					}
										
				}
				
			}
			
		}
		
        List<ArrayList<String>> buckets = new ArrayList<ArrayList<String>>();
        
        for(int i = 0; i < NUM_BUCKETS; i++){
        	
        	buckets.add(new ArrayList<>());
        	
        }
		
		for(int i = maxLen - 1; i > 0; i--){
			
			for(String s : arr){
				
				buckets.get(i > s.length() - 1 ? 0 : s.charAt(i)).add(s);
				
			}
			
			int j = 0;
			
			for(ArrayList<String> bucket : buckets){
				
				for(String s : bucket){
					
					arr[j++] = s;
					
				}
				
				bucket.clear();
				
			}
			
		}
		
		return arr;
		
	}

}
