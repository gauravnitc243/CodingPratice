package com.interviewbit.hashing;

import java.util.HashSet;

public class ColourNumber
{

	public static void main(String[] args)
	{
		System.out.println(colorful(32451));

	}
	
	public static int colorful(int a) 
	{
		HashSet<Integer> set = new HashSet<Integer>();
		String input = ""+a;
		int t = 0;
		for(int i = 0 ;i<input.length();i++)
		{
			if(set.contains(Character.getNumericValue(input.charAt(i))))
				return 0;
			else
				set.add(Character.getNumericValue(input.charAt(i)));
			for(int j = i+1 ;j<input.length();j++)
			{
				t = getMultiplicationValue(input.substring(i,j+1));
				if(set.contains(t))
					return 0;
				else
					set.add(t);
			}
		}
		return 1;
	}
	
	public static int getMultiplicationValue(String a)
	{
		int rest = 1;
		for(int i =0;i<a.length();i++)
		{
			rest *= Character.getNumericValue(a.charAt(i));
		}
		return rest;
	}

}
