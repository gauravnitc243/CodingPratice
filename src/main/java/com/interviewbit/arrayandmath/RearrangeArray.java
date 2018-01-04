package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
arrange(new ArrayList<>(Arrays.asList(4, 0, 2, 1, 3)));
	}
	
	public static void arrange(ArrayList<Integer> a) {
		for(int i =0;i<a.size();i++)
		{
			a.set(i,a.get(i) +(a.get(a.get(i))%a.size())*a.size());
		}
		for(int i =0;i<a.size();i++)
		{
			a.set(i, (a.get(i))/a.size());
		}
	}

}
