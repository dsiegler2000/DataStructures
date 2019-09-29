package binarysearchtree;

import tree.BinaryTreeNode;
import tree.TreeNode;

public class BinarySearchTreeNode<E extends Comparable<E>> extends BinaryTreeNode<E>{
	
	/**
	 * Constructs a node with {@code data}, {@code parent}, and {@code children = null}.
	 * This means that it is also a root  
	 */
	public BinarySearchTreeNode(){
		
		super();
		
	}
	
	/**
	 * Constructs a node with {@code this.data = data}.
	 * @param data The data stored in this node.
	 */
	public BinarySearchTreeNode(E data){
		
		super(data);
		
	}
	
	/**
	 * @param data
	 * @param leftChild
	 * @param rightChild
	 * @throws UnsupportedOperationException You can only construct a {@code BinarySearchTreeNode} using the 
	 * {@code BinarySearchTreeNode()} and {@code BinarySearchTreeNode(E data)} constructors.
	 */
	public BinarySearchTreeNode(E data, BinaryTreeNode<E> leftChild, BinaryTreeNode<E> rightChild){
		
		super(data, leftChild, rightChild);
				
	}

	
	/**
	 * @param data
	 * @param parent
	 * @throws UnsupportedOperationException You can only construct a {@code BinarySearchTreeNode} using the 
	 * {@code BinarySearchTreeNode()} and {@code BinarySearchTreeNode(E data)} constructors.
	 */
	public BinarySearchTreeNode(E data, TreeNode<E> parent){

		throw new UnsupportedOperationException("You can only construct a BinarySearchTreeNode using the "
				+ "BinarySearchTreeNode() and BinarySearchTreeNode(E data) constructors.");
				
	}
	
	/**
	 * @param parent
	 * @throws UnsupportedOperationException You can only construct a {@code BinarySearchTreeNode} using the 
	 * {@code BinarySearchTreeNode()} and {@code BinarySearchTreeNode(E data)} constructors.
	 */
	public BinarySearchTreeNode(TreeNode<E> parent){
		
		throw new UnsupportedOperationException("You can only construct a BinarySearchTreeNode using the "
				+ "BinarySearchTreeNode() and BinarySearchTreeNode(E data) constructors.");
		
	}
	
	/**
	 * @param data
	 * @param parent
	 * @param leftChild
	 * @param rightChild
	 * @throws UnsupportedOperationException You can only construct a {@code BinarySearchTreeNode} using the 
	 * {@code BinarySearchTreeNode()} and {@code BinarySearchTreeNode(E data)} constructors.
	 */
	public BinarySearchTreeNode(E data, BinaryTreeNode<E> parent, BinaryTreeNode<E> leftChild, BinaryTreeNode<E> rightChild){
		
		throw new UnsupportedOperationException("You can only construct a BinarySearchTreeNode using the "
				+ "BinarySearchTreeNode() and BinarySearchTreeNode(E data) constructors.");
						
	}
	
	/**
	 * Returns the left child of this node.
	 * @return The left child of this node.
	 */
	@Override
	public BinarySearchTreeNode<E> getLeft(){
		
		return (BinarySearchTreeNode<E>) super.getLeft();
		
	}
	
	/**
	 * Returns the right child of this node.
	 * @return The right child of this node.
	 */
	@Override
	public BinarySearchTreeNode<E> getRight(){
		
		return (BinarySearchTreeNode<E>) super.getRight();
		
	}

}
