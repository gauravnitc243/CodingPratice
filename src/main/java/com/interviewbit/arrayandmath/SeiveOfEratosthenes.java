package com.interviewbit.arrayandmath;

import java.util.ArrayList;

public class SeiveOfEratosthenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sieve(7));
	}
	
	public static  ArrayList<Integer> sieve(int a) {
		int[] primes = new int[a+1];
		int range = (int) Math.sqrt(a);
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i =2;i<=range;i++)
		{
			if(primes[i]==0)
			{
				for(int j=2;i*j<=a;j++)
					primes[i*j] = 1;
			}
		}
		for(int i =2;i<=a;i++)
			if(primes[i]==0)
				result.add(i);
		return result;
		
	}

}
