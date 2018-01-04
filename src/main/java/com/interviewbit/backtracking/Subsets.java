package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Subsets
{
	public static void main(String[] args)
	{
		System.out.println(subsetsWithDup(new ArrayList<>(Arrays.asList(1,2,2))));
	}
	
	public static  ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) 
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		res.add(new ArrayList<>());
		Collections.sort(a);
		subsets(result,a,new ArrayList<Integer>(),0 );
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
	
	public static void subsets(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> input,ArrayList<Integer> temp,int index )
	{
		for(int i =index;i<input.size();i++)
		{
			temp.add(input.get(i));
			result.add(new ArrayList<>(temp));
			subsets(result,input,temp,i+1 );
			temp.remove(temp.indexOf(input.get(i)));
		}
	}

}
