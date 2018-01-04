package com.interviewbit.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DistinctNumberInWindow
{

	public static void main(String[] args)
	{
		System.out.println(dNums(new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3)),3));

	}
	

	 public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B)
	{
		ArrayList<Integer> res = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i =0;i<B;i++)
		{
			if(map.containsKey(A.get(i)))
				map.put(A.get(i),map.get(A.get(i))+1);
			else
				map.put(A.get(i),1);
		}
		for(int i =0;i<A.size()-B;i++)
		{
			res.add(map.size());
			int t = map.get(A.get(i));
			if(t==1)
				map.remove(A.get(i));
			else
				map.put(A.get(i), map.get(A.get(i))-1);
			
			int next = A.get(B+i);
			if(map.containsKey(next))
				map.put(next, map.get(next)+1);
			else
				map.put(next, 1);
		}
		res.add(map.size());
		return res;
    }
}
