package com.interviewbit.stackqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class EvaluateExpression
{
	public static void main(String[] args)
	{
		System.out.println(evaluate("(5+4)"));
		System.out.println(evalRPN(new ArrayList<String>(Arrays.asList("2","1","+","3","*"))));
	}
	
	public static int evaluate(String a)
	{
		a = "("+a+")";
		Stack<Character> operators = new Stack<Character>(); 
		Stack<Integer> operands = new Stack<Integer>(); 
		char t;
		for(int i =0;i<a.length();i++)
		{
			t = a.charAt(i); 
			if(t=='-' || t=='+' || t=='/' || t=='*')
			{
				operators.push(t);
			}
			else if (t!=')' &&  t!='(')
			{
				operands.push(Character.getNumericValue(t));
			}
			else if (t==')' && !operands.isEmpty() && !operators.isEmpty())
			{
				int res =0;
				char operator = operators.pop();
				int second = operands.pop();
				int first = operands.pop();
				if(operator=='-')
					res = first - second;
				else if(operator=='+')
					res = first + second;
				else if(operator=='*')
					res = first * second;
				else if(operator=='/')
					res = first / second;
				operands.push(res);
			}
		}
		return operands.pop();
	}
	public static int evalRPN(ArrayList<String> a)
	{
		Stack<Integer> operands = new Stack<Integer>(); 
		for(int i =0;i<a.size();i++)
		{
			String t = a.get(i);
			if(t.equals("-") || t.equals("+") ||t.equals("*") ||t.equals("/"))
			{
				int res=0;
				int second = operands.pop();
				int first = operands.pop();
				if(t.equals("-"))
					res = first - second;
				else if(t.equals("+"))
					res = first + second;
				else if(t.equals("*"))
					res = first * second;
				else if(t.equals("/"))
					res = first / second;
				operands.push(res);
			}
			else
			{
				operands.push(Integer.parseInt(t));
			}
		}
		return operands.peek();
	}

}
