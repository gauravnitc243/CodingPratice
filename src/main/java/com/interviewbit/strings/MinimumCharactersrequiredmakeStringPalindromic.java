package com.interviewbit.strings;

public class MinimumCharactersrequiredmakeStringPalindromic {

	public static void main(String[] args) {
		System.out.println(solve("AACECAAAA"));
	}

	public static int solve(String A) {
		String pattern = A + (new StringBuilder(A).reverse()).toString();
		int[] lpsArray = getLPSArr(pattern);
		return A.length() - lpsArray[lpsArray.length - 1] < 0 ? 0 : A.length() - lpsArray[lpsArray.length - 1];
	}

	public static int[] getLPSArr(String s) {
		int[] lpsArray = new int[s.length()];
		int currentMatchedIndex = 0;
		int i = 1;
		while (i < s.length()) {
			if (s.charAt(i) == s.charAt(currentMatchedIndex))
				lpsArray[i++] = ++currentMatchedIndex;
			else {
				if (currentMatchedIndex != 0)
					currentMatchedIndex = lpsArray[currentMatchedIndex - 1];
				else
					lpsArray[i++] = 0;
			}
		}
		return lpsArray;
	}
}
