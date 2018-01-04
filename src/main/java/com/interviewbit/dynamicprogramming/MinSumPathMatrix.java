package com.interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSumPathMatrix
{

	public static void main(String[] args)
	{
		ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1,3,2));
		ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(4,3,1));
		ArrayList<Integer> a3 = new ArrayList<>(Arrays.asList(5,6,1));
		ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
		grid.add(a1);
		grid.add(a2);
		grid.add(a3);
		System.out.println(new MinSumPathMatrix().minPathSumMatrix(grid));

	}
	
	public int minPathSumMatrix(ArrayList<ArrayList<Integer>> a)
	{
		if(a==null || a.size()==0 || a.get(0).size()==0)
			return 0;
		int rows = a.size(),cols = a.get(0).size();
		int[][] mem = new int[rows][cols];
		mem[0][0] = a.get(0).get(0);
		for(int i =0;i<rows;i++)
		{
			for(int j =0;j<cols;j++)
			{
				if(i==0 && j==0)
					mem[i][j] =  a.get(i).get(j);
				else if(j==0)
					mem[i][j] =  a.get(i).get(j) + mem[i-1][j];
				else if(i==0)
					mem[i][j] = a.get(i).get(j) + mem[i][j-1];
				else
					mem[i][j] = Math.min(mem[i-1][j], mem[i][j-1]) + a.get(i).get(j);
			}
		}
		return mem[rows-1][cols-1];
	}
	
}
