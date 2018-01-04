package com.hackerrank.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SwapNodes {

/*	private static class Node{
		int data;
		Node left;
		Node right;
	}

	public static void Inorder(Node node){
		if (node == null){
	        return;
	    }
	    Inorder(node.left);
	    if (node.data != -1){
	    	System.out.print(node.data+" ");
	    }
	    Inorder(node.right);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int nodecount = Integer.parseInt(reader.readLine());
		Node[] nodes = new Node[nodecount];
		nodes[0] = new Node();
		nodes[0].data = 1;
		Map<Node, Integer> depth = new HashMap<Node, Integer>();
		Map<Integer, List<Node>> lookup = new HashMap<Integer, List<Node>>();
		depth.put(nodes[0], 1);
        lookup.put(1, new ArrayList<Node>());
		lookup.get(1).add(nodes[0]);
		for (int i = 0; i < nodecount; i++){
			int currDepth = depth.get(nodes[i]);
			String[] split = reader.readLine().split(" ");
			Node left = new Node(), right = new Node();
			left.data = Integer.parseInt(split[0]);
			right.data = Integer.parseInt(split[1]);
			if (left.data != -1 ){
				nodes[i].left = left;
				nodes[left.data-1] = left;
				depth.put(left, currDepth + 1);
				if (lookup.get(currDepth+1) == null){
					lookup.put(currDepth+1, new ArrayList<Node>());
				}
				lookup.get(currDepth+1).add(left);
			}
			if (right.data != -1){
				nodes[i].right = right;	
				nodes[right.data-1] = right;
				depth.put(right, currDepth + 1);
				if (lookup.get(currDepth+1) == null){
					lookup.put(currDepth+1, new ArrayList<Node>());
				}
				lookup.get(currDepth+1).add(right);
			}			
		}
		int swaps = Integer.parseInt(reader.readLine());
		for (int i = 0; i < swaps; i++){
			int k = Integer.parseInt(reader.readLine());
			for (int j = 1; lookup.get(j*k) != null; j++){
				for (Node b : lookup.get(j*k)){
					Node c = b.left;
					b.left = b.right;
					b.right = c;
				}
			}
			Inorder(nodes[0]);
			System.out.println();
		}
	}*/

	static class Node {
		int data;
		Node left;
		Node right;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Node root = new Node();
		root.data = 1;
		Node h = root;
		Queue<Node> q = new LinkedList<Node>();
		q.add(h);
		while (n > 0 && !q.isEmpty()) {
			Node t = q.remove();
			int a = scan.nextInt();
			int b = scan.nextInt();
			if (a != -1) {
				Node l = new Node();
				l.data = a;
				t.left = l;
				q.add(l);
			}
			if (b != -1) {
				Node r = new Node();
				r.data = b;
				t.right = r;
				q.add(r);
			}
			n--;
		}

		n = scan.nextInt();
		int depth = depth(root);
		while (n > 0) {
			int d = scan.nextInt();
			int k = 1;
			while (d < depth) {
				d *= k;
				swapNodes(root, d, 1);
				k++;
			}
			printInorder(root);
			System.out.println();
		}
		scan.close();
	}
	public static void swapNodes(Node root, int d, int currDepth) {
		if (root == null)
			return;
		else if (currDepth == d) {
			Node t = root.right;
			root.right = root.left;
			root.left = t;
			return;
		}
		swapNodes(root.left, d, currDepth + 1);
		swapNodes(root.right, d, currDepth + 1);
	}

	public static void printInorder(Node root) {
		if (root == null)
			return;
		else {
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}

	}

	public static int depth(Node root) {
		if (root == null)
			return 0;
		else
			return 1 + Math.max(depth(root.left), depth(root.right));
	}

}
