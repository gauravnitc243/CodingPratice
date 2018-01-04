package com.interviewbit.graphs;

import java.util.ArrayList;

public class SumOfFIbo
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SumOfFIbo s = new SumOfFIbo();
		System.out.println(s.fibsum(9));
	
	}
	
	public int fibsum(int n) 
	{
		ArrayList<Integer> fiboNums = new ArrayList<Integer>();
		int a=1,b=1,c=1;
		fiboNums.add(a);
		fiboNums.add(b);
		while((c=a+b)<=n) 
		{
			fiboNums.add(c);
			a = b;
			b = c;
		}
		int count =0;
		while(n!=0)
		{
			while(fiboNums.get(fiboNums.size()-1)>n)
				fiboNums.remove(fiboNums.size()-1);
			n = n- fiboNums.get(fiboNums.size()-1);
			fiboNums.remove(fiboNums.size()-1);
			count++;
		}
		return count;
	}
	
	
	public int fibsumDynamicProgramming(int n) 
	{
		ArrayList<Integer> fiboNums = new ArrayList<Integer>();
		int a=1,b=1,c=1;
		fiboNums.add(a);
		fiboNums.add(b);
		while((c=a+b)<=n) 
		{
			fiboNums.add(c);
			a = b;
			b = c;
		}
		int minSum[] = new int[n+1];
		minSum[0] = 0;
		for(int i = 1;i<=n;i++)
		{
			minSum[i] = n; 
			for(int k : fiboNums)
			{
				if(k<=i) 
					minSum[i] = Math.min(minSum[i], minSum[i-k] + 1);
				else 
					break;
			}
		}
		return minSum[n];
	}

}
