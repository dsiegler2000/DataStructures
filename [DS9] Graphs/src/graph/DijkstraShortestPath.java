package graph;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Stack;

import graph.adjacencylistgraph.AdjacencyListGraph;
import graphvisualizer.GraphVisualizer;

public class DijkstraShortestPath {
	
	public static void main(String[] args){
		
		args = new String[1];
		args[0] = "src/graph/weighted.txt";
		
		if(args.length < 1){
			
			System.err.println("Must pass a file!");
			System.exit(1);
			
		}
		
		Graph<String> graph = new AdjacencyListGraph(new File(args[0]), true);
		Node<String> start = graph.getNodes().iterator().next();
		DijkstraContainer dijkstra = dijkstra(graph, start);
		System.out.println(dijkstra);
		
		GraphVisualizer<String> g = new GraphVisualizer<>(graph);
		g.setVisitableNodes(dijkstra.getVisitableNodes());
		g.setPathsAndDistances(dijkstra.getShortestPaths(), dijkstra.getDistances());
		
	}
	
	public static DijkstraContainer dijkstra(Graph<String> graph, Node<String> source){
		
		Map<Node<String>, Integer> distances = new HashMap<>();
		Map<Node<String>, Node<String>> nodeToPrevNode = new HashMap<>();
				
		for(Node<String> n : graph.getNodes()){
			
			distances.put(n, (n.equals(source) ? 0 : -1));
			
		}
				
		PriorityQueue<Node<String>> unvisited = new PriorityQueue<>(new Comparator<Node<String>>(){
			
			@Override
			public int compare(Node<String> o1, Node<String> o2) {

				if(distances.get(o1) == -1){
					
					 return Integer.MAX_VALUE;
					
				}
				
				if(distances.get(o2) == -1){
					
					return Integer.MIN_VALUE;
					
				}
				
				return distances.get(o1) - distances.get(o2);
				
			}
			
		});
		
		unvisited.addAll(graph.getNodes());
		
		Node<String> current = source;
		
		while(!unvisited.isEmpty()){
									
			for(Edge<String> e : graph.getAdjacentEdges(current)){
								
				if(distances.get(e.getFrom()) + e.getWeight() < distances.get(e.getTo()) || distances.get(e.getTo()) == -1){
										
					distances.put(e.getTo(), distances.get(e.getFrom()) + e.getWeight());
					nodeToPrevNode.put(e.getTo(), e.getFrom());
					
				}
				
			}
						
			unvisited.remove(current);
			
			if(!unvisited.isEmpty()){
								
				current = unvisited.remove();
				
				if(distances.get(current) == -1){
					
					break;
					
				}
				
			}
			
		}
		
		return new DijkstraShortestPath.DijkstraContainer(distances, nodeToPrevNode, source);
		
	}
	
	static class DijkstraContainer{
		
		private Map<Node<String>, Integer> distances;
		private Map<Node<String>, List<Node<String>>> shortestPathToNode;
		private Node<String> startNode;
		private List<Node<String>> visitableNodes;
		
		public DijkstraContainer(Map<Node<String>, Integer> distances, Map<Node<String>, Node<String>> nodeToPrevNode, Node<String> start){
			
			this.distances = distances;
			
			this.startNode = start;
			
			this.visitableNodes = new ArrayList<>();
			
			for(Entry<Node<String>, Integer> e : distances.entrySet()){
				
				if(e.getValue() != -1){
					
					visitableNodes.add(e.getKey());
					
				}
				
			}
			
			this.shortestPathToNode = new HashMap<>();
			List<Node<String>> tmp = new ArrayList<>();
			tmp.add(start);
			shortestPathToNode.put(start, tmp);
			
			for(Entry<Node<String>, Node<String>> e : nodeToPrevNode.entrySet()){
				
				shortestPathToNode.put(e.getKey(), new LinkedList<>());
				
				if(e.getKey().equals(startNode)){
					
					shortestPathToNode.get(e.getKey()).add(startNode);
					
					return;
					
				}

				Stack<Node<String>> tempPath = new Stack<>();
				tempPath.push(e.getKey());
				
				Node<String> current = e.getValue();
				
				while(!current.equals(startNode)){
					
					tempPath.push(current);
					current = nodeToPrevNode.get(current);
					
				}
				
				tempPath.push(startNode);
				
				while(!tempPath.isEmpty()){
					
					shortestPathToNode.get(e.getKey()).add(tempPath.pop());
					
				}
				
			}
						
		}
		
		public Map<Node<String>, Integer> getDistances(){
			
			return distances;
			
		}
		
		public List<Node<String>> getShortestPath(Node<String> n){
			
			return shortestPathToNode.get(n);
			
		}
		
		public Map<Node<String>, List<Node<String>>> getShortestPaths(){
			
			return shortestPathToNode;
			
		}
		
		public Node<String> getStartNode(){
			
			return startNode;
			
		}
		
		public List<Node<String>> getVisitableNodes(){
			
			return visitableNodes;
			
		}
		
		@Override
		public String toString(){
			
			StringBuilder str = new StringBuilder();
			
			str.append("Start node: " + startNode.getData() + "\n");
			
			str.append("Distances:\n");
			
			for(Entry<Node<String>, Integer> e : distances.entrySet()){
				
				str.append(e.getKey().getData() + " has a distance of " + e.getValue() + "\n");
				
			}
			
			str.append("\nPaths:\n");
			
			for(Entry<Node<String>, List<Node<String>>> e : shortestPathToNode.entrySet()){
				
				str.append(e.getKey().getData() + "'s path is: " + e.getValue() + "\n");
				
			}
			
			return str.toString();
			
		}
		
	}

}