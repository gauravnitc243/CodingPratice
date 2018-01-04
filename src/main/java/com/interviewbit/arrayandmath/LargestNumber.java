package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(largestNumber(new ArrayList<Integer>(Arrays.asList(3, 30, 34, 5, 9))));
	}
	
	public static String largestNumber(final List<Integer> a) 
	{
		Collections.sort(a,maxIntSeqComparator);
		if(a.get(0)==0)
			return "0";
		StringBuilder sb = new StringBuilder();
		for(int i:a)
			sb.append(i);
		return sb.toString();
	}
	
	 public static Comparator<Integer> maxIntSeqComparator = new Comparator<Integer>() {
	        @Override
	        public int compare(Integer a, Integer b) {
	        	String x = a.toString()+b.toString();
	        	String y = b.toString()+a.toString();
	    		return y.compareTo(x);
	        }
	  };
}


