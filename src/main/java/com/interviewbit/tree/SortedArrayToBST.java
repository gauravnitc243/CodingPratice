package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedArrayToBST
{
	public static void main(String[] args)
	{
		
		System.out.println(sortedArrayToBST(new ArrayList<>(Arrays.asList(1,2,3))));
	}
	
	public static TreeNode sortedArrayToBST(final List<Integer> a) 
	{
		if(a==null || a.size()<1)
			return null;
		int lo = 0;
		int hi = a.size();
		return createTree(a, lo, hi-1);
	}
	
	public static TreeNode createTree(List<Integer> input, int lo,int hi)
	{
		if(hi<lo)
			return null;
		int mid = (hi+lo)/2;
		TreeNode curr = new TreeNode(input.get(mid));
		curr.left = createTree(input, lo, mid-1);
		curr.right = createTree(input, mid+1, hi);
		return curr;
	}

}
