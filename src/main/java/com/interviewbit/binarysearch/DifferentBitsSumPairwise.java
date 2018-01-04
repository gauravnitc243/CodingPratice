package com.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class DifferentBitsSumPairwise
{
	

	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 3, 5));
		System.out.println(sum(a));
		int  i = (int)Math.pow(10, 9)+7;
		System.out.println(i);
	}
	
	public static int sum(ArrayList<Integer> a)
	{
		int MOD = 1000000007;
		java.math.BigInteger ans = new java.math.BigInteger("1");
	    for(int i = 0; i < 31; i++)
	    {
	        long count = 0;
	        for(int j = 0; j < a.size(); j++) 
	        {
	        	if (!(( a.get(j) & (1 << i)) ==0))
	        		count++;
	        }
	        ans = ans.add(new java.math.BigInteger(""+count).multiply(new java.math.BigInteger(""+(a.size()-count)).multiply(new java.math.BigInteger("2"))));
	        //ans += (count * ((long)a.size() - count)) * 2l;
	        //if(ans >= MOD) ans -= MOD;
	    }
	    return (ans.mod(new java.math.BigInteger(""+MOD))).intValue()-1;
	}

}
