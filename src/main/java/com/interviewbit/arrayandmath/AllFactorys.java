package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Collections;

public class AllFactorys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(allFactors(1));

	}
	
	public static ArrayList<Integer> allFactors(int a) {
		int range = (int) Math.sqrt(a);
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for(int i= 1;i<=range;i++)
		{
			if(a%i==0)
			{
				
				result.add(a/i);
				if(!result.contains(i))
					result.add(i);
			}
		}
		Collections.sort(result);
		return result;
		
	}

}
