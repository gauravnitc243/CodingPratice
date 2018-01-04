package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxDistance {

	public static void main(String[] args) {
		MaxDistance m = new MaxDistance();
		System.out.println(m.maximumGap(new ArrayList<>(Arrays.asList(3, 5, 4, 2))));
	}

	public int maximumGap(final List<Integer> a) {
		if (a.size() == 1)
			return 0;
		List<Integer> leftMinimum = new ArrayList<Integer>(Arrays.asList(new Integer[a.size()]));
		List<Integer> rightMaximum = new ArrayList<Integer>(Arrays.asList(new Integer[a.size()]));
		leftMinimum.set(0, a.get(0));
		for (int i = 1; i < a.size(); ++i)
			leftMinimum.set(i, Math.min(a.get(i), leftMinimum.get(i - 1)));
		rightMaximum.set(a.size() - 1, a.get(a.size() - 1));
		for (int j = a.size() - 2; j >= 0; --j)
			rightMaximum.set(j, Math.max(a.get(j), rightMaximum.get(j + 1)));
		int i = 0, j = 0, totalMax = -1;
		while (j < a.size() && i < a.size()) {
			if (leftMinimum.get(i) <= rightMaximum.get(j)) {
				totalMax = Math.max(totalMax, j - i);
				j = j + 1;
			} else
				i = i + 1;
		}

		return totalMax;
	}

}
