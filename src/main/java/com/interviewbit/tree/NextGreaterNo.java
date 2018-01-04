package com.interviewbit.tree;

public class NextGreaterNo
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public  TreeNode getSuccessor(TreeNode a, int b) 
	{
		TreeNode current = find(a,b);
		if(current==null)
			return null;
		else if(current.right!=null)
			return findMin(current.right);
		else
		{
			TreeNode p = null;
			TreeNode q = a;
			while(a!=current)
			{
				if(q.val>current.val)
				{
					p = q;
					q = q.left;
				}
				else
					q = q.right;
			}
			return p;
		}
			
	}
	public TreeNode findMin(TreeNode root)
	{
		while(root.left!=null)
			root = root.left;
		return root;
	}
	
	public  TreeNode find(TreeNode root,int data)
	{
		while(root!=null)
		{
			if(root.val==data)
				return root;
			else if(root.val>data)
				root = root.left;
			else
				root = root.right;
		}
		return root;
	}

}
