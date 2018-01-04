package com.hackerrank.tree;

import java.util.Scanner;
import java.util.Stack;

public class TextEditor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<String>  stack = new Stack<String>();
		String  str ="";
		int k =0;
		while(n>0){
			int i = sc.nextInt();
			switch(i){
			case 1 :
				stack.push(str);
				str += sc.next();
				break;
			case 2 :
				stack.push(str);
				k = sc.nextInt();
				str = str.substring(0,str.length()-k);
				break;
			case 3 :
				k = sc.nextInt();
				System.out.println(str.charAt(k-1));
				break;
			case 4 :
				if(!stack.isEmpty())
					str = stack.pop();
			}
		}
		sc.close();
	}
}
