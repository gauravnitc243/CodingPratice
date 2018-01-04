package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Arrays;

public class PreetyPrint {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> res = prettyPrint(4);
		for(int i =0 ;i<res.size();i++)
			System.out.println(res.get(i));

	}

public static ArrayList<ArrayList<Integer>> prettyPrint(int a) {
	    
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Integer[] temp = new Integer[a*2-1];
		for(int i =0;i<a*2-1;i++)
		{
			result.add(new ArrayList<>( Arrays.asList(temp)));
		}
		int rowStart = 0;
		int columStart = 0;
		int rowEnd =a*2-2;
		int columEnd = a*2-2;
		int num =a;
		
		while(rowStart<=rowEnd && columStart<=columEnd)
		{
			for(int i= columStart ;i<=columEnd;i++)
			{
				result.get(rowStart).set(i,num);
			}
			rowStart++;
			for(int i =rowStart;i<=rowEnd;i++)
			{
				result.get(i).set(columEnd, num);
			}
			columEnd--;
			for(int i=columEnd;i>=columStart;i--)
			{
				result.get(rowEnd).set(i, num);
			}
			rowEnd--;
			for(int i = rowEnd ;i>=rowStart;i--)
			{
				result.get(i).set(columStart, num);
			}
			columStart++;
			num--;
		}
		return result;
	}


}
