package com.interviewbit.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterPhone
{
	 static Map<Character, String> letterMap = new HashMap<Character, String>();
	    static
	    {
	    	letterMap.put('0', "0");
	        letterMap.put('1', "1");
	        letterMap.put('2', "abc");
	        letterMap.put('3', "def");
	        letterMap.put('4', "ghi");
	        letterMap.put('5', "jkl");
	        letterMap.put('6', "mno");
	        letterMap.put('7', "pqrs");
	        letterMap.put('8', "tuv");
	        letterMap.put('9', "wxyz");
	    }
	public static void main(String[] args)
	{
		System.out.println(letterCombinationsNew("234"));

	}
	
	public static ArrayList<String> letterCombinationsNew(String a) 
	{
		char[] tempStringArray = new char[a.length()];
		ArrayList<String> result = new ArrayList<String>();
		appendCombination(a,0,tempStringArray,result);
		return result;
	}
	public static void appendCombination(String degits,int i,char[] tempStringArray,ArrayList<String> result)
	{
		if(i==degits.length())
		{
			result.add(new String(tempStringArray));
			return ;
		}
		String currentDegitCombination = letterMap.get(degits.charAt(i));
		for(int j=0;j<currentDegitCombination.length();j++)
		{
			tempStringArray[i] = currentDegitCombination.charAt(j);
			appendCombination(degits,i+1,tempStringArray,result);
		}
	}
}
