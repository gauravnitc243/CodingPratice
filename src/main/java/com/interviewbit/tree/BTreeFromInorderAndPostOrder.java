package com.interviewbit.tree;

import java.util.ArrayList;

public class BTreeFromInorderAndPostOrder
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public static TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder)
	{
	    if (inorder == null || postorder == null || inorder.size() == 0 || inorder.size() != postorder.size())
	        return null;
	    int n = inorder.size();
	    return rec(inorder, postorder, 0, n - 1, n - 1);
	 }
	
	public static TreeNode rec(ArrayList<Integer> inorder, ArrayList<Integer> postorder, int start, int end, int postIndex) 
	{
	    if (start > end)
	        return null;
	    TreeNode node = new TreeNode(postorder.get(postIndex));
	    int i;
	    for (i = start; i <= end; i++) {
	        if (inorder.get(i) == node.val)
	            break;
	    }
	    node.left = rec(inorder, postorder, start, i - 1, postIndex - (end - i + 1));
	    node.right = rec(inorder, postorder, i + 1, end, postIndex - 1);
	    return node;
	}
}
