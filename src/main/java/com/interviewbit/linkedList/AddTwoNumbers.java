package com.interviewbit.linkedList;

public class AddTwoNumbers
{

	public static void main(String[] args)
	{
		ListNode a = new ListNode(1);
		/*a.next = (new ListNode(0));
		a.next.next = new ListNode(1);
		a.next.next.next = new ListNode(4);
		a.next.next.next.next = new ListNode(5);
		a.next.next.next.next.next = new ListNode(6);*/
		ListNode b = new ListNode(9);
		b.next = (new ListNode(9));
		b.next.next = new ListNode(9);
		ListNode c =addNumbers(a,b);
		while(c!=null)
		{
			System.out.print(c.val+" ");
			c = c.next;
		}
	}
	
	public static ListNode addNumbers(ListNode a,ListNode b) 
	{
		int carry = 0;
		ListNode first = a;
		ListNode second = b;
		
		while(first!=null && second != null)
		{
			if(first.val+second.val+carry>=10)
			{
				first.val = first.val+second.val+carry-10;
				carry =1;
			}
			else
			{
				first.val = first.val+second.val+carry;
				carry = 0;
			}
			first = first.next;
			second = second.next;
		}
		if(first==null)
		{
			first = a;
			while(first.next!=null)
				first = first.next;
			first.next = second;
			first = first.next;
		}
		while(first!=null)
		{
			if(first.val+carry>=10)
			{
				first.val = first.val+carry-10;
				carry = 1;
			}
			else
			{
				first.val = first.val+carry;
				carry = 0;
			}
			first = first.next;
		}
		if(carry ==1)
		{
			first = a;
			while(first.next!=null)
				first = first.next;
			first.next = new ListNode(1);
		}
		return a;
	}

}
