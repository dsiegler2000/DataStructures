package tree;

import node.GeneralNode;

public class TreeNode<E> extends GeneralNode<E>{
	
	/**
	 * The parent of this node. If {@code parent == null} then it is assumed that this is the root.
	 */
	private TreeNode<E> parent;
	
	/**
	 * An array of the children of this node. If {@code children.length == 0} or all of its elements
	 * are {@code null} then this node is assumed to be a leaf.
	 */
	private TreeNode<E>[] children;
	
	/**
	 * Constructs a node with {@code data}, {@code parent}, and {@code children = null}.
	 * This means that it is also a root  
	 */
	public TreeNode(){
		
		super(null);
		
		this.parent = null;
		this.children = null;
		
	}
	
	/**
	 * Constructs a node with {@code this.data = data}.
	 * @param data The data stored in this node.
	 */
	public TreeNode(E data){
		
		super(data);
		
	}
	
	/**
	 * Constructs a tree with {@code data} and {@code children = null} with a {@code parent} of {@code parent}.
	 * This means that this node is also a leaf.
	 * @param parent The parent node of this node. 
	 */
	public TreeNode(TreeNode<E> parent){
		
		super(null);
		
		this.parent = parent;
		
		this.children = null;
		
	}
	
	/**
	 * Constructs a leaf with {@code parent = parent} and {@code data = data}. This means that this node
	 * is a leaf.
	 * @param parent The parent node of this node.
	 * @param data The data to be contained in this node. 
	 */
	public TreeNode(TreeNode<E> parent, E data){

		super(data);
		
		this.parent = parent;
		
	}
	
	/**
	 * Constructs a node with {@code parent = parent}, {@code data = data}, and {@code children = children}.
	 * @param parent The parent node of this node.
	 * @param data The data to be contained in this node.
	 * @param children The children nodes of this node. 
	 */
	@SafeVarargs
	protected TreeNode(TreeNode<E> parent, E data, TreeNode<E> ... children){
		
		super(data);
		
		this.parent = parent;
		this.children = children;
		
	}
	
	/**
	 * Constructs a root node ({@code parent == null}) with {@code parent = parent} and {@code children = children}.
	 * @param data The data to be contained in this node. 
	 * @param children The children of this node. 
	 */
	@SafeVarargs
	protected TreeNode(E data, TreeNode<E> ... children){
		
		super(data);
		
		this.children = children;
		
		this.parent = null;
		
	}
	
	/**
	 * Returns the parent of this node or {@code null} if it is a root. 
	 * @return The parent of this node or {@code null} if it is a root. 
	 */
	public TreeNode<E> getParent(){
		
		return parent;
		
	}
	
	/**
	 * Sets the parent of this node. 
	 * @param newParent The new value for {@code this.parent}.
	 */
	public void setParent(TreeNode<E> newParent){
		
		this.parent = newParent;
		
	}
	
	/**
	 * Returns the array of all of the children of this node and {@code null} if it is a leaf.
	 * @return The array of all of the children of this node and {@code null} if it is a leaf.
	 */
	public TreeNode<E>[] getChildren(){
		
		return children;
		
	}
	
	/**
	 * Sets the children of this node. 
	 * @param newChildren The new value for {@code this.children}.
	 */
	public void setChildren(TreeNode<E>[] newChildren){
		
		this.children = newChildren;
		
	}
	
	/**
	 * Predicate to check whether this node is a leaf.
	 * @return True if this node is a leaf, false otherwise. 
	 */
	public boolean isLeaf(){
				
		if(children == null){
			
			return true;
			
		}
				
		for(TreeNode<E> node : children){
						
			if(node != null){
								
				return false;
				
			}
			
		}
		
		return true;
		
	}
	
	/**
	 * Predicate to check whether this node is a root.
	 * @return True if this node is a root, false otherwise. 
	 */
	public boolean isRoot(){
		
		return parent == null;
		
	}

}
