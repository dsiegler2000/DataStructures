package exercise7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MessagePriorityQueueUsingBuckets {
	
	private List<Queue<Message>> queues;
	
	private int size;
	
	public MessagePriorityQueueUsingBuckets(){
		
		queues = new ArrayList<Queue<Message>>();
		
		for(int i = 0; i < 5; i++){
			
			queues.add(new LinkedList<Message>());
			
		}
		
		size = 0;
		
	}
	
	public void add(Message m){
		
		size++;
		
		queues.get(m.getPriority()).add(m);
		
	}

	public Message remove(){
		
		size--;
		
		if(!queues.get(0).isEmpty()){
			
			return queues.get(0).remove();
			
		}
		
		if(!queues.get(1).isEmpty()){
			
			return queues.get(1).remove();
			
		}
		
		if(!queues.get(2).isEmpty()){
			
			return queues.get(2).remove();
			
		}
		
		if(!queues.get(3).isEmpty()){
			
			return queues.get(3).remove();
			
		}
		
		if(!queues.get(4).isEmpty()){
			
			return queues.get(4).remove();
			
		}
		
		else{
			
			return null;
			
		}
		
	}
	
	public int size(){
		
		return size;
		
	}
	
	public boolean isEmpty(){
		
		return size() == 0;
		
	}

}
