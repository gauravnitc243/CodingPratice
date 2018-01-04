package com.interviewbit.binarysearch;

import java.util.ArrayList;

public class MatrixSearch {

	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<>();a.add(1);
		ArrayList<Integer> b = new ArrayList<>();b.add(29);
		ArrayList<Integer> c = new ArrayList<>();c.add(36);
		ArrayList<Integer> d = new ArrayList<>();d.add(63);
		ArrayList<ArrayList<Integer>>  aa = new ArrayList<ArrayList<Integer>>();
		aa.add(a);
		/*aa.add(b);
		aa.add(c);
		aa.add(d);*/
		System.out.println(searchMatrix(aa, 1));
	}

	public static int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) 
	{
		int rowIndex = 0;
		int columnIndex = a.get(0).size()-1;
		
		while(rowIndex<=a.size()-1)
		{
			if(a.get(rowIndex).get(0)<=b && a.get(rowIndex).get(columnIndex)>=b)
			{
				for(int i = 0;i<=columnIndex;i++)
				{
					if(a.get(rowIndex).get(i)==b)
						return 1;
				}
			}
			rowIndex++;
		}
		
		return 0;
	}

}
