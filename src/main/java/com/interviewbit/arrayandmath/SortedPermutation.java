package com.interviewbit.arrayandmath;

import java.util.ArrayList;
import java.util.HashMap;

public class SortedPermutation {

	public static void main(String[] args)
	{
		System.out.println(findRank("ZCSFLVHXRYJQKWABGT"));

	}
	
	   public static int findRankDP(String S) {
           int[] charCount= new int[256]; 
           int MOD = 1000003;
           for (int i = 0; i < S.length(); i++) charCount[S.charAt(i)]++;

           ArrayList<Integer> fact =  new ArrayList<Integer>(); // fact[i] will contain i! % MOD
           initializeFactorials(S.length() + 1, fact);

           long  rank =  1;
           for (int i = 0; i < S.length(); i++) {
               // find number of characters smaller than S[i] still left. 
               int less = 0;
               for (int ch = 0; ch < S.charAt(i); ch++) {
                   less += charCount[ch]; 
               }
               rank = (rank + ((long)fact.get(S.length() - i - 1) * less)) % MOD;
               // remove the current character from the set. 
               charCount[S.charAt(i)]--;
           }
           return (int)rank;
       }

	   public static void initializeFactorials(int totalLen, ArrayList<Integer> fact) {
           long  factorial = 1;
           fact.add(1); // 0!= 1
           for (int curIndex = 1; curIndex < totalLen; curIndex++) {
               factorial = (factorial * curIndex) % 1000003;
               fact.add((int) factorial);
           }
           return;
       }
	
	public static int findRank(String a) {
	    long rank = 1;
	    long suffixPermCount = 1;
	    HashMap<Character, Integer> charCounts = new HashMap<Character, Integer>();
	    for (int i = a.length() - 1; i > -1; i--) 
	    {
	        char x = a.charAt(i);
	        int xCount = charCounts.containsKey(x) ? charCounts.get(x) + 1 : 1;
	        charCounts.put(x, xCount);
	        for (java.util.Map.Entry<Character, Integer> e : charCounts.entrySet()) 
	        {
		        if (e.getKey() < x)
		        {
		                rank += suffixPermCount * e.getValue() / xCount;
		        }
	        }
	        suffixPermCount *= a.length() - i;
	        suffixPermCount /= xCount;
	    }
	    return (int)(rank%1000003);
	    
	}

}
