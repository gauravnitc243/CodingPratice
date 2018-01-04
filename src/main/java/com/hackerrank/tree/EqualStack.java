package com.hackerrank.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EqualStack {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> a = new LinkedList<Integer>();
        Queue<Integer> b = new LinkedList<Integer>();
        Queue<Integer> c = new LinkedList<Integer>();
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int t;
        for(int h1_i=0; h1_i < n1; h1_i++){
            t = in.nextInt();
            countA += t; 
            a.add(t);
        }
        for(int h2_i=0; h2_i < n2; h2_i++){
            t = in.nextInt();
            countB += t;
            b.add(t);
        }
        for(int h3_i=0; h3_i < n3; h3_i++){
            t = in.nextInt();
            countC += t; 
            c.add(t);
        }
        in.close();
        while(!((countA==countB) && (countA==countC))){
        	if(a.isEmpty() || b.isEmpty() || c.isEmpty()){
        		System.out.println(0);
        		return;
        	}else{
        		if(countA>=countB && countA>=countC)
        			countA -= a.remove();
        		else if(countB>=countA && countB>=countC)
        			countB -= b.remove();
        		else
        			countC -= c.remove();
        	}
        }
        System.out.println(countA);
        
	}

}
