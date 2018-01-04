package com.interviewbit.stackqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangle
{

	public static void main(String[] args)
	{
		System.out.println(largestRectangle(new ArrayList<Integer>(Arrays.asList(2,1,5,6,2,3))));

	}
	
	public static int largestRectangle(ArrayList<Integer> a) 
	{
	    Stack<Integer> s = new Stack<Integer>();
	    int max_area = 0; 
	    int tp;  
	    int area_with_top; 
	    int n = a.size();
	    int i = 0;
	    while (i < n)
	    {
	        if (s.empty() || a.get(s.peek()) <= a.get(i))
	            s.push(i++);
	        else
	        {
	            tp = s.pop();
	            area_with_top = a.get(tp) * (s.empty() ? i : i - s.peek() - 1);
	            if (max_area < area_with_top)
	                max_area = area_with_top;
	        }
	    }
	    while (s.empty() == false)
	    {
	    	tp = s.pop();
	        area_with_top =a.get(tp) * (s.empty() ? i : i - s.peek() - 1);
	 
	        if (max_area < area_with_top)
	            max_area = area_with_top;
	    }
	    return max_area;}
}
