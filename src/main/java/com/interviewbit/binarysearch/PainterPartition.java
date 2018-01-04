package com.interviewbit.binarysearch;

import java.util.ArrayList;

public class PainterPartition
{
	private static final int MOD = 10000003;

	public static void main(String[] args)
	{
		ArrayList<Integer> c = new ArrayList<Integer>();
		c.add(100);
		c.add(200);
		c.add(300);
		c.add(400);
		c.add(500);
		c.add(600);
		c.add(700);
		c.add(800);
		c.add(900);
		System.out.println(paint(3, 1, c));
	}
	
public static int paint(int noOfPainters, int timeTakenByEachPainter, ArrayList<Integer> listOfBlocks) {
	    long res = Long.MAX_VALUE;
	    long low = 0;
	    long high = Long.MAX_VALUE;
	    long mid;
	    while (low <= high)
	    {
	        mid = low + ((high - low) >> 1);
	        boolean status = possible(noOfPainters, timeTakenByEachPainter, listOfBlocks, mid);
	        if (status) 
	        {
	            res = mid;
	            high = mid - 1;
	        }
	        else
	        {
	            low = mid + 1;
	        }
	    }
	    return (int) (res % MOD);
	}
	
	private static boolean possible(int noOfPainters, int timeTakenByEachPainter, ArrayList<Integer> listOfBlocksLength, long time) {
	    int n = listOfBlocksLength.size();
	    int index = 0;
	    for (int i = 0; i < noOfPainters && index < n; i++) 
	    {
	    	long total = 0;
	        while (total < time && index < n) 
	        {
	            total += (1L * listOfBlocksLength.get(index) * timeTakenByEachPainter);
	            if (total > time)
	                break;
	            index++;
	        }
	    }
	    if (index != n)
	        return false;
	    return true;
	}
}
