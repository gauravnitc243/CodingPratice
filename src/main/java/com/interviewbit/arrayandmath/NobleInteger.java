package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NobleInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(
				new ArrayList<>(Arrays.asList(-2, -7, 1, -2, -1, 6, -6, -7, -7, 3, 8, -4, -10, -6, 8, -2, -2, -1, 7))));
	}

	public static int solve(ArrayList<Integer> A) {
		Collections.sort(A);
		for (int i = 0; i < A.size(); i++) {
			while (i + 1 < A.size() && A.get(i) == A.get(i + 1))
				i++;
			if (A.get(i) == A.size() - 1 - i)
				return 1;
		}
		return -1;
	}
}
