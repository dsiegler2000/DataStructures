package graph;

import java.util.List;
import java.util.Set;

import graph.Node;

public interface Graph<T> {
	
	public Set<Node<T>> getNodes();
	
	public List<Node<T>> getAdjacentNodes(Node<T> node);
	
	public List<Edge<T>> getAdjacentEdges(Node<T> node);
	
	public List<Edge<T>> getEdges();
	
	public int getNumberOfNodes();

}