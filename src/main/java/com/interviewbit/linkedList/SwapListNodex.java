package com.interviewbit.linkedList;

public class SwapListNodex
{

	private static class ListNode 
	{
	      public int val;
	      public ListNode next;
	      ListNode(int x) { val = x; next = null; }
	}
	public static void main(String[] args)
	{
		ListNode a = new ListNode(1);
		a.next = (new ListNode(2));
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(4);
		a.next.next.next.next = new ListNode(5);
		a.next.next.next.next.next = new ListNode(6);
		ListNode b =swapAlternative(a);
		while(b!=null)
		{
			System.out.print(b.val+" ");
			b = b.next;
		}

	}
	public static ListNode swapAlternative(ListNode a) 
	{
		ListNode node = a;
		ListNode previous = null;
		ListNode next  =null;
		ListNode temp  =null;
		ListNode res  =a;
		while(node!=null && node.next!=null)
		{
			next = node.next.next;
			if(previous!=null)
				previous.next = node.next;
			temp = node.next;
			node.next = next;
			temp.next = node;
			
			if(previous == null)
			{
				previous = temp;
				res = previous;
				previous = previous.next;
			}
			previous = node;
			node = node.next;
		}
		
		return res;
	}

}
