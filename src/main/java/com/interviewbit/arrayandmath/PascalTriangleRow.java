package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Arrays;

public class PascalTriangleRow {

	public static void main(String[] args) {
		System.out.println(generate1(67));
	}
	
		public static ArrayList<ArrayList<Integer>> generate(int a) {
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			if(a<1){
				return res;
			}
			res.add(new ArrayList<>(Arrays.asList(1)));
			int currentRow =1;
			while(currentRow<a)
			{
				ArrayList<Integer> t = new ArrayList<Integer>();
				t.add(1);
				for(int i = 1; i<currentRow;i++){
					t.add(res.get(currentRow-1).get(i-1)+res.get(currentRow-1).get(i));
				}
				t.add(1);
				res.add(t);
				currentRow++;
			}
			return res;
		}
		
		public static ArrayList<Integer> generate1(int a) {
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
