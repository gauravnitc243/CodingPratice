package com.interviewbit.tree;

public class MaxDepthBTree
{

	public static void main(String[] args)
	{
		TreeNode a = new TreeNode(1);
		a.left = new TreeNode(2);
		a.left.left = new TreeNode(8);
		System.out.println(maxDepth(a));

	}
	
	
	public static int maxDepth(TreeNode a) { 
	    return depth(a, 0);
	}
	public static int depth(TreeNode node, int level)
	{
	    if (node == null)
	        return level;
	    return Math.max(depth(node.left, level + 1), depth(node.right, level + 1));
	}

}
