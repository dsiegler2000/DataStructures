package computationdag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import graph.Edge;
import graph.Graph;
import graph.Node;

public class ComputationDag implements Graph<Task> {
	
	public static int N_CORES = 2;
	
	private Map<Node<Task>, List<Edge<Task>>> adjacencyList;
	
	private Node<Task> start;
	private Node<Task> end;
		
	public static void main(String[] args){
		
		/*
		 *      start 
		 *      /  \
		 *     /   t3
		 *    /   /  \
		 *   t2  t4  t5
		 *    \   \  /
		 *     \   t6
		 *      \  /
		 *      end
		 */
		
		Node<Task> start = new Node<Task>(new Task(() -> System.out.println("This is the first task!"), 1, "start"));
		
		Node<Task> end = new Node<Task>(new Task(() -> System.out.println("This is the last task!"), 5, "end"));
		
		ComputationDag dag = new ComputationDag(start, end);
		
		Node<Task> t2 = new Node<>(new Task(() -> {try{Thread.sleep(2000);}catch(InterruptedException e){}}, 2, "t2"));
		Node<Task> t3 = new Node<>(new Task(() -> {try{Thread.sleep(5000);}catch(InterruptedException e){}}, 5, "t3"));
		Node<Task> t4 = new Node<>(new Task(() -> {try{Thread.sleep(3000);}catch(InterruptedException e){}}, 3, "t4"));
		Node<Task> t5 = new Node<>(new Task(() -> {try{Thread.sleep(3000);}catch(InterruptedException e){}}, 3, "t5"));
		Node<Task> t6 = new Node<>(new Task(() -> {try{Thread.sleep(4000);}catch(InterruptedException e){}}, 4, "t6"));
		
		dag.addNode(t2).addNode(t3).addNode(t4).addNode(t5).addNode(t6);
		
		dag.addEdge(start, t2).addEdge(start, t3).addEdge(t2, end).addEdge(t3, t4).addEdge(t3, t5).addEdge(t4, t6).addEdge(t5, t6).addEdge(t6, end);
		
		System.out.println(dag);
		dag.execute();
		
	}
		
	public ComputationDag(Node<Task> start, Node<Task> end){
		
		this.adjacencyList = new HashMap<>();
		
		this.start = start;
		this.end = end;
		
		List<Edge<Task>> startAdjacents = new ArrayList<>();
		this.adjacencyList.put(this.start, startAdjacents);
		
		List<Edge<Task>> endAdjacents = new ArrayList<>();
		this.adjacencyList.put(this.end, endAdjacents);
				
	}
	
	public void execute(){

		Schedule schedule = Schedule.createSchedule(this, 2);
		
		while(!schedule.isCompleted()){
			
			Task t = schedule.remove().getData();
			
			execute(t);
			
		}
		
	}
	
	private void execute(Task task){
		
		Thread t = new Thread(task.getTask());
		System.out.println("Starting executiong of " + task);
		t.start();
		
		try {
			
			t.join();
			
		} catch (InterruptedException e) {

			e.printStackTrace();
			
		}
		
		System.out.println(task + " is done!");
		
	}
		
	public ComputationDag addNode(Node<Task> node){
		
		adjacencyList.put(node, new ArrayList<>());
		
		return this;
		
	}
	
	public ComputationDag addEdge(Node<Task> nodeFrom, Node<Task> nodeTo){
		
		if(!adjacencyList.containsKey(nodeFrom) || !adjacencyList.containsKey(nodeTo)){
			
			throw new IllegalArgumentException("Both nodeFrom and nodeTo must be in the graph!");
			
		}
		
		adjacencyList.get(nodeFrom).add(new Edge<Task>(nodeFrom, nodeTo, 1));
		
		return this;
		
	}
	
	public boolean checkIfDag(){
		
		return true;
		
	}
	
	public Set<Node<Task>> getNodes(){
		
		return adjacencyList.keySet();
		
	}
	
	public List<Node<Task>> getAdjacentNodes(Node<Task> node){
		
		List<Node<Task>> adjacents = new ArrayList<>();
		
		for(Edge<Task> e : adjacencyList.get(node)){
			
			adjacents.add(e.getTo());
			
		}
		
		return adjacents;
		
	}
	
	public int getNumberOfNodes(){
		
		return adjacencyList.size();
		
	}
	
	@Override
	public String toString(){
		
		StringBuilder str = new StringBuilder();
		
		for(Node<Task> n : this.getNodes()){
						
			List<Edge<Task>> adjacents = this.getAdjacentEdges(n);
			
			str.append(n.getData() + " -> ");
			
			if(adjacents.size() != 0){
				
				for(int i = 0; i < adjacents.size(); i++){
					
					str.append(adjacents.get(i).getTo().getData() + (i == adjacents.size() - 1 ? "" : ", "));
					
				}
				
			}
			
			else{
				
				str.append("No other nodes");
				
			}
			
			str.append("\n");
			
		}
		
		return str.toString();
		
	}

	@Override
	public List<Edge<Task>> getEdges() {
		
		Collection<List<Edge<Task>>> edgesList = adjacencyList.values();
		
		List<Edge<Task>> edges = new ArrayList<>();
		
		for(List<Edge<Task>> l : edgesList){
			
			edges.addAll(l);
			
		}

		return edges;
		
	}

	@Override
	public List<Edge<Task>> getAdjacentEdges(Node<Task> node) {

		return adjacencyList.get(node);
		
	}

}
