package com.interviewbit.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class HighestProduct
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public int maxp3(ArrayList<Integer> a) 
	{  
		int n = a.size();
		if (a == null || n < 3)
			return 0;
	    Collections.sort(a);
	    int max;
	    max = a.get(n - 3) * a.get(n - 2) * a.get(n - 1);
	    max = Math.max(max, a.get(0) * a.get(1) * a.get(n - 1));
	    return max;
	}

}
