package sorting;

import java.util.ArrayList;

public class Quicksort {
	
	/*
	 * TODO:
	 * Implement quick3 with 3 way partitioning
	 */
	
	/**
	 * Sorts and returns an array using the quick sort algorithm.
	 * @param A The array to sort
	 * @param low The starting index to check. When calling this function for sorting, this should be 0.
	 * @param high The highest index to check. When calling this function for sorting, this should be A.length - 1.
	 * @return The sorted array A.
	 */
	public static int[] quickSort(int[] A, int low, int high){
			
		//Check for illegal cases
		if (A == null || A.length == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
 
		if (low >= high){
			
			throw new IllegalArgumentException("low is greater than high " + low + " " + high);
			
		}
		
		/*
		 * Basic steps are:
		 * 1. Determine pivot point
		 * 2. Partition the array based on pivot point
		 * 3. Call quickSort on each of the partitions
		 */
		
		int i = low;
        int j = high;
        
        // Calculate pivot point as the middle number. Assuming uniform distribution this is fine
        int pivot = A[low + (high - low) / 2];

        // Partition
        while (i <= j) {

        	/*
        	 * Identify a number to the left and right of the pivot that are less than and greater than the pivot point 
        	 * respectively. Exchange those two numbers. 
        	 */
        	
            while (A[i] < pivot) {
            	
                i++; //Keep going on the left side until a less than value is found.
                
            }
            
            while (A[j] > pivot) {
            	
                j--; //Keep going on the right side until a greater than value is found.
                
            }
            
            if (i <= j) { //To make sure that i and j are still on the left and right sides.
            	
            	int temp = A[i]; //Swap
            	A[i] = A[j];
            	A[j] = temp;
            	
                //Move index to next position on both sides
                i++;
                j--;
                
            }
            
        }
        
        //Call quickSort on both of the partitions
        if (low < j){
        	
            quickSort(A, low, j);
        	
        }
        
        if (i < high){
        	
            quickSort(A, i, high);
        	
        }
        
        return A;
        
	}
	
	/**
	 * Calls the quickSort method for general sorting.
	 * @param A The array to sort.
	 * @return A sorted using the quick sort algorithm. 
	 */
	public static int[] quickSort(int[] A){
		
		return quickSort(A, 0, A.length - 1);
		
	}
	
	/**
	 * Sorts and returns an array using the quick sort algorithm.
	 * @param A The array to sort
	 * @param low The starting index to check. When calling this function for sorting, this should be 0.
	 * @param high The highest index to check. When calling this function for sorting, this should be A.length - 1.
	 * @return The sorted array A.
	 */
	public static <E extends Comparable<E>> E[] quickSort(E[] A, int low, int high){
			
		//Check for illegal cases
		if (A == null || A.length == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
 
		if (low >= high){
			
			throw new IllegalArgumentException("low is greater than high " + low + " " + high);
			
		}
		
		/*
		 * Basic steps are:
		 * 1. Determine pivot point
		 * 2. Partition the array based on pivot point
		 * 3. Call quickSort on each of the partitions
		 */
		
		int i = low;
        int j = high;
        
        // Calculate pivot point as the middle number. Assuming uniform distribution this is fine
        E pivot = A[low + (high - low) / 2];

        // Partition
        while (i <= j) {

        	/*
        	 * Identify a number to the left and right of the pivot that are less than and greater than the pivot point 
        	 * respectively. Exchange those two numbers. 
        	 */
        	
            while (A[i].compareTo(pivot) == -1) {
            	
                i++; //Keep going on the left side until a less than value is found.
                
            }
            
            while (A[j].compareTo(pivot) == 1) {
            	
                j--; //Keep going on the right side until a greater than value is found.
                
            }
            
            if (i <= j) { //To make sure that i and j are still on the left and right sides.
            	
            	E temp = A[i]; //Swap
            	A[i] = A[j];
            	A[j] = temp;
            	
                //Move index to next position on both sides
                i++;
                j--;
                
            }
            
        }
        
        //Call quickSort on both of the partitions
        if (low < j){
        	
            quickSort(A, low, j);
        	
        }
        
        if (i < high){
        	
            quickSort(A, i, high);
        	
        }
        
        return A;
				
	}
	
	/**
	 * Calls the quickSort method for general sorting.
	 * @param A The array to sort.
	 * @return A sorted using the quick sort algorithm. 
	 */
	public static <E extends Comparable<E>> E[] quickSort(E[] A){
		
		return quickSort(A, 0, A.length - 1);
		
	}
	
	/**
	 * Sorts and returns an array using the quick sort algorithm.
	 * @param A The array to sort
	 * @param low The starting index to check. When calling this function for sorting, this should be 0.
	 * @param high The highest index to check. When calling this function for sorting, this should be A.length - 1.
	 * @return The sorted array A.
	 */
	public static <E extends Comparable<E>> ArrayList<E> quickSort(ArrayList<E>  A, int low, int high){
			
		//Check for illegal cases
		if (A == null || A.size() == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
 
		if (low >= high){
			
			throw new IllegalArgumentException("low is greater than high " + low + " " + high);
			
		}
		
		/*
		 * Basic steps are:
		 * 1. Determine pivot point
		 * 2. Partition the array based on pivot point
		 * 3. Call quickSort on each of the partitions
		 */
		
		int i = low;
        int j = high;
        
        // Calculate pivot point as the middle number. Assuming uniform distribution this is fine
        E pivot = A.get(low + (high - low) / 2);

        // Partition
        while (i <= j) {

        	/*
        	 * Identify a number to the left and right of the pivot that are less than and greater than the pivot point 
        	 * respectively. Exchange those two numbers. 
        	 */
        	
            while (A.get(i).compareTo(pivot) == -1) {
            	
                i++; //Keep going on the left side until a less than value is found.
                
            }
            
            while (A.get(j).compareTo(pivot) == 1) {
            	
                j--; //Keep going on the right side until a greater than value is found.
                
            }
            
            if (i <= j) { //To make sure that i and j are still on the left and right sides.
            	
            	E temp = A.get(i); //Swap
            	A.set(i, A.get(j));
            	A.set(j, temp);
            	
                //Move index to next position on both sides
                i++;
                j--;
                
            }
            
        }
        
        //Call quickSort on both of the partitions
        if (low < j){
        	
            quickSort(A, low, j);
        	
        }
        
        if (i < high){
        	
            quickSort(A, i, high);
        	
        }
        
        return A;
				
	}
	
	/**
	 * Calls the quickSort method for general sorting.
	 * @param A The array to sort.
	 * @return A sorted using the quick sort algorithm. 
	 */
	public static <E extends Comparable<E>> ArrayList<E> quickSort(ArrayList<E> A){
		
		return quickSort(A, 0, A.size() - 1);
		
	}
	
	/**
	 * Sorts and returns an array using the quick sort algorithm.
	 * @param A The array to sort
	 * @param low The starting index to check. When calling this function for sorting, this should be 0.
	 * @param high The highest index to check. When calling this function for sorting, this should be A.length - 1.
	 * @return The sorted array A.
	 */
	public static float[] quickSort(float[] A, int low, int high){
			
		//Check for illegal cases
		if (A == null || A.length == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
 
		if (low >= high){
			
			throw new IllegalArgumentException("low is greater than high " + low + " " + high);
			
		}
		
		/*
		 * Basic steps are:
		 * 1. Determine pivot point
		 * 2. Partition the array based on pivot point
		 * 3. Call quickSort on each of the partitions
		 */
		
		int i = low;
        int j = high;
        
        // Calculate pivot point as the middle number. Assuming uniform distribution this is fine
        float pivot = A[low + (high - low) / 2];

        // Partition
        while (i <= j) {

        	/*
        	 * Identify a number to the left and right of the pivot that are less than and greater than the pivot point 
        	 * respectively. Exchange those two numbers. 
        	 */
        	
            while (A[i] < pivot) {
            	
                i++; //Keep going on the left side until a less than value is found.
                
            }
            
            while (A[j] > pivot) {
            	
                j--; //Keep going on the right side until a greater than value is found.
                
            }
            
            if (i <= j) { //To make sure that i and j are still on the left and right sides.
            	
            	float temp = A[i]; //Swap
            	A[i] = A[j];
            	A[j] = temp;
            	
                //Move index to next position on both sides
                i++;
                j--;
                
            }
            
        }
        
        //Call quickSort on both of the partitions
        if (low < j){
        	
            quickSort(A, low, j);
        	
        }
        
        if (i < high){
        	
            quickSort(A, i, high);
        	
        }
        
        return A;
				
	}
	
	/**
	 * Calls the quickSort method for general sorting.
	 * @param A The array to sort.
	 * @return A sorted using the quick sort algorithm. 
	 */
	public static float[] quickSort(float[] A){
		
		return quickSort(A, 0, A.length - 1);
		
	}
	
	/**
	 * Sorts and returns an array using the quick sort algorithm.
	 * @param A The array to sort
	 * @param low The starting index to check. When calling this function for sorting, this should be 0.
	 * @param high The highest index to check. When calling this function for sorting, this should be A.length - 1.
	 * @return The sorted array A.
	 */
	public static double[] quickSort(double[] A, int low, int high){
			
		//Check for illegal cases
		if (A == null || A.length == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
 
		if (low >= high){
			
			throw new IllegalArgumentException("low is greater than high " + low + " " + high);
			
		}
		
		/*
		 * Basic steps are:
		 * 1. Determine pivot point
		 * 2. Partition the array based on pivot point
		 * 3. Call quickSort on each of the partitions
		 */
		
		int i = low;
        int j = high;
        
        // Calculate pivot point as the middle number. Assuming uniform distribution this is fine
        double pivot = A[low + (high - low) / 2];

        // Partition
        while (i <= j) {

        	/*
        	 * Identify a number to the left and right of the pivot that are less than and greater than the pivot point 
        	 * respectively. Exchange those two numbers. 
        	 */
        	
            while (A[i] < pivot) {
            	
                i++; //Keep going on the left side until a less than value is found.
                
            }
            
            while (A[j] > pivot) {
            	
                j--; //Keep going on the right side until a greater than value is found.
                
            }
            
            if (i <= j) { //To make sure that i and j are still on the left and right sides.
            	
            	double temp = A[i]; //Swap
            	A[i] = A[j];
            	A[j] = temp;
            	
                //Move index to next position on both sides
                i++;
                j--;
                
            }
            
        }
        
        //Call quickSort on both of the partitions
        if (low < j){
        	
            quickSort(A, low, j);
        	
        }
        
        if (i < high){
        	
            quickSort(A, i, high);
        	
        }
        
        return A;
				
	}
	
	/**
	 * Calls the quickSort method for general sorting.
	 * @param A The array to sort.
	 * @return A sorted using the quick sort algorithm. 
	 */
	public static double[] quickSort(double[] A){
		
		return quickSort(A, 0, A.length - 1);
		
	}
	
	/**
	 * Sorts and returns an array using the quick sort algorithm.
	 * @param A The array to sort
	 * @param low The starting index to check. When calling this function for sorting, this should be 0.
	 * @param high The highest index to check. When calling this function for sorting, this should be A.length - 1.
	 * @return The sorted array A.
	 */
	public static long[] quickSort(long[] A, int low, int high){
			
		//Check for illegal cases
		if (A == null || A.length == 0){
			
			throw new IllegalArgumentException("A is not populated");
			
		}
 
		if (low >= high){
			
			throw new IllegalArgumentException("low is greater than high " + low + " " + high);
			
		}
		
		/*
		 * Basic steps are:
		 * 1. Determine pivot point
		 * 2. Partition the array based on pivot point
		 * 3. Call quickSort on each of the partitions
		 */
		
		int i = low;
        int j = high;
        
        // Calculate pivot point as the middle number. Assuming uniform distribution this is fine
        long pivot = A[low + (high - low) / 2];

        // Partition
        while (i <= j) {

        	/*
        	 * Identify a number to the left and right of the pivot that are less than and greater than the pivot point 
        	 * respectively. Exchange those two numbers. 
        	 */
        	
            while (A[i] < pivot) {
            	
                i++; //Keep going on the left side until a less than value is found.
                
            }
            
            while (A[j] > pivot) {
            	
                j--; //Keep going on the right side until a greater than value is found.
                
            }
            
            if (i <= j) { //To make sure that i and j are still on the left and right sides.
            	
            	long temp = A[i]; //Swap
            	A[i] = A[j];
            	A[j] = temp;
            	
                //Move index to next position on both sides
                i++;
                j--;
                
            }
            
        }
        
        //Call quickSort on both of the partitions
        if (low < j){
        	
            quickSort(A, low, j);
        	
        }
        
        if (i < high){
        	
            quickSort(A, i, high);
        	
        }
        
        return A;
				
	}
	
	/**
	 * Calls the quickSort method for general sorting.
	 * @param A The array to sort.
	 * @return A sorted using the quick sort algorithm. 
	 */
	public static long[] quickSort(long[] A){
		
		return quickSort(A, 0, A.length - 1);
		
	}

}
