package com.interviewbit.binarysearch;

public class Numberof1Bits
{

	public static void main(String[] args)
	{
		Numberof1Bits n = new Numberof1Bits();
		System.out.println(n.numSetBits(11));

	}
	
	public int numSetBits(long a) 
	{
		if(a==0)
			return 0;
		int count = 0;
		while(a>0)
		{
			if(a%2==1)
				count++;
			a /=2;
		}
		return count;
	}

}
