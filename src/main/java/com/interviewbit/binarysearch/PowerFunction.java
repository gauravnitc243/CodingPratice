package com.interviewbit.binarysearch;

public class PowerFunction
{

	public static void main(String[] args)
	{
		System.out.println(pow(79161127,99046373,57263970));
		System.out.println(pow(2,3,3));
		System.out.println(pow(-1,1,20));
		System.out.println(pow(-1,2,20));
	}
	
	public static long pow(long x, int n, int d) 
	{
		if(x==0)
			return 0;
		boolean isNegative = false;
		if(x<0)
		{
			x*=-1;
			isNegative = true;
		}
		long a  = x%d;
		long res = 1;
		res =power(a, n, d);
		if(isNegative && n%2!=0)
			res = d-res;
		return (int)res;
	}
	
	public static long power(long a, long b,int d)
	{
		if ( b == 0)        return 1;
	    if ( b == 1)        return a;
	    if(b%2==0)    return     power((a*a)%d, b/2,d)%d; 
	    else                return a * power ( (a * a)%d, b/2,d)%d;
	}
	
}
