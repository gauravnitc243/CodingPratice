package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Collections;

public class SortedPermutationRankBigInteger {

	public static void main(String[] args)
	{
		//System.out.println(findRank("ZCSFLVHXRYJQKWABGT"));
		System.out.println(findRank("GRAMMAR"));
	}
	
	public static int findRank(String a) 
	{
		ArrayList<Character> input = new ArrayList<Character>();
		for (char c : a.toCharArray()) {
			input.add(c);
		}
		Collections.sort(input);
		java.math.BigInteger result = new java.math.BigInteger("0");
		
		for(int i=0;i<a.length();i++)
		{
			
			result = result.add((factorial(a.length()-i-1)).multiply(new java.math.BigInteger(""+input.indexOf(a.charAt(i)))));
			input.remove(input.indexOf(a.charAt(i)));
		}
		return result.mod(new java.math.BigInteger(1000003+"")).intValue()+1;
	}
	
	 public static java.math.BigInteger factorial(long n) 
	 {
		 java.math.BigInteger fact = new java.math.BigInteger("1");
	       for (int i = 1; i <= n; i++) 
	       {
	           fact = fact.multiply(new java.math.BigInteger(i + ""));
	       }
	        return fact;
	    }

}
