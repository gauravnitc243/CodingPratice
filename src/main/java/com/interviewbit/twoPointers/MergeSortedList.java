package com.interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortedList
{

	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1,5,8));
		ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(6,9));
		merge(a, b);
		System.out.println(a);

	}
	
	public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) 
	{
		int i =0,j=0;
		while(i<a.size() && j<b.size())
		{
			if(a.get(i)>=b.get(j))
			{
				a.add(i++, b.get(j++));
			}
			else
			{
				i++;
			}
		}
		if(j<b.size())
		{
			for(;j<b.size();j++)
				a.add(b.get(j));
		}
	}

}
