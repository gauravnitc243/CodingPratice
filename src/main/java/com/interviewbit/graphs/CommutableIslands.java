package com.interviewbit.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CommutableIslands {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 2, 1));
		ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(2, 3, 4));
		ArrayList<Integer> c = new ArrayList<Integer>(Arrays.asList(1, 4, 3));
		ArrayList<Integer> d = new ArrayList<Integer>(Arrays.asList(4, 3, 2));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(1, 3, 10));

		ArrayList<ArrayList<Integer>> t = new ArrayList<ArrayList<Integer>>();
		t.add(e);
		t.add(b);
		t.add(c);
		t.add(d);
		t.add(a);
		System.out.println(new CommutableIslands().solve(4, t));

	}
	

	private class Edge implements Comparable<Edge> {
		int v;
		int w;
		Integer weight;

		public Edge(int v, int w, int weight) {
			this.v = v;
			this.w = w;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return weight.compareTo(o.weight);
		}
	}

	public int solve(int A, ArrayList<ArrayList<Integer>> B) {
		boolean[][] isTraversed = new boolean[A + 1][A + 1];
		ArrayList<Edge> result = new ArrayList<>();
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (ArrayList<Integer> a : B) {
			pq.add(new Edge(a.get(0), a.get(1), a.get(2)));
		}
		while (result.size() < A - 1) {
			Edge t = pq.poll();
			if (isTraversed[t.v][t.w])
				continue;
			else {
				result.add(t);
				isTraversed[t.v][t.w] = true;
			}
		}
		int sum = 0;
		for (Edge e : result)
			sum += e.weight;
		return sum;
	}

}
