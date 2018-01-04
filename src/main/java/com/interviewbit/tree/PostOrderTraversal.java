package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal
{

	public static void main(String[] args)
	{
		TreeNode a = new TreeNode(1);
		a.right = new TreeNode(2);
		a.right.left = new TreeNode(3);
		System.out.println(postorderTraversal(a));
	}
	
	public static ArrayList<Integer> postorderTraversal(TreeNode a) 
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
	    if(a==null) {
	        return result;
	    }
	    Stack<TreeNode> stack1 = new Stack<TreeNode>();
	    Stack<TreeNode> stack2 = new Stack<TreeNode>();
	    stack1.push(a);
	    while(!stack1.isEmpty())
	    {
	    	TreeNode t= stack1.pop();
	    	stack2.push(t);
	    	if(t.left!=null)
	    		stack1.push(t.left);
	    	if(t.right!=null)
	    		stack1.push(t.right);
	    }
	    while(!stack2.isEmpty())
	    	result.add(stack2.pop().val);
	    return result;
	}
	
	public static ArrayList<Integer> postorderTraversal1(TreeNode a) 
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
	    if(a==null) {
	        return result;
	    }
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(a);
	    while(!stack.isEmpty()) 
	    {
	        TreeNode temp = stack.peek();
	        if(temp.left==null && temp.right==null) 
	        {
	            TreeNode pop = stack.pop();
	            result.add(pop.val);
	        }
	        else 
	        {
	            if(temp.right!=null) 
	            {
	                stack.push(temp.right);
	                temp.right = null;
	            }
	            if(temp.left!=null) 
	            {
	                stack.push(temp.left);
	                temp.left = null;
	            }
	        }
	    }
	 
	    return result;
	}
	
}
