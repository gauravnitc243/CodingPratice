package com.interviewbit.graphs;

import java.util.ArrayList;

public class SmallestSequenceWithGivenPrimes {

	public static void main(String[] args) {
		System.out.println(solve(2, 3, 5, 5));
	}

	public static ArrayList<Integer> solve(int A, int B, int C, int D) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int[] nextNumToInclude = new int[3];
		int[] currentIndex = new int[3];
		int[] prime = new int[3];
		prime[0] = A;
		prime[1] = B;
		prime[2] = C;
		nextNumToInclude[0] = A;
		nextNumToInclude[1] = B;
		nextNumToInclude[2] = C;
		currentIndex[0] = -1;
		currentIndex[1] = -1;
		currentIndex[2] = -1;

		for (int j = 1; j <= D; j++) {
			int nextMinNum = Math.min(Math.min(nextNumToInclude[1], nextNumToInclude[2]), nextNumToInclude[0]);
			result.add(nextMinNum);
			for (int i = 0; i < 3; i++) {
				if (nextMinNum == nextNumToInclude[i]) {
					currentIndex[i]++;
					nextNumToInclude[i] = result.get(currentIndex[i]) * prime[i];
				}
			}
		}
		return result;
	}

}
