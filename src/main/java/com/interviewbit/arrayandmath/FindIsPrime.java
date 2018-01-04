package com.interviewbit.arrayandmath;

import java.util.ArrayList;

public class FindIsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sieve(7));

	}
	
	public static boolean isPrime(int a) {
		if(a==2)
			return true;
		if(a<=1)
			return false;
		int range = (int) Math.sqrt(a);
		for(int i=2 ; i<=range;i++)
		{
			if(a%i==0)
				return false;
		}
		return true;
	}
	
	public static  ArrayList<Integer> sieve(int a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=1 ; i<=a ;i++)
		{
			if(isPrime(i))
				result.add(i);
		}
		return result;
	}

}
