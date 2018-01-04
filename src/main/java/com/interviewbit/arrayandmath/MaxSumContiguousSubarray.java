package com.interviewbit.arrayandmath;

import java.util.ArrayList;

public class MaxSumContiguousSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int maxArr(ArrayList<Integer> A) {		
		int submax = Integer.MIN_VALUE;
		int submin = Integer.MAX_VALUE;
		int addmax = Integer.MIN_VALUE;
		int addmin = Integer.MAX_VALUE;
		for(int i =0;i<A.size();i++)
		{
			int addVal = A.get(i)+i;
			int subVal = A.get(i)-i;
			submax = Math.max(submax, subVal);
			submin = Math.min(submin, subVal);
			addmin = Math.min(addmin, addVal);
			addmax = Math.max(addmax, addVal);
		}
		
		return Math.max(submax-submin,addmax-addmin);
    }
	
}
