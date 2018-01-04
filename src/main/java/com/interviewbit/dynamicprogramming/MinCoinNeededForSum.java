package com.interviewbit.dynamicprogramming;

public class MinCoinNeededForSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1,3,5};
		minCoins(coins, 11);
	}

	
	public static void minCoins(int[] coinDen,int sum)
	{
		int[] min = new int[sum+1];
		for(int i =1;i<=sum;i++){
			min[i] =  Integer.MAX_VALUE;
		}
		for(int i =1;i<=sum;i++){
			for(int j=0;j<coinDen.length;j++){
				if(coinDen[j]<=i && min[i-coinDen[j]]+1<min[i])
					min[i]=min[i-coinDen[j]]+1;
			}
		}
		for(int i =1;i<=sum;i++)
			System.out.print(min[i]+" ");
	}

}
