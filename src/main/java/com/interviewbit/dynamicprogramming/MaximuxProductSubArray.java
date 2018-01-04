package com.interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximuxProductSubArray
{

	public static void main(String[] args)
	{
		System.out.println(maxProduct(new ArrayList<Integer>(Arrays.asList(0))));

	}
	
public static int maxProduct(final List<Integer> a) {
    if (a == null)
        return 0;
    int n = a.size(),k,maxTotal = 0;
    int maxTotalNegatives = 1;
    int maxTatalPositives = 1;
    for (int i = 0; i < n; i++) 
    {
    	k = a.get(i);
        if (k == 0) 
            maxTatalPositives = maxTotalNegatives = 1;
         else if (k > 0) 
         {
            maxTatalPositives *= k;
            if (maxTotalNegatives * k < 0)
	            maxTotalNegatives *= k;
            maxTotal = Math.max(maxTotal, maxTatalPositives);
        } else 
        {
            int temp = maxTatalPositives;
            maxTatalPositives = Math.max(1, k * maxTotalNegatives);
            maxTotalNegatives = k * temp;
            if (maxTatalPositives != 1)
	            maxTotal = Math.max(maxTotal, maxTatalPositives);
        }
    }
    return maxTotal;
}
}
