package binarysearchtree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> implements Iterable<E>{
	
	/**
	 * The root of this binary search tree.
	 */
	private BinarySearchTreeNode<E> root;
	
	/**
	 * Constructs a binary search tree with {@code this.root = null}.
	 */
	public BinarySearchTree(){
		
		this.root = null;
		
	}
	
	/**
	 * Constructs a binary search tree with {@code this.root = root}.
	 * @param root The root of this binary search tree. It is assumed that the root is a valid binary search tree.
	 */
	public BinarySearchTree(BinarySearchTreeNode<E> root){
		
		this.root = root;
		
	}
	
	/**
	 * Prints an inorder tree walk of this binary search tree. The output should be the nodes of
	 * this tree sorted in ascending order. 
	 */
	public void inorderTreeWalk(){
		
		if(this.root != null){
			
			inorderTreeWalk(this.root);
			System.out.print("\n");
			
		}
		
	}
	
	/**
	 * Prints an inorder tree walk of this binary search tree rooted at {@code root}. The output 
	 * should be the nodes of this tree sorted in ascending order. This will not work if the tree 
	 * rooted at {@code root} isn't a true binary search tree.
	 * @param root The root of the tree (or subtree).
	 */
	public static <T extends Comparable<T>> void inorderTreeWalk(BinarySearchTreeNode<T> root){
		
		if(root != null){
			
			inorderTreeWalk((BinarySearchTreeNode<T>) root.getLeft());
			System.out.print((root == null ? "ND" : root.getData().toString()) + " ");
			inorderTreeWalk((BinarySearchTreeNode<T>) root.getRight());
			
		}
		
	}
	
	/**
	 * Makes and returns a list of an inorder tree walk of this binary search tree 
	 * and prints it if {@code printWalk} is {@code true}. This means that the returned
	 * list is sorted in ascending order.
	 * @param printWalk Whether or not to output the tree walk.
	 * @return The results of the tree walk, which is equal to a list of the tree's nodes sorted
	 * in ascending order.
	 */
	public List<BinarySearchTreeNode<E>> inorderTreeWalk(boolean printWalk){
				
		List<BinarySearchTreeNode<E>> walk = inorderTreeWalk(this.root, printWalk);
		
		if(printWalk){
			
			System.out.print("\n");
			
		}
		
		return walk;
		
	}
	
	/**
	 * Makes and returns a list of an inorder tree walk of this binary search tree 
	 * and prints it if {@code printWalk} is {@code true}. This means that the returned
	 * list is sorted in ascending order. This will not work if the tree rooted at {@code root} 
	 * isn't a true binary search tree.
	 * @param root The root of the tree (or subtree).
	 * @param printWalk Whether or not to output the tree walk.
	 * @return The nodes of the walk in order, which means that the nodes are sorted by ascending
	 * order by data.
	 */
	public static <T extends Comparable<T>> List<BinarySearchTreeNode<T>> inorderTreeWalk(BinarySearchTreeNode<T> root, boolean printWalk){
				
		if(root == null){
			
			return new ArrayList<BinarySearchTreeNode<T>>(0);
			
		}
		
		List<BinarySearchTreeNode<T>> inorderWalk = new ArrayList<BinarySearchTreeNode<T>>();
		
		inorderWalk.addAll(inorderTreeWalk((BinarySearchTreeNode<T>) root.getLeft(), printWalk));
		inorderWalk.add(root);
		
		if(printWalk){
			
			System.out.print(root == null ? "ND" : root.getData() + " ");
			
		}
		
		inorderWalk.addAll(inorderTreeWalk((BinarySearchTreeNode<T>) root.getRight(), printWalk));
		
		return inorderWalk;
		
	}
	
	/**
	 * Inserts {@code node} into this binary search tree. This method finds a spot which satisfies
	 * the binary search tree invariant. 
	 * @param node The node to be inserted.
	 * @throws IllegalArgumentException If {@code node} is already in this binary search tree.
	 */
	public void add(BinarySearchTreeNode<E> node){
		
		if(this.contains(node)){
			
			throw new IllegalArgumentException("Attempting to insert a node which is already in this binary"
					+ " search tree.");
			
		}
		
		BinarySearchTreeNode<E> y = null;
		BinarySearchTreeNode<E> x = this.root;
		
		while(x != null){
			
			y = x;
			
			if(node.getData().compareTo(x.getData()) == -1){
				
				x = (BinarySearchTreeNode<E>) x.getLeft();
				
			}
			
			else{
				
				x = (BinarySearchTreeNode<E>) x.getRight();
				
			}
			
		}
		
		node.setParent(y);
		
		if(y == null){
			
			this.root = node;
			
		}
		
		else if(node.getData().compareTo(y.getData()) == -1){
			
			y.setLeft(node);
			
		}
		
		else{
			
			y.setRight(node);
		}
		
	}
	
	/**
	 * Inserts {@code data} into this binary search tree. This method finds a spot which satisfies
	 * the binary search tree invariant. 
	 * @param data The data to be inserted.
	 * @throws IllegalArgumentException If {@code node} is already in this binary search tree.
	 */
	public void add(E data){
		
		this.add(new BinarySearchTreeNode<E>(data));
		
	}
	
	/**
	 * Deletes {@code node} from this binary search tree.
	 * @param node The node to delete.
	 * @return {@code node}.
	 */
	public BinarySearchTreeNode<E> remove(BinarySearchTreeNode<E> node){
		
		if(node == null){
			
			return null;
			
		}
		
		if(node.getLeft() == null){
			
			transplant(node, node.getRight());
			
			return node;
			
		}
		
		else if(node.getRight() == null){
			
			transplant(root, root.getLeft());
			
			return node;
			
		}
		
		else{
			
			BinarySearchTreeNode<E> y = minimum(node.getRight());
			
			if(!y.getParent().equals(node)){
				
				transplant(y, y.getRight());
				
			}
			
			transplant(node, y);
			y.setLeft(node.getLeft());
			y.getLeft().setParent(y);
						
			return node;
			
		}
		
	}
	
	/**
	 * Deletes the first found node with key {@code key}.
	 * @param key The key of the node to be deleted.
	 * @return The node which has {@code data.equals(key)} and was deleted from the tree.
	 */
	public BinarySearchTreeNode<E> remove(E key){
		
		return remove(search(key));
		
	}
	
	/*
	 * Removes the root of this tree.
	 */
	public BinarySearchTreeNode<E> removeRoot(){
		
		return remove(root);
				
	}
	
	/**
	 * A subroutine of delete which replaces one subtree as a child of its parent with another
	 * subtree. {@code transplant} replaces the subtree rooted at {@code source} with the subtree 
	 * rooted at {@code destination} and {@code source}'s parent becomes {@code destination}'s parent.
	 * Also, {@code source}'s parent ends up having {@code destination} as the appropriate child.
	 * @param source The root of the subtree to be transplanted in.
	 * @param destination The destination for {@code source}'s subtree.
	 */
	private void transplant(BinarySearchTreeNode<E> source, BinarySearchTreeNode<E> destination){
		
		if(source.getParent() == null){
			
			this.root = destination;
			
		}
		
		else if(source.equals(((BinarySearchTreeNode<E>) source.getParent()).getLeft())){
			
			((BinarySearchTreeNode<E>) source.getParent()).setLeft(destination);
			
		}
		
		else{
			
			((BinarySearchTreeNode<E>) source.getParent()).setRight(destination);
			
		}
		
		if(destination != null){
			
			destination.setParent(source.getParent());
			
		}
		
	}
	
	/**
	 * Searches this binary search tree and returns the first node with key {@code key}.
	 * @param key The key to search for.
	 * @return The first node with {@code data.equals(key)} in this tree.
	 */
	public BinarySearchTreeNode<E> search(E key){
		
		return search(this.root, key);
		
	}
	
	/**
	 * Searches for {@code node} and returns {@code node} if {@code node} is in this tree
	 * and {@code null} otherwise.
	 * @param node The node to search for.
	 * @return {@code node} if this tree contains {@code node} and {@code null} otherwise. 
	 */
	public BinarySearchTreeNode<E> search(BinarySearchTreeNode<E> node){
		
		return search(this.root, node);
		
	}
	
	/**
	 * Searches the binary search tree rooted at {@code root} and returns the first node with key {@code key}.
	 * @param root The root of the binary search tree. This will not work if the tree rooted at {@code root} 
	 * isn't a true binary search tree.
	 * @param key The key to search for.
	 * @return The first node with {@code data.equals(key)} in this tree.
	 */
	public static <T extends Comparable<T>> BinarySearchTreeNode<T> search(BinarySearchTreeNode<T> root, T key){
		
		while(root != null && key != root.getData()){
			
			if(key.compareTo(root.getData()) == -1){
				
				root = root.getLeft();
				
			}
			
			else{
				
				root = root.getRight();
				
			}
			
		}
		
		return root;
		
	}
	
	/**
	 * Searches the binary search tree rooted at {@code root} and returns {@code node} if {@code node} is in the
	 * tree and {@code null} otherwise. This will not work if the tree rooted at {@code root} isn't a true binary 
	 * search tree.
	 * @param root The root of the binary search tree to search.
	 * @param node The node to search for.
	 * @return {@code node} if this tree contains {@code node} and {@code null} otherwise. 
	 */
	public static <T extends Comparable<T>> BinarySearchTreeNode<T> search(BinarySearchTreeNode<T> root, BinarySearchTreeNode<T> node){
		
		while(root != null && !node.equals(root)){
			
			if(node.getData().compareTo(root.getData()) == -1){
				
				root = root.getLeft();
				
			}
			
			else{
				
				root = root.getRight();
				
			}
			
		}
		
		return root;
		
	}
	
	/**
	 * Searches this binary search tree for {@code node} and returns whether this tree
	 * contains it.
	 * @param node The node to search for.
	 * @return True if this binary search tree contains {@code node}, false otherwise.
	 */
	public boolean contains(BinarySearchTreeNode<E> node){
		
		return search(node) != null;
		
	}
	
	/**
	 * Returns the minimum node of this binary search tree.
	 * @return The minimum node of this binary search tree (by data).
	 */
	public BinarySearchTreeNode<E> minimum(){
		
		return minimum(this.root);
		
	}
	
	/**
	 * Returns the minimum node of the binary search tree rooted at {@code root}. This will not work
	 * if the tree rooted at {@code root} isn't a true binary search tree.
	 * @param root The root of the binary search tree.
	 * @return The minimum node of this binary search tree (by data).
	 */
	public static <T extends Comparable<T>> BinarySearchTreeNode<T> minimum(BinarySearchTreeNode<T> root){
		
		BinarySearchTreeNode<T> node = root;
		
		while(!node.isLeaf()){
			
			node = node.getLeft();
			
		}
		
		return node;
		
	}

	/**
	 * Returns the maximum node of this binary search tree.
	 * @return The maximum node of this binary search tree (by data).
	 */
	public BinarySearchTreeNode<E> maximum(){
		
		return maximum(this.root);
		
	}
	
	/**
	 * Returns the maximum node of the binary search tree rooted at {@code root}. This will not work
	 * if the tree rooted at {@code root} isn't a true binary search tree.
	 * @param root The root of the binary search tree.
	 * @return The maximum node of this binary search tree (by data).
	 */
	public static <T extends Comparable<T>> BinarySearchTreeNode<T> maximum(BinarySearchTreeNode<T> root){
		
		BinarySearchTreeNode<T> node = root;
		
		while(!node.isLeaf()){
			
			node = node.getRight();
			
		}
		
		return node;
		
	}
	
	/**
	 * Returns {@code node}'s successor in an inorder tree walk.
	 * @param node The node to get the successor of.
	 * @return {@code node}'s successor in an inorder tree walk.
	 */
	public BinarySearchTreeNode<E> successor(BinarySearchTreeNode<E> node){
		
		if(node.getRight() != null){
			
			return maximum(node.getRight());
			
		}
		
		BinarySearchTreeNode<E> y = (BinarySearchTreeNode<E>) node.getParent();
		
		while(y != null && node.equals(y.getRight())){
			
			node = y;
			y = (BinarySearchTreeNode<E>) y.getParent();
			
		}
		
		return y;
		
	}
	
	/**
	 * Predicate to check whether the binary search tree rooted at {@code root} is a valid
	 * binary search tree.
	 * @param root The root of the tree to check.
	 * @return True if the binary search tree rooted at {@code root} satisfies the binary search tree
	 * invariant, false otherwise. 
	 */
	public static <T extends Comparable<T>> boolean isValidBinarySearchTree(BinarySearchTreeNode<T> root){
		
		List<BinarySearchTreeNode<T>> walk = inorderTreeWalk(root, false);
		
		for(int i = 0; i < walk.size() - 1; i++){
			
			if(walk.get(i).getData().compareTo(walk.get(i + 1).getData()) == 1){
				
				return false;
				
			}
			
		}
		
		return true;
		
	}
	
	/**
	 * Returns the root of this tree.
	 * @return {@code this.root}.
	 */
	public BinarySearchTreeNode<E> getRoot(){
		
		return this.root;
		
	}
	
	/**
	 * Sets the root of this tree.
	 * @param newRoot The new root for this tree.
	 */
	public void setRoot(BinarySearchTreeNode<E> newRoot){
		
		this.root = newRoot;
		
	}

	@Override
	public Iterator<E> iterator() {

		return new BinarySearchTreeIterator<E>(this.root);
		
	}
	
}

class BinarySearchTreeIterator<E extends Comparable<E>> implements Iterator<E>{

	private Queue<BinarySearchTreeNode<E>> toVisit;
	
	public BinarySearchTreeIterator(BinarySearchTreeNode<E> root){
				
		toVisit = new LinkedList<BinarySearchTreeNode<E>>();
		fillQueue(root);
		
	}
	
	private void fillQueue(BinarySearchTreeNode<E> root){
		
		if(root == null){
			
			return;
			
		}
		
		fillQueue(root.getLeft());
		toVisit.add(root);
		fillQueue(root.getRight());
		
	}
	 
	@Override
	public boolean hasNext() {

		return !toVisit.isEmpty();
		
	}

	@Override
	public E next() {

		return toVisit.remove().getData();
		
	}
	
}