package com.interviewbit.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class AssignMice
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	
	 public int mice(ArrayList<Integer> a, ArrayList<Integer> b) 
	 {
		 Collections.sort(a);
		 Collections.sort(b);
		 int max =0;
		 for(int i =0;i<a.size();i++)
			 max = Math.max(Math.abs(a.get(i)-b.get(i)), max);
		 return max;
	 }

}
