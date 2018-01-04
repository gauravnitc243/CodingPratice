package com.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeSearch
{

	public static void main(String[] args)
	{
		Integer[] input ={5, 7, 7, 8, 8, 10};
		System.out.println(searchRange(Arrays.asList(input), 8));

	}
	
	public static ArrayList<Integer> searchRange(final List<Integer> a, int b) 
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		int firstIndex = binarySearch(a,b,true);
		int lastIndex = binarySearch(a,b,false);
		if(firstIndex==-1)
		{
			result.add(-1);
			result.add(-1);
			
		}
		else
		{
			result.add(firstIndex);
			result.add(lastIndex);
		}
		return result;
	}
	
	public static  int binarySearch(final List<Integer> a, int b,boolean isFirstOccurance)
	{
		int lo = 0 ;
		int hi = a.size()-1;
		int foundIndex = -1;
		while(lo<=hi)
		{
			int mid = lo+(hi-lo)/2;
			if(a.get(mid)==b)
			{
				foundIndex = mid;
				if(isFirstOccurance)
					hi = mid-1;
				if(!isFirstOccurance)
					lo = mid+1;
			}
			else if(a.get(mid) > b)
				hi = mid-1;
			else
				lo = mid+1;
		}
		return foundIndex;
	}
}
