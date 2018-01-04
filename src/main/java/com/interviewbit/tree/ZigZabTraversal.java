package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZabTraversal
{

	public static void main(String[] args)
	{
		TreeNode a = new TreeNode(3);
		a.left = new TreeNode(9);
		a.right  = new TreeNode(20);
		a.right.right = new TreeNode(15);
		a.right.left = new TreeNode(7);
		System.out.println(zigZag(a));

	}
	
	public static  ArrayList<ArrayList<Integer>> zigZag(TreeNode a)
	{
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Stack<TreeNode> st1= new Stack<>();
		Stack<TreeNode> st2= new Stack<>();
		ArrayList<Integer> list ;
		st1.push(a);
		while(!st1.isEmpty() || !st2.isEmpty())
		{
			list = new ArrayList<>();
			while(!st1.isEmpty())
			{
				TreeNode t = st1.pop();
				list.add(t.val);
				if(t.left!=null)
					st2.push(t.left);
				if(t.right!=null)
					st2.push(t.right);
			}
			if(list.size()>0)
				res.add(list);
			list = new ArrayList<>();
			while(!st2.isEmpty())
			{
				TreeNode t = st2.pop();
				list.add(t.val);
				if(t.right!=null)
					st1.push(t.right);
				if(t.left!=null)
					st1.push(t.left);
			}
			if(list.size()>0)
				res.add(list);
		}
		return res;
	}

}
