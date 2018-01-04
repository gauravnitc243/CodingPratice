package com.interviewbit.linkedList;

public class PalindromeList
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
		a.next = (new ListNode(1));
		a.next.next = new ListNode(6);
		a.next.next.next = new ListNode(4);
		a.next.next.next.next = new ListNode(1);
		PalindromeList p = new PalindromeList();
		p.isPalindrome(a);
	}
	
	public int isPalindrome(ListNode A)
	{
		ListNode rev = null;
		ListNode revStart = null;
		ListNode a = A;
		while(A!=null)
		{
			if(rev==null)
			{
				rev = new ListNode(A.val);
				revStart = rev;
				A = A.next;
			}
			else
			{
				rev.next=new ListNode(A.val);
				rev = rev.next;
				A =A.next;
			}
		}
		rev = reverse(revStart);
		
		while(a!=null)
		{
			if(a.val != rev.val)
				return 0;
			a =a.next;
			rev = rev.next;
		}
		return 1;
	}
	public ListNode reverse(ListNode a)
	{
		ListNode p = null;
		ListNode current = a;
		ListNode n = null;
		while(current!=null)
		{
			n = current.next;
			current.next= p;
			p = current;
			current = n;
		}
		return p;
	}

}
