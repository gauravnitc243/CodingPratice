package com.interviewbit.arrayandmath;

import java.util.ArrayList;

public class DiagonalMatrix {

	public static void main(String[] args) {
/*
		ArrayList<ArrayList<Integer>> res = diagonal(5);
		for(int i =0 ;i<res.size();i++)
			System.out.println(res.get(i));*/
	}
	
	
	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int columnEnd = a.size()-1;
		int rowStart = 0;
		for(int i =0;i<a.size()*2-1;i++)
		{
			ArrayList<Integer> temp= new ArrayList<Integer>();
			result.add(temp);
		}
		for(int i =0;i<a.size();i++)
		{
			ArrayList<Integer> currentRow = new ArrayList<Integer>();
			for(int j=0;j<=columnEnd ;j++)
			{
				currentRow.add(a.get(i).get(j));
			}
			for(int j= i+1;j<a.size();j++)
			{
				currentRow.add(a.get(j).get(columnEnd));
			}
			
			for(int j = 0,row = rowStart;j<currentRow.size();j++,row++)
			{
				result.get(row).add(currentRow.get(j));
			}
			columnEnd--;
			rowStart++;
		}
		return result;
	}

}
