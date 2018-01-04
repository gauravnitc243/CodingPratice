package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumUnsortedSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subUnsort(new ArrayList<>(Arrays.asList(1, 2, 3,0))));
	}

	public static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
		int n = A.size();
		int i = 0, j = n-1;
		ArrayList<Integer> res = new ArrayList<Integer>();
		while (i < n-1 && A.get(i) <= A.get(i + 1)) {
			i++;
		}
		if (i == n - 1) {
			res.add(-1);
			return res;
		}
		while (j > 0 && A.get(j) >= A.get(j - 1)) {
			j--;
		}
		int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
		for (int k = i; k <= j; k++) {
			maxValue = Math.max(maxValue, A.get(k));
			minValue = Math.min(minValue, A.get(k));
		}
		int l = 0, r = n - 1;
		while (A.get(l) <= minValue && l <= i) {
			l++;
		}
		while (r >= j && A.get(r) >= maxValue) {
			r--;
		}
		res.add(l);
		res.add(r);
		return res;
    }

}
