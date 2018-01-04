package com.interviewbit.stackqueues;

import java.util.ArrayList;
import java.util.Arrays;

public class TrappingRainWater
{

	public static void main(String[] args)
	{
		System.out.println(trapeWater(new ArrayList<Integer>(Arrays.asList(0,2,1,0,1,0,2,10,2,9))));
	}
	
	public static int trapeWater(ArrayList<Integer> a)
	{
		int n = a.size();
	    int leftMax[] =new int[n];
	    int rightMax[] = new int[n];
	    int water = 0;
	    leftMax[0] = a.get(0);
	    for (int i = 1; i < n; i++)
	       leftMax[i] = Math.max(leftMax[i-1], a.get(i));
	    rightMax[n-1] = a.get(n-1);
	    for (int i = n-2; i >= 0; i--)
	       rightMax[i] = Math.max(rightMax[i+1], a.get(i));
	    for (int i = 0; i < n; i++)
	       water += Math.min(leftMax[i],rightMax[i]) - a.get(i);
	    return water;
	  }

}
