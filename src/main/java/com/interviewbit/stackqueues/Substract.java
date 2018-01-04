package com.interviewbit.stackqueues;

import java.util.Stack;

import com.interviewbit.linkedList.ListNode;

public class Substract
{

	public static void main(String[] args)
	{
		ListNode a = new ListNode(1);
		a.next = (new ListNode(2));
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(4);
		//a.next.next.next.next = new ListNode(5);
		
		ListNode r =subtract(a);
		while(r!=null)
		{
			System.out.print(r.val+" ");
			r = r.next;
		}

	}
	
	public static ListNode subtract(ListNode a) 
	{
		ListNode slow = a;
		ListNode fast = a;
		ListNode head = a;
		Stack<ListNode> secondHalf = new Stack<ListNode>();
		while(fast!=null && fast.next!=null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		while(slow!=null)
		{
			secondHalf.push(slow);
			slow = slow.next;
		}
		while(!secondHalf.isEmpty())
		{
			ListNode t = secondHalf.pop();
			if(head==t)
				break;
			head.val = t.val-head.val;
			head = head.next;
		}
		return a;
	}

}
