package com.hackerrank.tree;

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		int maxArea = 0;
		int area = 0;
		for(int i =0;i<n;i++)
			input[i] = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		int i =0;
		while(i<n){
			if(stack.isEmpty() || input[stack.peek()] <= input[i])
				stack.push(i++);
			else{
				int t = stack.pop();
				area = input[t] * (stack.isEmpty()?i:(i-stack.peek()-1));
				if(area>maxArea)
					maxArea = area;
			}
		}
		while(!stack.isEmpty()){
			int t = stack.pop();
			area = input[t] * (stack.isEmpty()?i:(i-stack.peek()-1));
			if(area>maxArea)
				maxArea = area;
		}
		System.out.println(maxArea);
		sc.close();
	}

}
