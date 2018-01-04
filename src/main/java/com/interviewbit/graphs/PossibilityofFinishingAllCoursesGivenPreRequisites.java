package com.interviewbit.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class PossibilityofFinishingAllCoursesGivenPreRequisites {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 2));
		ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(2, 3));
		System.out.println(new PossibilityofFinishingAllCoursesGivenPreRequisites().solve(3, a, b));
	}

	public boolean solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
		boolean[] visited = new boolean[A + 1];
		boolean[] recStack = new boolean[A + 1];
		ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[A + 1];
		for (int i = 0; i <= A; i++)
			adj[i] = new ArrayList<Integer>();

		for (int i = 0; i < B.size(); i++) {
			adj[B.get(i)].add(C.get(i));
		}
		for (int i = 0; i < A; i++)
			if (isCyclicUtil(i, visited, recStack, adj))
				return true;
		return false;
	}

	public boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack, ArrayList<Integer>[] adj) {
		if (visited[v] == false) {
			visited[v] = true;
			recStack[v] = true;
			for (int i : adj[v]) {
				if (!visited[i] && isCyclicUtil(i, visited, recStack, adj))
					return true;
				else if (recStack[i])
					return true;
			}
		}
		recStack[v] = false;
		return false;
	}
}
