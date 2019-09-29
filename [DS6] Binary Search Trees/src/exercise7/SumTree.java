package exercise7;

import binarysearchtree.BinarySearchTree;
import binarysearchtree.BinarySearchTreeNode;

public class SumTree {
	
	public static void main(String[] args){
		
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.add(1);
		tree.add(2);
		tree.add(10);
		tree.add(7);
		tree.add(1);
		tree.add(5);
		
		System.out.println("SUM: " + sumTree(tree));
		
	}
	
	public static int sumTree(BinarySearchTree<Integer> tree){
				
		BinarySearchTreeNode<Integer> root = tree.getRoot();

		if(root == null){
			
			return 0;
			
		}
				
		else if(root.isLeaf()){

			return root.getData();

		}

		return root.getData() + sumTree(new BinarySearchTree<Integer>(root.getRight())) + sumTree(new BinarySearchTree<Integer>(root.getLeft()));
		
	}

}
