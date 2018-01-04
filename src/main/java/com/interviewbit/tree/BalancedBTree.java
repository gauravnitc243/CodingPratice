package com.interviewbit.tree;

public class BalancedBTree
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public int isBalanced(TreeNode a) 
	{
		if (a == null)
			return 1;
 
		if (getHeight(a) == -1)
			return 0;
		return 1;
	}
	public int getHeight(TreeNode root) {
		if (root == null)
			return 0;
 
		int left = getHeight(root.left);
		int right = getHeight(root.right);
 
		if (left == -1 || right == -1)
			return -1;
 
		if (Math.abs(left - right) > 1) {
			return -1;
		}
 
		return Math.max(left, right) + 1;
 
	}

}
