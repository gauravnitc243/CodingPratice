package com.interviewbit.linkedList;


public class CycleDetection
{

	public static void main(String[] args)
	{
		ListNode a = new ListNode(1);
		a.next = (new ListNode(2));
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(4);
		a.next.next.next.next = new ListNode(5);
		a.next.next.next.next.next = new ListNode(6);
		ListNode b =addNumbers(a);
		while(b!=null)
		{
			System.out.print(b.val+" ");
			b = b.next;
		}
	}
	public static ListNode addNumbers(ListNode a)
	{
         if(a == null || a.next == null) {
            return null;
        }

        ListNode fast = a;
        ListNode slow = a;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                slow = a;
                while(slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        return null;
    }
/*	public static ListNode addNumbers(ListNode a) 
	{
		ListNode slow = a;
		ListNode fast = a;
		while(fast!=null && fast.next!=null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast)
				break;
		}
		if(fast == null)
			return null;
		slow =a;
		while(slow!=fast)
		{
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}*/
}
