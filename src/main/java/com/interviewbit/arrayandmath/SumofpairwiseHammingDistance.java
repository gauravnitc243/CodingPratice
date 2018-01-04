package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumofpairwiseHammingDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingDistance(new ArrayList<>(Arrays.asList(2, 4, 6))));
		System.out.println();
	}

	public static int hammingDistance(final List<Integer> A) 
	{
	    int mod = 1000000007;
	    long sum = 0;
	    for (int currentBitPosition = 0; currentBitPosition < 31; currentBitPosition++) 
	    {
	        int oneCountBit = 0;
	        int zeroCountBit = 0;
	        for(int i = 0; i < A.size(); i++)
	        {
	            if ((A.get(i) & (1 << currentBitPosition))>0)
	            	oneCountBit++;
	            else
	            	zeroCountBit++;
	        }
	        sum += ((2L * oneCountBit * zeroCountBit) % mod);
	        if (sum >= mod) sum = sum - mod;
	    }
	    return (int)sum;
	 }
}
