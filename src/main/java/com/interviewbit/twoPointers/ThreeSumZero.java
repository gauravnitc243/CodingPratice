package com.interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumZero
{

	public static void main(String[] args)
	{
		System.out.println(threeSum(new ArrayList<>(Arrays.asList(-1,0,1,2,-1,4))));
	}
	
	public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) 
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (a.size() < 3)
			return result;
		Collections.sort(a);
		for (int i = 0; i < a.size() - 2; i++) {
			if (i == 0 || a.get(i) > a.get(i-1)) {
				int negate = -a.get(i);
				int start = i + 1;
				int end = a.size() - 1;
				while (start < end) {
					//case 1
					if (a.get(start) + a.get(end) == negate) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(a.get(i));
						temp.add(a.get(start));
						temp.add(a.get(end));
	 
						result.add(temp);
						start++;
						end--;
						//avoid duplicate solutions
						while (start < end && a.get(end) ==a.get(end+1))
							end--;
	 
						while (start < end && a.get(start) == a.get(start-1))
							start++;
					//case 2
					} else if (a.get(start) + a.get(end) < negate) {
						start++;
					//case 3
					} else {
						end--;
					}
				}
	 
			}
     }
		return result;
	}
}
