package com.interviewbit.linkedList;


public class MergeTwoSortedList
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
		ListNode b = new ListNode(4);
		b.next = (new ListNode(5));
		b.next.next = new ListNode(6);
		ListNode r =mergeTwoLists(a,b);
		while(r!=null)
		{
			System.out.print(r.val+" ");
			r = r.next;
		}

	}
	
/*	public static ListNode mergeTwoLists(ListNode a, ListNode b) 
	{
		ListNode tt = new ListNode(Integer.MIN_VALUE);
		tt.next =a;
		a=tt;
		ListNode current= a.next;
		ListNode previous = a;
		if(b==null)
			return a;
		while(b!=null)
		{
			while(b.val>current.val)
			{
				previous = current;
				current = current.next;
			}
			ListNode t = new ListNode(b.val);
			previous.next = t;
			t.next = current;
			previous = t;
		}
		a = tt.next;
		return a;
	}*/
	
	public static ListNode mergeTwoLists(ListNode a, ListNode b) 
	{
		ListNode result=null ;
		ListNode ret =null;
		ListNode aa =a;
		ListNode bb =b;
		while(aa!=null && bb!=null)
		{
			if(aa.val<bb.val)
			{
				if(result==null)
				{
					result = new ListNode(aa.val);
					ret = result;
					aa= aa.next;
				}
				else
				{
					result.next = new ListNode(aa.val);
					result = result.next;
					aa = aa.next;
				}
			}
			else
			{
				if(result==null)
				{
					result = new ListNode(bb.val);
					ret = result;
					bb=bb.next;
				}
				else
				{
					result.next = new ListNode(bb.val);
					result = result.next;
					bb = bb.next;
				}
			}
		}
		while(aa!=null)
		{
			result.next = new ListNode(aa.val);
			aa = aa.next;
			result = result.next;
		}
		while(bb!=null)
		{
			result.next = new ListNode(bb.val);
			bb = bb.next;
			result = result.next;
		}
		return ret;
	}
}
