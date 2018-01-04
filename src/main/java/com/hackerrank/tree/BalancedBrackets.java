package com.hackerrank.tree;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	     int t = in.nextInt();
	     for(int a0 = 0; a0 < t; a0++)
	     {
	            String s = in.next();
	            Stack<Character> stack  = new Stack<Character>();
	            for(int i =0;i<s.length();i++){
	            	if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='(')
	            		stack.push(s.charAt(i));
	            	else{
	            		if(stack.isEmpty()){
	            			System.out.println("NO");
	            			break;
	            		}
	            		char c = stack.pop();
	            		if((c=='(' && s.charAt(i)!=')') || (c=='{' && s.charAt(i)!='}') || (c=='[' && s.charAt(i)!=']')){
	            			System.out.println("NO");
	            			break;
	            		}
	            	}
	            	if(i==s.length()-1){
	            		if(stack.isEmpty())
	            			System.out.println("YES");
	            		else
	            			System.out.println("NO");
	            	}
	            }
	     }
	     in.close();

	}

}
