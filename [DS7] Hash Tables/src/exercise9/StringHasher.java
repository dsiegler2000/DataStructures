package exercise9;

import java.util.HashSet;

public class StringHasher {
	
	private static String[] words = ("A hash table has sixty entries. Devise and test"
			+ " a hash function for English words such that all the different "
			+ "words from this paragraph are hashed into the table with no more"
			+ " than four collisions. Do not call any hashCode methods.").split(" ");
			
	public static void main(String[] args){
				
		HashSet<Integer> hashed = new HashSet<>();

		int collisions = 0;
		
		for(String s : words){
			
			int hash = hash(s);
			
			if(hashed.contains(hash)){
				
				collisions++;
				
			}
			
			else{
				
				hashed.add(hash);
				
			}
			
		}
		
		System.out.println("Number of collisions: " + collisions + " - 4 (because the words hash, table, words, and the occur twice) = " + (collisions - 4));
		
		hashed = new HashSet<>();
		collisions = 0;
		
		for(String s : words){
			
			int hash = basicHash(s);
			
			if(hashed.contains(hash)){
				
				collisions++;
				
			}
			
			else{
				
				hashed.add(hash);
				
			}
			
		}
		
		System.out.println("Number of collisions for Litvin's hash function: " + collisions);
		
				
		class Test{
						
			@Override
			public int hashCode(){
				
				return 69;
				
			}
			
			@Override
			public boolean equals(Object o){

				return false;
				
			}
			
		}
		
		HashSet<Test> set = new HashSet<>();
		
		set.add(new Test());
		set.add(new Test());
		
		System.out.println(set.size());
		
	}
	
	public static int hash(String s){
		
		int hash = 0;
		int i = 0;
		
		for(hash = i; i < s.length(); i++){
			
			hash += s.charAt(i);
			hash += (hash << 5);
			hash ^= (hash >> 9);
			
		}
		
		hash += (hash << 7);
		hash ^= (hash >> 10);
		hash += (hash << 15);

	   return hash % 60;
		
	}
	
	public static int basicHash(String s){
		
		return Math.abs(s.hashCode()) % 60;
		
	}
	
}
