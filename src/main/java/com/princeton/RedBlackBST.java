package com.princeton;

public class RedBlackBST<Key extends Comparable<Key>,Value> {
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root;
	private class Node{
		private Key key;
		private Value value;
		private Node leftChild;
		private Node rightChild;
		private boolean colour;
		private int N;
		
		public Node(Key key , Value value, boolean colour, int N){
			this.key = key;
			this.value = value;
			this.colour = colour;
			this.N = N;
		}
	}
	
	public Value get(Key key){
		if(key==null) throw new NullPointerException("Key is null");
		else 
			return get(root,key);
	}
	
	private Value get(Node x, Key key)
	{
		if(x==null) return null;
		int cmp;
		while(x!=null)
		{
		    cmp = key.compareTo(x.key);
			if(cmp<0) x = x.leftChild;
			else if (cmp>0) x =  x.rightChild;
			else return x.value;
		}
		return null;
	}
	
	private Node rotateLeft(Node h){
		Node x = h.rightChild;
		h.rightChild = x.leftChild;
		x.leftChild = h;
		x.colour = x.leftChild.colour;
		x.leftChild.colour = RED;
		x.N = h.N;
	    h.N = size(h.leftChild) + size(h.rightChild) + 1;
	    return x;
	}
	
	private Node rotateRight(Node h) {
        Node x = h.leftChild;
        h.leftChild = x.rightChild;
        x.rightChild = h;
        x.colour = x.rightChild.colour;
        x.rightChild.colour = RED;
        x.N = h.N;
        h.N = size(h.leftChild) + size(h.rightChild) + 1;
        return x;
    }
	
	private void flipColours(Node h)
	{
		h.colour = !h.colour;
		h.leftChild.colour = !h.leftChild.colour;
		h.rightChild.colour = !h.rightChild.colour;
	}
	
	public void put(Key key,Value value)
	{
		if(key == null) throw new NullPointerException("first argument to put() is null");
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root,key,value);
        root.colour = BLACK;
	}
	
	private Node put(Node h,Key key,Value value)
	{
		 if (h == null) return new Node(key, value, RED, 1);
		 int cmp = key.compareTo(h.key);
		 if(cmp < 0)
			  h.leftChild = put(h.leftChild,key,value);
		 else if(cmp >0)
			 h.rightChild = put(h.rightChild,key,value);
		 else
			 h.value = value;
		 
		 if(isRed(h.rightChild) && !isRed(h.leftChild))
			 h = rotateLeft(h);
		 if(isRed(h.leftChild) && isRed(h.leftChild.leftChild))
			 h = rotateRight(h);
		 if(isRed(h.leftChild) && isRed(h.rightChild))
			  flipColours(h);
		 
		 h.N = size(h.leftChild) + size(h.rightChild) +1;
		 return h;
	}
	
	
	public void delete(Key key)
	{
		
	}
	
	private boolean isRed(Node x)
	{
		if(x==null) 
			return false;
		else
			return x.colour==RED;
	}
	
	 private int size(Node x) {
	        if (x == null) return 0;
	        return x.N;
	    } 
	 
	 public int size() {
	        return size(root);
	    }

	    public boolean isEmpty() {
	        return root == null;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
