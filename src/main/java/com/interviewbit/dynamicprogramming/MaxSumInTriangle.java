package com.interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumInTriangle
{

	public static void main(String[] args)
	{
		ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(2));
		ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(3,4));
		ArrayList<Integer> a3 = new ArrayList<>(Arrays.asList(6,5,7));
		ArrayList<Integer> a4 = new ArrayList<>(Arrays.asList(4,1,8,3));
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		triangle.add(a1);
		triangle.add(a2);
		triangle.add(a3);
		triangle.add(a4);
		System.out.println(minimumTotal(triangle));

	}

	public static int minimumTotalWithoutModification(ArrayList<ArrayList<Integer>> a) 
	{
		if(a==null || a.size()==0)
			return 0;
		if(a.size()==1)
			return a.get(0).get(0);
		int[] result = new int[a.size()];
		int[] tempResult = new int[a.size()];
		result[0]= a.get(0).get(0);
		int minDistance = Integer.MAX_VALUE;
		for(int i =1;i<a.size();i++)
		{
			ArrayList<Integer> curr = a.get(i);
			tempResult[0] = curr.get(0) + result[0];
			tempResult[curr.size()-1] =curr.get(curr.size()-1) + result[curr.size()-2] ;
			for(int j =1;j<curr.size()-1;j++)
				tempResult[j] = curr.get(j) + Math.min(result[j-1], result[j]);
			for(int j =0;j<curr.size();j++)
			{
				result[j] = tempResult[j];
				if(i==a.size()-1 && result[j]<minDistance)
					minDistance = result[j];
			}
		}
		return minDistance;
    }

	
	public static int minimumTotal(ArrayList<ArrayList<Integer>> a) 
	{
	    int m, n;
	    m = a.size();
	    n = a.get(m - 1).size();
	    int[] memTable = new int[n + 1];
	    int rowSize = n;
	    for (int i = m - 1; i >= 0; i--) 
	    {
	        for (int j = 0; j < rowSize; j++) 
	            memTable[j] = Math.min(memTable[j], memTable[j + 1]) + a.get(i).get(j);
	        rowSize--;
	    }
	    
	    return memTable[0];}
}
