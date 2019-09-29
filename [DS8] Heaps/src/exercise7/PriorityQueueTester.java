package exercise7;

import java.util.Random;
import java.util.UUID;

public class PriorityQueueTester {
	
	private static int NUM_ITERATIONS = 3000;
	
	public static void main(String[] args){
		
		System.out.println("A heap-based priority queue takes O(lg(n)) time to insert and delete");
		System.out.println("The Litvin-based priority queue takes O(1) time to insert and delete");
			
		runSimulation();
		runSimulation();
		runSimulation();
		
	}
	
	public static void runSimulation(){
		
		MessagePriorityQueueUsingBuckets bucketQueue = new MessagePriorityQueueUsingBuckets();
		
		Message processedMessage = null;
		
		int[] totals = new int[5];
		int[] numsPerPriority = new int[5];
		
		int nextTimeToRemove = 5;
		
		for(int i = 0; i < NUM_ITERATIONS; i++){
						
			if(i == 0){
				
				processedMessage = new Message(UUID.randomUUID().toString(), new Random().nextInt(5), i);
				
			}
						
			if(Math.random() < 0.2 && i != 0){
								
				bucketQueue.add(new Message(UUID.randomUUID().toString(), new Random().nextInt(5), i));
								
			}
						
			if(processedMessage == null){
				
				if(!bucketQueue.isEmpty()){
					
					processedMessage = bucketQueue.remove();
					
					nextTimeToRemove = i + 5;
										
					totals[processedMessage.getPriority()] += i - processedMessage.getTimeArrived() + 1;
					numsPerPriority[processedMessage.getPriority()]++;
					
				}
				
			}
			
			if(processedMessage != null && i == nextTimeToRemove){
								
				if(bucketQueue.isEmpty()){
															
					processedMessage = null;
					
				}
				
				else{
										
					nextTimeToRemove = i + 5;
					
					processedMessage = bucketQueue.remove();
					
					totals[processedMessage.getPriority()] += i - processedMessage.getTimeArrived() + 1;
					numsPerPriority[processedMessage.getPriority()]++;
					
				}
				
			}
			
		}
		
		System.out.println("\nAverage waiting times with " + NUM_ITERATIONS + " minutes:");
		
		System.out.println("Average waiting time for priority 0: " + ((float) totals[0] / (float) numsPerPriority[0]));
		System.out.println("Average waiting time for priority 1: " + ((float) totals[1] / (float) numsPerPriority[1]));
		System.out.println("Average waiting time for priority 2: " + ((float) totals[2] / (float) numsPerPriority[2]));
		System.out.println("Average waiting time for priority 3: " + ((float) totals[3] / (float) numsPerPriority[3]));
		System.out.println("Average waiting time for priority 4: " + ((float) totals[4] / (float) numsPerPriority[4]));
			
		
	}
	
}
