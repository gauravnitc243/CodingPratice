package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Integer> wave(ArrayList<Integer> a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Collections.sort(a);
		for(int i =0; i<a.size();i+=2)
		{
			result.add(a.get(i+1));
			result.add(a.get(i));
		}
		if(a.size()%2!=0)
			result.add(a.get(a.size()-1));
		return result;
	}

}
