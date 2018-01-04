package com.interviewbit.arrayandmath;

import java.util.ArrayList;

public class Flip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static ArrayList<Integer> flip(String A) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] input = new int[A.length()];
		boolean isZeroFound = Boolean.FALSE;
		for (int i = 0; i < A.length(); i++)
		{
			input[i] = A.charAt(i) == '0' ? 1 : -1;
			if(A.charAt(i) == '0')isZeroFound= Boolean.TRUE;
		}
		if(!isZeroFound)
			return list;
		int maxSum = 0;
		int currSum = 0;
		int start = 0;
		int bestEnd = 0;
		int bestStart = Integer.MAX_VALUE;
		for (int i = 0; i < input.length; i++) {
			currSum += input[i];
			if (currSum < 0) {
				currSum = 0;
				start = i+1;
			} 
			if (currSum > maxSum) {
				maxSum = currSum;
				bestStart = start;
				bestEnd = i;
			}

		}
		if(bestStart==Integer.MAX_VALUE){
			return new ArrayList<>();
		}
		list.add(bestStart+1);
		list.add(bestEnd+1);
		return list;
	}

}
