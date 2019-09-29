package graph.adjacencylistgraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import graph.Edge;
import graph.Graph;
import graph.Node;

public class AdjacencyListGraph implements Graph<String> {
	
	private Map<Node<String>, List<Edge<String>>> adjacencyList;
	
	private boolean weighted;
	
	public AdjacencyListGraph(File input, boolean weighted){
		
		this.weighted = weighted;
		
		adjacencyList = new HashMap<>();
		
		Scanner in = null;
		
		try {
			
			in = new Scanner(input);
			
		} catch (FileNotFoundException e) {

			System.out.println("Invalid input");
			System.exit(1);
			
		}
		
		List<Node<String>> refs = new ArrayList<>();
		
		while(in.hasNextLine()){
			
			String line = in.nextLine();
			String[] split = line.split(",");
			
			Node<String> from = new Node<>(split[0]);			
			Node<String> to = new Node<>(split[1]);
			
			if(!refs.contains(from)){
				
				refs.add(from);
				
			}
			
			if(!refs.contains(to)){
				
				refs.add(to);
				
			}
						
		}
		
		try {
			
			in = new Scanner(input);
			
		} catch (FileNotFoundException e) {

			System.out.println("Invalid input");
			System.exit(1);
			
		}
		
		while(in.hasNextLine()){
			
			String line = in.nextLine();
			String[] split = line.split(",");
			
			Node<String> from = refs.get(refs.indexOf(new Node<String>(split[0])));
			Node<String> to = refs.get(refs.indexOf(new Node<String>(split[1])));
			
			Edge<String> e = new Edge<>(from, to, (weighted ? Integer.parseInt(split[2]) : 1));
						
			if(adjacencyList.containsKey(from)){
												
				adjacencyList.get(from).add(e);
								
			}
			
			else{
				
				adjacencyList.put(from, new LinkedList<>());
				adjacencyList.get(from).add(e);
				
			}
			
			if(!adjacencyList.containsKey(to)){
				
				adjacencyList.put(to, new LinkedList<>());
				
			}
						
		}
		
	}
	
	public Set<Node<String>> getNodes(){
		
		return adjacencyList.keySet();
		
	}
	
	public List<Node<String>> getAdjacentNodes(Node<String> node){
		
		List<Node<String>> adjacents = new ArrayList<>();
		
		for(Edge<String> e : adjacencyList.get(node)){
			
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
		
		for(Node<String> n : this.getNodes()){
						
			List<Edge<String>> adjacents = this.getAdjacentEdges(n);
			
			str.append(n.getData() + " -> ");
			
			if(adjacents.size() != 0){
				
				for(int i = 0; i < adjacents.size(); i++){
					
					str.append(adjacents.get(i).getTo().getData() + (weighted ? " " + "(" + adjacents.get(i).getWeight() + ")" : "") + (i == adjacents.size() - 1 ? "" : ", "));
					
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
	public List<Edge<String>> getEdges() {
		
		Collection<List<Edge<String>>> edgesList = adjacencyList.values();
		
		List<Edge<String>> edges = new ArrayList<>();
		
		for(List<Edge<String>> l : edgesList){
			
			edges.addAll(l);
			
		}

		return edges;
		
	}

	@Override
	public List<Edge<String>> getAdjacentEdges(Node<String> node) {

		return adjacencyList.get(node);
		
	}

}
