package com.interviewbit.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix
{

	public static void main(String[] args)
	{
		ArrayList<String> in = new ArrayList<String>(Arrays.asList( "abcdefgh", "aefghijk", "abcefgh"));
	//	ArrayList<String> in = new ArrayList<String>(Arrays.asList("abcd", "aze" ));
		System.out.println(longestCommonPrefix(in));

	}
	
	public static String longestCommonPrefix(ArrayList<String> a) 
	{
		if(a.size()==1)
			return a.get(0);
		else if(a.isEmpty())
			return "";
		ArrayList<String> prefix = new ArrayList<String>();
		String first = a.get(0);
		for(int i=first.length();i>0;i--)
			prefix.add(first.substring(0, i));
		int i=0;
		boolean found = false;
outer:	for(String b : prefix)
		{
			for(i=1;i<=a.size()-1;i++)
			{
				if(!(a.get(i).contains(b)))
					continue outer;
				if(a.get(a.size()-1).contains(b))
					found = true;
			}
			if(i==a.size() && found)
				return b;
		}
		
		return "";
	}

}
