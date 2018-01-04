package com.interviewbit.strings;

public class StrStr
{

	public static void main(String[] args)
	{
		System.out.println(strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba", "babaaa"));

	}
	
	public static int strStr(final String haystack, final String needle)
	{
		if(haystack.length()==0 || needle.length()==0)
			return -1;
		else if(haystack.equals(needle))
			return 0;
		
		int m = needle.length();
		int n = haystack.length();
		
		for(int i =0 ;i<= n-m;i++)
		{
			int j ;
			for(j=0;j<m;j++)
			{
				if(haystack.charAt(i+j) != needle.charAt(j))
					break;
			}
			if(j==m)
				return i;
		}
		return -1;
		
	}
}
