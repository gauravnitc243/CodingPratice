package com.interviewbit.twoPointers;

import java.util.Collections;
import java.util.List;

public class KthSmallestNumber
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	public int kthsmallest(final List<Integer> a, int k) 
	{
		Collections.sort(a);
		return a.get(k-1);
	}

}
