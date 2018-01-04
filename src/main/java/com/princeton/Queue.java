package com.princeton;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item>{
	private int itemCount ;
	private Node<Item> firstNode;
	private Node<Item> lastNode;
	
	private static class Node<Item>
	{
		Item item;
		Node<Item> nextNode;
	}
	
	public Queue()
	{
		itemCount = 0;
		firstNode = lastNode =null;
	}
	
	public boolean isEmpty()
	{
		return itemCount==0;
	}
	
	 public void enqueue(Item item)
	 {
		 
		 Node<Item> oldlast = lastNode;
		 lastNode = new Node<Item>();
		 lastNode.item = item;
		 lastNode.nextNode = null;
		 if(isEmpty())
			 firstNode = lastNode;
		 else
			 oldlast.nextNode = lastNode;
		 itemCount++;
	 }
	 
	 public Item dequeue()
	 {
		 if(isEmpty())
			 throw new NoSuchElementException("Queue underflow");
		 else
		 {
			 Node<Item> tempNode = firstNode;
			 firstNode = firstNode.nextNode;
			 itemCount--;
			 if(isEmpty())
				 lastNode = null;
			 return tempNode.item;
		 }
	 }
	 
	 
	 

	public static void main(String[] args) {

		Queue<String> stack = new Queue<String>();
		stack.enqueue("jitender");
		stack.enqueue("kumar");
		stack.enqueue("is");
		stack.enqueue("the");
		/*while(true)
		{
			System.out.println(stack.dequeue());
			System.out.println(stack.itemCount);
			
		}*/
	}

	@Override
	public Iterator<Item> iterator() {
		return new QueueItereator<Item>(firstNode);
	}
	
	public class QueueItereator<Item> implements Iterator<Item>
	{
		public Node<Item> currentNode;
		
		public QueueItereator(Node<Item> firstNode)
		{
			currentNode = firstNode;
		}
		public boolean hasNext()
		{
			return currentNode!=null;
		}
		public Item next()
		{
			if(!hasNext())
				throw new NoSuchElementException("Queue underflow");
			Item item = currentNode.item;
			currentNode = currentNode.nextNode;
			return item;
		}
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
