package com.interviewbit.linkedList;


public class RemoveNthNode
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
		ListNode b =removeNth(a,7);
		while(b!=null)
		{
			System.out.print(b.val+" ");
			b = b.next;
		}
	}
	public static ListNode removeNth(ListNode a, int b) 
	{
		ListNode slow = a;
		ListNode fast = a;
		while(b>0 && fast!=null)
		{
			fast = fast.next;
			b--;
			if(fast==null)
				break;
		}
		if(fast==null)
		{
			slow = null;
			fast = null;
			a = a.next;
			return a;
		}
		while(fast.next!=null)
		{
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return a;
		
	}
}
