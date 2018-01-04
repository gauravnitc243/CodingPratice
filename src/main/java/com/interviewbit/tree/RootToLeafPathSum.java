package com.interviewbit.tree;

import java.util.ArrayList;

public class RootToLeafPathSum
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum)
	{
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    ArrayList<Integer> array = new ArrayList<>();
	    findAll(root, 0, sum, res, array);
	    return res;
	}
	public static void findAll(TreeNode node, int curSum, int reqSum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> array) 
	{
	    if (node == null)
	        return;
	    array.add(node.val);
	    if (node.left == null && node.right == null)
	    {
	        curSum += node.val;
	        if (curSum == reqSum) 
	            res.add(new ArrayList<Integer>(array));
	        array.remove(array.size() - 1);
	        return;
	    }
	    curSum += node.val;
	    findAll(node.left, curSum, reqSum, res, array);
	    findAll(node.right, curSum, reqSum, res, array);
	    array.remove(array.size() - 1);
	}

}
