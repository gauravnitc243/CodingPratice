package com.interviewbit.arrayandmath;

class UniquePaths {
	
	public static void main(String[] args) {
		System.out.println(uniquePaths(15, 9));
	}
	
	
	public static  int uniquePaths(int a, int b) 
	{
	    long res = 1;
	    for (int i = b; i < (a + b - 1); i++) {
	    	res *= i;
	    	res /= (i - b + 1);
	    }
	    return (int)res;
	}
}
