package com.interviewbit.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class LengthofLongestSubsequenceBitonic {

	public static void main(String[] args) {
		// List<Integer> l = Arrays.asList(1, 11, 2, 10, 4, 5, 2, 1);
		List<Integer> l = Arrays.asList(1, 11, 2);
		System.out.println(new LengthofLongestSubsequenceBitonic().longestSubsequenceLength(l));

	}

	public int longestSubsequenceLength(final List<Integer> A) {
		if (A.size() < 2)
			return A.size();
		int result = 0;
		int[] LIS = new int[A.size()];
		int[] LDS = new int[A.size()];
		LIS[0] = LDS[A.size() - 1] = 1;
		for (int i = 1; i < A.size(); i++) {
			LIS[i] = 1;
			for (int j = 0; j <i; j++) {
				if (A.get(i) > A.get(j)) {
					LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
				}
			}
		}

		for (int i = A.size() - 2; i >= 0; i--) {
			LDS[i] = 1;
			for (int j = A.size() - 1; j > i; j--) {
				if (A.get(i) > A.get(j))
					LDS[i] = Math.max(LDS[i], 1 + LDS[j]);
			}
		}
		for (int i = 0; i < LDS.length; i++) {
			result = Math.max(result, LDS[i] + LIS[i] - 1);
		}
		return result;
	}

}
