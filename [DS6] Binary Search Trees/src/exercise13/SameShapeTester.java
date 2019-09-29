package exercise13;

import binarysearchtree.BinarySearchTree;
import binarysearchtree.BinarySearchTreeNode;

public class SameShapeTester {
	
public static void main(String[] args){
		
		BinarySearchTree<Integer> tree1 = new BinarySearchTree<>();
		tree1.add(1);
		tree1.add(5);
		tree1.add(7);
		tree1.add(2);
		tree1.add(3);
		tree1.add(2);
		tree1.add(17);
		
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
		tree2.add(1);
		tree2.add(5);
		tree2.add(7);
		tree2.add(2);
		tree2.add(3);
		tree2.add(2);
		
		System.out.println("DIFFERENT SHAPES:");
		System.out.println(sameShape(tree1.getRoot(), tree2.getRoot()));
		
		tree2.add(17);
		
		System.out.println("SAME SHAPES:");
		System.out.println(sameShape(tree1.getRoot(), tree2.getRoot()));
		
	}
	
	public static <E extends Comparable<E>> boolean sameShape(BinarySearchTreeNode<E> root1, BinarySearchTreeNode<E> root2){

		if(root1 == null && root2 == null){
			
			return false;
			
		}
		
		if((root1 == null && root2 != null) || (root1 != null && root2 == null)){
			
			return false;
			
		}
		
		if((root1.isLeaf() && !root2.isLeaf()) ||
			(!root1.isLeaf() && root2.isLeaf())){

			return false;

		}

		else if(root1.isLeaf() && root2.isLeaf()){

			return true;

		}

		else{

			return sameShape(root1.getRight(), root2.getRight()) &&
				sameShape(root1.getRight(), root2.getRight());

		}

	}

}
