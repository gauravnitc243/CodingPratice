package com.interviewbit.tree;

import java.util.ArrayList;

public class BTreeFromInorderAndPreorder
{
	ArrayList<Integer> preorder, inorder;

	public static void main(String[] args)
	{
		/*ArrayList<Integer> in = new ArrayList<>(Arrays.asList(4 ,2, 5,1, 6, 7, 3, 8));
		ArrayList<Integer> pre = new ArrayList<>(Arrays.asList(1, 2, 4, 5,  3, 7, 6, 8));
		TreeNode res = buildTree(pre, in);*/
	}
	public  static TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder)
	{
	    if (preorder == null || inorder == null || preorder.size() == 0 || inorder.size() == 0 || (preorder.size() != inorder.size()))
	        return null;
	    return rec(preorder, inorder,0, preorder.size() - 1, 0);
	 }
	public static TreeNode rec(ArrayList<Integer> preorder,ArrayList<Integer> inorder,int start, int end, int index) {
	    if (start > end)
	        return null;
	    TreeNode root = new TreeNode(preorder.get(index));
	    int i = start;
	    for (; i <= end; i++) 
	    {
	        if (inorder.get(i).intValue() == root.val)
	            break;
	    }
	    root.left = rec(preorder, inorder,start, i - 1, index + 1);
	    root.right = rec(preorder, inorder,i + 1, end, index + i - start + 1);
	    return root;
	}
	

}
