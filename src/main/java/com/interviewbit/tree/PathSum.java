package com.interviewbit.tree;

public class PathSum
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	  public int hasPathSum(TreeNode a, int b) 
	  {
		  int res =0;
		  if(a==null && b==0)
			  return 1;
		  else if(a==null)
			  return 0;
		  if(b-a.val==0 && a.left==null && a.right==null)
			  return 1;
		  if(a.right!=null)
			  res |=  hasPathSum(a.right, b-a.val);
		  if(a.left!=null)
			  res |= hasPathSum(a.left, b-a.val);
		  return res;
	  }

}
