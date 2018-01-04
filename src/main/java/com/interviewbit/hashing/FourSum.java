package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class FourSum
{

	public static void main(String[] args)
	{
		ArrayList<ArrayList<Integer>> result = fourSum(new ArrayList<Integer>(Arrays.asList(1 ,0, -1 ,0, -2, 2)),0);
		for(ArrayList<Integer> a :result)
			System.out.println(a);

	}
	
	public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) 
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		Collections.sort(a);
		for(int i =0;i<a.size();i++)
		{
			for(int j = i+1;j<a.size();j++)
			{
				int k = j+1;
				int l = a.size()-1;
				while(k<l)
				{
					int sum = a.get(i)+a.get(j)+a.get(k)+a.get(l);
					if(sum<b)
						k++;
					else if(sum>b)
						l--;
					else
					{
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(a.get(i));
						temp.add(a.get(j));
						temp.add(a.get(k));
						temp.add(a.get(l));
						if(!set.contains(temp))
						{
							set.add(temp);
							result.add(temp);
						}
						k++;
						l--;
					}
				}
						
			}
		}
		return result;
	}
}
