package problem2;

import java.util.ArrayList;
import java.util.List;

public class ListAppender {
	
	public static void main(String[] args) {
		
		System.out.println("With iterator:");
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		
		list1.add("1");
		list1.add("2");
		
		list2.add("3");
		
		System.out.println("Appending " + list1.toString() + " and " + list2.toString());
		
		append(list1, list2);
		System.out.println(list1.toString());
		
		ArrayList<String> list3 = new ArrayList<>();
		ArrayList<String> list4 = new ArrayList<>();
		
		list3.add("1");
		list3.add("2");
				
		System.out.println("Appending " + list3.toString() + " and " + list4.toString());
		
		append(list3, list4);
		System.out.println(list3.toString());
		
		ArrayList<String> list5 = new ArrayList<>();
		ArrayList<String> list6 = new ArrayList<>();
		
		list6.add("1");
		list6.add("2");
				
		System.out.println("Appending " + list5.toString() + " and " + list6.toString());
		
		append(list5, list6);
		System.out.println(list5.toString());
		
	}
	
	public static <E> void append(List<E> list1, List<E> list2){
		
		for(int i = 0; i < list2.size(); i++){
			
			list1.add(list2.get(i));
			
		}
		
	}

}