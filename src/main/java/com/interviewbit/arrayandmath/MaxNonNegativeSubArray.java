package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxNonNegativeSubArray {

	public static void main(String[] args) {
		ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3 ,4, 1, 4, 1));
		//ArrayList<Integer> a = new ArrayList<>(Arrays.asList(-1469348094, 1036140795, 2040651434, -317097467, 1376710097, 1330573317, 1687926652 ));
		System.out.println(maxset(b));

	}

	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
		int bestStartIndex = 0;
		int bestEndIndex = 0;
		Long bestSum = 0L;
		Long currentSum = 0L;
		int startIndex = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) < 0) {
				if ((currentSum > bestSum) || ((currentSum == bestSum) && (i - startIndex) > (bestEndIndex - bestStartIndex))) {
					bestSum = Long.valueOf(currentSum);
					bestStartIndex = startIndex;
					bestEndIndex = i;
				}
				currentSum = 0L;
				startIndex = i + 1;
			} else {
				currentSum += a.get(i);
			}
		}
		if(bestSum<currentSum)
			return new ArrayList<>(a.subList(startIndex, a.size()));
		else
			return new ArrayList<>(a.subList(bestStartIndex, bestEndIndex));
	}
}
