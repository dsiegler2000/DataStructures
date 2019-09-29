package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import binarysearchtree.BinarySearchTree;

/**
 * A class to print a binary tree. All credit to michal.kreuzman on StackOverflow for the algorithm
 * but adapted to work with my classes and documented by me. 
 * @author michal.kreuzman from http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
 */
public class BinaryTreePrinter {
	
	/**
	 * Outputs a binary tree to the console.
	 * @param root The root of the tree.
	 */
	public static <T> void printTree(BinaryTreeNode<T> root){
		
		printNode(root);
		
	}
	
	public static <T extends Comparable<T>> void printTree(BinarySearchTree<T> tree){
		
		printTree(tree.getRoot());
		
	}

	/**
	 * Prints a node and all of its children in tree form to the console.
	 * @param node The node to output.
	 */
    public static <T> void printNode(BinaryTreeNode<T> node) {
    	
        int maxLevel = BinaryTreePrinter.maxLevel(node);
        printNodeInternal(Collections.singletonList(node), 1, maxLevel);
        
    }

    /**
     * Prints the nodes in {@code nodes} from level {@code level} to {@code maxLevel}. "ND" is used when
     * the data of a node is null. It stands for "null data".
     * @param nodes The node(s) to print.
     * @param level The level to start at (the level of {@code nodes}).
     * @param maxLevel The level to end at. 
     */
    private static <T> void printNodeInternal(List<BinaryTreeNode<T>> nodes, int level, int maxLevel) {
    	
        if (nodes.isEmpty() || BinaryTreePrinter.isAllElementsNull(nodes)){
        	
        	return;
        	
        }
        
        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BinaryTreePrinter.printWhitespaces(firstSpaces);

        List<BinaryTreeNode<T>> newNodes = new ArrayList<BinaryTreeNode<T>>();
        
        for (BinaryTreeNode<T> node : nodes) {
        	
            if (node != null) {
            	            	
                System.out.print(node.getData() == null ? "ND" : node.getData().toString());
                
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
                                
            } 
            
            else {
            	
                newNodes.add(null);
                newNodes.add(null);
                
                System.out.print(" ");
                
            }

            BinaryTreePrinter.printWhitespaces(betweenSpaces);
            
        }
        
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
        	
            for (int j = 0; j < nodes.size(); j++) {
            	
                BinaryTreePrinter.printWhitespaces(firstSpaces - i);
                
                if (nodes.get(j) == null) {
                	
                    BinaryTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                    
                }

                if (nodes.get(j).getLeft() != null){
                	
                    System.out.print("/");
                    
                }
                
                else{
                	
                    BinaryTreePrinter.printWhitespaces(1);
                	
                }

                BinaryTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).getRight() != null){
                	
                    System.out.print("\\");
                	
                }
                
                else{
                	
                    BinaryTreePrinter.printWhitespaces(1);
                	
                }

                BinaryTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
                
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
        
    }

    /**
     * Prints {@code count} whitespaces ( ). 
     * @param count The number of whitespaces to print.
     */
    private static void printWhitespaces(int count) {
    	
        for (int i = 0; i < count; i++){
        	
            System.out.print(" ");
    
        }
                
    }

    /**
     * Determines and returns the maximum level (height) of node {@code node}.
     * @param node The node to examine.
     * @return The length of the longest chain from {@code node} or the highest height or level from {@code node}.
     */
    private static <T> int maxLevel(BinaryTreeNode<T> node) {
    	
    	if (node == null){
        	
            return 0;
        
        }

        return Math.max(BinaryTreePrinter.maxLevel(node.getLeft()), BinaryTreePrinter.maxLevel(node.getRight())) + 1;
    
    }

    /**
     * Checks if all elements in {@code list} are {@code null}.
     * @param list The list to check.
     * @return True if all elements in {@code list == null}, false otherwise. 
     */
    private static <T> boolean isAllElementsNull(List<T> list) {
    	
    	for (Object object : list) {
        	
    		if (object != null){
            	
    			return false;
                
            }
            
        }

        return true;
    
    }

}