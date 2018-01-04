package com.princeton;

public class BreadthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private int s; // source vertex
	
	public BreadthFirstPaths(Graph G, int s) {
		this.s = s;
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		bfs(G, s);
	}
	
	private  void bfs(Graph G,int s)
	{
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(s);
		marked[s] = true;
		while(!q.isEmpty())
		{
			int v = q.dequeue();
			if(!marked[v])
			{
				for(int k : G.adj(v))
				{
					q.enqueue(k);
					marked[k] = true;
					edgeTo[k] = v;	
				}
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
