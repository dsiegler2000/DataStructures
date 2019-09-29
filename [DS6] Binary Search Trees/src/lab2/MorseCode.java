package lab2;

import java.util.TreeMap;

import binarysearchtree.BinarySearchTreeNode;
import tree.BinaryTreeNode;

public class MorseCode {
	
	private static final char DOT = '.';
	private static final char DASH = '-';

	private static TreeMap<Character, String> codeMap;
	private static BinaryTreeNode<Character> decodeTree;

	public static void start() {

		codeMap = new TreeMap<Character, String>();
		BinarySearchTreeNode<Character> root = new BinarySearchTreeNode<>(' ');
		decodeTree = new BinaryTreeNode<>(root);

		addSymbol('A', ".-");
		addSymbol('B', "-...");
		addSymbol('C', "-.-.");
		addSymbol('D', "-..");
		addSymbol('E', ".");
		addSymbol('F', "..-.");
		addSymbol('G', "--.");
		addSymbol('H', "....");
		addSymbol('I', "..");
		addSymbol('J', ".---");
		addSymbol('K', "-.-");
		addSymbol('L', ".-..");
		addSymbol('M', "--");
		addSymbol('N', "-.");
		addSymbol('O', "---");
		addSymbol('P', ".--.");
		addSymbol('Q', "--.-");
		addSymbol('R', ".-.");
		addSymbol('S', "...");
		addSymbol('T', "-");
		addSymbol('U', "..-");
		addSymbol('V', "...-");
		addSymbol('W', ".--");
		addSymbol('X', "-..-");
		addSymbol('Y', "-.--");
		addSymbol('Z', "--..");
		addSymbol('0', "-----");
		addSymbol('1', ".----");
		addSymbol('2', "..---");
		addSymbol('3', "...--");
		addSymbol('4', "....-");
		addSymbol('5', ".....");
		addSymbol('6', "-....");
		addSymbol('7', "--...");
		addSymbol('8', "---..");
		addSymbol('9', "----.");
		addSymbol('.', ".-.-.-");
		addSymbol(',', "--..--");
		addSymbol('?', "..--..");
	}

	/**
	 * Inserts a letter and its Morse code string into the encoding map and
	 * calls treeInsert to insert them into the decoding tree.
	 */
	private static void addSymbol(char letter, String code) {
		
		codeMap.put(letter, code);
		treeInsert(letter, code);

	}

	/**
	 * Inserts a letter and its Morse code string into the decoding tree. Each
	 * dot-dash string corresponds to a path in the tree from the root to a
	 * node: at a "dot" go left, at a "dash" go right. The node at the end of
	 * the path holds the symbol for that code string.
	 */
	private static void treeInsert(char letter, String code) {
		
		BinaryTreeNode<Character> root = decodeTree;
		 
        for (int i = 0; i < code.length(); i++) {
        	
            char c = code.charAt(i);
            
            if (c == DOT) {
            	
                if (root.getLeft() != null) {
                	
                    root = root.getLeft();
                    
                } 
                
                else {
                	
                    root.setLeft(new BinaryTreeNode<Character>());
                    root = root.getLeft();
                    
                }
                
            } 
            
            else if(c == DASH) {
            	
                if (root.getRight() != null) {
                	
                	root = root.getRight();
                	
                } 
                
                else {
                	
                	root.setRight(new BinaryTreeNode<Character>());
                	root = root.getRight();
                	
                }
                
            }
            
        }
        
        root.setData(letter);
		
	}

	/**
	 * Converts text into a Morse code message. Adds a space after a dot-dash
	 * sequence for each letter. Other spaces in the text are transferred
	 * directly into the encoded message. Returns the encoded message.
	 */
	public static String encode(String text) {
		
		StringBuffer morse = new StringBuffer(400);
		
		text = text.toUpperCase();
		
		for(int i = 0; i < text.length(); i++){
						
			if(text.charAt(i) == ' '){
				
				morse.append(' ');
				
			}
			
			else{
				
				morse.append(codeMap.get(text.charAt(i)) + " ");
				
			}
			
		}

		return morse.toString();
		
	}

	/**
	 * Converts a Morse code message into a text string. Assumes that dot-dash
	 * sequences for each letter are separated by one space. Additional spaces
	 * are transferred directly into text. Returns the plain text message.
	 */
	public static String decode(String morse) {
		
		StringBuffer text = new StringBuffer(100);
		
		String[] split = morse.split(" ");
				
		for(String s : split){
			
			if(s.equals("") || s.equals(" ")){
				
				text.append(" ");
				
			}
			
			else{
				
				BinaryTreeNode<Character> root = decodeTree;
				
				for(int i = 0; i < s.length(); i++){
					
					if(s.charAt(i) == DOT){
						
						root = root.getLeft();
						
					}
					
					else if(s.charAt(i) == DASH){
						
						root = root.getRight();
						
					}
					
					else{
						
						text.append(' ');
						
					}
					
				}
														
				if(s.charAt(s.length() - 1) == DOT){
					
					text.append(root.getData());
					
				}
				
				else if(s.charAt(s.length() - 1) == DASH){
					
					text.append(root.getData());
					
				}
				
			}
			
		}
		
		return text.toString();
		
	}
	
}
