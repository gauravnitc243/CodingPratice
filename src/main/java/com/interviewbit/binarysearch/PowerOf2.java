package com.interviewbit.binarysearch;

public class PowerOf2
{

	public static void main(String[] args)
	{
		System.out.println(power("1282"));

	}
	
	public static  int power(String a) 
	{
		if(a.length()==1 && Integer.parseInt(a)==1)
			return 0;
		java.math.BigInteger  input= new java.math.BigInteger(a);
		java.math.BigInteger  two = new java.math.BigInteger("2");
		java.math.BigInteger  zero = new java.math.BigInteger("0");
		while(!input.equals(new java.math.BigInteger("1")))
		{
			if(!(input.mod(two).equals(zero)))
				return 0;
			input = input.divide(two);
		}
		return 1;
	}

}
