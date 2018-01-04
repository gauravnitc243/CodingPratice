package com.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MinXORvalue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(12, 4, 6, 2 ));
		System.out.println(findMinXor(A));
	}
	
	
	 public static int findMinXor(ArrayList<Integer> A) {
		 int minXORValue = Integer.MAX_VALUE;
		 Collections.sort(A);
		 for(int i =1;i<A.size();i++)
		 {
				 minXORValue  = Math.min(minXORValue, A.get(i-1) ^ A.get(i));
		 }
		 return minXORValue;
	 }
}
