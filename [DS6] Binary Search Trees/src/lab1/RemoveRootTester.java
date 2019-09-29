package lab1;

import binarysearchtree.BinarySearchTree;
import tree.BinaryTreePrinter;

public class RemoveRootTester {
	
	public static void main(String[] args){
		
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.add(1);
		tree.add(5);
		tree.add(7);
		tree.add(2);
		tree.add(3);
		tree.add(2);
		tree.add(17);
		
		System.out.println("REMOVING THE ROOT:");
		
		System.out.println("BEFORE:");
		BinaryTreePrinter.printTree(tree);
		
		tree.removeRoot();
		
		System.out.println("AFTER:");
		BinaryTreePrinter.printTree(tree);
		
		System.out.println("REMOVING THE ROOT FROM AN EMPTY TREE:");
		
		tree = new BinarySearchTree<>();
		
		System.out.println("BEFORE:");
		BinaryTreePrinter.printTree(tree);
		
		tree.removeRoot();
		
		System.out.println("AFTER:");
		BinaryTreePrinter.printTree(tree);	
		
	}

}
