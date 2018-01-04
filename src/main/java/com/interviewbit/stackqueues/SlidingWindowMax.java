package com.interviewbit.stackqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax
{

	public static void main(String[] args)
	{
		System.out.println(slidingWindowsForDummies(new ArrayList<Integer>(Arrays.asList(1,3,-1,-3,5,3,6,7)),3));
		//slidingWindowsForDummies(new ArrayList<Integer>(Arrays.asList(1,3,-1,-3,5,3,6,7)),3);
	}
	
	public static ArrayList<Integer> slidingWindowsForDummies(ArrayList<Integer> a, Integer b) {
		  ArrayList<Integer> res = new ArrayList<Integer>(a.size()-b);
		  Deque<Integer> queue= new LinkedList<Integer>();
		  for (int i = 0; i < b; i++)
		  {
			  //storing index in queue instead of element so that it is easy to remove indexes which are not in current window
		    while (!queue.isEmpty() && a.get(i) >= a.get(queue.getLast()))
		      queue.removeLast();
		    queue.addLast(i);
		  }
		  for (int i = b; i < a.size(); i++) 
		  {
		    res.add(a.get(queue.getFirst()));
		    while (!queue.isEmpty() && a.get(i) >= a.get(queue.getLast()))
		      queue.removeLast();
		    //removing indexes which are not in current window
		    while (!queue.isEmpty() && queue.getFirst() <= i-b)
		      queue.removeFirst();
		    queue.addLast(i);
		  }
		  res.add(a.get(queue.getFirst()));
		  return res;
	}
}
