package com.interviewbit.heap;

import java.util.HashMap;

public class LRUCache
{
	public static void main(String[] args)
	{
		LRUCache l = new LRUCache(2);
		l.set(1, 10);
        l.set(5, 12);
        System.out.println(l.get(5));
        System.out.println(l.get(1));
        System.out.println(l.get(10));
        l.set(6, 14);
        System.out.println(l.get(5));
	}
	int capacity = 0;
	HashMap<Integer,Node> cache ;
	Node head = null;
	Node end = null;
	private class Node
	{
		int key;
		int value;
		Node next;
		Node prev;
		public Node(int k , int v)
		{
			key = k;
			value = v;
		}
	}

	public LRUCache(int capacity)
	{
		this.capacity = capacity;
		cache = new HashMap<>();
    }
    
    public int get(int key) 
    {
    	if(cache.containsKey(key))
    	{
    		Node t = cache.get(key);
    		remove(t);
    		setHead(t);
    		return t.value;
    	}
    	else 
    		return -1;
    }
    
    public void remove(Node t)
    {
    	if(t.prev!=null)
    		t.prev.next = t.next;
    	else
    		head = t.next;
    	
    	if(t.next!=null)
    		t.next.prev = t.prev;
    	else
    		end = t.prev;
    }
    
    public void setHead(Node t)
    {
    	t.next = head;
    	t.prev = null;
    	if(head!=null)
    		head.prev = t;
    	head = t;
    	if(end==null)
    		end = head;
    }
    
    public void set(int key, int value)
    {
        if(cache.containsKey(key))
        {
        	Node t = cache.get(key);
        	remove(t);
        	t.value = value;
        	setHead(t);
        }
        else
        {
        	Node newNode = new Node(key,value);
        	if(cache.size()>=capacity)
        	{
        		cache.remove(end.key);
        		remove(end);
        	}
        	setHead(newNode);
        	cache.put(key, newNode);
        }
    }

}
