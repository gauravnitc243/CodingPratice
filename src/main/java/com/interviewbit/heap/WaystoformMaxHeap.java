package com.interviewbit.heap;

public class WaystoformMaxHeap {

	public static void main(String[] args) {
	}
	int MOD = 1000000007;
	long[] maxHeapDP;
	long[][] nChooseKDP;
	int[] log2Array;
	
	public int solve(int A) {
		maxHeapDP = new long[A + 1];
		for (int i = 0; i <= A; i++)
			maxHeapDP[i] = -1;
		nChooseKDP = new long[A + 1][A + 1];
		for (int i = 0; i <= A; i++)
			for (int j = 0; j <= A; j++)
				nChooseKDP[i][j] = -1;
		log2Array = new int[A + 1];
		int currLogAnswer = -1;
		int currPower2 = 1;
		for (int i = 1; i <= A; i++) {
			if (currPower2 == i) {
				currLogAnswer++;
				currPower2 *= 2;
			}
			log2Array[i] = currLogAnswer;
		}
		return (int) getNumberOfMaxHeaps(A);
	}
	public long choose(int n, int k) {
		if (k > n)
			return 0;
		else if(n <= 1 || k == 0)
			return 1;
		else if(nChooseKDP[n][k] != -1)
			return nChooseKDP[n][k];
		long result = choose(n - 1, k - 1) + choose(n - 1, k);
		result %= MOD;
		nChooseKDP[n][k] = result;
		return result;
	}

	public int getLeftChildCount(int n) {
		if (n == 1)
			return 0;
		int h = log2Array[n];
		int p = n - ((1 << (h)) - 1);
		int m = (1 << h);
		if (p >= (m / 2))
			return (1 << (h)) - 1;
		else
			return (1 << (h)) - 1 - ((m / 2) - p);
	}

	public long getNumberOfMaxHeaps(int n) {
		if (n <= 1)
			return 1;
		if (maxHeapDP[n] != -1)
			return maxHeapDP[n];
		int L = getLeftChildCount(n);
		long ans = (choose(n - 1, L) * getNumberOfMaxHeaps(L)) % MOD * (getNumberOfMaxHeaps(n - 1 - L));
		ans %= MOD;
		maxHeapDP[n] = ans;
		return ans;
	}

}
