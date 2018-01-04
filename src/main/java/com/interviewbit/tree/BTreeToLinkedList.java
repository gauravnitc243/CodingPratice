package com.interviewbit.tree;

import java.util.Stack;

public class BTreeToLinkedList
{

	public static void main(String[] args)
	{
		TreeNode a = new TreeNode(1);
		a.left = new TreeNode(2);
		a.left.left  = new TreeNode(3);
		a.left.right = new TreeNode(4);
		a.right = new TreeNode(5);
		a.right.right = new TreeNode(6);
		TreeNode b = flatten(a);
		System.out.println(b);

	}
	
	public static TreeNode flatten(TreeNode a) 
	{
		TreeNode root = a;
		Stack<TreeNode>  st = new Stack<>();
		while(root!=null || !st.isEmpty())
		{
			if(root.right!=null)
				st.push(root.right);
			if(root.left!=null)
			{
				root.right =root.left;
				root.left = null;
			}
			else if(!st.isEmpty())
			{
				root.right = st.pop();
			}
			root = root.right;
		}
		return a;
	}
	
}
