package node;


public class ListNode<E> extends GeneralNode<E>{
	
	/**
	 * A pointer to the next node.
	 */
	private ListNode<E> next;
	
	/**
	 * Constructs a node with {@code this.data = data} and {@code this.next = null}.
	 * @param data The data stored in this node.
	 */
	public ListNode(E data){
		
		super(data);
		
		this.next = null;
		
	}
	
	/**
	 * Constructs a node with data {@code data} and with the next node {@code next}.
	 * @param data The data to be contained in the node.
	 * @param next The next node in the list.
	 */
	public ListNode(E data, ListNode<E> next){
		
		super(data);
		
		this.next = next;
				
	}
	
	/**
	 * Constructs a node with {@code this.next == null} and {@code this.data = null}.
	 */
	public ListNode(){
		
		super(null);
				
		this.next = null;
		
	}
	
	/**
	 * Returns the next node this node is pointing to.
	 * @return The next node this node is pointing to.
	 */
	public ListNode<E> getNext(){
		
		return this.next;
		
	}
	
	/**
	 * Sets this node's {@code next} pointer.
	 * @param next The new {@code next} value.
	 */
	public void setNext(ListNode<E> next){
		
		this.next = next;
		
	}
	
	@Override
	public String toString(){
				
		return this.getData().toString();
		
	}

}