package com.interviewbit.greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class DistributeCandy
{

	public static void main(String[] args)
	{
		System.out.println(candySol(new ArrayList<Integer>(Arrays.asList(1,2))));

	}
	
	public static int candySol(ArrayList<Integer> ratings) 
	{
		ArrayList<Integer> candy = new ArrayList<>();
		for(int i =0;i<ratings.size();i++)
			candy.add(1);
		for(int i =1;i<ratings.size();i++)
		{
			if(ratings.get(i-1)<ratings.get(i))
				candy.set(i, candy.get(i-1)+1);
		}
		for(int i =ratings.size()-2;i>=0;i--)
		{
			if(ratings.get(i)>ratings.get(i+1) && candy.get(i)<=candy.get(i+1))
				candy.set(i, candy.get(i+1)+1);
		}
		int sum =0;
		for(int i =0;i<candy.size();i++)
			sum += candy.get(i);
		return sum;
	}

}
