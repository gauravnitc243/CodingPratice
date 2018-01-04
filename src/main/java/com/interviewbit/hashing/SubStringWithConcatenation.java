package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubStringWithConcatenation
{

	public static void main(String[] args)
	{
		String a = "barfoothefoobarman ";
		String[] words = {"foo", "bar"};
		System.out.println(findSubstring(a, Arrays.asList(words)));
	}

	 public static ArrayList<Integer> findSubstring(String a,final List<String> b) 
	 {
		    ArrayList<Integer> res = new ArrayList<>();
		    if (a == null || b == null || b.size() == 0 || a.length() == 0)
		        return res;
		    HashMap<String, Integer> words = new HashMap<>();
		    int len = b.get(0).length();
		    for (String str : b) 
		    {
		        if (words.containsKey(str)) 
		        	words.put(str, words.get(str) + 1);
		        else
		        	words.put(str,1);
		    }
		    int size = b.size();
		    int index;
		    for (int i = 0; i <= a.length() - len * size; i++) 
		    {
		        index = i;
		        int loop = size;
		        HashMap<String, Integer> hashMap = new HashMap<>(words);
		        for (int j = 0; j < loop; j++) 
		        {
		            String str = a.substring(index + j * len, index + j * len + len);
		            if (hashMap.containsKey(str)) 
		            {
		                int val = hashMap.get(str);
		                if (val == 1) 
		                    hashMap.remove(str);
		                else 
		                    hashMap.put(str, val - 1);
		            } 
		            else
		                break;
		        }
		        if (hashMap.isEmpty()) 
		            res.add(i);
		    }
		    return res;
	    }
	}