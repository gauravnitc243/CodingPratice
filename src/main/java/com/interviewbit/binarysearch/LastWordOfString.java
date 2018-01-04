package com.interviewbit.binarysearch;

public class LastWordOfString
{

	public static void main(String[] args)
	{
		
		System.out.println(lengthOfLastWord("Wordl   "));
	}
	public static int lengthOfLastWord(final String a) 
	{
		String b=a.trim();
		int count = 0;
		int length = b.length()-1;
		if(length==0)
			return 1;
		while(length >=0 && b.charAt(length--) != ' ')
		{
			count++;
		}
		return count;
			
	}

}
