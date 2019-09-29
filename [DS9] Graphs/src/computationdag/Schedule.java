package computationdag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import graph.Node;

public class Schedule {
	
	private Queue<Node<Task>> schedule;
			
	private Schedule(Queue<Node<Task>> s, int cores){
		
		schedule = s;
		
	}
	
	public static Schedule createSchedule(ComputationDag computations, int nCores){
				
		Queue<Node<Task>> topologicalSort = new LinkedList<>(topologicalSort(computations));
		
		int maxNumSlots = 0;
		
		for(Node<Task> t : topologicalSort){
			
			maxNumSlots += t.getData().getEstimatedExecutionTime();
			
		}
		
		List<List<Slot>> timeTable = new ArrayList<>();
		
		for(int i = 0; i < nCores; i++){
			
			List<Slot> slots = new ArrayList<>();
			
			for(int j = 0; j < maxNumSlots; j++){
				
				slots.add(null);
				
			}
			
			timeTable.add(slots);
			
		}
		
		Task currentTaskToSchedule = topologicalSort.remove().getData();
		int timeStepOn = 0;
		
		outer:while(true){
						
			for(List<Slot> coreSchedule : timeTable){
				
				if(coreSchedule.get(timeStepOn) == null){
					
					for(int i = 0; i < currentTaskToSchedule.getEstimatedExecutionTime(); i++){
						
						coreSchedule.set(timeStepOn + i, new Slot(currentTaskToSchedule));
						
					}
					
					Node<Task> temp = topologicalSort.poll();
					
					if(temp == null){
						
						break outer;
						
					}
					
					else{
						
						currentTaskToSchedule = temp.getData();
						
					}
					
				}
				
			}
			
			timeStepOn++;
			
		}
		
		for(List<Slot> l : timeTable){
			
			for(Slot s : l){
				
				System.out.println(s);
				
			}
			
			System.out.println();
			
		}
		
		return new Schedule(topologicalSort, nCores);
		
	}
	
	private static List<Node<Task>> topologicalSort(ComputationDag computations){
		
		List<Node<Task>> sorted = new ArrayList<>();
		Map<Node<Task>, Integer> degrees = calculateDegrees(computations);
		Queue<Node<Task>> zeroDegrees = new LinkedList<>();
		int visitedNodes = 0;
		
		for(Entry<Node<Task>, Integer> e : degrees.entrySet()){
			
			if(e.getValue() == 0){
				
				zeroDegrees.add(e.getKey());
				
			}
			
		}
		
		while(!zeroDegrees.isEmpty()){
			
			Node<Task> n = zeroDegrees.remove();
			sorted.add(n);
			visitedNodes++;
			
			for(Node<Task> a : computations.getAdjacentNodes(n)){
				
				degrees.put(a, degrees.get(a) - 1);
				
				if(degrees.get(a) == 0){
					
					zeroDegrees.add(a);
					
				}
				
			}
			
		}
		
		if(visitedNodes != computations.getNumberOfNodes()){
			
			throw new IllegalArgumentException("The given graph cannot be topologically sorted!");
			
		}
		
		return sorted;
		
	}
	
	private static Map<Node<Task>, Integer> calculateDegrees(ComputationDag computations){
		
		Map<Node<Task>, Integer> degrees = new HashMap<>();
		
		for(Node<Task> n : computations.getNodes()){
			
			if(!degrees.containsKey(n)){
				
				degrees.put(n, 0);
				
			}
			
			for(Node<Task> a : computations.getAdjacentNodes(n)){
				
				if(!degrees.containsKey(a)){
					
					degrees.put(a, 0);
					
				}
				
				degrees.put(a, degrees.get(a) + 1);
				
			}
			
		}
		
		return degrees;
		
	}
	
	public Node<Task> remove(){
		
		return schedule.remove();
		
	}
	
	public boolean isCompleted(){
		
		return schedule.isEmpty();
		
	}

}
