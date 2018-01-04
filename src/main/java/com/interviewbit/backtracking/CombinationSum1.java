package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSum1
{

	public static void main(String[] args)
	{
		System.out.println(combinationSum(new ArrayList<>(Arrays.asList(8, 10, 6, 11, 1, 16, 8)), 28));

	}
	
	public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) 
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Collections.sort(a);
		findCombinations(a,new ArrayList<Integer>(),b,result,0);
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
	public static void findCombinations(ArrayList<Integer> input , ArrayList<Integer> temp,int target,ArrayList<ArrayList<Integer>> result,int index)
	{
		if(target==0)
		{
			result.add(new ArrayList<>(temp));
			return ;
		}
		for(int i =index;i<input.size();i++)
		{
			if(input.get(i)>target)
				break;
			temp.add(input.get(i));
			if(input.get(i)<=target-input.get(i))
				findCombinations(input, temp, target-input.get(i), result, i);
			else
				findCombinations(input, temp, target-input.get(i), result, i+1);
			temp.remove(temp.indexOf(input.get(i)));
		}
	}

}
