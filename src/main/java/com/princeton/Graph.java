package com.princeton;

import java.util.ArrayList;

public class Graph {
	
	private ArrayList<Integer>[] adj ;
	private final int V;
	private int  E;
	
	public Graph(int v)
	{
		this.V = v;
		this.E = 0;
		adj = (ArrayList<Integer>[])new ArrayList[v];
		for(int i =0 ;i<v;i++)
			adj[i] = new ArrayList<Integer>();
	}

	public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }
	public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }
	 public Iterable<Integer> adj(int v) {
	        validateVertex(v);
	        return adj[v];
	    }
	 private void validateVertex(int v) {
	        if (v < 0 || v >= V)
	            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
	    }
	 public int V() {
	        return V;
	    }
	    public int E() {
	        return E;
	    }

}
