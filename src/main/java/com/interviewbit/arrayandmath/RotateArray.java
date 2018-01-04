package com.interviewbit.arrayandmath;

import java.util.ArrayList;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void rotate(ArrayList<ArrayList<Integer>> a) 
	{
		swapRows(a);
		tranpose(a);
	}
	
	public void tranpose(ArrayList<ArrayList<Integer>> a)
	{
		 for (int i = 0; i < a.size(); i++) {
	            for (int j = i + 1; j < a.size(); j++) {
	            	int temp = a.get(i).get(j);
	            	a.get(i).set(j, a.get(j).get(i));
	            	a.get(j).set(i, temp);
	            }
	        }
	}
	
	public static void swapRows(ArrayList<ArrayList<Integer>> a) {
	    for (int  i = 0, k = a.size() - 1; i < k; ++i, --k) {
	    	ArrayList<Integer>x = a.get(i);
	    	a.set(i, a.get(k));
	    	a.set(k, x);
	    }
	}


}
