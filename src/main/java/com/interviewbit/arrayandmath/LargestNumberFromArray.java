package com.interviewbit.arrayandmath;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumberFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LargestNumberFromArray cla = new LargestNumberFromArray();
		Integer[] inp = {3, 30, 34, 5, 2};
		List<Integer> a = Arrays.asList(inp);
		System.out.println(cla.largestNumber(a));;

	}
	
	public String largestNumber(final List<Integer> a) {
		List<Integer> inputList = a;
		StringBuilder output = new StringBuilder();
		Collections.sort(inputList,new NumberComparision());
		boolean isNotZero = false;
		for(int i : inputList)
		{
			output.append(i);
			if(i!=0)
				isNotZero = true;
		}
		if(!isNotZero)
			return "0";
		return output.toString();
		
	}
	
	class NumberComparision implements Comparator<Integer>{
		@Override
		public int compare(Integer arg0, Integer arg1) {
			Long firstNumber = Long.parseLong(Long.toString(arg0)+Long.toString(arg1));
			Long secondNumber = Long.parseLong(Long.toString(arg1)+Long.toString(arg0));
			return secondNumber.compareTo(firstNumber);
		}
		
	}

}
