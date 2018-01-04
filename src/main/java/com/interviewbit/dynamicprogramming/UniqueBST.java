package com.interviewbit.dynamicprogramming;

import java.util.ArrayList;

public class UniqueBST
{
	 static class TreeNode 
	 {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}

	public static void main(String[] args)
	{
		System.out.println(generateTrees(4));

	}
	
	public static ArrayList<TreeNode> generateTrees(int a) 
	{
		if(a<=0)
			return new ArrayList<TreeNode>();
		else
			return generatHelper(1,a);
	}
	
	public static ArrayList<TreeNode> generatHelper(int m, int n)
	{
	    ArrayList<TreeNode> result = new ArrayList<TreeNode>();
	    if(m>n)
	    {
	        result.add(null);
	        return result;
	    }
	    for(int i=m; i<=n; i++)
	    {
	    	ArrayList<TreeNode> ls = generatHelper(m, i-1);
	    	ArrayList<TreeNode> rs = generatHelper(i+1, n);
	        for(TreeNode l: ls)
	        {
	            for(TreeNode r: rs)
	            {
	                TreeNode curr = new TreeNode(i);
	                curr.left=l;
	                curr.right=r;
	                result.add(curr);
	            }
	        }
	    }
	    return result;
	}

}
