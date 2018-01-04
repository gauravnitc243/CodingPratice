package com.interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class SortByColour
{

	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(0 ,1 ,2 ,0 ,1 ,2));
		sortColors(a);
		System.out.println(a);
		

	}
	public static void sortColors(ArrayList<Integer> a) 
	{
		int zeroIndex = 0;
		int twosIndex= a.size()-1;
		for(int i =0;i<=twosIndex;)
		{
			if(a.get(i)==0)
			{
				int t = a.get(zeroIndex);
				a.set(zeroIndex, 0);
				a.set(i, t);
				i++;
				zeroIndex++;
			}
			else if(a.get(i)==2)
			{
				int t = a.get(twosIndex);
				a.set(twosIndex, 2);
				a.set(i, t);
				twosIndex--;
			}
			else i++;
		}
	}

}
