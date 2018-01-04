package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal
{

	public static void main(String[] args)
	{
		TreeNode a = new TreeNode(1);
		a.right = new TreeNode(2);
		a.right.left = new TreeNode(3);
		System.out.println(preorderTraversal(a));

	}
	public static ArrayList<Integer> preorderTraversal(TreeNode a) 
	{
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        if(a == null)
            return returnList;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(a);
        while(!stack.empty())
        {
            TreeNode n = stack.pop();
            returnList.add(n.val);
            if(n.right != null){
                stack.push(n.right);
            }
            if(n.left != null){
                stack.push(n.left);
            }
 
        }
        return returnList;
      }
}
