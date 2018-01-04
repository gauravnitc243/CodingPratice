package com.interviewbit.tree;

public class IdenticalBTrees
{

	public static void main(String[] args)
	{
		
	}
	public static int isSameTree(TreeNode a, TreeNode b) 
	{
        if (a == null && b == null)
            return 1;
        else if ((a == null && b != null) || (a !=null && b == null) || (a.val != b.val))
            return 0;
        else
            return isSameTree(a.left, b.left) & isSameTree(a.right, b.right);
    }
	public static boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if ((p == null && q != null) || (p !=null && q == null) || (p.val != q.val))
            return false;
        else
            return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }
}
