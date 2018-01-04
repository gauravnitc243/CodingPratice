package com.interviewbit.twoPointers;

import java.util.ArrayList;

public class ContainersWithMostWater
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public int maxArea(ArrayList<Integer> a) 
	{
		if (a == null || a.size() < 2) {
			return 0;
		}
		int max = 0;
		int left = 0;
		int right = a.size() - 1;
	 
		while (left < right) {
			max = Math.max(max, (right - left) * Math.min(a.get(left), a.get(right)));
			if (a.get(left) < a.get(right))
				left++;
			else
				right--;
		}
	 
		return max;
	}

}
