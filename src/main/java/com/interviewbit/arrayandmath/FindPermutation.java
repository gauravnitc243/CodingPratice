package com.interviewbit.arrayandmath;

import java.util.ArrayList;

public class FindPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findPerm("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD", 354));
	}

	public static ArrayList<Integer> findPerm(final String A, int B) 
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		int lowIndex=1;
		int highIndex=B;
		for(int i =0;i<A.length();i++)
		{
			if(A.charAt(i)=='I')
				result.add(lowIndex++);
			else
				result.add(highIndex--);
		}
		result.add(lowIndex++);
		return result;
    }
}
