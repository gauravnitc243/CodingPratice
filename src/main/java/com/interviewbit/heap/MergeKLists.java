package com.interviewbit.heap;

import java.util.ArrayList;
import java.util.TreeMap;

public class MergeKLists
{
	static class ListNode
	{
		int val;
		ListNode next;
		ListNode(int x) 
		{
			val = x;
			next = null;
		}
	}
	
/*	public static ListNode mergeKLists(ArrayList<ListNode> a) 
	{
        if (a.size() == 0)
            return null;
        return mergeKLists(a, 0, a.size() - 1);
    }
	 public static  ListNode mergeKLists(List<ListNode> lists, int left, int right) {
	        if (left < right) {
	            int mid = (left + right) / 2;
	            return merge(mergeKLists(lists, left, mid), mergeKLists(lists, mid + 1, right));
	        }
	        return lists.get(left);
	    }
	    
	    public static ListNode merge(ListNode m, ListNode n) {
	        ListNode head = new ListNode(0);
	        ListNode p = head;
	        while (m != null && n != null) {
	            if (m.val < n.val) {
	                p.next = m;
	                p = p.next;
	                m = m.next;
	            } else {
	                p.next = n;
	                p = p.next;
	                n = n.next;
	            }
	        }
	        if (m != null)
	            p.next = m;
	        else
	            p.next = n;
	        return head.next;
	    }*/
	public static void main(String[] args)
	{
	
		ListNode a = new ListNode(1);
		a.next = new ListNode(10);
		a.next.next = new ListNode(20);
		
		ListNode b = new ListNode(4);
		b.next = new ListNode(11);
		b.next.next = new ListNode(13);
		
		ListNode c = new ListNode(3);
		c.next = new ListNode(8);
		c.next.next = new ListNode(9);
		
		ArrayList<ListNode> list =  new ArrayList<>();
		list.add(a);
		list.add(b);
		list.add(c);
		
		ListNode r = mergeKLists(list);
		while(r!=null)
		{
			System.out.print(r.val+" ");
			r = r.next;
		}

	}
	public static ListNode mergeKLists(ArrayList<ListNode> a) 
	{
		ListNode res =null;
		ListNode currentNode =null;
		TreeMap<Integer,ListNode> minHeap = new TreeMap<Integer,ListNode>();
		for(ListNode l : a)
			minHeap.put(l.val, l);
		while(!minHeap.isEmpty())
		{
			int val =minHeap.firstKey().intValue();
			ListNode t = minHeap.get(val);
			minHeap.remove(val);
			if(t.next!=null)
				minHeap.put(t.next.val, t.next);
			if(res == null)
			{
				res = new ListNode(val);
				currentNode = res;
			}
			else
			{
				currentNode.next = new ListNode(val);
				currentNode = currentNode.next;
			}
			
		}
		return res;
	}

}
