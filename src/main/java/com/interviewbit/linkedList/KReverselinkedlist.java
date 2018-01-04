package com.interviewbit.linkedList;

public class KReverselinkedlist {

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = (new ListNode(2));
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(4);
		a.next.next.next.next = new ListNode(5);
		ListNode b = reverseList(a, 2);
		while (b != null) {
			System.out.print(b.val + " ");
			b = b.next;
		}
	}

	public static ListNode reverseList(ListNode A, int B) {
		int count = B;
		ListNode currNode = A;
		ListNode prevNode = null;
		ListNode nextNode = null;
		if (currNode == null)
			return null;
		while (currNode != null && count-- > 0) 
		{
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		if (nextNode != null) 
	          A.next = reverseList(nextNode,B);
		return prevNode;
	}
}
