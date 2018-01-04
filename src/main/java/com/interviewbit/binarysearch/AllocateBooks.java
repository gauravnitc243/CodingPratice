package com.interviewbit.binarysearch;

import java.util.ArrayList;

public class AllocateBooks
{

	public static void main(String[] args)
	{
		ArrayList<Integer> c = new ArrayList<Integer>();
		c.add(12);
		c.add(34);
		c.add(67);
		c.add(90);
		System.out.println(books(c, 2));
	}
	
	public static int books(ArrayList<Integer> a, int b) 
	{
		if(b<1 || b>a.size())
			return -1;
		Long hi = Long.MAX_VALUE;
		long lo =0;
		long res =Long.MAX_VALUE;
		long mid;
		while(lo<=hi)
		{
			mid = lo + (hi-lo)/2;
			boolean isAllocatable = isPossible(a,b,mid);
			if(isAllocatable)
			{
				res = mid;
				hi = mid-1;
			}
			else
			{
				lo = mid+1;
			}
		}
		return (int)res;	
	}
	
	public static boolean isPossible(ArrayList<Integer> bookList,int numOfStudents,long time)
	{
		int total =0;
		int n = bookList.size();
		int index = 0;
		for(int i =0;i<numOfStudents && index < n;i++)
		{
			total =0;
			while(time>total && index<n)
			{
				total +=bookList.get(index);
				if(total>time)
					break;
				index++;
			}
		}
		if (index != n)
	        return false;
	    return true;
				
	}
	

}
