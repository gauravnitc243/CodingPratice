package com.interviewbit.tree;

import java.util.ArrayList;

public class RecoverBTree
{
	public static class Context
	{
		TreeNode firstMisplacedNode;
		TreeNode secondMisplacedNode;
		TreeNode previousNode;
	}

	public static void main(String[] args)
	{
		TreeNode a = new TreeNode(1);
		a.left = new TreeNode(2);
		a.right = new TreeNode(3);
		System.out.println(recoverTree(a));
	}
	public static ArrayList<Integer> recoverTree(TreeNode a)
	{
		 ArrayList<Integer> res = new ArrayList<>();
		 if(a==null)
			 return res;
		Context ctx= new Context();
		recoverTree(a,ctx);
		res.add(ctx.firstMisplacedNode.val);
		res.add(ctx.secondMisplacedNode.val);
		return res;
	}
	
	public static void recoverTree(TreeNode root,Context ctx)
	{
		if(root==null)
			return;
		recoverTree(root.left,ctx);
		if(ctx.previousNode!=null)
		{
			if(ctx.previousNode.val>root.val)
			{
				if(ctx.firstMisplacedNode==null)
					ctx.firstMisplacedNode = ctx.previousNode;
				ctx.secondMisplacedNode = root;
				
			}
		}
		ctx.previousNode = root;
		recoverTree(root.right,ctx);
	}

}
