package com.interviewbit.arrayandmath;

import java.util.ArrayList;


public class PrimeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(primesum(4));
	}
	
	public static ArrayList<Integer> primesum(int a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> temp = sieve(a);
		for(int i: temp)
			if(temp.contains(a-i))
			{
				result.add(i);
				result.add(a-i);
				break;
			}
		return result;
		
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
