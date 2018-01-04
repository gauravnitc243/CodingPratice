package com.interviewbit.strings;

public class Palindrome
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
	
	
	public static int isPalindrome(String a)
	{
		StringBuilder input = new StringBuilder(a.replaceAll("[^A-Za-z0-9]", ""));
		if(input.toString().equalsIgnoreCase(input.reverse().toString()))
			return 1;
		else return 0;
	}

}
