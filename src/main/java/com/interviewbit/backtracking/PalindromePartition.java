package com.interviewbit.backtracking;
import java.util.ArrayList;

public class PalindromePartition
{
	public static ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	public static void main(String[] args)
	{
		System.out.println(partition("aab"));
	}
	public static ArrayList<ArrayList<String>> partition(String a) 
	{
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (a == null || a.length() == 0) {
			return result;
		}
		ArrayList<String> partition = new ArrayList<String>();
		findPermutations(a, 0, partition, result);
		return result;
    }
	
	public static void findPermutations(String input,int startIndex,ArrayList<String> partition,ArrayList<ArrayList<String>> result)
	{
		if (startIndex == input.length()) 
		{
			ArrayList<String> temp = new ArrayList<String>(partition);
			result.add(temp);
			return;
		}
		for (int i = startIndex + 1; i <= input.length(); i++) 
		{
			String str = input.substring(startIndex, i);
			if (isPalindrome(str))
			{
				partition.add(str); 
				findPermutations(input, i, partition, result);
				partition.remove(partition.size() - 1);
			}
		}
	}
	
	public static boolean isPalindrome(String s)
	{
		return new StringBuilder(s).reverse().toString().equals(s);
	}

}
