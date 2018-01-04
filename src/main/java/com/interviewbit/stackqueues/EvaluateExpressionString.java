package com.interviewbit.stackqueues;

import java.util.Stack;

public class EvaluateExpressionString {
	
	public static int evaluateExpression(String expr) {
		char[] tokens = expr.toCharArray();
		Stack<Integer> valueStack = new Stack<Integer>();
		Stack<Character> operatorStack = new Stack<Character>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] == ' ')
				continue;
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer sbuf = new StringBuffer();
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sbuf.append(tokens[i++]);
				valueStack.push(Integer.parseInt(sbuf.toString()));
			} else if (tokens[i] == '(')
				operatorStack.push(tokens[i]);
			else if (tokens[i] == ')') {
				while (operatorStack.peek() != '(')
					valueStack.push(performOperation(operatorStack.pop(), valueStack.pop(), valueStack.pop()));
				operatorStack.pop();
			} else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
				while (!operatorStack.empty() && checkPrecedence(tokens[i], operatorStack.peek()))
					valueStack.push(performOperation(operatorStack.pop(), valueStack.pop(), valueStack.pop()));
				operatorStack.push(tokens[i]);
			}
		}
		while (!operatorStack.empty())
			valueStack.push(performOperation(operatorStack.pop(), valueStack.pop(), valueStack.pop()));
		return valueStack.pop();
	}

	public static boolean checkPrecedence(char firstOperator, char secondOperator) {
		if ((secondOperator == '(' || secondOperator == ')') || (firstOperator == '*' || firstOperator == '/') && (secondOperator == '+' || secondOperator == '-'))
			return false;
		else
			return true;
	}

	public static int performOperation(char operator, int b, int a) {
		switch (operator) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return a / b;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(EvaluateExpressionString.evaluateExpression("5  +  6  *  7"));
		System.out.println(EvaluateExpressionString.evaluateExpression("10 + 2 * 6"));
		System.out.println(EvaluateExpressionString.evaluateExpression("100 * 2 + 12"));
		System.out.println(EvaluateExpressionString.evaluateExpression("100 * ( 2 + 12 )"));
		System.out.println(EvaluateExpressionString.evaluateExpression("100 * ( 2 + 12 ) / 14"));
	}

}
