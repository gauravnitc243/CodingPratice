package com.interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinSumInfinite
{
	static int res = 0;
	public static void main(String[] args)
	{
		System.out.println(coinchange2(new ArrayList<>(Arrays.asList(1,3,5)), 11));
	}
	  public static int coinchange2(ArrayList<Integer> a, int b) 
	  {
			int[] memTable = new int[b+1];
			memTable[0] = 1;
			for(int j =0;j< a.size();j++)
			{
				for(int i =a.get(j);i<=b;i++)
						memTable[i] = (memTable[i]+memTable[i-a.get(j)])%1000007;
			}
			return memTable[b];
		}
	  
	  public static int coinchange1(ArrayList<Integer> a, int b) 
	  {
			int[] memTable = new int[b+1];
			memTable[0] = 0;
			for(int i=1;i<memTable.length;i++)
				memTable[i]= Integer.MAX_VALUE-1;
			int count = 0;
			for(int j =0;j< a.size();j++)
			{
				for(int i =a.get(j);i<=b;i++)
						memTable[i] = Math.min(memTable[i], 1+memTable[i-a.get(j)]);
			}
			System.out.println(memTable);
			return count;
		}
}
