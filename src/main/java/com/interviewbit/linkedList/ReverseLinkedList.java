package com.interviewbit.linkedList;

public class ReverseLinkedList
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
		ListNode b =reverseBetween(a,2,4);
		while(b!=null)
		{
			System.out.print(b.val+" ");
			b = b.next;
		}

	}
	
	public static ListNode getIntersectionNode(ListNode a) 
	{
		ListNode previous =null;
		ListNode current  = a;
		ListNode next = null;
		while(current!=null)
		{
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		a = previous;
		return a;
	}
	
	public static ListNode reverseBetween(ListNode a, int m, int n) 
	{
	    int i;
	    ListNode node = a;
	    ListNode prev = null;
	    m--;
	    n--;
	    for (i = 0; i < m; i++) 
	    {
	       prev = node;
	       node = node.next;
	    }
	    if (prev != null)
    	    prev.next = reverseList(node, n - m + 1);
    	else
    	    a = reverseList(node, n - m + 1);
	    return a;
	}
	
    public static ListNode reverseList(ListNode A, int count)
    {
	    ListNode curr, prev, next, last;
	    curr = A;
	    last = A;
	    if (curr == null)
	        return null;
	    prev = null;
	    while (curr != null && count > 0) 
	    {
	        next = curr.next;
	        curr.next = prev;
	        prev = curr;
	        curr = next;
	        count--;
	    }
	    last.next = curr;
	    return prev;
	}
}
