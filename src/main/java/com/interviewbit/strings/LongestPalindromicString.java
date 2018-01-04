package com.interviewbit.strings;

public class LongestPalindromicString
{

	public static void main(String[] args)
	{
		System.out.println(paliondrome("aa"));

	}
	
	public static String paliondrome(String a)
	{
		String result = a;
		int maxLength = 1;
		int start = 0;
		int low, high;
		for(int i =1;i<a.length();i++)
		{
		  	low = i - 1;
	        high = i;
	        while (low >= 0 && high < a.length() && a.charAt(low) == a.charAt(high))
	        {
	            if (high - low + 1 > maxLength)
	            {
	                start = low;
	                maxLength = high - low + 1;
	            }
	            --low;
	            ++high;
	        }
	        
	        low = i - 1;
	        high = i + 1;
	        while (low >= 0 && high < a.length() && a.charAt(low) == a.charAt(high))
	        {
	            if (high - low + 1 > maxLength)
	            {
	                start = low;
	                maxLength = high - low + 1;
	            }
	            --low;
	            ++high;
	        }
		}
			result = a.substring(start,start+maxLength);
		return result;
	}
}
