package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence
{

	public static void main(String[] args)
	{
		System.out.println(longestConsecutive(new ArrayList<Integer>(Arrays.asList(100, 4, 200, 1, 3, 2))));

	}
	
	 public  static  int longestConsecutive(ArrayList<Integer> nums)
	 {
	        HashSet<Integer> set = new HashSet<>(nums);
	        int max = 0;
	        for(int i: nums)
	        {
	        	int left = i-1;
	        	int right = i+1;
	        	int count = 1;
	        	while(set.contains(left))
	        	{
	        		set.remove(i);
	        		left--;
	        		count++;
	        	}
	        	while(set.contains(right))
	        	{
	        		set.remove(right);
	        		right++;
	        		count++;
	        	}
	        	max = Math.max(count, max);
	        }
	        return max;
	 }

}
