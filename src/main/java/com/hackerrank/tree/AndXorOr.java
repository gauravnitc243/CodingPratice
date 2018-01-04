package com.hackerrank.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class AndXorOr {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> input = new ArrayList<Integer>();
		for(int i =0;i<N;i++)
			input.add(sc.nextInt());
		sc.close();
		int maxVal = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<Integer>();
		int iterations = 0;
		while(iterations++<2){
			for(int i =0;i<N;i++)
			{
				while(!stack.isEmpty() && stack.peek()>input.get(i))
					stack.pop();
				if(!stack.isEmpty())
					maxVal = Math.max(maxVal,  input.get(i) ^ stack.peek());
				stack.push(input.get(i));
			}
			stack = new Stack<Integer>();
			Collections.reverse(input);
		}
		System.out.println(maxVal);
	}
}
