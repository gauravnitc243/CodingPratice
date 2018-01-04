package com.hackerrank.tree;

public class LCM {
	class Node{
	    int freq;
	    char data;
	    Node  left;
	    Node  right;

	}

 Node lca(Node root,int v1,int v2)
    {
	 
	 if(root==null)
		 return root;
	 if(root.data==v1 && root.data==v2)
		 return root;
	 Node left = lca(root.left,v1,v2);
	 Node right = lca(root.right,v1,v2);
	 if(left!=null && right !=null)
		 return root;
	 if(left==null)
		 return right;
	 else
		 return left;
    }

	public static void main(String[] args) {
      
	}

}
