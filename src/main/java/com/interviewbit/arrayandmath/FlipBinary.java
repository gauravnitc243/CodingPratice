package com.interviewbit.arrayandmath;

import java.util.ArrayList;

public class FlipBinary {

	public static void main(String[] args) {
		String a = "1101010001";
		FlipBinary f = new FlipBinary();
		f.flip(a);
	}
	
	
	public   ArrayList<Integer> flip(String A) {
		int[] inputBits = new int[A.length()];
		ArrayList<Integer> result  = new ArrayList<Integer>();
		boolean zeroFlag = false;
		for(int i =0 ; i<A.length();i++)
		{
			inputBits[i] = Character.getNumericValue(A.charAt(i));
			if(inputBits[i] ==1)
			{
				inputBits[i] =-1;
			}
			else
			if(inputBits[i]==0)
			{
				zeroFlag = true;
				inputBits[i] =1;
			}
		}
		if(!zeroFlag)
			return result;
		int currentMax=0;
		int totalMax = 0;
		int totalMaxStart =0;
		int totalMaxEnd = 0;
		
		for(int i =0 ; i<A.length();i++)
		{
			currentMax += inputBits[i];
			if(currentMax<0)
			{
				currentMax=0;
			}
			if(currentMax>totalMax)
			{
				totalMax = currentMax;
				totalMaxEnd = i;
			}
		}
		int sum = 0;
		for(int i =totalMaxEnd ; i>=0  ;i--)
		{
				
				sum += inputBits[i];
				if(sum==totalMax)
				{
					totalMaxStart = i;
				}
		}
		
		System.out.println((totalMaxStart+1)+" "+(totalMaxEnd+1));
		result.add(totalMaxStart+1);
		result.add(totalMaxEnd+1);
		return result;
	}
	
}
