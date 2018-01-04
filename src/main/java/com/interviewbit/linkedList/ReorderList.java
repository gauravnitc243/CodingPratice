package com.interviewbit.linkedList;

public class ReorderList
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
		ListNode b =reorderList(a);
		while(b!=null)
		{
			System.out.print(b.val+" ");
			b = b.next;
		}
	}
	public static ListNode reorderList(ListNode a) 
	{
		if (a != null && a.next != null) 
		{
			ListNode slow = a;
			ListNode fast = a;
			while (fast != null && fast.next != null && fast.next.next!= null) 
			{
				slow = slow.next;
				fast = fast.next.next;
			}
			ListNode second = slow.next;
			slow.next = null;
			second = reverseOrder(second);
			ListNode p1 = a;
			ListNode p2 = second;
			while (p2 != null) 
			{
				ListNode temp1 = p1.next;
				ListNode temp2 = p2.next;
				p1.next = p2;
				p2.next = temp1;		
				p1 = temp1;
				p2 = temp2;
			}
		}
		return a;
	}
 
	public static ListNode reverseOrder(ListNode head) 
	{
		if (head == null || head.next == null) 
		{
			return head;
		}
		ListNode pre = head;
		ListNode curr = head.next;
		while (curr != null) 
		{
			ListNode temp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = temp;
		}
		head.next = null;
		return pre;
	}
 
	
	/*public static ListNode reorderList(ListNode a) 
	{
		ListNode fast = a;
		ListNode slow = a;
		while(fast !=null && fast.next!=null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		
		re
		
	}*/
}
