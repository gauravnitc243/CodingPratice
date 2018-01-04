package com.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfTwoArrays
{

	public static void main(String[] args)
	{
		List<Integer> a = new ArrayList<Integer>(Arrays.asList( -50, -41, -40, -19, 5, 21, 28 ));
		List<Integer> b = new ArrayList<Integer>(Arrays.asList(-50, -21, -10));
		System.out.println(MedianOfTwoArrays.searchMedian(a, b));
	}
	

	public static double searchMedian(final List<Integer> a, final List<Integer> b)
	{
	    int len = a.size() + b.size();
	    if(len % 2 == 1) return findKth(a, 0, b, 0, len / 2 + 1);
	    else return (findKth(a, 0, b, 0, len / 2) + findKth(a, 0, b, 0, len / 2 + 1)) / 2.0;
	}
	
	public static int findKth(List<Integer> A, int A_start, List<Integer> B, int B_start, int k){
	    if(A_start >= A.size()) return B.get(B_start + k - 1);
	    if(B_start >= B.size()) return A.get(A_start + k - 1);
	    if(k == 1) return Math.min(A.get(A_start), B.get(B_start));
	    
	    int A_key = A_start + k / 2 - 1 < A.size() ? A.get(A_start + k / 2 - 1) : Integer.MAX_VALUE;
	    int B_key = B_start + k / 2 - 1 < B.size() ? B.get(B_start + k / 2 - 1) : Integer.MAX_VALUE;
	    
	    if(A_key < B_key){
	        return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
	    }
	    else
	       return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
	}
}
	