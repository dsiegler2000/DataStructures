package exercise12;

import binarysearchtree.BinarySearchTree;
import binarysearchtree.BinarySearchTreeNode;
import tree.BinaryTreePrinter;

public class CopyAndMirrorTester {
	
	public static void main(String[] args){
		
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.add(1);
		tree.add(5);
		tree.add(7);
		tree.add(2);
		tree.add(3);
		tree.add(2);
		tree.add(17);
		
		BinarySearchTree<Integer> copy = new BinarySearchTree<Integer>(copy(tree.getRoot()));
		
		System.out.println("COPYING:");
		
		BinaryTreePrinter.printTree(tree);
		BinaryTreePrinter.printTree(copy);
		
		BinarySearchTree<Integer> mirror = new BinarySearchTree<Integer>(mirrorImage(tree.getRoot()));
		
		System.out.println("MIRROR IMAGE");
		
		BinaryTreePrinter.printTree(tree);
		BinaryTreePrinter.printTree(mirror);
		
	}
	
	public static <E extends Comparable<E>> BinarySearchTreeNode<E> copy(BinarySearchTreeNode<E> root){

		if(root == null){

			return null;

		}

		BinarySearchTreeNode<E> newRoot = new BinarySearchTreeNode<E>(root.getData());
		newRoot.setLeft(copy(root.getLeft()));
		newRoot.setRight(copy(root.getRight()));
		
		return newRoot;

	}
	
	public static <E extends Comparable<E>> BinarySearchTreeNode<E> mirrorImage(BinarySearchTreeNode<E> root){

		if(root == null){

			return null;

		}

		BinarySearchTreeNode<E> newRoot = new BinarySearchTreeNode<E>(root.getData());
		
		newRoot.setRight(mirrorImage(root.getLeft()));
		newRoot.setLeft(mirrorImage(root.getRight()));
		
		return newRoot;

	}

}
