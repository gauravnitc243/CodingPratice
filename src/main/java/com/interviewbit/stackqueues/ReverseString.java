package com.interviewbit.stackqueues;

import java.util.Stack;

public class ReverseString
{

	public static void main(String[] args)
	{
		System.out.println(reverseString("jitender"));

	}
	public static String reverseString(String a) 
	{
		char[] input = a.toCharArray();
		Stack<Character> temp = new Stack<Character>();
		for(char i : input)
		{
			temp.push(i);
		}
		StringBuffer sb = new StringBuffer();
		while(!temp.isEmpty())
		{
			sb.append(temp.pop());
		}
		return sb.toString();
	}

}
