package com.interviewbit.strings;

public class ValidNumber
{

	public static void main(String[] args)
	{
		System.out.println(isNumber("1.e1"));

	}
	
	public static int isNumber(final String a) 
	{
		String input = a.trim();
		if(a.charAt(a.length()-1)=='.')
			return 0;
		if(a.contains("e") && a.charAt(a.indexOf('e')-1)=='.')
			return 0;
		try
		{
			Double.valueOf(input);
		}
		catch(Exception e)
		{
			return 0;
		}
		return 1;
	}

}
