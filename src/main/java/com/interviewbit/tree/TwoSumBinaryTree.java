package com.interviewbit.tree;

public class TwoSumBinaryTree
{

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(14);
		root.left = new TreeNode(1);
		root.right = new TreeNode(20);
		/*root.left.left = new TreeNode(9);
		root.right = new TreeNode(14);*/
		System.out.println(twoSum(root, 21));;
	}
	
	public static int twoSum(TreeNode A, int B)
	{
		Context context = new Context();
		convert(A,context);
		TreeNode head = context.head;
		TreeNode last = head;
		while(last.right!=null)
			last = last.right;
		while(head!=last)
		{
			if(head.val+last.val==B)
				return 1;
			else if(head.val+last.val>B)
				last = last.left;
			else
				head = head.right;
		}
		return 0;
	}
	
	 private static class Context {
	        public TreeNode head;
	        public TreeNode prev;
	        
	    }
	    private static void convert(TreeNode root, Context context) {
	        if (root == null) {
	            return;
	        }
	        convert(root.left, context);
	        if (context.prev == null) {
	            context.head = root;
	        } else {
	            root.left = context.prev;
	            context.prev.right = root;
	        }
	        context.prev = root;
	        convert(root.right, context);
	    }
}
