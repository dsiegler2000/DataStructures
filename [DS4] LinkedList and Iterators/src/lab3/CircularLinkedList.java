package lab3;

import java.util.Iterator;

import node.ListNode;

public class CircularLinkedList<E> implements Iterable<E>{
	
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
	public CircularLinkedList(){
		
		this.head = new ListNode<E>();
		this.tail = new ListNode<E>();
		this.size = 0;
		
	}
	
	/**
	 * Constructs a linked list with {@code values} values.
	 * @param values The values to be contained in the linked list in that order. 
	 */
	public CircularLinkedList(E[] values){
		
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
		this.tail.setNext(this.head);
		
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
			
			ListNode<E> newHead = new ListNode<>(item, this.head);
			this.head = newHead;
			this.tail = newHead;
			this.tail.setNext(this.head);
		
		}
		
		ListNode<E> newHead = new ListNode<>(item, this.head);			
		
		if(this.size == 1){
			
			this.head.setNext(newHead);
			
		}
		
		this.tail.setNext(newHead);
		this.tail = newHead;
		this.tail.setNext(this.head);
		
		size++;
					
	}
	
	/**
	 * Adds {@code object} in the {@code i}th position in the linked list. 
	 * @param i The index to add {@code object}.
	 * @param object The object to add.
	 * @throws IndexOutOfBoundsException If {@code this.size() <= i || i < 0}.
	 */
	public void add(int i, E object){
		
		if(this.size <= i || i < 0){
			
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
			this.tail.setNext(this.head);
			
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
		
		if(idx >= size || idx < 0 || this.isEmpty()){
			
			throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + this.size);
			
		}
		
		if(idx == 0){
			
			E toReturn = this.head.getData();
			head = this.head.getNext();
			
			size--;
			
			return toReturn;
			
		}
		
		if(idx == size - 1){
			
			E toReturn = this.tail.getData();
			
			ListNode<E> newTail = this.head;
			
			for(int i = 0; i < size - 1; i++){
				
				newTail = newTail.getNext();
				
			}
			
			this.tail.setData(null);
			this.tail = newTail;
			this.tail.setNext(this.head);
			
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
		
		if(this.head.getData().equals(item) && this.tail.getData().equals(item) && size == 1){
						
			this.head = null;
			this.tail = null;
			
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
			this.tail.setNext(this.head);
			
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
	 * @throws IndexOutOfBoundsException If {@code idx >= size || idx < 0}.
	 */
	public void set(int idx, E newValue){
		
		if(idx >= size || idx < 0){
			
			throw new IndexOutOfBoundsException("Index: " + idx + ", Size: " + this.size);
			
		}
		
		ListNode<E> next = this.head;
		
		for(int i = 0; i < idx; i++){
			
			next = next.getNext();
			
		}
		
		next.setData(newValue);
		
	}
	
	/**
	 * Returns the size of this linked list.
	 * @return The size of this linked list.
	 */
	public int size(){
		
		return this.size;
		
	}
	
	/**
	 * Sets the size of this linked list.
	 * @param newSize The new size of this linked list.
	 */
	public void setSize(int newSize){
		
		this.size = newSize;
		
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
			
			str.append(node.getData() + (i == size - 1 ? "" : ", "));
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
	 * The index that this iterator is currently on.
	 */
	int currentIdx;
	
	/**
	 * The size of the linked list that is being iterated.
	 */
	int size;
	
	/**
	 * Constructs a {@code SinglyLinkedListIterator} of {@code list}.
	 * @param list The list to construct the iterator for.
	 */
	public SinglyLinkedListIterator(CircularLinkedList<E> list){

		this.currentNode = list.getHead();
		this.currentIdx = 0;
		this.size = list.size();
		
	}
	
	/**
	 * Returns whether the iterator has a next node to return.
	 */
	@Override
	public boolean hasNext() {

		return currentNode != null && currentNode.getNext() != null || currentIdx < size;
		
	}

	/**
	 * Returns the next node and advances the pointer. 
	 * @return E The next object that is returned by the iterator.
	 */
	@Override
	public E next() {
		
		E toReturn = currentNode.getData();
		
		currentNode = currentNode.getNext();
		
		currentIdx++;

		return toReturn;
		
	}
	
}
