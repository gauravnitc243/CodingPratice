package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LargestContineousSequenceZeroSum
{
	public static void main(String[] args)
	{
		System.out.println(sum(new ArrayList<Integer>(Arrays.asList(1 ,2 ,-2 ,4 ,-4))));

	}
	
	public static ArrayList<Integer> sum(ArrayList<Integer> a)
	{
		ArrayList<Integer> res = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		a.add(0,0);
		int maxStart = 0;
		int maxLength = 0;
		int sum = 0;
		for(int i = 0;i<a.size();i++)
		{
			sum += a.get(i);
			if(map.containsKey(sum))
			{
				if(i-map.get(sum)>maxLength)
				{
					maxLength = i-map.get(sum);
					maxStart = map.get(sum);
				}
			}
			else
				map.put(sum, i);
		}
		int range = maxStart+maxLength;
		for(int i =maxStart+1;i<=range;i++)
		{
			res.add(a.get(i));
		}
		return res;
	}
	
}
