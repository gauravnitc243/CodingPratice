package com.interviewbit.tree;

public class SymmetricTrees
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	public int isSymmetric(TreeNode a) {
		if (a == null)
			return 1;
		return isSymmetric(a.left, a.right);
	}
	 
	public int isSymmetric(TreeNode l, TreeNode r) {
		if (l == null && r == null) {
			return 1;
		} else if (r == null || l == null) {
			return 0;
		}
	 
		if (l.val != r.val)
			return 0;
	 
		if (isSymmetric(l.left, r.right)==0)
			return 0;
		if (isSymmetric(l.right, r.left)==0)
			return 0;
	 
		return 1;
	}

}
