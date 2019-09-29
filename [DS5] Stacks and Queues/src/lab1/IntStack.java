package lab1;

import java.util.Arrays;

public class IntStack {

	public static void main(String[] args){
		
		IntStack stack = new IntStack();
		
		System.out.println("IS EMPTY");
		System.out.println(stack.isEmpty());
		
		System.out.println("PUSHING TO AN EMPTY STACK");
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		stack.push(11);
		stack.push(12);
		stack.push(13);
		
		System.out.println(stack);
		
		System.out.println("PEEKING");
		System.out.println(stack.peek());
		
		System.out.println("IS EMPTY");
		System.out.println(stack.isEmpty());
		
		System.out.println("POPPING 3 THINGS");
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack);
		
		System.out.println("POPPING THE REST OF THE STACK");
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		
		System.out.println("IS EMPTY");
		System.out.println(stack.isEmpty());
		
		System.out.println("PEEKING FROM AN EMPTY STACK");
		
		try{
			
			stack.peek();
			
		}catch(UnderflowException e){
			
			System.out.println("CORRECT EXCEPTION THROWN");
			
		}
		
		System.out.println("POPPING FROM AN EMPTY STACK");
		
		try{
			
			stack.pop();
			
		}catch(UnderflowException e){
			
			System.out.println("CORRECT EXCEPTION THROWN");
			
		}
		
	}
	
	/**
	 * The array storing the stack.
	 */
	private int[] stack;
	
	/**
	 * The index in the {@code stack} array that is the top of the stack.
	 */
	private int top;
	
	/**
	 * Constructs an empty stack with an initial size of 10.
	 */
	public IntStack(){
		
		this(10);
		
	}
	
	/**
	 * Constructs an empty stack with an initial size of initial size
	 * @param initialSize
	 */
	public IntStack(int initialSize){
		
		stack = new int[initialSize];
		top = 0;
		
	}
	
	/**
	 * Predicate to check whether the stack is empty.
	 * @return True if the stack is empty.
	 */
	public boolean isEmpty(){
		
		return top <= 0;
		
	}
	
	/**
	 * Pushes item to the top of the stack and returns item.
	 * @param item The item to be pushed to the top of the stack.
	 * @return item.
	 */
	public int push(int item){
		
		
		//If the array can go no more, double the array size by growing it
		if(top >= stack.length){
			
			this.grow(stack.length * 2);
			
		}
		
		stack[top++] = item;
		return item;
		
	}
	
	/**
	 * Removes the top value from the stack and returns it.
	 * @return The top value from the stack. 
	 * @throws UnderflowException If pop is called on an empty stack.
	 */
	public int pop(){
		
		if(this.isEmpty()){
			
			throw new UnderflowException("Attempting to pop from an empty stack.");
			
		}
		
		int item = stack[top - 1];
		stack[--top] = Integer.MIN_VALUE;
		
		return item;
		
	}
	
	/**
	 * Returns the top value of the stack.
	 * @return The top value of the stack
	 * @throws UnderflowException If peek is called on an empty stack.
	 */
	public int peek(){
		
		if(this.isEmpty()){
			
			throw new UnderflowException("Attempting to peek at an empty stack.");
			
		}
		
		return stack[top - 1];
		
	}
	
	/**
	 * Returns the distance from the top of the stack where 0 is the top element. 
	 * If target doesn't exist in the stack, it returns -1.
	 * @param target The object to search for.
	 * @return target's distance from the top of the stack where 0 is the top element, 
	 * 1 is the second element, and so on.
	 */
	public int search(int target){
		
		int distance = 0;
		
		for(int i = top - 1; i >= 0; i--){
			
			if(stack[i] == target){
				
				return distance;
				
			}
			
			distance++;
			
		}
		
		return -1;
		
	}
	
	/**
	 * Grows the array to newSize. If newSize is less than the current size the array will be 
	 * trimmed starting with the top of the stack and if newSize is greater than the current array
	 * size then the array will be padded with null values.
	 * @param newSize The new size the array will grow to.
	 */
	private void grow(int newSize){
		
		stack = Arrays.copyOf(stack, newSize);
		
	}
	
	@Override
	public String toString(){
		
		StringBuilder str = new StringBuilder();
		
		str.append("[");
		
		for(int i = 0; i < this.top; i++){
			
			str.append(stack[i] + (i == this.top - 1 ? "" : ","));
			
		}
		
		str.append("]");
		
		return str.toString();
		
	}
	
}
