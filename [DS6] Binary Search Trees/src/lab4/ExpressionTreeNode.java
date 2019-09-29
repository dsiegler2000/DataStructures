package lab4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import binarysearchtree.BinarySearchTreeNode;

public class ExpressionTreeNode<E extends String> extends BinarySearchTreeNode<String> {

	private static ArrayList<String> validOperators = new ArrayList<>();;

	static {

		validOperators.add("+");
		validOperators.add("-");
		validOperators.add("*");
		validOperators.add("/");

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		System.out.println("Input expression in postfix: \n");
		
		String input = in.nextLine();
		
		String[] postfix = input.split("");
		
		System.out.println(toExpressionTree(postfix).evaluate());
		
		in.close();
		
	}

	public ExpressionTreeNode(String value) {
		
		super(value);

	}

	public boolean isOperand() {

		if (this.getData().matches("^\\d+$")) {

			return true;

		}

		return false;

	}

	public int integerValue() {

		if (this.isOperand()) {

			return Integer.parseInt(this.getData());

		}

		throw new IllegalStateException("This node isn't an operand!");

	}

	@SuppressWarnings("unchecked")
	public int evaluate() {

		return evaluate((ExpressionTreeNode<String>) this);

	}

	public static int evaluate(ExpressionTreeNode<String> root) {

		if (root != null) {

			if (root.isOperand()) {

				return root.integerValue();

			}

			switch (root.getData()) {

			case "+":
				return evaluate((ExpressionTreeNode<String>) root.getRight())
						+ evaluate((ExpressionTreeNode<String>) root.getLeft());
			case "-":
				return evaluate((ExpressionTreeNode<String>) root.getRight())
						- evaluate((ExpressionTreeNode<String>) root.getLeft());
			case "*":
				return evaluate((ExpressionTreeNode<String>) root.getRight())
						* evaluate((ExpressionTreeNode<String>) root.getLeft());
			case "/":
				return evaluate((ExpressionTreeNode<String>) root.getRight())
						/ evaluate((ExpressionTreeNode<String>) root.getLeft());

			}

		}

		return 0;

	}

	@SuppressWarnings("unchecked")
	public String toInfixNotation() {

		return toInfixNotation((ExpressionTreeNode<String>) this);

	}

	public static String toInfixNotation(ExpressionTreeNode<String> root) {

		if (root != null) {

			StringBuilder str = new StringBuilder();

			str.append(toInfixNotation((ExpressionTreeNode<String>) root.getLeft()));
			str.append(root);
			str.append(toInfixNotation((ExpressionTreeNode<String>) root.getRight()));

		}

		return "";

	}

	public static int evaluatePostfix(String[] tokens) {

		StringBuilder str = new StringBuilder();

		for (String s : tokens) {

			str.append(s);

		}

		String postfix = str.toString();

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < postfix.length(); i++) {

			if (!validOperators.contains(postfix.charAt(i))) {

				stack.push(Integer.parseInt("" + postfix.charAt(i)));

			}

			else if (postfix.charAt(i) == ' ') {

				break;

			}

			else {

				int a = Integer.parseInt(stack.pop().toString());
				int b = Integer.parseInt(stack.pop().toString());

				switch (postfix.charAt(i)) {

				case '+':
					stack.push(b + a);
					break;
				case '-':
					stack.push(b - a);
					break;
				case '*':
					stack.push(b * a);
					break;
				case '/':
					stack.push(b / a);
					break;

				}

			}

		}

		return stack.peek();

	}

	public static ExpressionTreeNode<String> toExpressionTree(String[] tokens) {
		
		Stack<ExpressionTreeNode<String>> stack = new Stack<>();
		
		for(String s : tokens){
			
			if(!validOperators.contains(s) && s.matches("^\\d+$") && !s.equals(" ") && !s.equals("")){
												
				ExpressionTreeNode<String> node = new ExpressionTreeNode<>(s);
				stack.push(node);
				
			}
			
			else if(validOperators.contains(s)){
								
				ExpressionTreeNode<String> root = new ExpressionTreeNode<>(s);

				root.setLeft(stack.pop());
				root.setRight(stack.pop());
				
				stack.push(root);
				
			}
			
		}
		
		return stack.pop();

	}

}
