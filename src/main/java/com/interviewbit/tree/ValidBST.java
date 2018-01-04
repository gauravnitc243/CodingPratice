package com.interviewbit.tree;

public class ValidBST
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public int isValidBST(TreeNode a) 
	{
		if(isValidBSTree(a,Integer.MIN_VALUE,Integer.MAX_VALUE))
			return 1;
		else 
			return 0;
	}
	public boolean isValidBSTree(TreeNode root , int minValue, int maxValue) 
	{
		if(root==null)
			return true;
		if(root.val > minValue && root.val< maxValue && isValidBSTree(root.left,minValue,root.val) && isValidBSTree(root.right,root.val,maxValue))
			return true;
		else
			return false;
	}
}
