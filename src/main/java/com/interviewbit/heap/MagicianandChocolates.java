package com.interviewbit.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianandChocolates {

	public static void main(String[] args) {
		ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2147483647, 2000000014, 2147483647));
		System.out.println(nchoc(10, B));
	}

	public static int nchoc(int A, ArrayList<Integer> B) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(B.size(), Collections.reverseOrder());
		for (int i : B)
			maxHeap.add(i);
		long result = 0;
		while (A-- > 0) {
			int maxElement = maxHeap.poll();
			result = (result + maxElement) % 1000000007;
			maxHeap.add(maxElement / 2);
		}
		return (int) result;
	}

}
