package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.HashSet;

public class Combinations
{

	public static void main(String[] args)
	{
		System.out.println(combine(5, 3));

	}
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) 
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i =1;i<=n;i++)
			a.add(i);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		findCombinations(a,new ArrayList<Integer>(),result,0,k);
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(result);
		for(ArrayList<Integer> i : result)
		{
			if(set.contains(i))
			{
				res.add(i);
				set.remove(i);
			}
		}
		return res;
	}
	public static void findCombinations(ArrayList<Integer> input , ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> result,int index,int k)
	{
		if(temp.size()==k)
		{
			result.add(new ArrayList<>(temp));
			return ;
		}
		for(int i =index;i<input.size();i++)
		{
			temp.add(input.get(i));
			findCombinations(input, temp, result, i+1,k);
			temp.remove(temp.indexOf(input.get(i)));
		}
	}

}
