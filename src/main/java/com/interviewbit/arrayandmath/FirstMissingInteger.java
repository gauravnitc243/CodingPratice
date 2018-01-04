package com.interviewbit.arrayandmath;

import java.util.ArrayList;

public class FirstMissingInteger {

	public static void main(String[] args) {
		int[] input = {1};
		ArrayList<Integer> inpu = new ArrayList<Integer>();
		for(int i=0;i< input.length;i++)
		{
			inpu.add(input[i]);
		}
		System.out.println(firstMissingPositive(inpu));
	}
	
	
	public static int firstMissingPositive1(ArrayList<Integer> a) 
	{
		 int n = a.size();
         for (int i = 0; i < n; i++) {
             if (a.get(i) > 0 && a.get(i) <= n) {
                 int positionToSet = a.get(i) - 1;
                 if (a.get(positionToSet) != a.get(i))
                 {
                	 int t = a.get(positionToSet);
                	 a.set(positionToSet, a.get(i));
                	 a.set(i, t);
                     i--;
                 }
             }
         }
         for (int i = 0; i < n; i++) {
             if (a.get(i) != i + 1) return (i + 1);
         }
         return n + 1;
	}
	
	public static int firstMissingPositive(ArrayList<Integer> a) {
		if(a==null || a.size()==0)
			return 1;
		ArrayList<Integer> b = new ArrayList<Integer>();
		int maxNum = 0;
		for(int i:a)
		{
			if(i>0)b.add(i);
			if(i>maxNum)
				maxNum = i;
		}
		int[] temp = new int[maxNum+1];
		a =b;
		if(a.size()==0)
			return 1;
		for(int i=0;i< a.size();i++)
		{
			temp[Math.abs(a.get(i))] = Math.abs(a.get(i))*-1;
			//a.set(Math.abs(a.get(i)),a.get(i)*-1);
		}
		for(int i=1;i< temp.length;i++)
		{
			if(temp[i]>=0)
				return i;
		}
		return temp.length;
	}

}
