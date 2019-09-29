package exercise9;

import binarysearchtree.BinarySearchTree;
import binarysearchtree.BinarySearchTreeNode;

public class CountPathsTester {
	
	public static void main(String[] args){
		
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.add(1);
		tree.add(5);
		tree.add(7);
		tree.add(2);
		tree.add(3);
		tree.add(2);
		tree.add(17);
		
		System.out.println(countPaths(tree.getRoot()));
		
	}
	
	public static <E extends Comparable<E>> int countPaths(BinarySearchTreeNode<E> root){

		if(root == null){

			return 0;

		}

		return numNodes(root) - 1;

	}

	public static <E extends Comparable<E>> int numNodes(BinarySearchTreeNode<E> root){

		if(root == null){

			return 0;

		}

		return 1 + numNodes(root.getRight()) + numNodes(root.getLeft());

	}


}
