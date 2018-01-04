package com.interviewbit.tree;

public class SumRoottoLeaf
{

	public static void main(String[] args)
	{
		TreeNode a = new TreeNode(1);
		a.left = new TreeNode(2);
		a.right = new TreeNode(3);
		System.out.println(sumNumbers(a));

	}
	 public static int sumNumbers(TreeNode a) 
	 {
		 return getSum(a,0)%1003;
	 }
	 
	 public static int getSum(TreeNode root,int num)
	 {
		 if(root==null)
			 return 0;
		 if(root.left==null && root.right==null)
			 return  (root.val + num *10)%1003;
		 num =  (root.val + num *10)%1003;
		 int lSum =  getSum(root.left, num);
		 int rSum = getSum(root.right, num);
		 return (lSum+rSum)%1003;
	 }

}
