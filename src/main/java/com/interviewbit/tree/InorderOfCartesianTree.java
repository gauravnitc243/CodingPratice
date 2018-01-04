package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class InorderOfCartesianTree
{
	public static void main(String[] args)
	{
		System.out.println(buildTree(new ArrayList<>(Arrays.asList(1,2,3))));
	}
	
	public static TreeNode buildTree(ArrayList<Integer> a) 
	{
		 TreeNode root =null;
		 root = constructTree(root,a, 0, a.size()-1);
		 return root;
    }
	
	public static TreeNode constructTree(TreeNode root,ArrayList<Integer> input,int start,int end)
	{
		if(start<0 || end>=input.size() || start>=input.size() || end<0 || start>end)
			return null;
		int maxIndex = getMaxIndex(input, start, end);
		root = new TreeNode(input.get(maxIndex));
		root.left = constructTree(root.left, input, start, maxIndex-1);
		root.right = constructTree(root.right, input, maxIndex+1, end);
		return root;
	
	}
	public static int getMaxIndex(ArrayList<Integer> input,int start,int end)
	{
		int index = start;
		for(int i = start;i<=end;i++)
		{
			if(input.get(i)>=input.get(index))
				index = i;
		}
		return index;
	}
}
