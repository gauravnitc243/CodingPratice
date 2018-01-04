package com.interviewbit.linkedList;


public class RemoveDuplicatesFromSortedList
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
		System.out.println(deleteDuplicates(a));
	}
	
	 public ListNode deleteDuplicates1(ListNode a) 
	 {
		    ListNode t = new ListNode(0);
		    t.next = a;
		    ListNode p = t;
		    while(p.next!=null&&p.next.next!=null)
		    {
		        if(p.next.val == p.next.next.val)
		        {
		            int dup = p.next.val;
		            while(p.next!=null&&p.next.val==dup)
		            {
		                p.next = p.next.next;
		            }
		        }
		        else
		        {
		            p=p.next;
		        }
		    }
		    return t.next;
	}

	 public static ListNode deleteDuplicates(ListNode a) 
		{
			if(a==null)
				return null;
			ListNode temp = a;
			while(temp.next!=null)
			{
				if(temp.val==temp.next.val)
				{
					temp.next = temp.next.next;
				}
				else 
					temp = temp.next;
			}
			return a;
		}
}
