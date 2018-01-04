package com.interviewbit.arrayandmath;

public class PalindromeInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isPalindrome(123));
	}
	
	public static  boolean isPalindrome(int a) 
	{
		String input = ""+a;
		for(int i=0;i<input.length()/2;i++)
		{
			if(input.charAt(i) != input.charAt(input.length()-1-i))
				return false;
		}
		return true;
			
	}

}
