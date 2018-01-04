package com.interviewbit.linkedList;

public class RotateList
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
		ListNode b =rotateRight(a,89);
		while(b!=null)
		{
			System.out.print(b.val+" ");
			b = b.next;
		}
	}
	public static  ListNode rotateRight(ListNode a, int b) 
	{
		if(b<1)
			return a;
		int index = b;
		ListNode temp=a;
		ListNode current =a;
		ListNode result =null;
		while(index>0 && temp !=null)
		{
			temp = temp.next;
			index--;
		}
		
		if(temp==null)
		{
			index = (b)%(b-index);
			temp = a;
			while(index>0 && temp !=null)
			{
				temp = temp.next;
				index--;
			}
		}
		while(temp !=null && temp.next !=null)
		{
			temp = temp.next;
			current = current.next;
		}
		result=current.next;
		current.next = null;
		current = result;
		while(current != null && current.next!=null)
		{
			current= current.next;
		}
		if(current==null)
			return a;
		else
			current.next = a;
		return result;
		
	}

}
