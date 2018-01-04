package com.interviewbit.arrayandmath;

import java.util.ArrayList;

public class AllSquarePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(squareSum(4));
	}
	
	public static  ArrayList<ArrayList<Integer>> squareSum(int A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		for (int a = 1; a < A; a++) {
			for (int b = a; b>=a && b< A; b++) {
				if (a * a + b * b == A) 
				{
					ArrayList<Integer> newEntry = new ArrayList<Integer>();
					newEntry.add(a);
					newEntry.add(b);
					ans.add(newEntry);
				}
			}
		}
		return ans;
	}

}
