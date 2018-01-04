package com.interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayThreePointer
{

	public static void main(String[] args)
	{
		/*List<Integer> a= new ArrayList<Integer>(Arrays.asList(1,4,10));
		List<Integer> b= new ArrayList<Integer>(Arrays.asList(2,15,20));
		List<Integer> c= new ArrayList<Integer>(Arrays.asList(10,12));*/
		List<Integer> a= new ArrayList<Integer>(Arrays.asList(1));
		List<Integer> b= new ArrayList<Integer>(Arrays.asList(1));
		List<Integer> c= new ArrayList<Integer>(Arrays.asList(1));
		System.out.println(minimize(a,b,c));

	}
	
	public static int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) 
	{
		int p1=0,p2=0,p3=0,min = Integer.MAX_VALUE;
		while(p1<a.size() && p2<b.size() && p3<c.size())
		{
			min = Math.min(min, Math.max(a.get(p1),Math.max(b.get(p2), c.get(p3)))-Math.min(a.get(p1),Math.min(b.get(p2), c.get(p3))));
			if(a.get(p1)<=b.get(p2) && a.get(p1)<= c.get(p3))
				p1++;
			else if(b.get(p2)<=c.get(p3) && b.get(p2)<= a.get(p1))
				p2++;
			else 
				p3++;
		}
		return min;
	}
}
