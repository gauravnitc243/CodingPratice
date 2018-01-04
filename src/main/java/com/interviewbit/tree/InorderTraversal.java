package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal
{
	public static void main(String[] args)
	{

	}
	public ArrayList<Integer> inorderTraversal(TreeNode a) 
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = a;
		while(!stack.isEmpty() || temp!=null)
		{
			if(temp!=null)
			{
				stack.push(temp);
				temp = temp.left;
			}
			else
			{
				TreeNode t = stack.pop();
				result.add(t.val);
				temp = t.right;
			}
		}
		return result;
	}
	
}
