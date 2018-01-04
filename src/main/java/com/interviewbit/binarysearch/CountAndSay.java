package com.interviewbit.binarysearch;

public class CountAndSay
{

	public static void main(String[] args)
	{
		System.out.println(countAndSay(3));

	}
	
	public static String countAndSay(int a) 
	{
		if(a==1)
			return "1";
		else a = a-1;
		StringBuilder result = new StringBuilder("11");
		String initialValue ="11";
		for(int i =0;i<a-1;i++)
		{
			initialValue = result.toString();
			result =  new StringBuilder();;
			int count =1;
			for(int j =1;j<initialValue.length();j++)
			{
				if(initialValue.charAt(j) !=initialValue.charAt(j-1))
				{
					result.append(""+count+initialValue.charAt(j-1));
					count = 1;
				}
				else
					count++;
				
				if(j+1==initialValue.length())
				{
					result.append(""+count+initialValue.charAt(j));
					count = 1;
				}
			}
		}
		
		
		
		return result.toString();
	}

}
