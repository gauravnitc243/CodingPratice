package com.interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MaxRectangle
{

	public static void main(String[] args)
	{
		ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1,1,1));
		ArrayList<Integer> a2 = new ArrayList<>(Arrays.asList(0,1,1));
		ArrayList<Integer> a3 = new ArrayList<>(Arrays.asList(1,0,0));
		ArrayList<ArrayList<Integer>> d = new ArrayList<ArrayList<Integer>>();
		d.add(a1);
		d.add(a2);
		d.add(a3);
		System.out.println(getMaxRect(d));

	}
	
	
	public static int getMaxRect(ArrayList<ArrayList<Integer>> a)
	{
	    int result = maxHistArea(a.get(0));
	    int row = a.size();
	    int col = a.get(0).size();
	    for (int i = 1; i < row; i++)
	    {
	        for (int j = 0; j < col; j++)
	            if (a.get(i).get(j)==1) 
	            	a.get(i).set(j, a.get(i).get(j)+a.get(i-1).get(j));
	        result = Math.max(result, maxHistArea(a.get(i)));
	    }
	    return result;
	}
	
	public static int maxHistArea(ArrayList<Integer> row)
	{
		Stack<Integer> st = new Stack<Integer>();
		int maxArea = -1;
		int area = -1;
		int i =0;
		int top = 0;
		while(i<row.size())
		{
			if(st.isEmpty() || row.get(st.peek())<row.get(i))
				st.push(i++);
			else
			{
				top = row.get(st.pop());
				if(st.isEmpty())
					area = top*i;
				else
					area = top * (i-1-st.peek());
				maxArea = Math.max(area, maxArea);
			}
		}
		
		while(!st.isEmpty())
		{
			top = row.get(st.pop());
			if(st.isEmpty())
				area = top * i ;
			else
				area = top * (i -1 - st.peek());
			maxArea = Math.max(area, maxArea);
		}
		
		return maxArea;
	}
}
