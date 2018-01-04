package com.interviewbit.hashing;

import java.util.HashMap;

public class WindowString
{

	public static void main(String[] args)
	{
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));

	}
	
	public static String minWindow(String S, String T) 
	{
        if (S == null || S.length() == 0 || T == null || T.length() == 0)
        {
            return "";
        }
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        int start = 0;
        int count = 0;
        int minLen = S.length() + 1;
        String result = "";
        for (int i = 0; i < T.length(); i++) 
        {
            charMap.put(T.charAt(i), 0);
            if (charCountMap.containsKey(T.charAt(i))) 
                charCountMap.put(T.charAt(i), charCountMap.get(T.charAt(i)) + 1);
            else 
                charCountMap.put(T.charAt(i), 1);
        }
        for (int end = 0; end < S.length(); end++) 
        {
            if (charMap.containsKey(S.charAt(end))) 
            {
                charMap.put(S.charAt(end), charMap.get(S.charAt(end)) + 1);
                if (charMap.get(S.charAt(end)) <= charCountMap.get(S.charAt(end))) 
                    count++;
            }
            if (count == T.length()) 
            {
                while (!charCountMap.containsKey(S.charAt(start)) || charMap.get(S.charAt(start)) > charCountMap.get(S.charAt(start))) 
                {
                    if (charMap.containsKey(S.charAt(start))) 
                        charMap.put(S.charAt(start), charMap.get(S.charAt(start)) -1);
                    start++;
                } 
                if (end - start + 1 < minLen) 
                {
                    minLen = end - start + 1;
                    result = S.substring(start, end + 1);
                }
            }
        }
        return result;
    }
}
