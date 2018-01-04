package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class MaxPointinLine
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	

	public static int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) 
	{
		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		if (a == null || b == null)
			return -1;
		if (a.size() == 0)
			return 0;
	    int n = a.size();
	    int result = 0;
	    double slope = 0;
	    double den = 0;
	    int x1=0 ,x2=0,y1=0,y2=0;
	    for(int i = 0;i<n;i++)
	    {
	    	x1 = a.get(i);
	    	y1 = b.get(i);
	    	map.clear();
	    	for(int j =0;j<n;j++)
	    	{
	    		if(i==j)
	    			continue;
	    		x2 = a.get(j);
	    		y2 = b.get(j);
	    		slope = y2-y1;
	    		den = x2-x1;
	    		if(den ==0)
	    			slope = Double.POSITIVE_INFINITY;
	    		else
	    			slope = slope/den;
	    		if(map.containsKey(slope))
	    			map.put(slope, map.get(slope)+1);
	    		else
	    			map.put(slope,1);
	    	}
	    	for(java.util.Map.Entry<Double, Integer> entry : map.entrySet())
		    {
		    	if(entry.getValue()>result)
		    		result = entry.getValue();
		    }
	     }
	    return result+1;
	}
}
