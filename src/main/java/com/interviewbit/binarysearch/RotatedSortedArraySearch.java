package com.interviewbit.binarysearch;

import java.util.Arrays;
import java.util.List;

public class RotatedSortedArraySearch
{

	public static void main(String[] args)
	{
		Integer[] input = { 101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100 };
		RotatedSortedArraySearch s = new RotatedSortedArraySearch();
		System.out.println(s.search(Arrays.asList(input),202));
	}
	
	
	public int search(final List<Integer> a, int b) 
	{
		int lo = 0 ;
		int hi = a.size()-1;
		while(lo<=hi)
		{
			if(a.get(lo)<=a.get(hi))
			{
				int i = binarySearch(a,b,lo,a.size()-1);
				if(i!=-1)
					return i;
				else
					return binarySearch(a,b,0,lo-1);
			}
			int mid = lo+(hi-lo)/2;
			int next = (mid+1)%a.size();
			int prev = (mid+a.size()-1)%a.size();
			if(a.get(mid)<=a.get(next) && a.get(mid)<=a.get(prev))
			{
				int i = binarySearch(a,b,0,mid-1);
				if(i!=-1)
					return i;
				else
					return binarySearch(a,b,mid,a.size()-1);
			}
			else if(a.get(mid)<=a.get(hi))
				hi = mid-1;
			else if(a.get(mid)>=a.get(hi))
				lo =mid+1;
		}
		return -1;
	}
	
	public int binarySearch(List<Integer> a, int b,int lo,int hi)
	{
		int foundIndex = -1;
		while(lo<=hi)
		{
			int mid = lo+(hi-lo)/2;
			if(a.get(mid)==b)
				return mid;
			else if(a.get(mid) > b)
				hi = mid-1;
			else
				lo = mid+1;
		}
		return foundIndex;
	}

}
