package com.interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinsInLine
{

	public static void main(String[] args)
	{
		System.out.println(maxcoin(new ArrayList<Integer>(Arrays.asList(1,2,3,4))));
	}
	public static int maxcoin(ArrayList<Integer> a) 
	{
		int n = a.size();
	    int[][] memTable = new int[n][n];
	    int gap, i, j, x, y, z;
	    for (gap = 0; gap < n; ++gap)
	    {
	        for (i = 0, j = gap; j < n; ++i, ++j)
	        {
	            x = ((i+2) <= j) ? memTable[i+2][j] : 0;
	            y = ((i+1) <= (j-1)) ? memTable[i+1][j-1] : 0;
	            z = (i <= (j-2))? memTable[i][j-2]: 0;
	            memTable[i][j] = Math.max(a.get(i) + Math.min(x, y), a.get(j) + Math.min(y, z));
	        }
	    }
	    return memTable[0][n-1];
	}

}
