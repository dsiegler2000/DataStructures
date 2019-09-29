package exercise22;

import binarysearchtree.BinarySearchTree;
import binarysearchtree.BinarySearchTreeNode;

public class MaxNodeTester {
	
	public static void main(String[] args){
		
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.add(1);
		tree.add(5);
		tree.add(7);
		tree.add(17);
		tree.add(3);
		tree.add(2);
		tree.add(3);
		
		System.out.println(maxNode(tree.getRoot()).getData());
		
	}
	
	
	public static <E extends Comparable<E>> BinarySearchTreeNode<E> maxNode(BinarySearchTreeNode<E> root){

		if(root == null){

			return null;

		}

		BinarySearchTreeNode<E> node = root;

		while(node.getRight() != null){

			node = node.getRight();

		}

		return node;

	}

}
