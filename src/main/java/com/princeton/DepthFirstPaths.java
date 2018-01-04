package com.princeton;

public class DepthFirstPaths {

	private boolean[] marked;
	private int[] edgeTo;
	private int s; // source vertex

	public DepthFirstPaths(Graph G, int s) {
		this.s = s;
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	private void dfs(Graph G, int s) {
		marked[s] = true;
		for (int w : G.adj(s)) {
			if (!marked[w]) {
				edgeTo[w] = s;
				dfs(G, w);
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return (Iterable<Integer>) path;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
