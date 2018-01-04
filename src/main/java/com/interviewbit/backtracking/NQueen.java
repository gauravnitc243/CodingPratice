package com.interviewbit.backtracking;

import java.util.ArrayList;

public class NQueen
{

	public static void main(String[] args)
	{
		System.out.println(solveNQueens(8).size());
		System.out.println(solveNQueens(8));
	}
	
	 public static  ArrayList<ArrayList<String>> solveNQueens(int a) 
	 {
		 ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		 int currentPostions[] = new int[a];
		 for(int i =0;i<a;i++)
			 currentPostions[i] = -1;
		 findMoves(currentPostions,result,0,a);
		 return result;
	 }
	 public static void findMoves(int[] currentPostions,ArrayList<ArrayList<String>> result,int currentlyPlacedQueens,int noOfQueens)
	 {
		 for(int i =0;i<noOfQueens;i++)
		 {
			 if(isValidMove(currentPostions, currentlyPlacedQueens, i))
			 {
				 currentPostions[currentlyPlacedQueens] = i;
				 if(currentlyPlacedQueens==noOfQueens-1)
				 {
					 ArrayList<String> t = new ArrayList<String>();
					 StringBuilder current ;
					 for(int j =0;j<noOfQueens;j++)
					 {
						 current = new StringBuilder();
						 int k = 0;
						 while(k<noOfQueens)
						 {
							 if(k==currentPostions[j])
								 current.append("Q");
							 else
								 current.append(".");
							 k++;
						 }
						 t.add(current.toString());
					 }
					 result.add(t);
				 }
				 else
					 findMoves(currentPostions,result,currentlyPlacedQueens+1,noOfQueens);
			 }
		 }
	 }
	 public static boolean isValidMove(int[] currentPostions,int r,int c)
	 {
		 for(int i =0;i<r;i++)
		 {
			 if(currentPostions[i]==c || Math.abs(i-r)==Math.abs(currentPostions[i]-c))
				 return false;
		 }
		 return true;
	 }
	
	 
}
