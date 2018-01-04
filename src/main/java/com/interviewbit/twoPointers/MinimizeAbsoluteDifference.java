package com.interviewbit.twoPointers;

import java.util.ArrayList;

public class MinimizeAbsoluteDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) 
	{
		int result = Integer.MAX_VALUE;
	    int i=A.size()-1,j=B.size()-1,k=C.size()-1;
	    while(i>=0 && j>=0 && k>=0)
	    {
	        int maxValue = Math.max(A.get(i), Math.max(B.get(j),C.get(k)));
	        int minValue = Math.min(A.get(i), Math.min(B.get(j),C.get(k)));
	        result = Math.min(result, maxValue - minValue);
	        if(A.get(i)==maxValue) 
	        	i--;
	        else if(B.get(j)==maxValue) 
	        	j--;
	        else if(C.get(k)==maxValue)
	        	k--;
	    }
	    return result;
    }

}
