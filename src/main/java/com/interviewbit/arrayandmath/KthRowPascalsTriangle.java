package com.interviewbit.arrayandmath;

import java.util.ArrayList;

public class KthRowPascalsTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		KthRowPascalsTriangle k = new KthRowPascalsTriangle();
		System.out.println(k.generate(5));
	}
	
	
	public ArrayList<ArrayList<Integer>> generate(int a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(a<=0)
			return result;
		ArrayList<Integer> firstLine = new ArrayList<Integer>();
		firstLine.add(1);
		result.add(firstLine);
		for(int i =1;i<a;i++)
		{
			result.add(getRow(i));
		}
		return result;
	}
	
	public ArrayList<Integer> getRow(int a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(1);
		for(int i =1;i<= a;i++)
		{
			for(int j=result.size()-1;j>0;j--)
			{
				result.set(j, result.get(j)+result.get(j-1));
			}
			result.add(1);
		}
		return result;
	}

}
