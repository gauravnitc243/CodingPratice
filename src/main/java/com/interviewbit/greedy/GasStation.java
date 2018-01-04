package com.interviewbit.greedy;

import java.util.List;

public class GasStation
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) 
	{
		int remaning = 0;
		int totalRemaning = 0;
		int index =0;
		int total=0;
		for(int i =0;i<gas.size();i++)
		{
			remaning = gas.get(i)-cost.get(i);
			if(totalRemaning>=0)
				totalRemaning += remaning;
			else
			{
				totalRemaning = remaning;
				index = i;
			}
			total += remaning;
		}
		if(total>=0)
			return index;
		else
			return -1;
	}

}
