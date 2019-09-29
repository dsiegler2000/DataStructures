package lab2;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

import node.ListNode;

public class SinglyLinkedListWithTail<E> implements Iterable<E>{
			
	public static void main(String[] args)
    {

	    System.out.println("*******************************************************");
	    System.out.println("*******************************************************");
	    System.out.print("\n" + "** Execution begins @ ");
	    System.out.println(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME) + " **\n");
	    System.out.println("*******************************************************");
	    System.out.println("*******************************************************");
	
	    Scanner keyboard = new Scanner(System.in);
	
	    Object[] numbers = new Object[4];
	    numbers[0] = new Integer(1);
	    numbers[1] = new Integer(2);
	    numbers[2] = new Integer(3);
	    numbers[3] = new Integer(4);
	
	    System.out.println("** Checking creation of SinglyLinkedList of 1,2,3,4 **");
	    SinglyLinkedListWithTail<Object> myList = new SinglyLinkedListWithTail<>(numbers);
	    System.out.println(myList);
	    if(myList.toString().equals("[1, 2, 3, 4]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("** Checking myList.contains() of found and not found elements **");
	    System.out.println("Looking for 4: " + myList.contains(4));
	    System.out.println("Looking for 5: " + myList.contains(5));
	    if(myList.toString().equals("[1, 2, 3, 4]") && myList.contains(4) && !(myList.contains(5)) )
	        System.out.println("PASSED\n");
	    else
	        System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("** Checking myList.add(Object) to a non-empty list **");
	    System.out.println("Adding 6");
	    myList.add(6);
	    System.out.println(myList);
	    if(myList.toString().equals("[1, 2, 3, 4, 6]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("Press enter to continue");
	
	    System.out.println("** Checking myList.indexOf(Object) of found and not found elements **");
	    System.out.println("Looking for 4: " + myList.indexOf(4));
	    System.out.println("Looking for 5: " + myList.indexOf(5));
	    System.out.println(myList);
	    if(myList.toString().equals("[1, 2, 3, 4, 6]") && (myList.indexOf(4)>=0) && (myList.indexOf(5) < 0) )
	        System.out.println("PASSED\n");
	    else
	        System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("** Checking myList.get(i) with valid values **");
	    System.out.println("get(0) is " + myList.get(0));
	    System.out.println("get(3) is " + myList.get(3));
	
	    System.out.println("** Checking myList.get(i) with an invalid value **");
	
	    boolean badDayAtTheOffice = false;
	    try
	    {
	        System.out.println("get(20) is (invalid) " + myList.get(20));
	    }
	    catch (IndexOutOfBoundsException e)
	    {
	        System.out.println("get(20) correctly threw IndexOutOfBoundsException");
	    }
	    catch (Exception f)
	    {
	        System.out.println("get(20) threw an invalid exception");
	        badDayAtTheOffice = true;
	    }
	
	    System.out.println(myList);
	    if( myList.toString().equals("[1, 2, 3, 4, 6]") &&
	            myList.get(0).toString().equals("1")        &&
	            myList.get(3).toString().equals("4")        &&
	            badDayAtTheOffice == false
	            )
	        System.out.println("PASSED\n");
	    else
	        System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("Press enter to continue");
	
	    System.out.println("** Checking myList.remove(Object) with valid and invalid values **");
	    if(myList.remove(new Integer(720)))
	        System.out.println("myList.remove(720) caused UNIT TEST FAILED");
	    else
	        System.out.println("myList.remove(720) remove [not found]");
	
	    if(myList.remove(new Integer(3)))
	        System.out.println("myList.remove(3) removed 3");
	    else
	        System.out.println("myList.remove(3) caused UNIT TEST FAILED");
	
	    if(myList.remove(new Integer(3)))
	        System.out.println("myList.remove(3) caused UNIT TEST FAILED");
	    else
	        System.out.println("myList.remove(3) remove [not found]");
	    System.out.println(myList);
	    if(myList.toString().equals("[1, 2, 4, 6]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("** Checking myList.remove(Object) to remove first element **");
	    if(myList.remove(new Integer(1)))
	        System.out.println("myList.remove(1) removed 1");
	    else
	        System.out.println("myList.remove(1) caused UNIT TEST FAILED");
	    System.out.println(myList+ "\n");
	
	    System.out.println("** Checking myList.remove(Object) to remove last element **");
	    if(myList.remove(new Integer(6)))
	        System.out.println("myList.remove(6) removed 6");
	    else
	        System.out.println("myList.remove(6) caused UNIT TEST FAILED");
	    System.out.println(myList);
	    if(myList.toString().equals("[2, 4]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("Press enter to continue");
	
	    System.out.println("** Checking myList.remove(Object) to create an empty list **");
	    if(myList.remove(new Integer(2)))
	        System.out.println("myList.remove(2) removed 2");
	    else
	        System.out.println("myList.remove(2) caused UNIT TEST FAILED");
	    if(myList.remove(new Integer(4)))
	        System.out.println("myList.remove(4) removed 4");
	    else
	        System.out.println("myList.remove(4) caused UNIT TEST FAILED");
	    System.out.println(myList + "\n");
	
	    System.out.println("** Checking myList.remove(Object) removing from an empty list **");
	    if(myList.remove(new Integer(2)))
	        System.out.println("myList.remove(2) caused UNIT TEST FAILED");
	    else
	        System.out.println("myList.remove(2) remove [not found]");
	    System.out.println(myList);
	    if(myList.toString().equals("[]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("Press enter to continue");
	
	    System.out.println("** Checking myList.add(Object) to an empty list **");
	    System.out.println("Adding 6");
	    myList.add(6);
	    System.out.println(myList);
	    if(myList.toString().equals("[6]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("** Checking myList.add(i, Object) to the front with one node **");
	    System.out.println("Calling myList.add(0, 2)");
	    myList.add(0,2);
	    System.out.println(myList);
	    if(myList.toString().equals("[2, 6]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("** Checking myList.add(i, Object) to the middle **");
	    System.out.println("Calling myList.add(1, 4)");
	    myList.add(1,4);
	    System.out.println(myList);
	    if(myList.toString().equals("[2, 4, 6]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("** Checking myList.add(i, Object) to the end **");
	    System.out.println("Calling myList.add(3, 8)");
	    myList.add(3,8);
	    System.out.println(myList);
	    if(myList.toString().equals("[2, 4, 6, 8]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("** Checking myList.add(i, Object) to the middle **");
	    System.out.println("Calling myList.add(2, 9)");
	    myList.add(2,9);
	    System.out.println(myList);
	    if(myList.toString().equals("[2, 4, 9, 6, 8]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("Press enter to continue");
	
	    System.out.println("** Checking myList.add(i, Object) with an invalid index number **");
	    System.out.println("Calling myList.add(12, 19)");
	    try
	    {
	        myList.add(12,19);
	    }
	    catch(IndexOutOfBoundsException e)
	    {
	        System.out.println("myList.add(12, 19) correctly threw an IndexOutOfBoundsException");
	
	    }
	    catch (Exception f)
	    {
	        System.out.println("myList.add(12, 19) threw an invalid exception");
	        System.out.println("UNIT TEST FAILED");
	    }
	    System.out.println(myList);
	    if(myList.toString().equals("[2, 4, 9, 6, 8]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("Press enter to continue");
	
	    System.out.println("** Removing all but 9 **");
	    myList.remove(new Integer(2));
	    myList.remove(new Integer(4));
	    myList.remove(new Integer(6));
	    myList.remove(new Integer(8));
	    System.out.println(myList);
	    if(myList.toString().equals("[9]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("** Checking myList.add(i, Object) to the end with one node **");
	    System.out.println("Calling myList.add(1, 21)");
	    myList.add(1,21);
	    System.out.println(myList);
	    if(myList.toString().equals("[9, 21]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("Press enter to continue");
	
	    System.out.println("*** Resetting list to [1, 2, 3, 4, 6] ***");
	    myList.remove(new Integer(9));
	    myList.remove(new Integer(21));
	    myList.add(1);
	    myList.add(2);
	    myList.add(3);
	    myList.add(4);
	    myList.add(6);
	    if(myList.toString().equals("[1, 2, 3, 4, 6]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("Press enter to continue");
	
	    System.out.println("** Checking myList.remove(i) with an invalid value **");
	    try
	    {
	        if(myList.remove(720) != null)
	            System.out.println("myList.remove(720) caused UNIT TEST FAILED");
	        else
	            System.out.println("myList.remove(720) remove [not found]");
	
	    }catch(IndexOutOfBoundsException e)
	    {
	        System.out.println("myList.remove(720) correctly threw IndexOutOfBoundsException");
	    }
	    catch (Exception f)
	    {
	        System.out.println("myList.remove(720) threw an incorrect exception");
	        System.out.println("UNIT TEST FAILED");
	    }
	
	    System.out.println("** Checking myList.remove(i) with valid values **");
	    if(myList.remove(2).equals(3))
	        System.out.println("myList.remove(2) removed 3");
	    else
	        System.out.println("myList.remove(2) caused UNIT TEST FAILED");
	
	    System.out.println(myList);
	    if(myList.toString().equals("[1, 2, 4, 6]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("** Checking myList.remove(i) to remove first element **");
	    if(myList.remove(0).equals(1))
	        System.out.println("myList.remove(0) removed 1");
	    else
	        System.out.println("myList.remove(0) caused UNIT TEST FAILED");
	    System.out.println(myList+ "\n");
	
	    System.out.println("** Checking myList.remove(i) to remove last element **");
	    if(myList.remove(2).equals(6))
	        System.out.println("myList.remove(2) removed 6");
	    else
	        System.out.println("myList.remove(2) caused UNIT TEST FAILED");
	    System.out.println(myList);
	    if(myList.toString().equals("[2, 4]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("Press enter to continue");
	
	    System.out.println("** Checking myList.remove(i) to create an empty list **");
	    if(myList.remove(0).equals(2))
	        System.out.println("myList.remove(0) removed 2");
	    else
	        System.out.println("myList.remove(0) caused UNIT TEST FAILED");
	
	    if(myList.remove(0).equals(4))
	        System.out.println("myList.remove(0) removed 4");
	    else
	        System.out.println("myList.remove(0) caused UNIT TEST FAILED");
	    System.out.println(myList+ "\n");
	    if(myList.toString().equals("[]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("** Checking myList.remove(i) removing from an empty list **");
	    try {
	        if(myList.remove(0) != null)
	            System.out.println("myList.remove(0) caused UNIT TEST FAILED");
	        else
	            System.out.println("myList.remove(0) passed");
	
	    }
	    catch (IndexOutOfBoundsException e)
	    {
	        System.out.println("myList.remove(0) correctly threw IndexOutOfBoundsException");
	    }
	    catch (Exception f)
	    {
	        System.out.println("myList.remove(0) threw an incorrect exception");
	        System.out.println("UNIT TEST FAILED");
	    }
	
	
	    System.out.println(myList);
	    if(myList.toString().equals("[]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("Press enter to continue");
	
	    System.out.println("** Checking myList.set(i, Object) with an empty list **");
	    try {
	        System.out.println("Calling myList.set(0, 2)");
	        if (myList.set(0, 2) != null)
	            System.out.println("myList.set(0, 2) caused UNIT TEST FAILED");
	        else
	            System.out.println("myList.set(0, 2) passed");
	    }catch(IndexOutOfBoundsException e)
	    {
	        System.out.println("myList.set(0, 2) correctly threw IndexOutOfBoundsException");
	    }
	    catch(Exception f)
	    {
	        System.out.println("myList.set(0, 2) threw an incorrect exception");
	        System.out.println("UNIT TEST FAILED");
	
	    }
	    System.out.println(myList);
	    if(myList.toString().equals("[]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("Press enter to continue");
	
	    System.out.println("*** Adding 1 node to list ***");
	    myList.add(1);
	    System.out.println(myList);
	    if(myList.toString().equals("[1]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("** Checking myList.set(i, Object) with a one node list **");
	    System.out.println("Calling myList.set(0, 2)");
	    if(myList.set(0,2).equals(1))
	        System.out.println("myList.set(0, 2) passed");
	    else
	        System.out.println("myList.set(0, 2) caused UNIT TEST FAILED");
	    System.out.println(myList);
	    if(myList.toString().equals("[2]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("*** Resetting list to [1, 2, 3, 4, 6] ***");
	    myList.set(0,1);
	    myList.add(2);
	    myList.add(3);
	    myList.add(4);
	    myList.add(6);
	    System.out.println(myList);
	    if(myList.toString().equals("[1, 2, 3, 4, 6]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("Press enter to continue");
	
	    System.out.println("** Checking myList.set(i, Object) with the first node of a full list **");
	    System.out.println("Calling myList.set(0, 9)");
	    if(myList.set(0,9).equals(1))
	        System.out.println("myList.set(0, 9) passed");
	    else
	        System.out.println("myList.set(0, 9) caused UNIT TEST FAILED");
	    System.out.println(myList);
	    if(myList.toString().equals("[9, 2, 3, 4, 6]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("** Checking myList.set(i, Object) with the last node of a full list **");
	    System.out.println("Calling myList.set(4, 17)");
	    if(myList.set(4,17).equals(6))
	        System.out.println("myList.set(4, 17) passed");
	    else
	        System.out.println("myList.set(4, 17) caused UNIT TEST FAILED");
	    System.out.println(myList);
	    if(myList.toString().equals("[9, 2, 3, 4, 17]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("** Checking myList.set(i, Object) with an in-between node of a full list **");
	    System.out.println("Calling myList.set(2, 88)");
	    if(myList.set(2,88).equals(3))
	        System.out.println("myList.set(2, 88) passed");
	    else
	        System.out.println("myList.set(2, 88) caused UNIT TEST FAILED");
	    System.out.println(myList);
	    if(myList.toString().equals("[9, 2, 88, 4, 17]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("** Checking myList.set(i, Object) with an invalid value **");
	    System.out.println("Calling myList.set(431, 7)");
	    try
	    {
	        if(myList.set(431,7) == null)
	            System.out.println("myList.set(431, 7) passed");
	        else
	            System.out.println("myList.set(431, 7) caused UNIT TEST FAILED");
	    }catch(IndexOutOfBoundsException e)
	    {
	        System.out.println("myList.set(431, 7) correctly threw an IndexOutOfBoundsException");
	
	    }
	    catch(Exception e){
	        System.out.println("myList.set(431, 7) threw an incorrect threw an exception");
	        System.out.println("UNIT TEST FAILED.");
	
	    }
	    System.out.println(myList);
	    if(myList.toString().equals("[9, 2, 88, 4, 17]")) System.out.println("PASSED\n"); else System.out.println("UNIT TEST FAILED\n");
	
	    System.out.println("*******************************************************");
	    System.out.println("*******************************************************");
	    System.out.println("***           UNIT TESTING ENDS                     ***");
	    System.out.println("*******************************************************");
	    System.out.println("*******************************************************");
	    
	    keyboard.close();
	    
	}
	
	/**
	 * A pointer to the head node.
	 */
	private ListNode<E> head;
	
	/**
	 * A pointer to the tail node.
	 */
	private ListNode<E> tail;
	
	/**
	 * The size of the linked list.
	 */
	private int size;
	
	/**
	 * Constructs an empty linked list with the head as a null sentient.
	 */
	public SinglyLinkedListWithTail(){
		
		this.head = new ListNode<E>();
		this.tail = new ListNode<E>();
		this.size = 0;
		
	}
	
	/**
	 * Constructs a linked list with {@code values} values.
	 * @param values The values to be contained in the linked list in that order. 
	 */
	public SinglyLinkedListWithTail(E[] values){
		
		ListNode<E> next = null;
		
		for(E value : values){
			
			ListNode<E> node = new ListNode<E>(value, null);
			
			if(head == null){
				
				head = node;
				
			}
			
			else{
				
				next.setNext(node);
				
			}
			
			next = node;
			
			this.tail = node;
			
		}
		
		this.size = values.length;
		
	}
	
	/**
	 * Predicate to check whether the linked list is empty or not.
	 * @return True if the linked list is empty and false otherwise.
	 */
	public boolean isEmpty(){
		
		return size == 0;
		
	}
	
	/**
	 * Links (adds) {@code item} to the end of the linked list. 
	 * @param item The item to link (add) onto the end of the list.
	 */
	public void add(E item){
				
		if(this.isEmpty()){
			
			this.head = new ListNode<E>(item);
			this.tail = head;
			size++;
						
			return;
			
		}
		
		ListNode<E> next = head;
		
		for(int i = 0; i < size - 1; i++){
			
			next = next.getNext();
						
		}
		
		ListNode<E> toAdd = new ListNode<E>(item, null);
		next.setNext(toAdd);
		this.tail = toAdd;
		
		size++;
			
	}
	
	/**
	 * Adds {@code object} in the {@code i}th position in the linked list. 
	 * @param i The index to add {@code object}.
	 * @param object The object to add.
	 * @throws IndexOutOfBoundsException If {@code this.size() <= i || i < 0}.
	 */
	public void add(int i, E object){
		
		if(this.size < i || i < 0){
			
			throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.size);
			
		}
		
		ListNode<E> node = this.head;
		
		if(i == 0){
			
			ListNode<E> newHead = new ListNode<>(object, this.head);
			this.head = newHead;
			
			size++;
			
			return;
			
		}
		
		if(i == size){
			
			ListNode<E> newHead = new ListNode<>(object, null);			
			this.tail.setNext(newHead);
			this.tail = newHead;
			
			size++;
			
			return;
			
		}
				
		for(int idx = 0; idx < i - 1; idx++){
			
			node = node.getNext();
			
		}
		
		ListNode<E> next = node.getNext();
		
		node.setNext(new ListNode<E>(object, next));
		
		size++;
		
	}
	
	/**
	 * Appends another list to this list.
	 * @param otherList The other list to append.
	 */
	public void append(SinglyLinkedListWithTail<E> otherList){

		if(this.isEmpty()){
		
			this.head = otherList.head;
			this.tail = otherList.tail;
			return;

		}

		if(otherList.isEmpty()){

			return;

		}

		this.tail.setNext(otherList.head);

	}

	
	/**
	 * Removes the head of this queue.
	 * @return The head of this queue ({@code this.head}).
	 */
	public E remove(){
		
		return remove(0);
		
	}
	
	/**
	 * Unlinks (removes) the ith element from the linked list where {@code head} is the 0th element and {@code i = idx}.
	 * @param idx The index of the element to be unlinked (removed) where {@code head} is the 0th element and {@code i = idx}.
	 * @return The ith element which has been unlinked where {@code head} is the 0th element and {@code i = idx}.
	 * @throws IndexOutOfBoundsException If {@code idx >= size || idx < 0}. 
	 */
	public E remove(int idx){
		
		if(this.isEmpty() || idx >= size || idx < 0){
			
			throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + this.size);
			
		}
		
		if(idx == 0){
			
			E toReturn = this.head.getData();
			head = this.head.getNext();
			
			size--;
			
			return toReturn;
			
		}
		
		if(idx == size - 1){
						
			System.out.println(this);
			
			E toReturn = this.tail.getData();
			
			ListNode<E> newTail = this.head;
			
			for(int i = 0; i < size - 2; i++){
				
				newTail = newTail.getNext();
				
			}
			
			System.out.println("New tail: " + newTail);
			
			this.tail = newTail;
			newTail.setNext(null);
			
			size--;
			
			return toReturn;
			
		}
		
		ListNode<E> next = this.head;
		
		for(int i = 0; i <= idx - 2; i++){
			
			next = next.getNext();
			
		}
				
		E toReturn = next.getNext().getData();
				
		next.getNext().setData(null);
		next.setNext(next.getNext().getNext());
		
		size--;
		
		return toReturn;
		
	}
	
	/**
	 * Unlinks (removes) the first occurrence of {@code item} in this linked list.
	 * @param item The item to search for and unlink (remove). 
	 * @return {@code item}.
	 */
	public boolean remove(E item){
		
		if(this.isEmpty()){
			
			return false;
			
		}
		
		if(this.head.getData().equals(item) && this.tail.getData().equals(item)){
						
			this.head = null;
			this.tail = null;
			
			size--;
			
			return true;
			
		}
		
		else if(this.head.getData().equals(item)){
			
			this.head.setData(null);
			this.head = this.head.getNext();
			
			size--;
			
			return true;
			
		}
		
		else if(this.tail.getData().equals(item)){
						
			this.tail.setData(null);
			
			ListNode<E> newTail = this.head;
			
			for(int i = 0; i < size - 2; i++){
				
				newTail = newTail.getNext();
				
			}
						
			this.tail = newTail;
			newTail.setNext(null);
			
			size--;
			
			return true;
			
		}
		
		ListNode<E> next = this.head;

		for(int i = 0; i < this.size - 1; i++){
			
			if(next.getNext().getData().equals(item)){
				
				if(next.getNext() == null){
					
					next.getNext().setData(null);
					next.setNext(next.getNext().getNext());
					next.setNext(null);
					
					size--;
					
					return true;
					
				}
				
				else{
					
					next.getNext().setData(null);
					next.setNext(next.getNext().getNext());
					
					size--;
					
					return true;
					
				}
				
			}
						
			next = next.getNext();
						
		}
		
		return false;
				
	}
	
	public boolean contains(E item){
		
		return indexOf(item) != -1;
		
	}
	
	/**
	 * Returns the data of the head of this queue.
	 * @return {@code this.head.getData()}.
	 */
	public E peek(){
				
		return this.head.getData();
		
	}
	
	/**
	 * Returns the head of this node.
	 * @return {@code this.head}.
	 */
	public ListNode<E> getHead(){
		
		return this.head;
		
	}
	
	/**
	 * Returns the tail of this node. 
	 * @return {@code this.tail}.
	 */
	public ListNode<E> getTail(){
		
		return this.tail;
		
	}
	
	/**
	 * Returns the index of {@code item}'s first occurrence in this linked list where the index of the head
	 * is 0.
	 * @param item The item to search for.
	 * @return The index of {@code item}'s first occurrence in this linked list where the index of the head
	 * is 0, 1 is the second element, 2 is the third element, and so on.
	 */
	public int indexOf(E item){
		
		ListNode<E> next = this.head;

		for(int i = 0; i < this.size; i++){
			
			if(next.getData().equals(item)){
				
				return i;
				
			}
			
			next = next.getNext();
						
		}
		
		return -1;
		
	}
	
	/**
	 * Returns the ith element in the linked list where {@code head} is the 0th element and {@code i = idx}.
	 * @param idx The index of the element to be returned.
	 * @return The ith element in the linked list where {@code head} is the 0th element and {@code i = idx}.
	 * @throws IndexOutOfBoundsException {@code if >= size || idx < 0}.
	 */
	public E get(int idx){
		
		if(idx >= size || idx < 0){
			
			throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + this.size);
			
		}
		
		ListNode<E> next = this.head;
		
		for(int i = 0; i < idx; i++){
			
			next = next.getNext();
			
		}
		
		return next.getData();
		
	}
	
	/**
	 * Sets the ith element to {@code newValue}.
	 * @param idx The index to set.
	 * @param newValue The new value for that index.
	 * @return The old value of the ith element of this list. 
	 * @throws IndexOutOfBoundsException If {@code idx >= size || idx < 0}.
	 */
	public E set(int idx, E newValue){
		
		if(idx >= size || idx < 0){
			
			throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + this.size);
			
		}
		
		ListNode<E> next = this.head;
		
		for(int i = 0; i < idx; i++){
			
			next = next.getNext();
			
		}
		
		E toReturn = next.getData();
		
		next.setData(newValue);
		
		return toReturn;
		
	}
	
	/**
	 * Returns the size of this linked list.
	 * @return The size of this linked list.
	 */
	public int size(){
		
		return this.size;
		
	}
	
	@Override
	public String toString(){
				
		if(this.size == 0){
			
			return "[]";
			
		}
		
		if(this.size == 1){
			
			return "[" + this.head.getData() + "]";
			
		}
		
		if(this.size == 2){
			
			return "[" + this.head.getData() + ", " + this.tail.getData() + "]";
			
		}
				
		StringBuilder str = new StringBuilder();
		
		str.append("[");
		
		ListNode<E> node = this.head;
				
		for(int i = 0; i < size; i++){
			
			str.append(node.getData() + (node.getNext() == null ? "" : ", "));
			node = node.getNext();
			
		}
		
		str.append("]");
		
		return str.toString();
		
	}

	@Override
	public Iterator<E> iterator() {
		
		return new SinglyLinkedListIterator<E>(this);
		
	}

}

class SinglyLinkedListIterator<E> implements Iterator<E>{

	/**
	 * The node the iterator is currently on.
	 */
	ListNode<E> currentNode;
	
	/**
	 * Constructs a {@code SinglyLinkedListIterator} of {@code list}.
	 * @param list The list to construct the iterator for.
	 */
	public SinglyLinkedListIterator(SinglyLinkedListWithTail<E> list){

		this.currentNode = list.getHead();
		
	}
	
	/**
	 * Returns whether the iterator has a next node to return.
	 */
	@Override
	public boolean hasNext() {

		return currentNode != null && currentNode.getNext() != null;
		
	}

	/**
	 * Returns the next node and advances the pointer. 
	 * @return E The next object that is returned by the iterator.
	 */
	@Override
	public E next() {
		
		E toReturn = currentNode.getData();
		
		currentNode = currentNode.getNext();

		return toReturn;
		
	}
	
}
