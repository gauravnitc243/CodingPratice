package com.interviewbit.dynamicprogramming;

import java.util.Arrays;

public class IntersectingChordsInACircle {

	public static void main(String[] args) {
		System.out.println(new IntersectingChordsInACircle().chordCnt(22));
	}

	int[] dp = new int[1009];
	int MOD = 1000000007;

	public int chordCnt(int A) {
		Arrays.fill(dp, -1);
		return getChordCount(A);
	}

	public int getChordCount(int n) {
		if (n == 0)
			return 1;
		if (dp[n] != -1)
			return dp[n];
		dp[n] = 0;
		for (int i = 0; i < n; i++){
			dp[n] += ((long)getChordCount(i) * (long)getChordCount(n - i - 1)) % MOD;
			if(dp[n]>=MOD)
				dp[n] %= MOD;
		}
		
		return dp[n];
	}
	
	

}
