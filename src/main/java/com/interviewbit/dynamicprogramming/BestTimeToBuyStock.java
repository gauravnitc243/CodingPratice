package com.interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTimeToBuyStock
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(maxProfit(new ArrayList<Integer>(Arrays.asList(52 ,50, 25 ,100, 61, 63, 70 ,51, 71 ,55, 10 ,5))));
	}
	
	public static int maxProfit(final List<Integer> a) {
		if(a.size()<2)
			return 0;
		int minElement = a.get(0);
		int maxDiff = a.get(1)-a.get(0);
		for(int i =1;i<a.size();i++)
		{
				if(a.get(i)-minElement > maxDiff)
				{
					maxDiff = a.get(i)-minElement;
				}
				if(a.get(i)<minElement)
				{
					minElement = a.get(i);
				}
		}
		return maxDiff<0?0:maxDiff;
	}

}
