package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.Arrays;

public class SpiralOrderMatrixII {

	public static void main(String[] args) {
		System.out.println(generateMatrix(2));
	}

	public static ArrayList<ArrayList<Integer>> generateMatrix(int a) {
		Integer[][] input = new Integer[a][a];
		int totalElement = a * a;
		int count = 1;
		int dir = 0;
		int rowStart = 0;
		int colStart = 0;
		int rowEnd = a-1;
		int colEnd = a-1;
		while (count <= totalElement) {
			if (dir == 0) {
				for (int i = colStart; i <= colEnd; i++) {
					input[rowStart][i] = count++;
				}
				rowStart++;
			} else if (dir == 1) {
				for (int i = rowStart; i <= rowEnd; i++) {
					input[i][colEnd] = count++;
				}
				colEnd--;
			} else if (dir == 2) {
				for (int i = colEnd; i >= colStart; i--) {
					input[rowEnd][i] = count++;
				}
				rowEnd--;
			} else if (dir == 3) {
				for (int i = rowEnd; i >= rowStart; i--) {
					input[i][colStart] = count++;
				}
				colStart++;
			}
			dir = (dir + 1) % 4;
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0;i<a;i++) {
			result.add(new ArrayList<Integer>(Arrays.asList(input[i])));
		}
		return result;
	}
}