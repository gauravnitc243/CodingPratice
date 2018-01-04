package com.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MatrixMedian {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(9, 10, 10, 13, 14, 15, 16, 16, 16, 17, 18));
		ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1, 4, 9, 14, 16, 18, 19, 22, 26, 26, 27));
		ArrayList<Integer> c = new ArrayList<>(Arrays.asList(4, 6, 7, 10, 14, 20, 21, 23, 24, 27, 28));
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		A.add(a);
		A.add(b);
		A.add(c);
		System.out.println(findMedian(A));

	}

	  public static int findMedian(ArrayList<ArrayList<Integer>> A) {
			 int row = A.size();
			 int column = A.get(0).size();
			 int right = Integer.MAX_VALUE;
			 int left = 0;
			 int resultPosition = (row * column + 1) / 2;
			 while(right-left >1)
			 {
				 int mid = left + (right-left)/2;
				 int count = 0;
				 for(int i = 0 ;i<row;i++){
					 count += getCountLessThen(A.get(i),mid);
				 }
				 if(count>=resultPosition)
					 right = mid;
				 else
					 left = mid;
			 }
			 return right;
		 }
	  
	public static int getCountLessThen(ArrayList<Integer> sortedInput, int key) {
		int keyIndex = Collections.binarySearch(sortedInput, key);
		if (keyIndex < 0) {
			keyIndex *= -1;
			keyIndex -= 1;
		}else{
			while(keyIndex<sortedInput.size() && sortedInput.get(keyIndex)==key)
				keyIndex++;
		}
		return keyIndex;
	}
	
	public static int findMedian1(ArrayList<ArrayList<Integer>> A) {
		int l = 0, r = Integer.MAX_VALUE;
		int mid, req = A.size() *  A.get(0).size();
		while (r - l > 1) {
			mid = l + (r - l) / 2;
			int cnt = 0;
			for (int i = 0; i < A.size(); i++) {
				cnt += getCountLessThen(A.get(i), mid);
			}
			if (cnt >= (req / 2 + 1))
				r = mid;
			else
				l = mid;
		}
		return r;
	}
}
