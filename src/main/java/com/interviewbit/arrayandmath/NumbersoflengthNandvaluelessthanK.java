package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersoflengthNandvaluelessthanK {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0, 1, 3, 4, 6, 7 ));
		System.out.println(solve(A,4,59172));;

	}
	
/*	public static int solve(ArrayList<Integer> A, int B, int C) 
	{
		int inputLen = A.size();
		int resLen = (""+C).length();
		if(B > resLen)
			return 0;
		else if(B < resLen){
		    if(A.get(0)==0 && B != 1)
		    	return (int)Math.pow(inputLen ,B-1) * (inputLen-1);
		    else
		    	return (int)Math.pow(inputLen,B);
		}
		int[] data = new int[B];
		ArrayList<Integer> combinationList = new ArrayList<Integer>();
		getCombinations(A,combinationList, 0, A.size(), data, 0, C);
		return combinationList.size();
    }
	
	public static void getCombinations(ArrayList<Integer> a,ArrayList<Integer>  combinationList,int start , int end,int[] data,int currIndex , int upperLimit){
		if(currIndex==data.length){
			StringBuilder sb = new StringBuilder();
			for(int i: data)
				sb.append(i);
			if((!sb.toString().startsWith("0") && Integer.parseInt(sb.toString())<upperLimit) || (data.length==1 && Integer.parseInt(sb.toString())<upperLimit))
				combinationList.add(Integer.parseInt(sb.toString()));
			return;
		}
		
		for(int i = start;i<end;i++)
		{
			data[currIndex] = a.get(i);
			getCombinations(a, combinationList,start, end, data, currIndex+1, upperLimit);
		}
	}
*/


	public static ArrayList<Integer> numToArray(int N) {   
		ArrayList<Integer> digit = new ArrayList<Integer>();
	    while(N != 0) {
	        digit.add(0,N % 10);
	        N = N / 10;
	    }
	    if(digit.size() == 0)
	        digit.add(0);
	    return digit; 
	}

	public static int solve(ArrayList<Integer> A, int B, int C) {
		ArrayList<Integer> digit = numToArray(C); 
		int  inputSize =A.size();
		int d2;
		boolean isValid =Boolean.TRUE ;
		int[] dp = new int[B + 1];
		int[] lowerSuffixArray = new int[11];
	    if(B > digit.size()  || inputSize == 0)
	        return 0;
	    else if(B < digit.size()) {
	        if(A.get(0) == 0 && B != 1)
	            return (int)((inputSize - 1) * Math.pow(inputSize, B - 1));
	        else 
	            return (int)Math.pow(inputSize, B);
	    }
	    else {
	          for(int i = 0; i < inputSize; i++)
	              lowerSuffixArray[A.get(i) + 1] = 1;
	          for(int i = 1; i <= 10; i++)
	              lowerSuffixArray[i] = lowerSuffixArray[i-1] + lowerSuffixArray[i]; 
	          for(int i = 1; i <= B; i++) {
	              d2 = lowerSuffixArray[digit.get(i-1)];
	              dp[i] = dp[i-1] * inputSize;
	             if(i == 1 &&  A.get(0) == 0 && B != 1) // we can not use zero for first index
	                 d2 = d2 - 1;
	             if(isValid) //Whether (i-1) digit of generated number can be equal to (i - 1) digit of C.
	                 dp[i] += d2;
	             //Is digit[i - 1] present in A ?
	                isValid = isValid & (lowerSuffixArray[digit.get(i-1) + 1] == lowerSuffixArray[digit.get(i-1)] + 1);
	        }
	    return dp[B];                   
	    } 
	}









}
