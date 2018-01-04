package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Diffk
{

	public static void main(String[] args)
	{
		System.out.println(diffPossible(new ArrayList<>(Arrays.asList( 77, 28, 19, 21, 67, 15, 53, 25, 82, 52, 8, 94, 50, 30, 37, 39, 9, 43, 35, 48, 82, 53, 16, 20, 13, 95, 18, 67, 77, 12, 93, 0 )), 53));
	}
	
	public static int diffPossible(final List<Integer> a, int b) 
	{
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i:a)
		{
			if(set.contains(i-b) || set.contains(i+b))
				return 1;
			else
				set.add(i);
		}
		return 0;
	}

}
