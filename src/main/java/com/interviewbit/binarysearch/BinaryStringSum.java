package com.interviewbit.binarysearch;

public class BinaryStringSum
{

	public static void main(String[] args)
	{
		System.out.println(addBinary("1010110111001101101000", "1000011011000000111100110"));

	}
	
	
	public static String addBinary(String a, String b)
	{
		StringBuilder result = new StringBuilder();
		String firstString ;
		String secondString;
		if(a.length()<b.length())
		{
			firstString = b;
			secondString =a;
		}
		else
		{
			firstString = a;
			secondString = b;
		}
		
		int carry = 0;
		int i = secondString.length()-1;
		int j=firstString.length()-1;
		for(;i>=0 && j>=0;i--,j--)
		{
			if(firstString.charAt(j)=='0' && secondString.charAt(i)=='0')
			{
				result.append(0+carry);
				carry = 0;
			}
			else if((firstString.charAt(j)=='1' && secondString.charAt(i)=='0') || (firstString.charAt(j)=='0' && secondString.charAt(i)=='1'))
			{
				if(carry ==0)
					result.append(1);
				else
				{
					result.append(0);
					carry =1;
				}
			}
			else
			{
				if(carry ==0)
					result.append(0);
				else
					result.append(1);
					carry = 1;
			}
			
		}
		
		while(j>=0)
		{
			if(firstString.charAt(j)==1 && carry==1)
			{
				result.append(0);
				carry =1;
			}
			else if((firstString.charAt(j)=='1' && carry==0 ) || (firstString.charAt(j)=='0' && carry==1))
			{
				result.append(1);
				carry =0;
			}
			else
				result.append(0);
			j--;
		}
		if(carry==1)
			result.append(1);
		return result.reverse().toString();
			
	}

}
