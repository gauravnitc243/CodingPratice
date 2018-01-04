package com.interviewbit.binarysearch;

import java.util.List;

public class SingleNumber
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public static int singleNumber1(final List<Integer> a)
	{
		if(a.size()==1)
			a.get(0);
		int result =a.get(0);
		for(int i =1;i<a.size();i++)
		{
			result ^=a.get(i); 
		}
		return result;
	}
	
	public int singleNumber(final List<Integer> a) 
	{
       int    ones = 0 ;
       int    twos = 0 ;
       int 	  not_threes;
       int    x ;

	   for(int i=0; i< a.size(); i++ )
	   {
	   		x =  a.get(i);
	        twos |= ones & x ;
	        ones ^= x ;
	        not_threes = ~(ones & twos) ;
	        ones &= not_threes ;
	        twos &= not_threes ;
	    }
	   return ones;
	}
}
