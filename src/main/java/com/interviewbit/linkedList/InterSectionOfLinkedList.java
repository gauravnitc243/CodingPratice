package com.interviewbit.linkedList;

public class InterSectionOfLinkedList
{
	private static class ListNode 
	{
	      public int val;
	      public ListNode next;
	      ListNode(int x) { val = x; next = null; }
	}

	public static void main(String[] args)
	{
		ListNode first = new ListNode(1);
		first.next = new ListNode(2);
		ListNode second = new ListNode(3);
		second.next = new ListNode(3);
		first.next.next =  new ListNode(4);
		second.next.next =first.next.next ;
		System.out.println(getIntersectionNode(first,second).val);
	}
	
	
	public static ListNode getIntersectionNode(ListNode a, ListNode b) 
	{
		int lengthA =0;
		int lengthB =0;
		ListNode A=a;
		ListNode B =b;
		if(a==null || b==null)
			return null;
		
		while(A!=null)
		{
			lengthA++;
			A = A.next;
		}
		while(B!=null)
		{
			lengthB++;
			B = B.next;
		}
		if(lengthA==0 || lengthB==0)
			return null;
		 A=a;
		 B=b;
		if(lengthA>lengthB)
		{
			int diff = lengthA-lengthB;
			
			while(diff>0)
			{
				A = A.next;
				diff--;
			}
		}
		if(lengthA<lengthB)
		{
			int diff = lengthB-lengthA;
			 
			while(diff>0)
			{
				B = B.next;
				diff--;
			}
		}
		
		while(A!=null && B!=null)
		{
			if(A==B)
				return A;
			A = A.next;
			B = B.next;
		}
		return null;
	}

}
