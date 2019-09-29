package graph;

public class Edge<T> {

	private Node<T> from;
	private Node<T> to;
	
	private int weight;

	public Edge(Node<T> from, Node<T> to, int weight) {
				
		this.from = from;
		this.to = to;
		
		this.weight = weight;
		
	}
	
	public Node<T> getFrom() {
		
		return from;
		
	}
	public Node<T> getTo() {
		
		return to;
		
	}

	public int getWeight() {
		
		return weight;
		
	}
	
	@Override
	public String toString(){
		
		return "From : " + from.toString() + " To: " + to.toString() + " Weight: " + weight;
		
	}

}
