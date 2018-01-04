package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrdertraversalBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Pair {
		TreeNode t;
		int x;
		Pair(TreeNode t, int x) {
			this.t = t;
			this.x = x;
		}
	}

	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (A == null)
			return result;
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(A, 0));
		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			int v = p.t.val;
			int x = p.x;
			if (map.containsKey(x)) {
				map.get(x).add(v);
			} else {
				ArrayList<Integer> ar = new ArrayList<Integer>();
				ar.add(v);
				map.put(x, ar);
			}
			if (p.t.left != null) {
				queue.add(new Pair(p.t.left, x - 1));
			}
			if (p.t.right != null) {
				queue.add(new Pair(p.t.right, x + 1));
			}
		}
		for (int x : map.keySet())
			result.add(map.get(x));
		return result;
	}

}
