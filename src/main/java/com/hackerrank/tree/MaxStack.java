package com.hackerrank.tree;

import java.util.Scanner;

public class MaxStack {
	
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		Stack s = new Stack();
		while(N>0){
			int a = scan.nextInt();
			if(a==1){
				s.push(scan.nextInt());
			}else if(a==2){
				s.pop();
			}else if(a==3){
				s.printMax();
			}
		}
		scan.close();

	}
	
	static class Stack
	{
		class Node{
			int data;
			int max;
			Node next;
			public Node(int val,int max){
				this.data = val;
				this.max = max;
				this.next = null;
			}
		}
		Node head ;
		int itemCount ;
		
		public Stack(){
			head = null;
			itemCount = 0;
		}
		public void push(int v){
			Node oldHead = head;
			head = new Node(v,v);
			if(itemCount==0){
				head = new Node(v,v);
			}else{
				int max = v>head.max?v:head.max;
				head = new Node(v,max);
			}
			head.next = oldHead;
			itemCount++;
		}
		public void pop(){
			head = head.next;
			itemCount--;
		}
		public void printMax(){
			System.out.println(head.max);
		}
	}

}
