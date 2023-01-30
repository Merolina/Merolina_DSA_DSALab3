package com.gl.dsa.question1;

import java.util.Stack;

public class BalancingBracket {
	public static void main(String[] args) {
		String Bracketexpression = "[{(a+b)*(c+d)}-{(a+b)*(c+d)}]";
		boolean result;
		result = checkBalancingBracket(Bracketexpression);
		if (result)
			System.out.println("The entered string has balanced brackets....");
		else
			System.out.println("The entered string does not contain balanced brackets....");
	}

	private static boolean checkBalancingBracket(String Bracketexpression) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < Bracketexpression.length(); i++) {
			char character = Bracketexpression.charAt(i);
			if (character == '(' || character == '{' || character == '[') {
				stack.push(character);
			} else if (character == ')' || character == '}' || character == ']') {
				if (stack.isEmpty())
					return false;
				stack.pop();
			}
		}

		return stack.isEmpty() ? true : false;
	}

}
