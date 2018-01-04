package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Arrays;

public class AntiDiagonals {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3));
		ArrayList<Integer> b = new ArrayList<>(Arrays.asList(4,5,6));
		ArrayList<Integer> c = new ArrayList<>(Arrays.asList(7,8,9));
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
		r.add(a);
		r.add(b);
		r.add(c);
		System.out.println(diagonal(r));

	}
	
	public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) 
	{
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for(int i =0;i<(a.get(0).size()+a.size())-1;i++)
			res.add(new ArrayList<>());
		for(int i =0;i<a.size();i++){
			for(int j=0;j<a.get(0).size();j++){
				res.get(i+j).add(a.get(i).get(j));
			}
		}
		return res;
	}
}
