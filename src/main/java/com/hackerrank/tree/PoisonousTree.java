package com.hackerrank.tree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class PoisonousTree {
	static class Node{
		int val;
		int days;
		public Node(int v,int d){
			this.val = v;
			this.days = d;
		}
	}
	public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
	    ArrayList<Integer> list= new ArrayList<Integer>();
	    Stack<Node> stack = new Stack<Node>();
	    int n=scn.nextInt();
	    for(int i=0;i<n;i++){
	        list.add(scn.nextInt());
	    }
	    scn.close();
	    stack.push(new Node(list.get(0),0));
	    int maxDays = 0;
	    for(int i =1;i<n;i++){
	    	if(stack.isEmpty()){
	    		stack.push(new Node(list.get(i),0));
	    	}
	    	else{
	    		Node t = stack.peek();
	    		if(t.val<list.get(i)){
	    			maxDays = Math.max(maxDays, 1);
	    			stack.push(new Node(list.get(i),1));
	    		}else{
	    			int pr=t.days;
	    			while(!stack.isEmpty() && t.val>=list.get(i)){
	    				stack.pop();
	    				if(stack.empty())
	                        break;
	    				pr = Math.max(t.days, pr);
	    				t = stack.peek();
	    			}
	    			if(stack.isEmpty())
	    				stack.push(new Node(list.get(i),0));
	    			else{
	    				stack.push(new Node(list.get(i),pr+1));
	    				maxDays = Math.max(maxDays, pr+1);
	    			}
	    				
	    		}
	    	}
	    }
	    System.out.println(maxDays);
	}
}
