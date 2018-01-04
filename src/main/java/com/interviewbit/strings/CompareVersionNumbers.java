package com.interviewbit.strings;

public class CompareVersionNumbers
{

	public static void main(String[] args)
	{
		System.out.println(compareVersion("1.0", "1"));

	}
	
	public static int compareVersion(String a, String b)
	{
		String[] firstVersion = a.split(java.util.regex.Pattern.quote("."));
		String[] secondVersion  = b.split(java.util.regex.Pattern.quote("."));
		if(firstVersion.length==0 && a.length()>0)
		{
			firstVersion = new String[1];
			firstVersion[0] = a;
		}
		if(secondVersion.length==0 && b.length()>0)
		{
			secondVersion = new String[1];
			secondVersion[0] = b;
		}
		int i =0;
		for(;i<firstVersion.length && i<secondVersion.length;i++)
		{
			if((new java.math.BigInteger(""+firstVersion[i])).compareTo(new java.math.BigInteger(""+secondVersion[i])) > 0)
				return 1;
			else if((new java.math.BigInteger(""+firstVersion[i])).compareTo(new java.math.BigInteger(""+secondVersion[i])) < 0)
				return -1;
		}
		
		if(firstVersion.length==secondVersion.length &&(new java.math.BigInteger(""+firstVersion[firstVersion.length-1])).equals((new java.math.BigInteger(""+secondVersion[firstVersion.length-1]))))
			return 0;
		else if(firstVersion.length > secondVersion.length)
		{
			for(int t =i;t<firstVersion.length;)
			{
				if(!((new java.math.BigInteger(""+firstVersion[t])).equals((new java.math.BigInteger("0")))))
				{
					return 1;
				}
				else
					return 0;
			}
		}
		else if(firstVersion.length < secondVersion.length)
		{

			for(int j =i;j<secondVersion.length;)
				if(!((new java.math.BigInteger(""+secondVersion[j])).equals((new java.math.BigInteger("0")))))
				{
					return -1;
				}
				else
					return 0;
		
		}
			return -1;
	}

}
