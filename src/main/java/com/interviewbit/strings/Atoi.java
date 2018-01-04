package com.interviewbit.strings;

public class Atoi
{

	public static void main(String[] args)
	{
		System.out.println(atoi("5121478262 8070067M75 X199R 547 8C0A11 93I630 4P4071 029W433619 M3  5 14703818 776366059B9O43393"));

	}
	
	
	public static int atoi(final String a)
	{
		String input = a.trim();
		boolean isNegative = false;
		if(input.charAt(0)=='-')
		{
			isNegative = true;
			input = input.substring(1);
		}
		else if(input.charAt(0)=='+'){
			input = input.substring(1);
		}
		StringBuilder num = new StringBuilder();
		for(int i =0;i<input.length();i++)
		{
			if(Character.isDigit(input.charAt(i)))
				num.append(input.charAt(i));
			else 
				break;
		}
		int result = 0;
		int fact = 1;
		for(int i = num.length()-1;i>=0;i--)
		{
			int number = Character.getNumericValue(num.charAt(i));
			if(number>(Integer.MAX_VALUE/fact))
			{
				if(isNegative)
					return Integer.MIN_VALUE;
				else
					return Integer.MAX_VALUE;
			
			}
			number *=fact;
			result +=number;
			fact *=10;
		}
		if(isNegative)
			return result*-1;
		return result;
	}

}
