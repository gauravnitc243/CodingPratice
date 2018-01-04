package com.geeks4geeks;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetSum {

	public static void main(String[] args) {
		int input[] = {3, 34, 4, 12, 5, 2};
		Arrays.sort(input);
		int sum = 9;
		combinationUtil(input,0,sum,0,new ArrayList<Integer>());
	}
	
	
	
	public static void combinationUtil(int[] input,int start,int desiredSum,int currentSum,ArrayList<Integer> sumArr){
		if(currentSum>desiredSum)
			return;
		if(desiredSum==currentSum)
		{
			System.out.println(sumArr);
			return;
		}
		for(int i = start ;i<input.length;i++){
			currentSum += input[i];
			sumArr.add(input[i]);
			combinationUtil(input,start+1,desiredSum,currentSum,sumArr);
			currentSum -= input[i];
			sumArr.remove(sumArr.size()-1);
		}
	}

}
