package com.interviewbit.stackqueues;

public class MinStack
{

	ListNode head = null;
	int		 size = 0;
	private static class ListNode
	{
		public int		val;
		public int		minSoFar;
		public ListNode	next;

		ListNode(int x)
		{
			val = x;
			next = null;
		}
	}

	public void push(int x)
	{
		ListNode t = new ListNode(x);
		if (head == null)
		{
			head = t;
			head.minSoFar = x;
		} else
		{
			int min = head.minSoFar < x ? head.minSoFar : x;
			t.minSoFar = min;
			t.next = head;
			head = t;
		}
	}

	public void pop()
	{
		if (head != null)
		{
			head = head.next;
		}

	}

	public int top()
	{
		if (head != null)
			return head.val;
		return -1;

	}

	public int getMin()
	{
		if (head != null)
			return head.minSoFar;
		return -1;
	}

}
