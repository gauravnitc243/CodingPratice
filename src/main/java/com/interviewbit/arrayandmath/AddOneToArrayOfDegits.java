
package com.interviewbit.arrayandmath;

import java.util.ArrayList;

public class AddOneToArrayOfDegits {

	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(0);
		input.add(3);
		input.add(7);
		input.add(6);
		input.add(4);
		input.add(0);
		input.add(5);
		input.add(5);
		input.add(5);
		System.out.println(plusOne(input));

	}
	
	public static  ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		a.add(0,0);
		for(int i =a.size()-1 ; i>=0;i-- )
		{
			int degit = a.get(i);
			if(degit<=8)
			{
				degit += 1;
				a.set(i, degit);
				break;
			}
			else
			{
				a.set(i, 0);
			}
		}
		
		for(int i =0 ;i<a.size() ; )
		{
			if(a.get(i)==0)
				a.remove(i);
			if(a.get(i)!=0)
				break;
			
		}
		return a;
			
			
	}

}
