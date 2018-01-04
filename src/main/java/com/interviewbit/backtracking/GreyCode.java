package com.interviewbit.backtracking;

import java.util.ArrayList;

public class GreyCode
{

	public static void main(String[] args)
	{
		System.out.println(grayCode(4));
	}
	
	public static ArrayList<Integer> grayCode(int a)
	{
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    result.add(0);
	    for(int i=0;i<a;i++)
	    {
	        int inc = 1<<i;
	        for(int j=result.size()-1;j>=0;j--)
	            result.add(result.get(j)+inc);
	    }
	    return result;
    }

}
