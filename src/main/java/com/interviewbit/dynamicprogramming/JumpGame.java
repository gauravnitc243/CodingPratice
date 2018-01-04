package com.interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class JumpGame
{

	public static void main(String[] args)
	{
		System.out.println(canJump(new ArrayList<Integer>(Arrays.asList(2,3,1,1,4))));
		System.out.println(canJump(new ArrayList<Integer>(Arrays.asList(3,2,1,0,4))));

	}
	
	public int jump(ArrayList<Integer> a) 
	{
	    if(a.get(0)==0 && a.size()>1)
	        return -1;
		if(a.size()==0 || a.get(0)==0)
			return 0;
		int maxReach = 0;
		int lastReach = 0;
		int totalSteps =0 ;
		for(int i =0;i<=maxReach && i<a.size();i++)
		{
			if(i>lastReach)
			{
				totalSteps++;
				lastReach = maxReach;
			}
			maxReach = Math.max(maxReach, i+a.get(i));
		}
		if(maxReach<a.size())
			return -1;
		else
			return totalSteps;
	}
	
	
	public static int canJump(ArrayList<Integer> a)
	{
		if(a.size()<2)
			return 1;
		int maxReach = a.get(0);
		for(int i =0;i<a.size();i++)
		{
			if(maxReach<=i && a.get(i)==0)
				return 0;
			if(maxReach<i+a.get(i))
				maxReach = i+a.get(i);
			if(maxReach>=a.size())
				return 1;
		}
		return 0; 
	}
}
