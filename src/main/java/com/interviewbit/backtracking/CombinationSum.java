package com.interviewbit.backtracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class CombinationSum
{

	public static void main(String[] args)
	{
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(10,1,2,7,6,1,5));
		System.out.println(combinationSum(input, 8));
	}
	
	public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) 
	{
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    if(a == null || a.size() == 0)
	        return result;
	    Collections.sort(a);            
	    ArrayList<Integer> temp = new ArrayList<Integer>();    
	    getCombination(a, 0, b, temp, result);
	    HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(result);
	    result.clear();
	    result.addAll(set);
	    return result;
	}
	public static void getCombination(ArrayList<Integer> num, int start, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result)
	{
	    if(target == 0)
	    {
	        ArrayList<Integer> t = new ArrayList<Integer>(temp);
	        result.add(t);
	        return;
	    }
	    for(int i=start; i<num.size(); i++)
	    {
	        if(target < num.get(i))
	            break;
	        temp.add(num.get(i));
	        getCombination(num, i+1, target-num.get(i), temp, result);
	        temp.remove(temp.size()-1);
	    }
	}
}
