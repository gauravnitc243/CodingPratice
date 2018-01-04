package com.interviewbit.graphs;

import java.util.ArrayList;

public class BlackShapes
{
	public static void main(String[] args)
	{
		String a= "OOOXOOO";
		String b= "OOXXOXO";
		String c= "OXOOOXO";
		ArrayList<String> in = new ArrayList<String>();
		in.add(a);
		in.add(b);
		in.add(c);
		System.out.println(black(in));
		
	}
	
	public static int black(ArrayList<String> a) 
	{
		int row = a.size();
		int col = a.get(0).length();
		int[][] input = new int[a.size()][a.get(0).length()];
		int i = 0;
		for(String s : a)
		{
			for(int j=0;j<col;j++)
				input[i][j] =  s.charAt(j)=='X'?1:0;
			i++;
		}
		return solveShapes(input, row,col);
	}
	
	public static int solveShapes(int[][] input , int row,int col)
	{
		int count = 0;
		boolean[][] visited = new boolean[row][col];
		for(int i =0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(input[i][j]==1 && !visited[i][j])
				{
					dfs(input,i,j,visited,row,col);
					count++;
				}
			}
		}
		return count;
	}
	
	public static void dfs(int[][] input , int i , int j , boolean[][] visited,int r,int c)
	{
		if(i<0 || i>=r || j<0 || j>=c || input[i][j]==0 || visited[i][j])
			return;
		visited[i][j] = true;
		dfs(input,i+1,j,visited,r,c);
		dfs(input,i-1,j,visited,r,c);
		dfs(input,i,j+1,visited,r,c);
		dfs(input,i,j-1,visited,r,c);
	}
		
}
