package com.hackerrank.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TruckTour {
	public static class Node{
		int petrol;
		int dist;
		public Node(int p, int d){
			this.petrol = p;
			this.dist = d;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Node> q = new LinkedList<Node>();
		int dist = 0;
		while(N-->0)
		{
			int p = sc.nextInt();
			int d = sc.nextInt();
			q.add(new Node(p,d));
			dist += d;
			
		}
		sc.close();
		int d =0;
		int currP = 0;
		int count = 0;
		while(!q.isEmpty() && d!=dist)
		{
			count++;
			Node t = q.poll();
			currP = currP + t.petrol;
			if(currP<t.dist){
				 currP = 0;
				 d = 0;
			}else{
				currP -= t.dist;
				d += t.dist;
			}
			q.add(t);
		}
		System.out.println(count-q.size());
		System.out.println("dist "+q.peek().dist +" "+q.peek().petrol);
	}

}
