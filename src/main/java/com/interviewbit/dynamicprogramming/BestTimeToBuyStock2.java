package com.interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTimeToBuyStock2
{

	public static void main(String[] args)
	{
		System.out.println(maxProfit(new ArrayList<Integer>(Arrays.asList(1 ,2 ,3, 4 ,5, 6, 7 ,8, 9 ,10, 11, 12))));
		System.out.println(maxProfit(new ArrayList<Integer>(Arrays.asList(52 ,50, 25 ,100, 61, 63, 70 ,51, 71 ,55, 10 ,5))));
		
	}
	
	public static int maxProfit(final List<Integer> a) 
	{
		int profit =0;
		int diff=0;
		for(int i =1;i<a.size();i++)
		{
			 diff = a.get(i)-a.get(i-1);
			 if(diff>0)
				 profit +=diff;
		}
		return profit;
	}
}
