package com.interviewbit.backtracking;

import java.util.ArrayList;
public class GenreateParantheses
{
	public static void main(String[] args)
	{
		System.out.println(generateParenthesis(3));
	}
	public static ArrayList<String> generateParenthesis(int n) 
	{
		ArrayList<String> res = new ArrayList<String>();
		getValidParenthsis(n,n,"",res);
		return res;
	}
	public static void getValidParenthsis(int leftBracesCount,int rightBracesCount,String temp,ArrayList<String> res)
	{
		if(leftBracesCount>rightBracesCount)
			return;
		if(leftBracesCount==0 && rightBracesCount==0)
		{
			res.add(temp.toString());
			return;
		}
		if(leftBracesCount>0)
			getValidParenthsis(leftBracesCount-1,rightBracesCount,temp+"(",res);
		if(rightBracesCount>0)
			getValidParenthsis(leftBracesCount,rightBracesCount-1,temp+")",res);
	}
}
