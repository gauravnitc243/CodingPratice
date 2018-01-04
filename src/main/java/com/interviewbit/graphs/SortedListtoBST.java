package com.interviewbit.graphs;

public class SortedListtoBST
{
	 class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
		  class ListNode {
		      public int val;
		      public ListNode next;
		      ListNode(int x) { val = x; next = null; }
		  }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	static ListNode h;
	public TreeNode sortedListToBST(ListNode a) 
	{
		if (a == null)
			return null;
		h = a;
		int len = getLength(a);
		return sortedListToBST(0, len - 1);
	}
		public int getLength(ListNode head)
		{
			int len = 0;
			ListNode p = head;
			while (p != null) 
			{
				len++;
				p = p.next;
			}
			return len;
		}
		public TreeNode sortedListToBST(int start, int end) 
		{
			if (start > end)
				return null;
			int mid = (start + end) / 2;
			TreeNode left = sortedListToBST(start, mid - 1);
			TreeNode root = new TreeNode(h.val);
			h = h.next;
			TreeNode right = sortedListToBST(mid + 1, end);
			root.left = left;
			root.right = right;
			return root;
		}
	/*	
		public ArrayList<ListNode> nodes = new ArrayList<ListNode>();
		public TreeNode sortedListToBST(ListNode a) 
		{
			if (a == null)
				return null;
			int N =0;
			ListNode b = a;
			while(b!=null)
			{
				nodes.add(b);
				N++;
				b = b.next;
			}
			return buildTree(0, N - 1);
		}
		public TreeNode buildTree(int start, int end) 
		{
			if(start>end)
				return null;
			if(start==end)
				return new TreeNode(nodes.get(start).val);
			int mid = start + (end-start)/2;
			TreeNode node = new TreeNode(nodes.get(mid).val);
			node.left = buildTree(0,mid-1);
			node.right = buildTree(mid+1,end);
			return node;
			
		}*/
		
		

}
