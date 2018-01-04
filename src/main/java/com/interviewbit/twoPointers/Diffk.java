package com.interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class Diffk
{

	public static void main(String[] args)
	{

		System.out.println(diffPossible(new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4)), 0));

	}
	
	public static int diffPossible(ArrayList<Integer> a, int b) 
	{
		if(a.size()<2)
			return 0;
		else if((a.get(a.size()-1)-a.get(0))<b)
			return 0;
outer:	for(int i =0;i<a.size();i++)
		{
			int j = a.size()-1;
			int k =i;
			while(j>k)
			{
				if(Math.abs(a.get(i)-a.get(j))==b)
					return 1;
				else if(Math.abs(a.get(i)-a.get(j)) <b)
					continue outer;
				else
					j--;
			}
		}
	return 0;
	}

}
