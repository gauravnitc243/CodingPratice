package com.interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class RodCutting
{
	ArrayList<Integer> tempArray= new ArrayList<Integer>();
	ArrayList<Integer> ans= new ArrayList<Integer>();
	int[][] dp;
	int[][] parent;
	public static void main(String[] args){
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList( 2, 3, 6, 7, 14, 22, 25, 30, 34, 45, 51, 52, 54, 56, 57, 58, 59, 61, 63, 66, 76, 78));
		RodCutting r = new RodCutting();
		System.out.println(r.rodCut(100, a));
	}
	
  public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) 
  {
	    B.add(A);
	    B.add(0,0);
	    int n=B.size();
	    dp = new int[n][n];
	    parent = new int[n][n];
	    tempArray = new ArrayList<Integer>(B);
	    for(int i=0; i<n; i++)
	    {
	        for(int j=0; j<n; j++)
	            dp[i][j]=-1;
	    }
	    rec(0,n-1);
	    back(0,n-1);
	    return ans;
  }
	  

	long rec(int left, int right)
	{
		System.out.println("rec function , left : "+left+" right : "+right);
	    if(left+1>=right)return 0;
	    long ret=dp[left][right];
	    if(ret!=-1)return ret;
	    ret=Long.MAX_VALUE;
	    int bestind = 0;    //stores the best index
	    for(int i=left+1; i<right; i++)
	    {
	        long current = rec(left,i)+rec(i,right) + tempArray.get(right)-tempArray.get(left);
	        if(current<ret)
	        {
	            ret=current;
	            bestind=i;
	        }
	    }
	    parent[left][right]=bestind;
	    return ret;
	}
	void back(int left, int right)
	{
	    if(left+1>=right)return;
	    ans.add(tempArray.get(parent[left][right]));
	    back(left,parent[left][right]);
	    back(parent[left][right],right);
	}
	
	
	
	
	
	
	
	
	
	
	
	/*  public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) 
	  {
		  int[] mem = new int[A+1];
		  for(int i = 1;i<=A;i++)
		  {
			  int max = Integer.MIN_VALUE;
			  for(int j=0;j<i;j++)
				  max = Math.max(B.get(j), mem[i-j-1]);
			  mem[i] = max;
		  }
		  return mem[A];
	  }*/

}
