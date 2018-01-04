package com.interviewbit.linkedList;

public class PartitionList
{

	public static void main(String[] args)
	{

		ListNode a = new ListNode(1);
		a.next = (new ListNode(4));
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(2);
		a.next.next.next.next = new ListNode(5);
		a.next.next.next.next.next = new ListNode(2);
		ListNode b =partition(a,3);
		while(b!=null)
		{
			System.out.print(b.val+" ");
			b = b.next;
		}

	}

	public static ListNode partition(ListNode a, int b) 
	{
		ListNode result = new ListNode(0);
		ListNode r = result;
		ListNode head = a;
		while(head!=null)
		{
			if(head.val<b)
			{
				result.next = new ListNode(head.val);
				result = result.next;
			}
			head = head.next;
		}
		 head = a;
		while(head!=null)
		{
			if(head.val>=b)
			{
				result.next = new ListNode(head.val);
				result = result.next;
			}
			head = head.next;
		}
		return r.next;
	}
}
