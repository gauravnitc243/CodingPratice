package com.hackerrank.tree;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratbleTest<Item> implements Iterable<Item> {
	
	LinkedList<Item> list ;
	public IteratbleTest(){
		list = new LinkedList<Item>();
	}
	
	public void add(Item item){
		list.add(item);
	}

	public static void main(String[] args) {
		IteratbleTest<String> list = new IteratbleTest<String>();
		list.add("jitender");
		list.add("is");
		list.add("doing");
		list.add("something");
		for(String s : list)
			System.out.println(s);
	}
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	class ListIterator implements Iterator<Item>
	{
		int i =0;
		public boolean hasNext(){
			return list.size()>i;
			
		}
		public Item next(){
			return list.get(i++);
		}
	}
}
