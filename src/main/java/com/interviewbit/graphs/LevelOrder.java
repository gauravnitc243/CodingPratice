package com.interviewbit.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder
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
		TreeNode a= new TreeNode(3);
		a.left = new TreeNode(9);
		a.right= new TreeNode(20);
		a.right.left= new TreeNode(15);
		a.right.right= new TreeNode(7);
		System.out.println(levelOrder(a));

	}
	
	public static  ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) 
	{
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		if(a==null)
			return res;
		q1.add(a);
		ArrayList<Integer> r = new ArrayList<Integer>();
		while(!q1.isEmpty() || !q2.isEmpty())
		{
			if(!q1.isEmpty())
			{
				TreeNode t = q1.poll();
				r.add(t.val);
				if(t.left!=null)
					q2.add(t.left);
				if(t.right!=null)
					q2.add(t.right);
			}
			else
			{
				res.add(new ArrayList<>(r));
				r.clear();
				q1=q2;
				q2= new LinkedList<TreeNode>();
			}
		}
		res.add(new ArrayList<>(r));
		return res;
		
	}

}
