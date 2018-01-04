package com.interviewbit.hashing;
import java.util.HashMap;

public class CopyList
{
	static class RandomListNode 
	{
		     int label;
		     RandomListNode next, random;
		     RandomListNode(int x) { this.label = x; }
	};

	public static void main(String[] args)
	{

	}
	 
	
	public static RandomListNode deepCopy(RandomListNode head)
	{
		if (head == null)
			return null;
		HashMap<RandomListNode,RandomListNode> map  = new HashMap<RandomListNode,RandomListNode>() ;
		RandomListNode result = new RandomListNode(head.label);
		RandomListNode p =head;
		RandomListNode q =result;
		map.put(head, result);
		p = p.next;
		while(p!=null)
		{
			RandomListNode t = new RandomListNode(p.label);
			map.put(p, t);
			q.next = t;
			q = q.next;
			p = p.next;
		}
		p =head;
		q = result;
		while(p!=null)
		{
			if (p.random != null)
				q.random = map.get(p.random);
			else
				q.random = null;
			p = p.next;
			q = q.next;
		}
		return result;
	}

}
