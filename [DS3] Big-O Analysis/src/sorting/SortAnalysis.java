package sorting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Arrays;
import java.util.Scanner;

public class SortAnalysis {
	
	public static void main(String[] args) throws IOException{
		
		if(args.length < 3){
			
			System.out.println("NO!");
			System.exit(1);
			
		}
		
		File smallF = new File(args[0]);
		File mediumF = new File(args[1]);
		File largeF = new File(args[2]);
		
		Scanner smallIn = new Scanner(smallF);
		Scanner mediumIn = new Scanner(mediumF);
		Scanner largeIn = new Scanner(largeF);
		
		int smallSize = 0;
		int mediumSize = 0;
		int largeSize = 0;
		
		while(smallIn.hasNextLine()){
			
			smallSize++;
			smallIn.nextLine();
			
		}
		
		while(mediumIn.hasNextLine()){
			
			mediumSize++;
			mediumIn.nextLine();
			
		}
		
		while(largeIn.hasNextLine()){
			
			largeSize++;
			largeIn.nextLine();
			
		}
		
		smallIn.close();
		mediumIn.close();
		largeIn.close();
		
		smallIn = new Scanner(smallF);
		mediumIn = new Scanner(mediumF);
		largeIn = new Scanner(largeF);
		
		int[] smallOriginal = new int[smallSize];
		int[] mediumOriginal = new int[mediumSize];
		int[] largeOriginal = new int[largeSize];
		
		int idx = 0;
	
		while(smallIn.hasNextLine()){
			
			smallOriginal[idx] = Integer.parseInt(smallIn.nextLine());
			idx++;
			
		}
		
		idx = 0;
		
		while(mediumIn.hasNextLine()){
			
			mediumOriginal[idx] = Integer.parseInt(mediumIn.nextLine());
			idx++;
			
		}
		
		idx = 0;
		
		while(largeIn.hasNextLine()){
			
			largeOriginal[idx] = Integer.parseInt(largeIn.nextLine());
			idx++;
			
		}
		
		int[] smallTemp = Arrays.copyOf(smallOriginal, smallOriginal.length);
		int[] mediumTemp = Arrays.copyOf(mediumOriginal, mediumOriginal.length);
		int[] largeTemp = Arrays.copyOf(largeOriginal, largeOriginal.length);
		
		System.out.println("STARTING SORTS NOW\n");
		
		System.out.println(smallSize + " " + mediumSize + " " + largeSize);
		
		double startTime = System.currentTimeMillis();
		Insertion.insertionSort(smallOriginal);
		System.out.println("INSERTION ON SMALL.TXT TOOK " + (System.currentTimeMillis() - startTime) / 1000 + " SECONDS.");
		
		FileWriter fw1 = new FileWriter("insertionSmall.txt");
		
		for(Integer i : smallOriginal){
			
			fw1.write(i + "\n");
			
		}
				
		startTime = System.currentTimeMillis();
		Insertion.insertionSort(mediumOriginal);
		System.out.println("INSERTION ON MEDIUM.TXT TOOK " + (System.currentTimeMillis() - startTime) / 1000 + " SECONDS.");
		
		FileWriter fw2 = new FileWriter("insertionMedium.txt");
		
		for(Integer i : mediumOriginal){
			
			fw2.write(i + "\n");
			
		}
		
		startTime = System.currentTimeMillis();
		Insertion.insertionSort(largeOriginal);
		System.out.println("INSERTION ON LARGE.TXT TOOK " + (System.currentTimeMillis() - startTime) / 1000 + " SECONDS.");
		
		FileWriter fw3 = new FileWriter("insertionLarge.txt");
		
		for(Integer i : largeOriginal){
			
			fw3.write(i + "\n");
			
		}
		
		smallOriginal = smallTemp;
		mediumOriginal = mediumTemp;
		largeOriginal = largeTemp;
		
		System.out.println();
		
		startTime = System.currentTimeMillis();
		Selection.selectionSort(smallOriginal);
		System.out.println("SELECTION ON SMALL.TXT TOOK " + (System.currentTimeMillis() - startTime) / 1000 + " SECONDS.");
		
		FileWriter fw4 = new FileWriter("selectionSmall.txt");
		
		for(Integer i : smallOriginal){
			
			fw4.write(i + "\n");
			
		}
				
		startTime = System.currentTimeMillis();
		Selection.selectionSort(mediumOriginal);
		System.out.println("SELECTION ON MEDIUM.TXT TOOK " + (System.currentTimeMillis() - startTime) / 1000 + " SECONDS.");
		
		FileWriter fw5 = new FileWriter("selectionMedium.txt");
		
		for(Integer i : mediumOriginal){
			
			fw5.write(i + "\n");
			
		}
		
		startTime = System.currentTimeMillis();
		Selection.selectionSort(largeOriginal);
		System.out.println("SELECTION ON LARGE.TXT TOOK " + (System.currentTimeMillis() - startTime) / 1000 + " SECONDS.");
		
		FileWriter fw6 = new FileWriter("selectionLarge.txt");
		
		for(Integer i : largeOriginal){
			
			fw6.write(i + "\n");
			
		}
		
		smallOriginal = smallTemp;
		mediumOriginal = mediumTemp;
		largeOriginal = largeTemp;
		
		System.out.println();

		startTime = System.currentTimeMillis();
		Quicksort.quickSort(smallOriginal);
		System.out.println("QUICKSORT ON SMALL.TXT TOOK " + (System.currentTimeMillis() - startTime) / 1000 + " SECONDS.");
		
		FileWriter fw7 = new FileWriter("quickSmall.txt");
		
		for(Integer i : smallOriginal){
			
			fw7.write(i + "\n");
			
		}
				
		startTime = System.currentTimeMillis();
		Quicksort.quickSort(mediumOriginal);
		System.out.println("QUICKSORT ON MEDIUM.TXT TOOK " + (System.currentTimeMillis() - startTime) / 1000 + " SECONDS.");
		
		FileWriter fw8 = new FileWriter("quickMedium.txt");
		
		for(Integer i : mediumOriginal){
			
			fw8.write(i + "\n");
			
		}
		
		startTime = System.currentTimeMillis();
		Quicksort.quickSort(largeOriginal);
		System.out.println("QUICKSORT ON LARGE.TXT TOOK " + (System.currentTimeMillis() - startTime) / 1000 + " SECONDS.");
		
		FileWriter fw9 = new FileWriter("quickLarge.txt");
		
		for(Integer i : largeOriginal){
			
			fw9.write(i + "\n");
			
		}
				
		smallOriginal = smallTemp;
		mediumOriginal = mediumTemp;
		largeOriginal = largeTemp;
		
		System.out.println();
		
		startTime = System.currentTimeMillis();
		Merge.mergeSort(smallOriginal);
		System.out.println("MERGESORT ON SMALL.TXT TOOK " + (System.currentTimeMillis() - startTime) / 1000 + " SECONDS.");
		
		FileWriter fw10 = new FileWriter("mergeSmall.txt");
		
		for(Integer i : smallOriginal){
			
			fw10.write(i + "\n");
			
		}
				
		startTime = System.currentTimeMillis();
		Merge.mergeSort(mediumOriginal);
		System.out.println("MERGESORT ON MEDIUM.TXT TOOK " + (System.currentTimeMillis() - startTime) / 1000 + " SECONDS.");
		
		FileWriter fw11 = new FileWriter("mergeMedium.txt");
		
		for(Integer i : mediumOriginal){
			
			fw11.write(i + "\n");
			
		}
		
		startTime = System.currentTimeMillis();
		Merge.mergeSort(largeOriginal);
		System.out.println("MERGESORT ON LARGE.TXT TOOK " + (System.currentTimeMillis() - startTime) / 1000 + " SECONDS.");
		
		FileWriter fw12 = new FileWriter("mergeMedium.txt");
		
		for(Integer i : largeOriginal){
			
			fw12.write(i + "\n");
			
		}
		
		smallIn.close();
		mediumIn.close();
		largeIn.close();
		
		fw1.close();
		fw2.close();
		fw3.close();
		fw4.close();
		fw5.close();
		fw6.close();
		fw7.close();
		fw8.close();
		fw9.close();
		fw10.close();
		fw11.close();
		fw12.close();
		
	}

}
