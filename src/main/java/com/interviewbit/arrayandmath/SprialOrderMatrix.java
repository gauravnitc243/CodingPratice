package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SprialOrderMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> res = generateMatrix(5);
		for(int i =0 ;i<res.size();i++)
			System.out.println(res.get(i));

	}
	
	public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 int rowStart = 0;
		 int colStart = 0;
		 int rowEnd = a.size()-1;
		 int colEnd = a.get(0).size()-1;
		 int dir = 0;
		 int totalElement = a.size() * a.get(0).size();
		 int count = 0;
		 while(count < totalElement)
		 {
		     if(dir==0){
		         for(int i = colStart ; i <= colEnd;i++){
		        	 result.add(a.get(rowStart).get(i));
		        	 count++;
		         }
		         rowStart++;
		     }
		     if(dir==1){
		         for(int i = rowStart; i <= rowEnd ; i++){
		        	 result.add(a.get(i).get(colEnd));
		        	 count++;
		         }
		         colEnd--;
		     }
		     if(dir==2){
		         for(int i = colEnd ; i >= colStart ; i-- ){
		        	 result.add(a.get(rowEnd).get(i));
		        	 count++;
		         }
		          rowEnd--;
		     }
		     if(dir==3){
		         for(int i = rowEnd ; i >= rowStart ;i--){
		        	 result.add(a.get(i).get(colStart));
		        	 count++;
		         }
		         colStart++;
		     }
		     dir = (dir+1)%4;
		 }
		 return result;
	}
	
	
	public static  ArrayList<ArrayList<Integer>> generateMatrix(int a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Integer[] temp = new Integer[a];
		for(int i =0;i<a;i++)
		{
			result.add(new ArrayList<>( Arrays.asList(temp)));
		}
		int no=1;
		int rowStart = 0;
		int columStart = 0;
		int rowEnd =a-1;
		int columEnd = a-1;
		
		while(rowStart<=rowEnd && columStart<=columEnd)
		{
			for(int i= columStart ;i<=columEnd;i++)
			{
				result.get(rowStart).set(i,no++);
			}
			rowStart++;
			for(int i =rowStart;i<=rowEnd;i++)
			{
				result.get(i).set(columEnd, no++);
			}
			columEnd--;
			for(int i=columEnd;i>=columStart;i--)
			{
				result.get(rowEnd).set(i, no++);
			}
			rowEnd--;
			for(int i = rowEnd ;i>=rowStart;i--)
			{
				result.get(i).set(columStart, no++);
			}
			columStart++;
		}
		return result;
	}

}
