package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum
{

	public static void main(String[] args)
	{
		System.out.println(twoSum(new ArrayList<Integer>(Arrays.asList(4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8 )),-3));
		

	}
	
	public static ArrayList<Integer> twoSum(final List<Integer> a, int b) 
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(0);
		res.add(0);
		boolean isFound = false;
		for (int i = 0; i < a.size(); i++) {
			if (map.containsKey(a.get(i))) 
			{
				isFound = true;
				int index = map.get(a.get(i));
				res.set(0, index+1);
				res.set(1, i+1);
				break;
			} else if(!map.containsKey(b - a.get(i)))
				map.put(b - a.get(i), i);
		}
		if(!isFound)
			return new ArrayList<Integer>();
		return res;
		}
}
