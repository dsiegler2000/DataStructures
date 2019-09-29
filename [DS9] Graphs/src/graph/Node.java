package graph;

public class Node<T> {
	
	private T data;
	
	private boolean visited;
	
	public Node(T data){
		
		this.data = data;
		
		visited = false;
		
	}
	
	public T getData(){
		
		return data;
		
	}
	
	public void setData(T newData){
		
		data = newData;
		
	}
	
	public boolean isVisited(){
		
		return visited;
		
	}
	
	public void setVisited(boolean v){
		
		visited = v;
		
	}
	
	@Override
	public String toString(){
		
		return data.toString();
		
	}
	
	@Override
	public int hashCode(){
		
		return data.hashCode();
		
	}
	
	@Override
	public boolean equals(Object o){
				
		if(o instanceof Node<?>){
			
			return this.getData().equals(((Node<?>) o).getData());
			
		}
		
		return false;
		
	}

}
