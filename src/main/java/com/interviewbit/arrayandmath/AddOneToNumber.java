package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Arrays;

public class AddOneToNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		Integer[] input = Arrays.copyOf(a.toArray(), a.size(), Integer[].class);
		ArrayList<Integer> res = new ArrayList<Integer>();
		int carry = 1;
		for (int i = input.length - 1; i >= 0; i--) {
			int t = input[i] + carry;
			input[i] = t % 10;
			carry = t / 10;
			if (carry == 0)
				break;
		}
		int index = 0;
		if (carry == 0) {
			while (input[index] == 0)
				index++;
		} else
			res.add(carry);
		while (index < input.length)
			res.add(input[index++]);
		return res;
	}

}
