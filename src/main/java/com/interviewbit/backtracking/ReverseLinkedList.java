package com.interviewbit.backtracking;

import com.interviewbit.linkedList.ListNode;

public class ReverseLinkedList
{
	public static ListNode head =null;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public ListNode reverseList(ListNode a) 
	{
		reverse(a);
		return head;
	}
	
	public static void reverse(ListNode a)
	{
		if(a.next==null)
		{
			head = a;
			return ;
		}
		reverse(a.next);
		ListNode t = a.next;
		t.next = a;
		a.next = null;
	}

}
