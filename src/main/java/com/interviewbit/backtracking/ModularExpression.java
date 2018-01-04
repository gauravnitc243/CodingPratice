package com.interviewbit.backtracking;

public class ModularExpression
{

	public static void main(String[] args)
	{
		System.out.println(Mod(71045970,41535484, 64735492));

	}
	
	public static int Mod(int a, int b, int c) 
	{
		if(a==0)
			return 0;
		long res = modRes(a,b,c);
		if(res<0)
			res = c+res;
		return (int)res;
			
	}
	
	public static long modRes(int a, int b, int c) 
	{
		if(b==0)
			return 1;
		else if(b%2==0)
		{
			long t = modRes(a,b/2,c)%c;
			return (t*t)%c;
		}
		else
			return ((a%c)*(modRes(a,b-1,c)%c))%c;
	}

}
