package com.interviewbit.backtracking;

import java.util.ArrayList;

public class KthPermutationSeq
{

	public static void main(String[] args)
	{
		
	//	for(int i = 0;i<6;i++)
			System.out.println(getPermutation(5, 61));

	}
	
	public static String getPermutation(int n, int k) 
	{
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer>  input = new ArrayList<>();
		for(int i = 1;i<=n;i++)
			input.add(i);
		int j=0;
		k--;
		while(j<k)
		{
			int fact = fact(input.size()-1);
			int t  = k/fact;
			sb.append(input.get(t));
			input.remove(t);
			k= k%fact;
		}
		for(int i:input)
			sb.append(i);
		return sb.toString();
	}
	public static int fact(int j)
	{ 
		if (j > 12) 
			return Integer.MAX_VALUE;
	    int fact = 1;
	    for (int i = 2; i <= j; i++) fact *= i;
	    return fact;
    }
}
