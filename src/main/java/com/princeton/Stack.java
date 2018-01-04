package com.princeton;

import java.util.NoSuchElementException;


public class Stack<Item>
{
	private Node<Item> firstNode; 
	private int itemCount ;
	private static class Node<Item>
	{
		Item item ;
		Node<Item> nextNode;
	}
	
	public Stack()
	{
		firstNode = null;
		itemCount = 0;
	}
	
	public boolean isEmpty()
	{
		return firstNode==null;
	}
	
	public int size()
	{
		return itemCount;
	}
	
	public void push(Item item)
	{
		Node<Item> oldFirst = firstNode;
		firstNode = new Node<Item>();
		firstNode.item = item;
		firstNode.nextNode = oldFirst;
		itemCount++;
	}
	
	public Item peek()
	{
		if (isEmpty()) 
			throw new NoSuchElementException("Stack underflow");
		return firstNode.item;
	}
	
	public Item pop()
	{
		if(firstNode == null)
			throw new NoSuchElementException("Stack underflow");
		else
		{
			Item returnItem = firstNode.item;
			firstNode = firstNode.nextNode;
			itemCount--;
			return returnItem;
		}
	}

	public static void main(String[] args) {

		Stack<String> stack = new Stack<String>();
		stack.push("jitender");
		stack.push("kumar");
		stack.push("is");
		stack.push("the");
		/*while(true)
		{
			System.out.println(stack.pop());
			System.out.println(stack.itemCount);
			
		}*/
		
		Queue<String> queue = new Queue<String>();
		
		for(String a : queue)
		{
			
		}
	}

}



