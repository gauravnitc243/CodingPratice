package com.interviewbit.tree;

public class InvertBTree
{

	public static void main(String[] args)
	{
		TreeNode a = new TreeNode(1);
		a.left = new TreeNode(2);
		a.right = new TreeNode(3);
		TreeNode t = invertTree(a);
		System.out.println(t);

	}
	
	 public static TreeNode invertTree(TreeNode root) 
	 {
		 if(root==null)
			 return root;
		 TreeNode t = root.left;
		 root.left = root.right;
		 root.right = t;
		 if(root.left!=null)
			  invertTree(root.left);
		 if(root.right!=null)
			 invertTree(root.right);
		 return root;
		 
	 }
	  

}
