package sorting;

import java.util.ArrayList;

public class Insertion {
	
	public static int[] insertionSort(int[] A){
		
		//Check for illegal cases
		if (A == null || A.length == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
		
		for(int i = 0; i < A.length; i++){
			
			int j = i;
			
			while(j > 0 && A[j - 1] > A[j]){
				
				int temp = A[j];
				A[j] = A[j - 1];
				A[j - 1] = temp;
				
				j--;
				
			}
			
		}
		
		return A;
		
	}
	
	public static <E extends Comparable<E>> E[] insertionSort(E[] A){
		
		//Check for illegal cases
		if (A == null || A.length == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
		
		for(int i = 0; i < A.length; i++){
			
			int j = i;
			
			while(j > 0 && A[j - 1].compareTo(A[j]) == 1){
								
				E temp = A[j];
				A[j] = A[j - 1];
				A[j - 1] = temp;
				
				j--;
				
			}
			
		}
		
		return (E[]) A;
		
	}
	
	public static <E extends Comparable<E>> ArrayList<E> insertionSort(ArrayList<E> A){
		
		//Check for illegal cases
		if (A == null || A.size() == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
		
		for(int i = 0; i < A.size(); i++){
			
			int j = i;
			
			while(j > 0 && A.get(j - 1).compareTo(A.get(j)) == 1){
				
				E temp = A.get(j);
				A.set(j, A.get(j - 1));
				A.set(j - 1, temp);
				
				j--;
				
			}
			
		}
		
		return A;
		
	}
	
	public static float[] insertionSort(float[] A){
		
		//Check for illegal cases
		if (A == null || A.length == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
		
		for(int i = 0; i < A.length; i++){
			
			int j = i;
			
			while(j > 0 && A[j - 1] > A[j]){
				
				float temp = A[j];
				A[j] = A[j - 1];
				A[j - 1] = temp;
				
				j--;
				
			}
			
		}
		
		return A;
		
	}
	
	public static double[] insertionSort(double[] A){
		
		//Check for illegal cases
		if (A == null || A.length == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
		
		for(int i = 0; i < A.length; i++){
			
			int j = i;
			
			while(j > 0 && A[j - 1] > A[j]){
				
				double temp = A[j];
				A[j] = A[j - 1];
				A[j - 1] = temp;
				
				j--;
				
			}
			
		}
		
		return A;
		
	}
	
	public static long[] insertionSort(long[] A){
		
		//Check for illegal cases
		if (A == null || A.length == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
		
		for(int i = 0; i < A.length; i++){
			
			int j = i;
			
			while(j > 0 && A[j - 1] > A[j]){
				
				long temp = A[j];
				A[j] = A[j - 1];
				A[j - 1] = temp;
				
				j--;
				
			}
			
		}
		
		return A;
		
	}

}