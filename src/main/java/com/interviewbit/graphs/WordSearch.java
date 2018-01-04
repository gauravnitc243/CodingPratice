package com.interviewbit.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class WordSearch
{

	public static void main(String[] args)
	{
		System.out.println((new WordSearch()).exist(new ArrayList<String>(Arrays.asList("FFBBCFE", "BFFCCAF", "FBDGAEG", "GAGBBEE", "FEAFCDF", "CCDGECG", "EGDDDDA" )), "EGDDDDDDA"));
	}
	 public int exist(ArrayList<String> a, String b) 
	 {
		 int r = a.size();
		 int c = a.get(0).length();
		 char[][] board = new  char[r][c];
		 int ii =0;
		 for(String s:a)
		 {
			 for(int j =0;j<c;j++)
				 board[ii][j] = s.charAt(j);
			 ii++;
		 }
		 for(int i = 0;i<r;i++)
		 {
			 for(int j = 0;j<c;j++)
			 {
				 if(board[i][j]==b.charAt(0))
				 {
					 if(dfs(board,i,j,r,c,b))
						 return 1;
				 }
			 }
		 }
		 return 0;
	 }
	 
	 public boolean dfs(char[][] board,int i , int j, int r, int c, String word)
	 {
		 if(word.length()==0)
			 return true;
		 if(i<0 || i>=r || j<0 || j>=c || board[i][j]!=word.charAt(0))
			 return false;
		  String sub = word.substring(1);
		  if(dfs(board,i+1,j,r,c,sub))
			  return true;
		  if(dfs(board,i-1,j,r,c,sub))
			  return true;
		  if(dfs(board,i,j+1,r,c,sub))
			  return true;
		  if(dfs(board,i,j-1,r,c,sub))
			  return true;
		  return false;
	 }
	        

}
