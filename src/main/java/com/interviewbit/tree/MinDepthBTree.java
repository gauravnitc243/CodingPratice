package com.interviewbit.tree;

public class MinDepthBTree
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public static int minDepth(TreeNode a)
	{
		if(a==null)
			return 0;
		if(a.left==null && a.right==null)
			return 1;
		if(a.left==null)
			return minDepth(a.right)+1;
		if(a.right==null)
			return minDepth(a.left)+1;
		return Math.min(minDepth(a.right), minDepth(a.left))+1;
	}
	
}
