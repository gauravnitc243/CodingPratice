package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubSet
{

	public static void main(String[] args)
	{
		System.out.println(subsets(new ArrayList<>(Arrays.asList(1,2,3))));
	}
	
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) 
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        if (a == null || a.size() == 0) {
            return result;
        }
        Collections.sort(a);
        addSubSets(a,new ArrayList<Integer>(),result,0);
        return result;
	}
	
	public static void addSubSets(ArrayList<Integer> input,ArrayList<Integer> tempResult,ArrayList<ArrayList<Integer>> result,int currentIndex)
	{
		for(int i =currentIndex;i<input.size();i++)
		{
			tempResult.add(input.get(i));
			result.add(new ArrayList<>(tempResult));
			System.out.println("tempresult "+tempResult +" result "+result+"currentIndex"+(currentIndex+1));
			addSubSets(input, tempResult, result, i+1);
			tempResult.remove(input.get(i));
		}
	}
}