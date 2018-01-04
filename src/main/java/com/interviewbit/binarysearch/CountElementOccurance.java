package com.interviewbit.binarysearch;

import java.util.Arrays;
import java.util.List;

public class CountElementOccurance {

	public static void main(String[] args) 
	{
		
		System.out.println(findCount(Arrays.asList( 4, 7, 7, 7, 8, 10, 10), 3));
	}
	
	public static  int findCount(final List<Integer> a, int b) {
		int firstIndex = binarySearch(a,b,true);
		int lastIndex = binarySearch(a,b,false);
		if(firstIndex==-1)
			return 0;
		else
		return lastIndex-firstIndex+1;
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
