package com.interviewbit.binarysearch;

public class ReverseBits
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(reverse(13));
		System.out.println(13&1);
	}
	
	public static long reverse(long a) 
	{
        long res = 0;
        long mask = 1;
        for (int i=0;i<32;i++)
        {
            if ((a&mask) !=0)
            	res = res + 1;
            if (i!=31)
            	res <<= 1;
            mask <<= 1;
        }
        return res;
    }
}