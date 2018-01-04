package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations
{
	public static void main(String[] args)
	{
		System.out.println(new Permutations().permute(new ArrayList<>(Arrays.asList(1,2,3))));
	}
	
	public  ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) 
	{
		 boolean[] currentlySelectedItems = new boolean[a.size()];
		 ArrayList<ArrayList<Integer>> result = new  ArrayList<ArrayList<Integer>>();
		 addPermutations(result,a,new ArrayList<Integer>(),currentlySelectedItems,0);
		 return result;
	}
	public void addPermutations(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> input,ArrayList<Integer> temp, boolean[] currentlySelectedItems,int index)
	{
		if(index==input.size())
		{
			result.add(new ArrayList<>(temp));
			return;
		}
		for(int i =0;i<input.size();i++)
		{
			if(!currentlySelectedItems[i])
			{
				currentlySelectedItems[i] = true;
				temp.add(input.get(i));
				addPermutations(result,input,temp,currentlySelectedItems,index+1);
				currentlySelectedItems[i] = false;
				temp.remove(temp.indexOf(input.get(i)));
			}
		}
	}
	
	
	
	
	
	
	
	
	
	/*public  ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) 
	{
	    n = a.size();
	    marked = new boolean[n];
	    res = new ArrayList<>();
	    this.a = a;
	    rec(0, new ArrayList<>());
	    return res;
	}
	public void rec(int index, ArrayList<Integer> temp)
	{
		    if (index == n) 
		    {
		        res.add(new ArrayList<>(temp));
		        return;
		    }
		    for (int i = 0; i < n; i++) 
		    {
		        if (!marked[i]) 
		        {
		            marked[i] = true;
		            temp.add(a.get(i));
		            rec(index + 1, temp);
		            marked[i] = false;
		            temp.remove(temp.size() - 1);
		        }
		    }
	}
		
	
	
	*/
	
	/*public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) 
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		for (int i = 0; i < a.size(); i++) 
		{
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> l : result) 
			{
				for (int j = 0; j <= l.size(); j++) 
				{
					l.add(j, a.get(i));
					ArrayList<Integer> temp = new ArrayList<Integer>(l);
					current.add(temp);
					l.remove(j);
				}
			}
			result = new ArrayList<ArrayList<Integer>>(current);
		}
		return result;
	}*/
}
