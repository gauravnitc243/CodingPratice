package com.interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class UniquePath
{

	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(0,0,0));
		ArrayList<Integer> b = new ArrayList<>(Arrays.asList(0,1,0));
		ArrayList<Integer> c = new ArrayList<>(Arrays.asList(0,0,0));
		ArrayList<ArrayList<Integer>> d = new ArrayList<ArrayList<Integer>>();
		d.add(a);
		d.add(b);
		d.add(c);
		System.out.println(uniquePathsWithObstacles(d));
	}
		
	
	public static int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) 
	{
			int m = a.size();
		    int n = a.get(0).size();
		    int[][] uniquePaths = new int[m + 1][n + 1];
		    for (int i = 0; i < m; i++) 
		    {
		        for (int j = 0; j < n; j++) 
		        {
		            if (a.get(i).get(j)==1) continue;
		            if (i == 0 && j == 0) uniquePaths[i][j] = 1;
		            if (i > 0) uniquePaths[i][j] += uniquePaths[i-1][j];
		            if (j > 0) uniquePaths[i][j] += uniquePaths[i][j-1];
		        }
		    }
		    return uniquePaths[m-1][n-1];
	}
	
}
