package com.interviewbit.stackqueues;

import java.util.Stack;

public class RedudantBraces
{

	public static void main(String[] args)
	{
		System.out.println(braces("(a*b)+(b*c)"));
	}
	public static int braces(String a)
	{
		char[] input = a.toCharArray();
		Stack<Character> temp = new Stack<Character>();
		StringBuilder sb  = new StringBuilder();
		boolean isBraceFound = false;
		for(char i : input)
		{
			sb = new StringBuilder();
			temp.push(i);
			if(i==')')
			{
				isBraceFound = true;
				while(!temp.isEmpty())
				{
					char t = temp.pop();
					sb.append(t);
					if(t=='(')
						break;
				}
				if(sb.length()<4)
					return 1;
			}
		}
		while(!temp.isEmpty())
		{
			char t = temp.pop();
			if(t=='(' || t==')')
				return 1;
		}
		if(temp.isEmpty() || !isBraceFound)
			return 0;
		return 1;
	}

}
