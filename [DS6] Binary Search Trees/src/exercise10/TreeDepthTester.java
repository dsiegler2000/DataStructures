package exercise10;

import binarysearchtree.BinarySearchTree;
import tree.BinaryTreeNode;

public class TreeDepthTester {
	
	public static void main(String[] args){
		
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.add(1);
		tree.add(5);
		tree.add(7);
		tree.add(2);
		tree.add(3);
		tree.add(2);
		tree.add(17);
		
		System.out.println(depth(tree.getRoot()));
		
	}
	
	public static <E> int depth(BinaryTreeNode<E> root){

		if(root == null){
			
			return 0;
			
		}
		
		else if(root.isLeaf()){

			return 1;

		}

		int left = depth(root.getLeft());
		int right = depth(root.getRight());

		if(left > right){

			return ++left;

		}

		return ++right;

	}

}
