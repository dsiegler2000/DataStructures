package problem4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FasterListAppender {
	
	public static void main(String[] args) {
				
		System.out.println("With iterator:");
		ArrayList<String> list1 = new ArrayList<>();
		ArrayList<String> list2 = new ArrayList<>();
		
		list1.add("1");
		list1.add("2");
		
		list2.add("3");
		
		System.out.println("Appending " + list1.toString() + " and " + list2.toString());
		
		appendWithIterator(list1, list2);
		System.out.println(list1.toString());
		
		ArrayList<String> list3 = new ArrayList<>();
		ArrayList<String> list4 = new ArrayList<>();
		
		list3.add("1");
		list3.add("2");
				
		System.out.println("Appending " + list3.toString() + " and " + list4.toString());
		
		appendWithIterator(list3, list4);
		System.out.println(list3.toString());
		
		ArrayList<String> list5 = new ArrayList<>();
		ArrayList<String> list6 = new ArrayList<>();
		
		list6.add("1");
		list6.add("2");
				
		System.out.println("Appending " + list5.toString() + " and " + list6.toString());
		
		appendWithIterator(list5, list6);
		System.out.println(list5.toString());
		
		System.out.println("With foreach:");
		
		list1 = new ArrayList<>();
		list2 = new ArrayList<>();
		
		list1.add("1");
		list1.add("2");
		
		list2.add("3");
		
		System.out.println("Appending " + list1.toString() + " and " + list2.toString());
		
		appendWithForEach(list1, list2);
		System.out.println(list1.toString());
		
		list3 = new ArrayList<>();
		list4 = new ArrayList<>();
		
		list3.add("1");
		list3.add("2");
				
		System.out.println("Appending " + list3.toString() + " and " + list4.toString());
		
		appendWithForEach(list3, list4);
		System.out.println(list3.toString());
		
		list5 = new ArrayList<>();
		list6 = new ArrayList<>();
		
		list6.add("1");
		list6.add("2");
				
		System.out.println("Appending " + list5.toString() + " and " + list6.toString());
		
		appendWithForEach(list5, list6);
		System.out.println(list5.toString());
		
		
	}
	
	public static <E> void appendWithIterator(List<E> list1, List<E> list2){
		
		Iterator<E> iter = list2.iterator();
		
		while(iter.hasNext()){
			
			list1.add(iter.next());
			
		}
		
	}
	
	public static <E> void appendWithForEach(List<E> list1, List<E> list2){
		
		for(E e : list2){
			
			list1.add(e);
			
		}
		
	}

}
