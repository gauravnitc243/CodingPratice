package com.hackerrank.tree;

import java.util.Scanner;
import java.util.Stack;

public class TwoStackQueue {

	public static void main(String[] args) {
		Stack<Integer> inbox = new Stack<Integer>();
		Stack<Integer> outbox = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while(N-->0)
		{
			int t = sc.nextInt();
			if(t==1)
				inbox.push(sc.nextInt());
			else if(t==2)
				deque(inbox,outbox);
			else if(t==3)
				printTop(inbox,outbox);
		}
		sc.close();
	}
	public static void printTop(Stack<Integer> a,Stack<Integer> b){
		if(b.isEmpty()){
			while(!a.isEmpty())
				b.push(a.pop());
		}
		System.out.println(b.peek());
	}
	
	public static void deque(Stack<Integer> a,Stack<Integer> b){
		if(b.isEmpty()){
			while(!a.isEmpty())
				b.push(a.pop());
		}
		b.pop();
	}
}
