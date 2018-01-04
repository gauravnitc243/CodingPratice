package com.interviewbit.arrayandmath;

public class CatalanNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int catalan(int n) {
		int res = 0;
		if (n <= 1) {
			return 1;
		}
		for (int i = 0; i < n; i++) {
			res += catalan(i) * catalan(n - i - 1);
		}
		return res;
	}
	
	
	int catalanDPint(int n)
	{
	    int[] catalan = new int[n+1];
	    catalan[0] = catalan[1] = 1;
	    for (int i=2; i<=n; i++)
	    {
	        catalan[i] = 0;
	        for (int j=0; j<i; j++)
	            catalan[i] += catalan[j] * catalan[i-j-1];
	    }
	    return catalan[n];
	}

}
