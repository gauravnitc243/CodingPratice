package com.interviewbit.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder2 {

	public static void main(String[] args)
	{
		WordLadder2 w = new WordLadder2();
		ArrayList<String> set = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
		System.out.println(w.findLadders("hit", "cog", set));
	}
	public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) 
	{
		ArrayList<ArrayList<String>> ladders = new ArrayList<ArrayList<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        dict.add(start);
        dict.add(end);
        bfs(map, distance, start, end, dict);
        List<String> path = new ArrayList<String>();
        dfs(ladders, path, end, start, distance, map);
        return ladders;
    }
	void dfs(ArrayList<ArrayList<String>>  ladders, List<String> path, String crt,String start, Map<String, Integer> distance,Map<String, List<String>> map) {
        path.add(crt);
        if (crt.equals(start)) 
        {
            Collections.reverse(path);
            ladders.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } 
        else 
        {
            for (String next : map.get(crt)) {
                if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) { 
                    dfs(ladders, path, next, start, distance, map);
                }
            }           
        }
        path.remove(path.size() - 1);
    }

    void bfs(Map<String, List<String>> map, Map<String, Integer> distance,String start, String end, ArrayList<String> dict) 
    {
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        distance.put(start, 0);
        for (String s : dict) 
            map.put(s, new ArrayList<String>());
        while (!q.isEmpty()) 
        {
            String crt = q.poll();
            List<String> nextList = expand(crt, dict);
            for (String next : nextList) {
                map.get(next).add(crt);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(crt) + 1);
                    q.offer(next);
                }
            }
        }
    }

    List<String> expand(String crt, ArrayList<String> dict)
    {
        List<String> expansion = new ArrayList<String>();
        for (int i = 0; i < crt.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != crt.charAt(i)) {
                    String expanded = crt.substring(0, i) + ch
                            + crt.substring(i + 1);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }
        return expansion;
    }
	

}