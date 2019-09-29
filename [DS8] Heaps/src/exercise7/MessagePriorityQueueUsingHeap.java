package exercise7;

import java.util.Arrays;

public class MessagePriorityQueueUsingHeap {
	
	private Message[] heap;
	
	private int size;
	
	public MessagePriorityQueueUsingHeap(){
		
		heap = new Message[100];
		
		size = 0;
		
	}
	
	public void add(Message m){
		
		if(size == heap.length){
			
			grow();
			
		}
		
		heap[size] = m;
		
		int i = size;
		int parentIdx;
		
		while(i > 0){
			
			parentIdx = (i - 1) / 2;
			
			if(heap[parentIdx].getPriority() > heap[i].getPriority()){
				
				Message temp = heap[parentIdx];
				heap[parentIdx] = heap[i];
				heap[i] = temp;
				
			}
			
			else{
				
				break;
				
			}
			
			i = parentIdx;
			
		}
		
		size++;
		
	}
	
	public Message remove(){
		
		if(size <= 0){
			
			throw new IllegalStateException("The queue is empty!");
			
		}
		
		Message toReturn = heap[0];
		
		heap[0] = heap[size - 1];
		
		size--;
		
		if(size > 0){
			
			reheapDown(0);
			
		}
				
		return toReturn;
		
	}
	
	private void reheapDown(int i){
		
		int leftIdx = i * 2 + 1;
		int rightIdx = i * 2 + 2;
		
		int minIdx;
		
		if(rightIdx >= size){
			
			if(leftIdx >= size){
				
				return;
				
			}
			
			else{
				
				minIdx = leftIdx;
				
			}
						
		}
		
		else{
			
			if(heap[leftIdx].getPriority() >= heap[rightIdx].getPriority()){
				
				minIdx = leftIdx;
				
			}
			
			else{
				
				minIdx = rightIdx;
				
			}
			
		}
		
		if(heap[i].getPriority() < heap[minIdx].getPriority()){
			
			Message temp = heap[minIdx];
			heap[minIdx] = heap[i];
			heap[i] = temp;
			
			reheapDown(minIdx);
			
		}
		
	}
	
	private void grow(){
		
		heap = Arrays.copyOf(heap, heap.length * 2);
		
	}

}
