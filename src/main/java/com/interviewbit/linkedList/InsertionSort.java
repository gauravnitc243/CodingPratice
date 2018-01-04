package com.interviewbit.linkedList;

public class InsertionSort
{

	public static void main(String[] args)
	{
		ListNode a = new ListNode(6);
		a.next = (new ListNode(3));
		a.next.next = new ListNode(2);
		a.next.next.next = new ListNode(2);
		a.next.next.next.next = new ListNode(1);
		a.next.next.next.next.next = new ListNode(4);
		ListNode b =insertionSort(a);
		while(b!=null)
		{
			System.out.print(b.val+" ");
			b = b.next;
		}

	}
	
	public static ListNode  insertionSort(ListNode a)
	{
		ListNode insertion = a;
		ListNode current = a.next;
		while(current!=null)
		{
			insertion = a;
			while(insertion!=null)
			{
				if(insertion.val>current.val)
				{
					int tem = insertion.val;
					insertion.val = current.val;
					current.val = tem;
				}
				else
					insertion = insertion.next;
			}
			current = current.next;
		}
		return a;
	}

}
