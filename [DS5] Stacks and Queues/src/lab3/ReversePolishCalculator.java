package lab3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class ReversePolishCalculator {

	private static ArrayList<Character> validOperators = new ArrayList<>();;

	static {

		validOperators.add('+');
		validOperators.add('-');
		validOperators.add('*');
		validOperators.add('/');

	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String expression = input.nextLine();

		System.out.println(evaluatePostfix(infixToPostfix(expression)));

		input.close();

	}

	public static String infixToPostfix(String infix) {

		Stack<Character> chars = new Stack<>();
		StringBuilder tmp = new StringBuilder();
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < infix.length(); i++) {

			if (infix.charAt(i) != ' ') {

				tmp.append(infix.charAt(i));

			}

		}

		infix = tmp.toString();

		for (int i = 0; i < infix.length(); i++) {

			if (infix.charAt(i) == '(') {

				chars.push('(');

			}

			else if (infix.charAt(i) == ' ') {

				break;

			}

			else if (infix.charAt(i) != '(' && infix.charAt(i) != ')' && validOperators.contains(infix.charAt(i))) {

				if (!chars.isEmpty()) {

					if (infix.charAt(i) == '*' || infix.charAt(i) == '/') {

						while (chars.peek() == '*' || chars.peek() == '/') {

							str.append(chars.pop());

						}

					}

					if (infix.charAt(i) == '+' || infix.charAt(i) == '-') {

						try {
							
							while (chars.peek() == '*' || chars.peek() == '/' || chars.peek() == '+' || chars.peek() == '-') {

								str.append(chars.pop());

							}
							
						} catch (EmptyStackException e) {}

					}

				}

				chars.push(infix.charAt(i));

			}

			else if (infix.charAt(i) != '(' && infix.charAt(i) != ')' && !validOperators.contains(infix.charAt(i))) {

				str.append(infix.charAt(i));

			}

			else if (infix.charAt(i) == ')') {

				while (chars.peek() != '(') {

					char popped = chars.pop();

					if (popped != '(') {

						str.append(popped);

					}

				}

				chars.pop();

			}

		}

		while (!chars.isEmpty()) {

			str.append(chars.pop());

		}

		return str.toString();

	}

	public static int evaluatePostfix(String postfix) {

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

}
