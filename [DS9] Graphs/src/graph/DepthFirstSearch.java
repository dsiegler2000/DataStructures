package graph;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import graph.adjacencylistgraph.AdjacencyListGraph;
import graphvisualizer.GraphVisualizer;

public class DepthFirstSearch {
	
	public static void main(String[] args){
		
		args = new String[1];
		args[0] = "src/graph/README.TXT";
		
		if(args.length < 1){
			
			System.err.println("Must pass a file!");
			System.exit(1);
			
		}
		
		Graph<String> g = new AdjacencyListGraph(new File(args[0]), false);
		Node<String> start = g.getNodes().iterator().next();
		System.out.println("DFS: " + depthFirstSearch(g, start));
		System.out.println(g.toString());
		
		GraphVisualizer<String> v = new GraphVisualizer<>(g);
		v.setVisitableNodes(depthFirstSearch(g, start));
		v.setStart(start);
		v.repaint();
		
	}

	public static List<Node<String>> depthFirstSearch(Graph<String> graph, Node<String> start){
		
		Stack<Node<String>> stack = new Stack<>();
		
		List<Node<String>> visited = new ArrayList<>();
		
		for(Node<String> v : graph.getNodes()){
			
			v.setVisited(false);
			
		}
				
		stack.push(start);
		
		while(!stack.isEmpty()){
			
			Node<String> u = stack.pop();
												
			if(!u.isVisited()){
								
				u.setVisited(true);
				visited.add(u);
				
				List<Node<String>> adjacents = graph.getAdjacentNodes(u);
				
				Collections.sort(adjacents, new Comparator<Node<String>>(){

					@Override
					public int compare(Node<String> o1, Node<String> o2) {

						return -o1.getData().compareTo(o2.getData());

					}
					
				});
				
				for(int i = 0; i < adjacents.size(); i++){
					
					Node<String> n = adjacents.get(i);
															
					if(!n.isVisited()){

						stack.push(n);
																		
					}
					
				}
								
			}
			
		}
		
		return visited;
		
	}
	
}
