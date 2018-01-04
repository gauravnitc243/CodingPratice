package com.interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfSortedArrays
{

	public static void main(String[] args)
	{
		ArrayList<Integer> a   = new ArrayList<>(Arrays.asList(1 ,2 ,3, 3, 4, 5, 6));
		ArrayList<Integer> b   = new ArrayList<>(Arrays.asList(3  ,5));
		System.out.println(intersection(a, b));

	}
	
	public static ArrayList<Integer> intersection(ArrayList<Integer> a,ArrayList<Integer> b)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i =0,j=0;i<a.size() && j<b.size();)
		{
			if(a.get(i)<b.get(j))
				i++;
			else if(a.get(i)>b.get(j))
				j++;
			else
			{
				result.add(a.get(i));
				i++;
				j++;
			}
		}
		return result;
	}


}
