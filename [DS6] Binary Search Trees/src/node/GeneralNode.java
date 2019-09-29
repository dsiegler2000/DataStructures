package node;

public class GeneralNode<E> {
	
	/**
	 * The data contained in this node.
	 */
	private E data;	
	
	/**
	 * Constructs a node with {@code this.data = null}.
	 */
	public GeneralNode(){
		
		this.data = null;
		
	}
	
	/**
	 * Constructs a node with {@code this.data = data}.
	 * @param data The data stored in this node.
	 */
	public GeneralNode(E data){
		
		this.data = data;
		
	}
	
	/**
	 * Returns the data stored in this node. 
	 * @return The data stored in this node. 
	 */
	public E getData(){
		
		return data;
		
	}
	
	/**
	 * Sets the data stored in this node. 
	 * @param newData The new value for {@code this.data}.
	 */
	public void setData(E newData){
		
		this.data = newData;
		
	}

}
