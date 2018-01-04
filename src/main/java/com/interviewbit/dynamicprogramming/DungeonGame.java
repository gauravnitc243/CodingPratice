package com.interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class DungeonGame
{

	public static void main(String[] args)
	{
		ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(-2,-3,3));
		ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(-5,-10,1));
		ArrayList<Integer> a3 = new ArrayList<>(Arrays.asList(10,30,-5));
		ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>();
		grid.add(a1);
		grid.add(a2);
		grid.add(a3);
		System.out.println(new DungeonGame().calculateMinimumHP(grid));

	}
	
	public int calculateMinimumHP(ArrayList<ArrayList<Integer>> a) 
	{
		int row = a.size();
		int col = a.get(0).size();
		int[][] mem = new int[row][col];
		
		mem[row-1][col-1] = Math.max(1-a.get(row-1).get(col-1), 1);
		
		for(int i = row-2;i>=0;i--)
			mem[i][col-1] = Math.max(mem[i][col-1]-a.get(i+1).get(col-1), 1);
		for(int i = col-2;i>=0;i--)
			mem[row-1][i] = Math.max(mem[row-1][i]-a.get(i).get(col-1), 1);
		
		for(int i = row-2;i>=0;i--)
		{
			for(int j = col-2;j>=0;j--)
			{
				int right = Math.max(mem[i][j+1]-a.get(i).get(j), 1);
				int bottom = Math.max(mem[i+1][j]-a.get(i).get(j), 1);
				mem[i][j] = Math.min(right, bottom);
			}
		}
		
		return mem[0][0];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	 /*public int calculateMinimumHP(ArrayList<ArrayList<Integer>> a) 
	 {
			int m = a.size();
			int n = a.get(0).size();
			int[][] mem = new int[m][n];
			mem[m - 1][n - 1] = Math.max(1 - a.get(m-1).get(n-1), 1);
			
			for (int i = m - 2; i >= 0; i--) 
				mem[i][n - 1] = Math.max(mem[i + 1][n - 1] - a.get(i).get(n-1), 1);
			
			for (int j = n - 2; j >= 0; j--) 
				mem[m - 1][j] = Math.max(mem[m - 1][j + 1] - a.get(m-1).get(j), 1);
			for (int i = m - 2; i >= 0; i--) 
			{
				for (int j = n - 2; j >= 0; j--) 
				{
					int down = Math.max(mem[i + 1][j] - a.get(i).get(j), 1);
					int right = Math.max(mem[i][j + 1] - a.get(i).get(j), 1);
					mem[i][j] = Math.min(right, down);
				}
			}
			return mem[0][0];
		}*/
	 
}
