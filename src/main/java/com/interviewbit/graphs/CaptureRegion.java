package com.interviewbit.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class CaptureRegion
{

	public static void main(String[] args)
	{
		ArrayList<Character> a = new ArrayList<>(Arrays.asList('X','O','O','O','O','O','O','X') );
		ArrayList<Character> b = new ArrayList<>(Arrays.asList('X','X','O','O','X','O','O','X')) ;
		ArrayList<Character> c = new ArrayList<>(Arrays.asList('O','X','X','O','X','O','X','X') );
		//ArrayList<Character> d = new ArrayList<>(Arrays.asList('X','O','X','X') );
		ArrayList<ArrayList<Character>> r = new ArrayList<ArrayList<Character>>();
		r.add(a);
		r.add(b);
		r.add(c);
	//	r.add(d);
		solve(r);
	}
	
	public static void solve(ArrayList<ArrayList<Character>> a) 
	{
        int r = a.size();
        int c = a.get(0).size();
        int[][] input = new int[r][c];
        for(int i =0;i<r;i++)
        {
        	ArrayList<Character> ch = a.get(i);
        	for(int j=0;j<c;j++)
        	{
        		input[i][j] = ch.get(j)=='X'?1:0;
        	}
        }
         solveRegion(a,input,r,c);
 
	}	 
	 public static void solveRegion(ArrayList<ArrayList<Character>> a,int[][] input,int r, int c)
	 {
		 boolean[][] isTraversed = new boolean[r][c];
		 for(int j = 0;j<c;j++)
		 {
			 if(input[0][j]==0 && !isTraversed[0][j])
				 dfs(input,r,c,isTraversed,0,j);
		 }
		 for(int j = 0;j<c;j++)
		 {
			 if(input[r-1][j]==0 && !isTraversed[r-1][j])
				 dfs(input,r,c,isTraversed,r-1,j);
		 }
		 for(int j = 0;j<r;j++)
		 {
			 if(input[j][0]==0 && !isTraversed[j][0])
				 dfs(input,r,c,isTraversed,j,0);
		 }
		 for(int j = 0;j<r;j++)
		 {
			 if(input[j][c-1]==0 && !isTraversed[j][c-1])
				 dfs(input,r,c,isTraversed,j,c-1);
		 }
		 
		 for(int i = 0;i<r;i++)
		 {
			 ArrayList<Character> re = new ArrayList<Character>();
			 for(int j=0;j<c;j++)
			 {
				 if(isTraversed[i][j])
					 re.add('O');
				 else
					 re.add('X');
			 }
			 a.set(i, re);
		 }
		 System.out.println(a);
	 }
	 
	 public static void dfs(int[][] input, int r, int c, boolean[][] isTraversed,int i , int j)
	 {
		 if(i<0 || i>=r || j<0 || j>=c || input[i][j]==1 || isTraversed[i][j])
			 return;
		 isTraversed[i][j] = true;
		 dfs(input,r,c,isTraversed,i+1,j);
		 dfs(input,r,c,isTraversed,i-1,j);
		 dfs(input,r,c,isTraversed,i,j+1);
		 dfs(input,r,c,isTraversed,i,j-1);
	 }
	 
	 
	 
	 /*	 public static void solve(ArrayList<String> board) 
	 {
	        int r = board.size();
	        int c = board.get(0).length();
	        int[][] input = new int[r][c];
	        int i =0;
	        for(String s : board)
	        {
	        	for(int j=0;j<c;j++)
	        	{
	        		input[i][j] = s.charAt(j)=='X'?1:0;
	        	}
	        	i++;
	        }
	         solveRegion(input,r,c);
	 }*/

}
