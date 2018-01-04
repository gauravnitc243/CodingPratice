package com.interviewbit.graphs;

import java.util.ArrayList;

public class SteppingNum
{

	public static void main(String[] args)
	{
		System.out.println(stepnum(10, 20));;
	}
	
	public static ArrayList<Integer> stepnum(int a, int b) 
	{
        ArrayList<Integer> res = new ArrayList<Integer>();
        int sLength = (""+a).length();
        int eLength = (""+b).length();
        for (long i = sLength; i <= eLength; ++i)
        {
            for (long j = 1; j < 10; ++j)
            {
                Dfs(a , b, i , j,res);
            }
        }
        return res;
    }
	
	public static void Dfs(long s, long e , long length , long num,ArrayList<Integer> res)
    {
        if (length-1 == 0)
        {
            if ( s <= num && num <=e)
                res.add((int)num);
            return;
        }
        long lastDigit = num%10;
        if (lastDigit == 0)
        {
            Dfs(s , e,length-1 , num*10+1,res);
        }
        else if (lastDigit == 9)
        {
            Dfs(s, e, length - 1, num*10 + 8,res);
        }
        else
        {
            Dfs(s , e,length-1 , num*10+lastDigit-1,res);
            Dfs(s , e,length-1 , num*10+lastDigit+1,res);
        }
    }
}
