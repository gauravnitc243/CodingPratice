package com.interviewbit.dynamicprogramming;

public class MinInsertionForPalindrome
{

	public static void main(String[] args)
	{
		System.out.println(findMinInsertion("edcbabcde"));
	}
	
	public static int minInsert(String a)
	{
		return findMinInsertion(a,0,a.length()-1);
	}
	
	public static int findMinInsertion(String a, int left , int right)
	{
		if(left>right)
			return Integer.MAX_VALUE;
		if(left==right)
			return 0;
		if(left+1==right)
			return a.charAt(left) ==  a.charAt(right)?0:1;
		return 
				a.charAt(left) ==  a.charAt(right)?findMinInsertion(a, left+1, right-1):(Math.min(findMinInsertion(a, left+1, right), findMinInsertion(a, left, right-1)))+1;
	}
	public static int findMinInsertion(String a)
	{
		int len = a.length();
		int[][] memTable = new int[len][len];
		int left , right,gap;
		for(gap=1;gap<len;gap++)
		{
			for(left=0,right=gap;right<len;left++,right++)
			{
				memTable[left][right] = (a.charAt(left)==a.charAt(right)) ? memTable[left+1][right-1]
																		  : Math.min(memTable[left][right-1], memTable[left+1][right])+1;
			}
			print(memTable);
		}
		return memTable[0][len-1];
		
	}
	public static void print(int[][] arr)
	{
		for(int i =0 ; i< arr.length;i++)
		{
			System.out.print("Row: "+(i+1)+" " );
			for(int j=0;j<arr.length;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	

}
