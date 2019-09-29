package sorting;

import java.util.ArrayList;

public class Selection {
	
	/**
	 * Sorts array A using the selection sort algorithm
	 * @param A The array to be sorted.
	 * @return The array A sorted using the selection sort algorithm
	 */
	public static int[] selectionSort(int[] A){
		
		//Check for illegal cases
		if (A == null || A.length == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
		
		int i;
		int j;
		
		for(i = 0; i < A.length; i++){
			
			int min = i;
			
			for(j = i + 1; j < A.length; j++){
				
				if(A[j] < A[min]){
					
					min = j;
					
				}
				
			}
			
			if(min != i){
				
				int temp = A[i];
				A[i] = A[min];
				A[min] = temp;
				
			}
			
		}
		
		return A;
				
	}
	
	/**
	 * Sorts array A using the selection sort algorithm
	 * @param A The array to be sorted.
	 * @return The array A sorted using the selection sort algorithm
	 */
	public static <E extends Comparable<E>> E[] selectionSort(E[] A){
		
		//Check for illegal cases
		if (A == null || A.length == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
		
		int i;
		int j;
		
		for(i = 0; i < A.length; i++){
			
			int min = i;
			
			for(j = i + 1; j < A.length; j++){
				
				if(A[j].compareTo(A[min]) == -1){
					
					min = j;
					
				}
				
			}
			
			if(min != i){
				
				E temp = A[i];
				A[i] = A[min];
				A[min] = temp;
				
			}
			
		}
		
		return A;
				
	}
	
	/**
	 * Sorts array A using the selection sort algorithm
	 * @param A The array to be sorted.
	 * @return The array A sorted using the selection sort algorithm
	 */
	public static <E extends Comparable<E>> ArrayList<E> selectionSort(ArrayList<E> A){
		
		//Check for illegal cases
		if (A == null || A.size() == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
		
		int i;
		int j;
		
		for(i = 0; i < A.size(); i++){
			
			int min = i;
			
			for(j = i + 1; j < A.size(); j++){
				
				if(A.get(j).compareTo(A.get(min)) == -1){
					
					min = j;
					
				}
				
			}
			
			if(min != i){
				
				E temp = A.get(i);
				A.set(i, A.get(min));
				A.set(min, temp);
				
			}
			
		}
		
		return A;
				
	}
	
	/**
	 * Sorts array A using the selection sort algorithm
	 * @param A The array to be sorted.
	 * @return The array A sorted using the selection sort algorithm
	 */
	public static float[] selectionSort(float[] A){
		
		//Check for illegal cases
		if (A == null || A.length == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
		
		int i;
		int j;
		
		for(i = 0; i < A.length; i++){
			
			int min = i;
			
			for(j = i + 1; j < A.length; j++){
				
				if(A[j] < A[min]){
					
					min = j;
					
				}
				
			}
			
			if(min != i){
				
				float temp = A[i];
				A[i] = A[min];
				A[min] = temp;
				
			}
			
		}
		
		return A;
				
	}
	
	/**
	 * Sorts array A using the selection sort algorithm
	 * @param A The array to be sorted.
	 * @return The array A sorted using the selection sort algorithm
	 */
	public static double[] selectionSort(double[] A){
		
		//Check for illegal cases
		if (A == null || A.length == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
		
		int i;
		int j;
		
		for(i = 0; i < A.length; i++){
			
			int min = i;
			
			for(j = i + 1; j < A.length; j++){
				
				if(A[j] < A[min]){
					
					min = j;
					
				}
				
			}
			
			if(min != i){
				
				double temp = A[i];
				A[i] = A[min];
				A[min] = temp;
				
			}
			
		}
		
		return A;
				
	}
	
	/**
	 * Sorts array A using the selection sort algorithm
	 * @param A The array to be sorted.
	 * @return The array A sorted using the selection sort algorithm
	 */
	public static long[] selectionSort(long[] A){
		
		//Check for illegal cases
		if (A == null || A.length == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
		
		int i;
		int j;
		
		for(i = 0; i < A.length; i++){
			
			int min = i;
			
			for(j = i + 1; j < A.length; j++){
				
				if(A[j] < A[min]){
					
					min = j;
					
				}
				
			}
			
			if(min != i){
				
				long temp = A[i];
				A[i] = A[min];
				A[min] = temp;
				
			}
			
		}
		
		return A;
				
	}

}
