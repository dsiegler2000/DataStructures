package graph;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import graph.adjacencylistgraph.AdjacencyListGraph;
import graphvisualizer.GraphVisualizer;

public class BreadthFirstSearch {
	
	public static void main(String[] args){
				
		if(args.length < 1){
			
			System.err.println("Must pass a file!");
			System.exit(1);
			
		}
		
		Graph<String> g = new AdjacencyListGraph(new File(args[0]), false);
		Node<String> start = g.getNodes().iterator().next();
		System.out.println(g.toString());
		System.out.println("BFS: " + depthFirstSearch(g, start));
		
		GraphVisualizer<String> v = new GraphVisualizer<>(g);
		v.setVisitableNodes(depthFirstSearch(g, start));
		v.setStart(start);
		v.repaint();
		
	}
	
	public static List<Node<String>> depthFirstSearch(Graph<String> graph, Node<String> start){
				
		for(Node<String> v : graph.getNodes()){
			
			v.setVisited(false);
			
		}
		
		start.setVisited(true);
		
		List<Node<String>> list = new ArrayList<Node<String>>();
		Queue<Node<String>> queue = new LinkedList<Node<String>>();
		
		queue.add(start);
		list.add(start);
		
		while(!queue.isEmpty()){
			
			Node<String> current = queue.remove();
			
			List<Node<String>> adjacents = graph.getAdjacentNodes(current);
			
			Collections.sort(adjacents, new Comparator<Node<String>>(){

				@Override
				public int compare(Node<String> o1, Node<String> o2) {

					return o1.getData().compareTo(o2.getData());

				}
				
			});
			
			for(int i = 0; i < adjacents.size(); i++){
				
				Node<String> n = adjacents.get(i);
				
				if(!list.contains(n)){
					
					list.add(n);
					queue.add(n);
					
				}
				
			}
			
		}
				
		return list;
		
	}

}
