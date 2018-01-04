package com.interviewbit.stackqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElement
{

	public static void main(String[] args)
	{
		System.out.println(prevSmaller(new ArrayList<Integer>(Arrays.asList(4, 5, 2, 10))));

	}

	public static ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) 
	 {
		 ArrayList<Integer>  result = new ArrayList<Integer>();
		 Stack<Integer> S = new Stack<>();
	    for (int i=0; i<arr.size(); i++)
	    {
	        while (!S.empty() && S.peek() >= arr.get(i))
	            S.pop();
	        if (S.empty())
	        	result.add(-1);
	        else  
	        	result.add(S.peek());
	 
	        S.push(arr.get(i));
	    }
	    return result;
	 }

}
