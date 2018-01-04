package com.interviewbit.arrayandmath;

import java.util.ArrayList;

public class MaxSubArrayOfNonNegativeNumbers {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(5);
		a.add(-7);
		a.add(2);
		a.add(3);
		System.out.println(maxset(a));
	}

	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
	long maxSum = 0;
    long newSum = 0;
    ArrayList<Integer> maxArray = new ArrayList<Integer>();
    ArrayList<Integer> newArray = new ArrayList<Integer>();
    for (Integer i : a) {
        if (i >= 0) {
            newSum += i;
            newArray.add(i);
        } else {
            newSum = 0;
            newArray = new ArrayList<Integer>();
        }
        if ((maxSum < newSum) || ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
            maxSum = newSum;
            maxArray = newArray;
        }
    }
    return maxArray;
}
}
