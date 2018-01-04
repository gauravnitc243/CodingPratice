package com.princeton;

import java.util.NoSuchElementException;

public class StackArray<Item> {
	private Item[] a;
	private int itemCount;
	
	StackArray()
	{
		a = (Item[])new Object[1];
		itemCount =0;
	}
	
	public boolean isEmpty()
	{
		return itemCount==0;
	}
	
	public void push(Item item)
	{
		if(itemCount==a.length)
			resizeArray(2*a.length);
			a[itemCount++] = item;
	}
	
	private void resizeArray(int length)
	{
		Item[] temp = (Item[])new Object[length];
		for(int i=0;i<itemCount;i++)
		{
			temp[i] = a[i];
		}
		a = temp;
	}
	
	private Item pop()
	{
		if(itemCount==0)
			throw new NoSuchElementException("Stack underflow");
		Item returnItem = a[--itemCount];
		a[itemCount] = null;
		if(itemCount>0 && itemCount == a.length/4)
			resizeArray(a.length/2);
		return returnItem;
	}
	

	public static void main(String[] args) {
		StackArray<String> stack = new StackArray<String>();
		stack.push("jitender");
		stack.push("kumar");
		stack.push("is");
		stack.push("the");
		while(true)
		{
			System.out.println(stack.pop());
			System.out.println(stack.itemCount);
			
		}

	}

}
