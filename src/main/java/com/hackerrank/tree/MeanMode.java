package com.hackerrank.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MeanMode {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] input = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			input[i] = s.nextInt();
			sum += input[i];
		}
		System.out.println((double) sum / N);
		Arrays.sort(input);
		System.out.println(N % 2 == 0 ? (double)(input[N / 2 - 1] + input[N / 2]) / 2 : input[N / 2]);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxKey = 0;
		int mode = 0;
		for (int i = 0; i < N; i++) {
			if (map.containsKey(i)) {
				map.put(i, 1 + map.get(i));
				if (map.get(i) > maxKey) {
				}
				mode = i;
				maxKey = map.get(i);
			} else
				map.put(i, 1);
		}
		System.out.println(mode == 0 ? input[0] : mode);
		s.close();
	}
}
