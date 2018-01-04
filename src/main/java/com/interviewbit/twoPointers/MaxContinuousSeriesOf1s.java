package com.interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxContinuousSeriesOf1s
{

	public static void main(String[] args)
	{
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1 ,1 ,0 ,1 ,1 ,0 ,0 ,1 ,1 ,1 ));
		ArrayList<Integer> input1 = new ArrayList<>(Arrays.asList( 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0));
		ArrayList<Integer> input3 = new ArrayList<>(Arrays.asList(1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0 ));
		System.out.println(maxone(input, 1));
		System.out.println(maxone(input1, 7));
		System.out.println(maxone(input3, 4));
	}
	
	public static ArrayList<Integer> maxone(ArrayList<Integer> a, int b) 
	{
		 ArrayList<Integer> result = new  ArrayList<Integer>();
		 int zeroCount = 0;
		 int lo = 0;
		 int hi = 0;
		 int best = -1;
		 int bestLoIndex = 0;
		 int bestHiIndex = 0;
		 while(hi<a.size())
		 {
			 if(zeroCount<=b )
			 {
				 if(a.get(hi)==0)
					 zeroCount++;
				 hi++;
			 }
			 
			 if(zeroCount>b)
			 {
				 if(a.get(lo)==0)
					 zeroCount--;
				 lo++;
			 }
			 if(hi-lo> best)
			 {
				 best = hi-lo;
				 bestLoIndex = lo;
				 bestHiIndex = hi-1;
			 }
		 }
		 
		 for(int i = bestLoIndex;i<=bestHiIndex;i++)
			 result.add(i);
		 return result;
	}

}
