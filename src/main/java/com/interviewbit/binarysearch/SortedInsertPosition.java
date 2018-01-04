package com.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedInsertPosition
{

	public static void main(String[] args)
	{
		System.out.println(searchInsert(new ArrayList<Integer>(Arrays.asList(1,3,5,6)), 7));

	}
	
	public static int searchInsert(ArrayList<Integer> a, int b)
	{
		int lo =0;
		int hi = a.size()-1;
		int index = 0;
		while(lo<=hi)
		{
			int mid = lo+(hi-lo)/2;
			if((a.get(mid)==b))
				return mid;
			else if(mid==0)
				return 0 ;
			else if(mid==a.size()-1)
				return a.size();
			else if((a.get(mid-1)<b && a.get(mid)>b))
				return mid;
			if(a.get(mid)>b)
				hi = mid-1;
			else if(a.get(mid)<b)
				lo = mid+1;
		}
		
		return index;
	}

}
