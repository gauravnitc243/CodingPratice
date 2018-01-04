package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderOfPepleHeight
{
	public static ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) 
	{
	    int n = heights.size();
		ArrayList<Pair> pairs = new ArrayList<>(n);
		Integer result[] = new Integer[n];
        for (int i = 0; i < n; i++) 
            pairs.add(new Pair(heights.get(i), infronts.get(i)));
      //  Collections.sort(pairs, (o1, o2) -> o1.h.compareTo(o2.h));
        for (int i = 0; i < n; i++)
        {
            Pair current = pairs.get(i);
            int count = current.i;
            int j = 0;
            for (; j < n && count > 0; j++) {
                if (result[j] == null) {
                    count--;
                }
            }
            while(result[j] != null) j++;
            result[j] = current.h;
        }
        return new ArrayList<>(Arrays.asList(result));
    }

    private static class Pair
    {
        Integer h;
        Integer i;
        public Pair(int h, int i) 
        {
            this.h = h;
            this.i = i;
        }
        @Override
        public String toString() {
            return "("+h+","+i+")";
        }
    }

    public static void main(String[] args) {
        System.out.println(order(new ArrayList<>(Arrays.asList(5,3,2,6,1,4)), new ArrayList<>(Arrays.asList(0,1,2,0,3,2))));
    }
}
