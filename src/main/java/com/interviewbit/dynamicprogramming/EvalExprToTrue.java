package com.interviewbit.dynamicprogramming;

import java.util.ArrayList;

public class EvalExprToTrue
{

	public static void main(String[] args)
	{
		System.out.println(cnttrue("T^T^T^F|F&F^F|T^F^T"));

	}
	
	public static int cnttrue(String a) 
	{
		ArrayList<Character> chars = new ArrayList<Character>();
		ArrayList<Character> opers = new ArrayList<Character>();
		for(int i =0;i<a.length();i++)
		{
			if(a.charAt(i)=='|' || a.charAt(i)=='&' || a.charAt(i)=='^')
				opers.add(a.charAt(i));
			else
				chars.add(a.charAt(i));
		}
		return countParenth(chars.toArray(new Character[chars.size()]), opers.toArray(new Character[opers.size()]));
	}
	
	public static int countParenth(Character exp[] , Character op[]) {
		int n= exp.length;
		int t[][] = new int[n][n];
		int f[][]= new int[n][n];
		for(int i=0 ; i < n; ++i) {
			if(exp[i]=='T') t[i][i] = 1;
			else f[i][i] =1;
		}
		for(int gap=1; gap <n; ++gap) {
			for(int i=0, j=gap; j < n; ++i, ++j) {
				for(int g=0; g< gap; ++g)
				{
					int k = i +g;
					switch(op[k])
					{
						case '&' : 
							t[i][j] += t[i][k] * t[k+1][j];
							f[i][j] += t[i][k] * f[k+1][j] + f[i][k] * t[k+1][j] + f[i][k] * f[k+1][j];
							break;
						case '|':
							t[i][j] += t[i][k] * t[k+1][j] + t[i][k] * f[k+1][j] + f[i][k] * t[k+1][j]; 
							f[i][j] +=  f[i][k] * f[k+1][j];
							break;
						case '^':
							t[i][j] += t[i][k] * f[k+1][j] + f[i][k] * t[k+1][j];
							f[i][j] += t[i][k] * t[k+1][j] + f[i][k] * f[k+1][j];
							break;
					}
					t[i][j] %= 1003;
					f[i][j] %= 1003;
				}
			}
		}
		
		return t[0][n-1];
	}

}
