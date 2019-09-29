package tree;

public class BinaryTreeNode<E> extends TreeNode<E>{
	
	/**
	 * The left child of this node.
	 */
	private BinaryTreeNode<E> leftChild;
	
	/**
	 * The right child of this node.
	 */
	private BinaryTreeNode<E> rightChild;
	
	/**
	 * Constructs a node with {@code data}, {@code parent}, and {@code children = null}.
	 * This means that it is also a root  
	 */
	public BinaryTreeNode(){
		
		super();
		
	}
	
	/**
	 * Constructs a node with {@code this.data = data}.
	 * @param data The data stored in this node.
	 */
	public BinaryTreeNode(E data){
		
		super(data);
		
	}
	
	/**
	 * Constructs a root node with children {@code leftChild} and {@code rightChild}.
	 * @param data The data to be contained in the node.
	 * @param leftChild The left child of the node. 
	 * @param rightChild The right child of the node.
	 */
	public BinaryTreeNode(E data, BinaryTreeNode<E> leftChild, BinaryTreeNode<E> rightChild){
		
		super(data, leftChild, rightChild);

		this.leftChild = leftChild;
		this.rightChild = rightChild;
				
	}
	
	/**
	 * Constructs a leaf with {@code parent = parent} and {@code data = data}. This means that this node
	 * is a leaf.
	 * @param parent The parent node of this node.
	 * @param data The data to be contained in this node. 
	 */
	public BinaryTreeNode(E data, TreeNode<E> parent){

		super(parent, data);
				
	}
	
	/**
	 * Constructs a tree with {@code data} and {@code children = null} with a {@code parent} of {@code parent}.
	 * This means that this node is also a leaf.
	 * @param parent The parent node of this node. 
	 */
	public BinaryTreeNode(TreeNode<E> parent){
		
		super(parent);
		
	}
	
	/**
	 * Constructs a node with children {@code leftChild} and {@code rightChild} and {@code this.data = data}.
	 * @param parent The parent of this node.
	 * @param data The data to be contained in the node.
	 * @param leftChild The left child of the node.
	 * @param rightChild The right child of the node. 
	 */
	public BinaryTreeNode(E data, BinaryTreeNode<E> parent, BinaryTreeNode<E> leftChild, BinaryTreeNode<E> rightChild){
		
		super(parent, data, leftChild, rightChild);
		
		this.leftChild = leftChild;
		this.rightChild = rightChild;
				
	}
	
	/**
	 * Returns the left child of this node.
	 * @return The left child of this node.
	 */
	public BinaryTreeNode<E> getLeft(){
		
		return leftChild;
		
	}
	
	/**
	 * Returns the right child of this node.
	 * @return The right child of this node.
	 */
	public BinaryTreeNode<E> getRight(){
		
		return rightChild;
		
	}
	
	/**
	 * Sets the left child of this node.
	 * @param newLeftChild The new value for {@code this.leftChild}.
	 */
	public void setLeft(BinaryTreeNode<E> newLeftChild){
		
		this.leftChild = newLeftChild;
		
	}
	
	/**
	 * Sets the right child of this node.
	 * @param newRightChild The new value for {@code this.rightChild}.
	 */
	public void setRight(BinaryTreeNode<E> newRightChild){
		
		this.rightChild = newRightChild;
		
	}
	
	/**
	 * Predicate to check whether this node is a leaf. 
	 * @return True if this node is a leaf (both its children are {@code null}, false otherwise. 
	 */
	@Override
	public boolean isLeaf(){
		
		return this.rightChild == null && this.leftChild == null;
		
	}

}
