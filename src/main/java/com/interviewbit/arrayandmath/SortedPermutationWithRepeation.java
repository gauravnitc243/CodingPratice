package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class SortedPermutationWithRepeation {

	public static void main(String[] args) 
	{
		System.out.println(findRank("bbbbaaaa"));
	}
	
	public static int findRank(String a) 
	{
		TreeMap<Character,Integer>  allCharsInString = new TreeMap<Character,Integer>();
		ArrayList<Character> input = new ArrayList<Character>();
		java.math.BigInteger result = new java.math.BigInteger("0");
		for(int i =0;i<a.length();i++)
		{
			input.add(a.charAt(i));
			if(allCharsInString.containsKey(a.charAt(i)))
				allCharsInString.put(a.charAt(i), allCharsInString.get(a.charAt(i))+1);
			else
			{
				allCharsInString.put(a.charAt(i), 1);
			}
		}
		Collections.sort(input);
		for(int i=0;i<a.length();i++)
		{
			result = result.add((factorial(a.length()-i-1)).multiply(new java.math.BigInteger(""+input.indexOf(a.charAt(i)))).divide(getAllChareFact(allCharsInString,a.charAt(i))));
			input.remove(input.indexOf(a.charAt(i)));
		}
		return result.mod(new java.math.BigInteger(1000003+"")).intValue()+1;
	}
	
	public static java.math.BigInteger getAllChareFact(TreeMap<Character,Integer>  allCharsInString,char a)
	{
		java.math.BigInteger fact = new java.math.BigInteger("1");
		for(Character c : allCharsInString.keySet())
		{
			fact = fact.multiply(factorial(allCharsInString.get(c)));
			if(c==a)
			{
				int t = allCharsInString.get(c)-1;
				if(t==0)
					allCharsInString.put(c, 1);
				else
					allCharsInString.put(c, t);
			}
		}
		return fact;
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
