package com.interviewbit.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class LargestDistanceBetweenNodesofATree {
    static int result = 0;
    static int node = 0;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
    	visited = new boolean[n];
		adj = new ArrayList[n];
		for(int i = 0; i < n; i++){
			adj[i] = new ArrayList<Integer>();
		}
    	for(int i=0; i<n; i++){
    	    int par = A.get(i);
    		if(par != -1){
    			adj[i].add(par);
    			adj[par].add(i);
    		}
    	}
    	dfs(0 , 0);
    	Arrays.fill(visited, false);
    	result = 0;
    	dfs(node , 0);
    	return result;
    }
    
    public  void dfs(int root , int d){
    	visited[root] = true;
    	if(d>result){ 
    	    result=d;
    	    node=root;
    	}
    	for(Integer node: adj[root]){
    		if(!visited[node]){
    			dfs(node , d+1);
    		}
    	}
    }
}
