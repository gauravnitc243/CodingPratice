package com.interviewbit.stackqueues;

import java.util.Stack;

public class GenerateAllParentheses
{

	public static void main(String[] args)
	{
		System.out.println(isValid("()[]{}")); 

	}
	
	public static int isValid(String a) 
	{
		char[] input = a.toCharArray();
		Stack<Character> temp = new Stack<Character>();
		char t;
		for(char i : input)
		{
			if(i=='(' || i=='{' || i=='[')
				temp.push(i);
			else if(temp.isEmpty())
				return 0;
			else if(i==')')
			{
				t = temp.pop();
				if('('!= t)
					return 0;
			}
			else if(i=='}')
			{
				t = temp.pop();
				if('{'!= t)
					return 0;
			}
			else if(i==']')
			{
				t = temp.pop();
				if('['!= t)
					return 0;
			}
		}
		
		if(temp.isEmpty())
			return 1;
		else
			return 0;
	}


}
