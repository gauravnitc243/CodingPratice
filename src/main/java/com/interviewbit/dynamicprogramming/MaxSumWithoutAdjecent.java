package com.interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumWithoutAdjecent
{

	public static void main(String[] args)
	{
		System.out.println(max(new ArrayList<Integer>(Arrays.asList(5,  5, 10, 40, 50, 35))));

	}
	
	
	public static int max(ArrayList<Integer> a)
	{
		int maxIncluding = a.get(0);
		int maxExcluding = 0;
		int temp =0;
		for(int i =1;i<a.size();i++)
		{
			temp = Math.max(maxExcluding, maxIncluding);
			maxIncluding = a.get(i)+maxExcluding;
			maxExcluding = temp;
		}
		return maxExcluding>maxIncluding?maxExcluding:maxIncluding;
	}

	public int adjacent(ArrayList<ArrayList<Integer>> a) 
	{
		if(a.size() != 2)
			return 0;
		for(int i =0;i<a.get(0).size();i++)
			a.get(0).set(i, Math.max(a.get(0).get(i), a.get(1).get(i)));
		ArrayList<Integer> input = a.get(0);
		int maxIncluding = input.get(0);
		int maxExcluding = 0;
		
		for(int i=1;i<input.size();i++)
		{
			int t = Math.max(maxIncluding, maxExcluding);
			maxIncluding = input.get(i)+maxExcluding;
			maxExcluding = t;
		}
		return maxExcluding>maxIncluding?maxExcluding:maxIncluding;
	}
	
}
