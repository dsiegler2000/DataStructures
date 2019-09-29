package sorting;

import java.util.ArrayList;
import java.util.List;

public class Merge {
	
	/**
	 * Sorts  and returns array A using the merge sort algorithm.
	 * @param A The array to be sorted.
	 * @return A sorted in ascending order.
	 */
	public static int[] mergeSort(int[] A){
		
		return mergeSort(A, 0, A.length - 1, new int[A.length]);
		
	}
	
	/**
	 * The recursive merge sort algorithm for sorting A[start] to A[end] given helper array temp.
	 * @param A The array to be sorted. 
	 * @param start The index to start the sorting at.
	 * @param end The index to end the sorting at.
	 * @param temp A helper array temp (should be empty).
	 * @return The array A with A[start] to A[end] sorted in ascending order. 
	 */
	public static int[] mergeSort(int[] A, int start, int end, int[] temp){
		
		//Check for illegal cases
		if (A == null || A.length == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
		
        if (start < end) { //If start == end then simply return A
        	
        	//Find the middle respecting the start and end values
            int middle = start + (end - start) / 2;
            
            mergeSort(A, start, middle, temp);
            mergeSort(A, middle + 1, end, temp);

            merge(A, start, middle, end, temp);
            
        }
        
        return A;
        		
	}
	
	/**
	 * Merges A[start] to A[middle] and A[middle + 1] to A[end] so that A[start] to A[end] is sorted in ascending order.
	 * It uses the helper variable temp.
	 * @param A The array to be merged.
	 * @param start The starting index of the first subarray.
	 * @param middle The ending index of the first subarray and one less than the starting index of the second subarray.
	 * @param end The ending index of the second subaray.
	 * @param temp A temporary array used for copying A to. It will be written over.
	 * @return A with A[start] to A[middle] and A[middle + 1] to A[end] merged so that A[start] to A[end] is sorted in ascending order.
	 */
	private static int[] merge(int[] A, int start, int middle, int end, int[] temp){

        for (int i = start; i <= end; i++) {
        	
            temp[i] = A[i]; //Copy A to temp
            
        }
        
        //Create some pointers
        int i = start;
        int j = middle + 1;
        int k = start;
        
        while (i <= middle && j <= end) {
        	
            if (temp[i] <= temp[j]) {
            	
                A[k] = temp[i]; //Since temp[i] is less than temp[j], add temp[i] to A and increase i
                i++;
                
            }
            
            else {
            	
                A[k] = temp[j]; //Otherwise add temp[j] to a and increase j
                j++;
                
            }
            
            k++; //Increase k so that when A is added to it is the next index in A
            
        }
        
        while (i <= middle) {
        	
            A[k] = temp[i]; //Add the rest of i to A
            k++;
            i++;
            
        }
        
        return A;
		
	}
	
	/**
	 * Sorts  and returns array A using the merge sort algorithm.
	 * @param A The array to be sorted.
	 * @return A sorted in ascending order.
	 */
	@SuppressWarnings("unchecked")
	public static <E extends Comparable<E>> E[] mergeSort(E[] A){
		
		return mergeSort(A, 0, A.length - 1, (E[]) new Object[A.length]);
		
	}
	
	/**
	 * The recursive merge sort algorithm for sorting A[start] to A[end] given helper array temp.
	 * @param A The array to be sorted. 
	 * @param start The index to start the sorting at.
	 * @param end The index to end the sorting at.
	 * @param temp A helper array temp (should be empty).
	 * @return The array A with A[start] to A[end] sorted in ascending order. 
	 */
	public static <E extends Comparable<E>> E[] mergeSort(E[] A, int start, int end, E[] temp){
		
		//Check for illegal cases
		if (A == null || A.length == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
		
        if (start < end) { //If start == end then simply return A
        	
        	//Find the middle respecting the start and end values
            int middle = start + (end - start) / 2;
            
            mergeSort(A, start, middle, temp);
            mergeSort(A, middle + 1, end, temp);

            merge(A, start, middle, end, temp);
            
        }
        
        return A;
        		
	}
	
	/**
	 * Merges A[start] to A[middle] and A[middle + 1] to A[end] so that A[start] to A[end] is sorted in ascending order.
	 * It uses the helper variable temp.
	 * @param A The array to be merged.
	 * @param start The starting index of the first subarray.
	 * @param middle The ending index of the first subarray and one less than the starting index of the second subarray.
	 * @param end The ending index of the second subaray.
	 * @param temp A temporary array used for copying A to. It will be written over.
	 * @return A with A[start] to A[middle] and A[middle + 1] to A[end] merged so that A[start] to A[end] is sorted in ascending order.
	 */
	private static <E extends Comparable<E>> E[] merge(E[] A, int start, int middle, int end, E[] temp){

        for (int i = start; i <= end; i++) {
        	
            temp[i] = A[i]; //Copy A to temp
            
        }
        
        //Create some pointers
        int i = start;
        int j = middle + 1;
        int k = start;
        
        while (i <= middle && j <= end) {
        	
            if (temp[i].compareTo(temp[j]) == -1 || temp[i].compareTo(temp[j]) == 0) {
            	
                A[k] = temp[i]; //Since temp[i] is less than temp[j], add temp[i] to A and increase i
                i++;
                
            }
            
            else {
            	
                A[k] = temp[j]; //Otherwise add temp[j] to a and increase j
                j++;
                
            }
            
            k++; //Increase k so that when A is added to it is the next index in A
            
        }
        
        while (i <= middle) {
        	
            A[k] = temp[i]; //Add the rest of i to A
            k++;
            i++;
            
        }
        
        return A;
		
	}
	
	/**
	 * Sorts  and returns array A using the merge sort algorithm.
	 * @param A The array to be sorted.
	 * @return A sorted in ascending order.
	 */
	public static <E extends Comparable<E>> List<E> mergeSort(List<E> A){
		
		return mergeSort(A, 0, A.size() - 1, new ArrayList<E>(A.size()));
		
	}
	
	/**
	 * The recursive merge sort algorithm for sorting A[start] to A[end] given helper array temp.
	 * @param A The array to be sorted. 
	 * @param start The index to start the sorting at.
	 * @param end The index to end the sorting at.
	 * @param temp A helper array temp (should be empty).
	 * @return The array A with A[start] to A[end] sorted in ascending order. 
	 */
	public static <E extends Comparable<E>> List<E> mergeSort(List<E> A, int start, int end, List<E> temp){
		
		//Check for illegal cases
		if (A == null || A.size() == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
		
        if (start < end) { //If start == end then simply return A
        	
        	//Find the middle respecting the start and end values
            int middle = start + (end - start) / 2;
            
            mergeSort(A, start, middle, temp);
            mergeSort(A, middle + 1, end, temp);

            merge(A, start, middle, end, temp);
            
        }
        
        return A;
        		
	}
	
	/**
	 * Merges A[start] to A[middle] and A[middle + 1] to A[end] so that A[start] to A[end] is sorted in ascending order.
	 * It uses the helper variable temp.
	 * @param A The array to be merged.
	 * @param start The starting index of the first subarray.
	 * @param middle The ending index of the first subarray and one less than the starting index of the second subarray.
	 * @param end The ending index of the second subaray.
	 * @param temp A temporary array used for copying A to. It will be written over.
	 * @return A with A[start] to A[middle] and A[middle + 1] to A[end] merged so that A[start] to A[end] is sorted in ascending order.
	 */
	private static <E extends Comparable<E>> List<E> merge(List<E> A, int start, int middle, int end, List<E> temp){
		
        for (int i = start; i <= end; i++) {
        	
           try{
        	   
        	   temp.set(i, A.get(i)); //Copy A to temp
        	   
           }catch(IndexOutOfBoundsException e){
        	   
        	 temp.add(A.get(i));
        	   
           }
            
        }
                
        //Create some pointers
        int i = start;
        int j = middle + 1;
        int k = start;
        
        while (i <= middle && j <= end) {
        	
            if (temp.get(i).compareTo(temp.get(j)) == -1 || temp.get(i).compareTo(temp.get(j)) == 0) {
            	
                A.set(k, temp.get(i)); //Since temp[i] is less than temp[j], add temp[i] to A and increase i
                i++;
                
            }
            
            else {
            	
                A.set(k, temp.get(j)); //Otherwise add temp[j] to a and increase j
                j++;
                
            }
            
            k++; //Increase k so that when A is added to it is the next index in A
            
        }
        
        while (i <= middle) {
        	
            A.set(k, temp.get(i)); //Add the rest of i to A
            k++;
            i++;
            
        }
        
        return A;
		
	}
	
	/**
	 * Sorts  and returns array A using the merge sort algorithm.
	 * @param A The array to be sorted.
	 * @return A sorted in ascending order.
	 */
	public static float[] mergeSort(float[] A){
		
		return mergeSort(A, 0, A.length - 1, new float[A.length]);
		
	}
	
	/**
	 * The recursive merge sort algorithm for sorting A[start] to A[end] given helper array temp.
	 * @param A The array to be sorted. 
	 * @param start The index to start the sorting at.
	 * @param end The index to end the sorting at.
	 * @param temp A helper array temp (should be empty).
	 * @return The array A with A[start] to A[end] sorted in ascending order. 
	 */
	public static float[] mergeSort(float[] A, int start, int end, float[] temp){
		
        if (start < end) { //If start == end then simply return A
        	
        	//Find the middle respecting the start and end values
            int middle = start + (end - start) / 2;
            
            mergeSort(A, start, middle, temp);
            mergeSort(A, middle + 1, end, temp);

            merge(A, start, middle, end, temp);
            
        }
        
        return A;
        		
	}
	
	/**
	 * Merges A[start] to A[middle] and A[middle + 1] to A[end] so that A[start] to A[end] is sorted in ascending order.
	 * It uses the helper variable temp.
	 * @param A The array to be merged.
	 * @param start The starting index of the first subarray.
	 * @param middle The ending index of the first subarray and one less than the starting index of the second subarray.
	 * @param end The ending index of the second subaray.
	 * @param temp A temporary array used for copying A to. It will be written over.
	 * @return A with A[start] to A[middle] and A[middle + 1] to A[end] merged so that A[start] to A[end] is sorted in ascending order.
	 */
	private static float[] merge(float[] A, int start, int middle, int end, float[] temp){

        for (int i = start; i <= end; i++) {
        	
            temp[i] = A[i]; //Copy A to temp
            
        }
        
        //Create some pointers
        int i = start;
        int j = middle + 1;
        int k = start;
        
        while (i <= middle && j <= end) {
        	
            if (temp[i] <= temp[j]) {
            	
                A[k] = temp[i]; //Since temp[i] is less than temp[j], add temp[i] to A and increase i
                i++;
                
            }
            
            else {
            	
                A[k] = temp[j]; //Otherwise add temp[j] to a and increase j
                j++;
                
            }
            
            k++; //Increase k so that when A is added to it is the next index in A
            
        }
        
        while (i <= middle) {
        	
            A[k] = temp[i]; //Add the rest of i to A
            k++;
            i++;
            
        }
        
        return A;
		
	}
	
	/**
	 * Sorts  and returns array A using the merge sort algorithm.
	 * @param A The array to be sorted.
	 * @return A sorted in ascending order.
	 */
	public static double[] mergeSort(double[] A){
		
		return mergeSort(A, 0, A.length - 1, new double[A.length]);
		
	}
	
	/**
	 * The recursive merge sort algorithm for sorting A[start] to A[end] given helper array temp.
	 * @param A The array to be sorted. 
	 * @param start The index to start the sorting at.
	 * @param end The index to end the sorting at.
	 * @param temp A helper array temp (should be empty).
	 * @return The array A with A[start] to A[end] sorted in ascending order. 
	 */
	public static double[] mergeSort(double[] A, int start, int end, double[] temp){
		
        if (start < end) { //If start == end then simply return A
        	
        	//Find the middle respecting the start and end values
            int middle = start + (end - start) / 2;
            
            mergeSort(A, start, middle, temp);
            mergeSort(A, middle + 1, end, temp);

            merge(A, start, middle, end, temp);
            
        }
        
        return A;
        		
	}
	
	/**
	 * Merges A[start] to A[middle] and A[middle + 1] to A[end] so that A[start] to A[end] is sorted in ascending order.
	 * It uses the helper variable temp.
	 * @param A The array to be merged.
	 * @param start The starting index of the first subarray.
	 * @param middle The ending index of the first subarray and one less than the starting index of the second subarray.
	 * @param end The ending index of the second subaray.
	 * @param temp A temporary array used for copying A to. It will be written over.
	 * @return A with A[start] to A[middle] and A[middle + 1] to A[end] merged so that A[start] to A[end] is sorted in ascending order.
	 */
	private static double[] merge(double[] A, int start, int middle, int end, double[] temp){

        for (int i = start; i <= end; i++) {
        	
            temp[i] = A[i]; //Copy A to temp
            
        }
        
        //Create some pointers
        int i = start;
        int j = middle + 1;
        int k = start;
        
        while (i <= middle && j <= end) {
        	
            if (temp[i] <= temp[j]) {
            	
                A[k] = temp[i]; //Since temp[i] is less than temp[j], add temp[i] to A and increase i
                i++;
                
            }
            
            else {
            	
                A[k] = temp[j]; //Otherwise add temp[j] to a and increase j
                j++;
                
            }
            
            k++; //Increase k so that when A is added to it is the next index in A
            
        }
        
        while (i <= middle) {
        	
            A[k] = temp[i]; //Add the rest of i to A
            k++;
            i++;
            
        }
        
        return A;
		
	}
	
	/**
	 * Sorts  and returns array A using the merge sort algorithm.
	 * @param A The array to be sorted.
	 * @return A sorted in ascending order.
	 */
	public static long[] mergeSort(long[] A){
		
		return mergeSort(A, 0, A.length - 1, new long[A.length]);
		
	}
	
	/**
	 * The recursive merge sort algorithm for sorting A[start] to A[end] given helper array temp.
	 * @param A The array to be sorted. 
	 * @param start The index to start the sorting at.
	 * @param end The index to end the sorting at.
	 * @param temp A helper array temp (should be empty).
	 * @return The array A with A[start] to A[end] sorted in ascending order. 
	 */
	public static long[] mergeSort(long[] A, int start, int end, long[] temp){
		
        if (start < end) { //If start == end then simply return A
        	
        	//Find the middle respecting the start and end values
            int middle = start + (end - start) / 2;
            
            mergeSort(A, start, middle, temp);
            mergeSort(A, middle + 1, end, temp);

            merge(A, start, middle, end, temp);
            
        }
        
        return A;
        		
	}
	
	/**
	 * Merges A[start] to A[middle] and A[middle + 1] to A[end] so that A[start] to A[end] is sorted in ascending order.
	 * It uses the helper variable temp.
	 * @param A The array to be merged.
	 * @param start The starting index of the first subarray.
	 * @param middle The ending index of the first subarray and one less than the starting index of the second subarray.
	 * @param end The ending index of the second subaray.
	 * @param temp A temporary array used for copying A to. It will be written over.
	 * @return A with A[start] to A[middle] and A[middle + 1] to A[end] merged so that A[start] to A[end] is sorted in ascending order.
	 */
	private static long[] merge(long[] A, int start, int middle, int end, long[] temp){

        for (int i = start; i <= end; i++) {
        	
            temp[i] = A[i]; //Copy A to temp
            
        }
        
        //Create some pointers
        int i = start;
        int j = middle + 1;
        int k = start;
        
        while (i <= middle && j <= end) {
        	
            if (temp[i] <= temp[j]) {
            	
                A[k] = temp[i]; //Since temp[i] is less than temp[j], add temp[i] to A and increase i
                i++;
                
            }
            
            else {
            	
                A[k] = temp[j]; //Otherwise add temp[j] to a and increase j
                j++;
                
            }
            
            k++; //Increase k so that when A is added to it is the next index in A
            
        }
        
        while (i <= middle) {
        	
            A[k] = temp[i]; //Add the rest of i to A
            k++;
            i++;
            
        }
        
        return A;
		
	}

}
