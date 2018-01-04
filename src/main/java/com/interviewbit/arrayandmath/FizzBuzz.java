package com.interviewbit.arrayandmath;

import java.util.ArrayList;

public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fizzBuzz(5));
	}
	
	public static ArrayList<String> fizzBuzz(int A) {
		ArrayList<String> result = new ArrayList<String>();
		for(int i =1;i<=A;i++)
		{
			StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
            	sb.append("Fizz");
            }
            if (i % 5 == 0) {
            	sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            result.add(sb.toString().trim());
		}
		System.out.println(result.size());
		return result;
    }

}
