package com.hackerrank.tree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Waiter {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		Stack<Integer> input = new Stack<Integer>();
		int prime = 1;
		while(N-->0)
			input.add(sc.nextInt());
		sc.close();
		ArrayList<Stack<Integer>> res = new ArrayList<Stack<Integer>>();
		while(Q-->0)
		{
			prime = getNextPrime(prime);
			Stack<Integer> tmpInput = new Stack<Integer>();
			Stack<Integer> t = new Stack<Integer>();
			while(!input.isEmpty())
			{
				int top = input.pop();
				if(top%prime==0)
					t.push(top);
				else
					tmpInput.push(top);
			}
			res.add(t);
			input = tmpInput;
		}
		res.add(input);
		for(int i =0;i<res.size();i++){
			Stack<Integer> t = res.get(i);
			while(!t.isEmpty())
				System.out.println(t.pop());
		}
		
	}
	
	public static int getNextPrime(int n){
		int k = n+1;
		for(int i =2;i<k;i++)
		{
			if(k%i==0)
			{
				k++;
				i = 1;
			}
		}
		return k;
	}

}
