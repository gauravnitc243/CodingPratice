package com.interviewbit.greedy;

import java.util.ArrayList;

public class Bulbs
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	
	 public int bulbs(ArrayList<Integer> a) 
	 {
		 int count=0,currentState = 0;
		 for(int i =0;i<a.size();i++)
		 {
			 if(a.get(i)==currentState)
			 {
				 count++;
				 currentState = 1-currentState;
			 }
		 }
		 return count;
	 }

}
