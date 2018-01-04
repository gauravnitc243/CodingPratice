package com.hackerrank.tree;

public class IsBST {
    class Node {
        int data;
        Node left;
        Node right;
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	boolean checkBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	
	boolean isBST(Node node, int l, int h){
		if(node==null)
			return true;
		if(node.data>l && node.data<h && isBST(node.left, l, node.data) && isBST(node.right, node.data, h))
			return true;
		else
			return false;
	}

}
