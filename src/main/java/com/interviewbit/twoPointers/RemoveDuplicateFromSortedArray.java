package com.interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicateFromSortedArray
{

	public static void main(String[] args)
	{
		ArrayList<Integer> a   = new ArrayList<>(Arrays.asList(1,1,1,2));
		
		System.out.println(removeDuplicatesMoreThen2(a));
	}
	
	public static int removeDuplicates(ArrayList<Integer> a)
	{
		for(int i =a.size()-2;i>=0;i--)
		{
			if(a.get(i).equals(a.get(i+1)))
			{
				a.remove(i);
			}
		}
		return a.size();
	}
	public static int removeDuplicatesMoreThen2(ArrayList<Integer> a)
	{
		if(a.size()<=2)
			return a.size();
		for(int i =a.size()-3;i>=0;i--)
		{
			if(a.get(i).equals(a.get(i+2)))
			{
				a.remove(i);
			}
		}
		return a.size();
	}

}
