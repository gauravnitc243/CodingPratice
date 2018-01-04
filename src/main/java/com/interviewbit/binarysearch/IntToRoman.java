package com.interviewbit.binarysearch;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntToRoman
{

	public static void main(String[] args)
	{
		System.out.println(intToRoman(14));

	}
	
	public static String intToRoman(int a) { 
		    LinkedHashMap<String, Integer> romanToIntMapCode = new LinkedHashMap<String, Integer>();
		    romanToIntMapCode.put("M", 1000);
		    romanToIntMapCode.put("CM", 900);
		    romanToIntMapCode.put("D", 500);
		    romanToIntMapCode.put("CD", 400);
		    romanToIntMapCode.put("C", 100);
		    romanToIntMapCode.put("XC", 90);
		    romanToIntMapCode.put("L", 50);
		    romanToIntMapCode.put("XL", 40);
		    romanToIntMapCode.put("X", 10);
		    romanToIntMapCode.put("IX", 9);
		    romanToIntMapCode.put("V", 5);
		    romanToIntMapCode.put("IV", 4);
		    romanToIntMapCode.put("I", 1);
		    String result = "";
		    for(Map.Entry<String, Integer> entry : romanToIntMapCode.entrySet())
		    {
		    	result += repeateCurrentCode(entry.getKey(),a/entry.getValue());
		    	a %= entry.getValue();
		    }
		    return result;
	  }
	  public static  String repeateCurrentCode(String code,int times)
	  {
		  StringBuilder currentString = new StringBuilder();
		  for(int i =0;i<times;i++)
			  currentString.append(code);
		  return currentString.toString();
	  }

}
