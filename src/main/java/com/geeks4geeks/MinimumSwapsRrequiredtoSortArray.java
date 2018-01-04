package com.geeks4geeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumSwapsRrequiredtoSortArray {

	public static void main(String[] args) {
		int[] a = { 1, 5,4,3, 2 };
		System.out.println(MinimumSwapsRrequiredtoSortArray.getMinimumSwapCount(a));
	}

	private static class Pair {
		private Integer value;
	//	private Integer index;
		public Pair(int i, int j) {
			value = i;
		//	index = j;
		}
	}
	
	private static class ValueComparator implements Comparator<Pair>{
		@Override
		public int compare(Pair o1, Pair o2) {
			if (o1.value > o2.value)
				return -1;
			else if (o1.value == o2.value)
				return 0;
			else
				return 1;
		}
	}

	public static int getMinimumSwapCount(int[] arr) {
		int n = arr.length;
		List<Pair> pairArray = new ArrayList<Pair>();
		for (int i = 0; i < n; i++)
			pairArray.add(new Pair(arr[i], i+1));
		boolean[] visited = new boolean[n];
		Collections.sort(pairArray,new ValueComparator());
		int minSwaps = 0;
		for (int i = 0; i < n; i++)
		{
			if (pairArray.get(i).value == i || visited[i]){
				continue;
			}
			int currentCycleSize = 0;
			int j = i;
			while (j< n && !visited[j]) 
			{
				visited[j] = !visited[j];
				j = pairArray.get(j).value;
				currentCycleSize++;
			}
			minSwaps += (currentCycleSize - 1);
		}
		return minSwaps;
	}
}
