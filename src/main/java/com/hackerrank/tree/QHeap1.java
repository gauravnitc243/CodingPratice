package com.hackerrank.tree;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class QHeap1 {

	public static void main(String[] args) {
		PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(Collections.reverseOrder());
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a = sc.nextInt();
		System.out.println(a);
		int b = sc.nextInt();
		System.out.println(((double)a+b)/2);
		if(a<=b){
			minPQ.offer(b);
			maxPQ.offer(a);
		}
		else{
			minPQ.offer(a);
			maxPQ.offer(b);
		}
		N = N-2;
		while(N-->0)
		{
			int i = sc.nextInt();
			if(i<=maxPQ.peek())
				maxPQ.offer(i);
			else
				minPQ.offer(i);
			
			while(minPQ.size()-maxPQ.size()>1)
				maxPQ.offer(minPQ.poll());
			while(maxPQ.size()-minPQ.size()>1)
				minPQ.offer(maxPQ.poll());
			
			if(minPQ.size()==maxPQ.size())
				System.out.println(((double)maxPQ.peek()+minPQ.peek())/2);
			else
			{
				if(minPQ.size()>maxPQ.size())
					System.out.println(minPQ.peek());
				else
					System.out.println(maxPQ.peek());
			}
		}
		sc.close();
	}
	
}
