package com.interviewbit.arrayandmath;

import java.util.List;

public class KadaneMaxSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int maxSubArray(final List<Integer> a) {
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;
		for (int i : a) {
			currSum += i;
			if (currSum > maxSum)
				maxSum = currSum;
			if (currSum < 0)
				currSum = 0;
		}
		return maxSum;
	}

}
