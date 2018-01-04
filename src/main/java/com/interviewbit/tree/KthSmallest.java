package com.interviewbit.tree;

import java.util.Stack;

public class KthSmallest
{

	public static void main(String[] args)
	{
		TreeNode a = new TreeNode(20);
		a.left = new TreeNode(8);
		a.left.left  = new TreeNode(4);
		a.left.right = new TreeNode(12);
		a.left.right.left =  new TreeNode(10);
		a.left.right.right =  new TreeNode(14);
		a.right = new TreeNode(22);
		System.out.println(kthsmallest(a, 1));

	}
	
	public static int  kthsmallest(TreeNode root,int k)
	{
		if(root==null)
			return 0;
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode tmp = root;
		while((tmp!=null || !st.isEmpty()))
		{
			if(tmp!=null)
			{
				st.push(tmp);
				tmp = tmp.left;
			}
			else
			{
				TreeNode t = st.pop();
				k --;
				if(k ==0)
					return t.val;
				tmp = t.right;
			}
		}
		return 0;
	}

}
