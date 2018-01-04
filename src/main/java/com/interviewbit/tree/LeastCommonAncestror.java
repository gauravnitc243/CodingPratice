package com.interviewbit.tree;

public class LeastCommonAncestror
{

	public static void main(String[] args)
	{
		TreeNode  a = new TreeNode(5);
		a.left = new TreeNode(4);
		a.right = new TreeNode(6);
		System.out.println(lca(a, 4, 2));

	}

	public static boolean foundFirst = false;
	public static boolean foundSecond = false;

	public static int lca(TreeNode a, int val1, int val2) 
	{
		TreeNode res = lcaHelper(a, new TreeNode(val1), new TreeNode(val2));
		if(res!=null && val1==val2)
			return res.val;
		if(foundFirst && foundSecond && res!=null )
			return res.val;
		else 
			return -1;
	}
	
	public static TreeNode lcaHelper(TreeNode root, TreeNode first,TreeNode second)
	{
		if(root==null)
			return null;
		if(root.val==first.val )
		{
			foundFirst = true;
			return root;
		}
		if( root.val==second.val)
		{
			foundSecond = true;
			return root;
		}
		TreeNode left = lcaHelper(root.left,first,second);
		TreeNode right = lcaHelper(root.right,first,second);
		if(left!=null && right!=null)
			return root;
		if(left==null)
			return right;
		else
			return left;
	}
}
