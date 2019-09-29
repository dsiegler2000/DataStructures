package heapsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Heapsort {
	
	private static int N;
	
	public static int[] heapsort(int[] a){
		
		N = 0;
		
		a = heapify(a);
		
		for(int i = N; i > 0; i--){
			
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			
			N--;
			
			a = reheapDown(a, 0);
			
		}
		
		return a;
		
	}
	
	public static int[] heapify(int[] a){
		
		N = a.length - 1;
		
		for(int i = N / 2; i >= 0; i--){
			
			a = reheapDown(a, i);
			
		}
		
		return a;
		
	}
	
	public static int[] reheapDown(int[] a, int i){
		
		int l = i * 2;
		int r = i * 2 + 1;
		
		int max = i;
		
		if(l <= N && a[l] > a[i]){
			
			max = l;
			
		}
		
		if(r <= N && a[r] > a[max]){
			
			max = r;
			
		}
		
		if(max != i){
			
			int temp = a[i];
			a[i] = a[max];
			a[max] = temp;
			
			a = reheapDown(a, max);
			
		}
		
		return a;
		
	}
	
	public static void main(String[] args) {

		if(args.length != 1){
			
			System.err.println("Must pass a file!");
			System.exit(1);
			
		}
		
		Scanner in = new Scanner(args[0]);
		
		ArrayList<Integer> nums = new ArrayList<>();
		
		while(in.hasNextLine()){
			
			nums.add(Integer.parseInt(in.nextLine()));
			
		}
		
		in.close();
				
		System.out.println(Arrays.toString(heapsort(nums.stream().mapToInt(i->i).toArray())));

	}

}
