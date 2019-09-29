package exercise6;

import binarysearchtree.BinarySearchTreeNode;

public class IsLeafTester {
	
	public static void main(String[] args){
		
		BinarySearchTreeNode<Integer> node = new BinarySearchTreeNode<>();
		System.out.println("NO CHILDREN: " + node.isLeaf());
		
		node.setRight(new BinarySearchTreeNode<Integer>());
		System.out.println("ONE CHILD: " + node.isLeaf());
		
		node.setLeft(new BinarySearchTreeNode<Integer>());
		System.out.println("TWO CHILDREN: " + node.isLeaf());
		
	}

}
