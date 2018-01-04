package com.interviewbit.arrayandmath;

import java.util.HashSet;
import java.util.List;

public class FindDuplicateInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int repeatedNumber(final List<Integer> a) {
		HashSet<Integer> temp = new HashSet<Integer>();
		
		for(int i=0;i<a.size();i++)
		{
			if(temp.contains(a.get(i)))
				return a.get(i);
			else
				temp.add(a.get(i));
		}
return 0;		
	}

}
