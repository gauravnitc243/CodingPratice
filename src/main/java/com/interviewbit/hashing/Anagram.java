package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram
{
	public static void main(String[] args)
	{
		System.out.println(anagrams(new ArrayList<String>(Arrays.asList("abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa", "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb"))));
		System.out.println(anagrams(new ArrayList<String>(Arrays.asList("caat", "taac", "dog", "god", "acta" ))));

	}
	public static ArrayList<ArrayList<Integer>> anagrams(final List<String> a) 
	{
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<a.size();i++)
			res.add(new ArrayList<Integer>(Arrays.asList(i+1)));
		ArrayList<String> input = new ArrayList<String>();
		for(int i =0;i<a.size();i++)
		{
			char[] tmp = a.get(i).toCharArray();
			Arrays.sort(tmp);
			input.add(new String(tmp));
		}
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int t=0;
		for(int i =0;i<input.size();i++)
		{
			if(map.containsKey(input.get(i)))
			{
				res.get(map.get(input.get(i))).add(i+1);
				res.remove(i-t);
				t++;
			}
			else
				map.put(input.get(i),i-t);
		}
		
		return res;
	}

}
