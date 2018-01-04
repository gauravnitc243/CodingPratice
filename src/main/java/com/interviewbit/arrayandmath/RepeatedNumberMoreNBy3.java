package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RepeatedNumberMoreNBy3 {

	public static void main(String[] args) {
		ArrayList<Integer> z = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 2, 3, 5, 7));
		System.out.println(repeatedNumber1(z));
	}
	
	public int repeatedNumber(final List<Integer> a) {
		int threshHold = a.size()/3;
		HashMap<Integer, Integer> input = new HashMap<>();
		for(int i:a)
		{
			if(!input.containsKey(i))
				input.put(i, 1);
			else{
				if(input.put(i,input.get(i)+1)==threshHold)
					return i;
			}
		}
		for(int i : input.keySet())
		{
			if(input.get(i)>threshHold)
				return i;
		}
		return -1;
	}
	
	public static int repeatedNumber1(final List<Integer> a) {
		int res=a.get(0);
		int count=1;
		for(int i=1;i<a.size();i++){
			if(res==a.get(i))
				count++;
			else{
				if(count==0){
					count =0;
					res = a.get(i);
				}else
					count--;
			}
		}
		if(count<=0){
			return -1;
		}
		count =0;
		for(int i:a ){
			if(i==res)
				count++;
		}
		if(count>a.size()/3)
			return res;
		else
			return -1;
	}
	

}
