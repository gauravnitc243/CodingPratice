package com.interviewbit.tree;

import java.util.Stack;

public class BSTIterator
{

	public static void main(String[] args)
	{

	}
	Stack<TreeNode> stack;
	 public BSTIterator(TreeNode root) {
		 stack  = new Stack<>();
		 while(root!=null)
		 {
			 stack.push(root);
			 root = root.left;
		 }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode  t = stack.pop();
        int result = t.val;
        if(t.right!=null)
        {
        	t = t.right;
        	while(t!=null)
        	{
        		stack.push(t);
        		t = t.left;
        	}
        }
        return result;
    }
}
