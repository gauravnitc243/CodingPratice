package com.interviewbit.binarysearch;

public class StringRevrese
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(reverseWords(""));
	}
	
	public static String reverseWords(String a)
	{
		a = a.trim().replaceAll(" +", " ");
		StringBuilder result = new StringBuilder();
		String [] input = a.split(" ");
		for(int i = input.length-1;i>0;i--)
			result.append(input[i]+" ");
		result.append(input[0]);
		return result.toString();
	}

}
