package com.princeton;

import java.util.NoSuchElementException;


public class SymbolTableBT<Key extends Comparable<Key>,Value>{
	private Node root = null;
	
	private class Node{
		private Key key;
		private Value value;
		private Node leftChild ;
		private Node rightChild;
		private int N;
		
		private Node(Key key,Value value,int N){
			this.key = key;
			this.value = value;
			this.N =N;
		}
	}

	public SymbolTableBT(){}
	
	private boolean isEmpty()
	{
		return size(root)==0;
	}
	
	private int size(Node x){
		if(x==null) return 0;
		return x.N;
	}
	
	public boolean contains(Key key)
	{
		if(root == null) throw new NullPointerException("No element in the ST");
		return get(key)!=null;
	}
	
	public Value get(Key key){
		return get(root,key);
	}
	
	private Value get(Node x , Key key)
	{
		if(x==null)
			return null;
		int cmp = key.compareTo(x.key);
		if(cmp > 0)
			return get(x.rightChild,key);
		else if(cmp < 0)
			return get(x.leftChild,key);
		else
			return x.value;
	}
	
	public void put(Key key,Value value)
	{
		if (key == null) throw new NullPointerException("first argument to put() is null");
        if (value == null) {
         //   delete(key);
            return;
        }
        root = put(root,key,value);
	}
	
	/*public void delete(Key key){
		if(root==null) throw new NoSuchElementException("ST Underflow");
		else
			root = delete
	}*/
	
	public void inorder(){
		if(root==null) throw new NoSuchElementException("ST Underflow");
		else
		inorder(root);
	}
	
	private void inorder(Node node){
		if(node == null) return;
		inorder(node.leftChild);
		System.out.println(node.key);
		inorder(node.rightChild);
	}
	
	private Key floorValue(Key key)
	{
		if (key == null) throw new NullPointerException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("called floor() with empty symbol table");
        Node x = floorValue(root,key);
        if(x==null) return null;
        else
        	return x.key;
	}
	
	public Node floorValue(Node node,Key key)
	{
		if(node==null)
			return null;
		int cmp = key.compareTo(node.key);
		if(cmp<0) return floorValue(node.leftChild,key);
		else if (cmp==0) return node;
		Node temp = floorValue(node.rightChild,key);
		if(temp!=null)
			return temp;
		else
			return node;
	}
	
	public Value minValue()
	{
		if(root==null) throw new NoSuchElementException("ST Underflow");
		else return minValue(root).value;
	}
	
	private Node minValue(Node node)
	{
		if(node.leftChild==null)
			return node;
		else
			return minValue(node.leftChild);
	}
	private Node put(Node node,Key key,Value value)
	{
		if(node==null) return new Node(key,value,1);
		int cmp = key.compareTo(node.key);
		if(cmp<0) node.leftChild =  put(node.leftChild,key,value);
		else if (cmp > 0) node.rightChild =  put(node.rightChild,key,value);
		else node.value = value;
		node.N = 1+size(node.leftChild)+size(node.rightChild);
		return node;
	}
	
	public void deleteMin(){
		if(root==null) throw new NoSuchElementException("Symbol table underflow");
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node node)
	{
		if(node.leftChild==null)
			return node.rightChild;
		else
			node.leftChild = deleteMin(node.leftChild);
		node.N = size(node.leftChild)+size(node.rightChild)+1;
		return node;
	}
	
	public boolean less(Comparable x,Comparable y){
		if(x.compareTo(y) < 0) return true;
		return false;
	}
	
	public void delete(Key key)
	{
		if(key==null) throw new NoSuchElementException("ST underflow");
		root = delete(root,key);
	}
	
	private Node delete(Node node,Key key)
	{
		if(node==null) return null;
		int cmp = key.compareTo(node.key);
		if(cmp < 0) node.leftChild = delete(node.leftChild,key);
		else if(cmp > 0) node.rightChild = delete(node.rightChild,key);
		else
		{
			if(node.rightChild==null)
				return node.leftChild;
			if(node.leftChild==null)
				return node.rightChild;
			Node t = node;
			node = minValue(t.rightChild);
			node.rightChild = deleteMin(t.rightChild);
			node.leftChild = t.leftChild;
		}
		node.N = size(node.leftChild) + size(node.rightChild) + 1;
        return node;
	}
		
	
	
	public static void main(String[] args) {

		SymbolTableBT<Integer, String> st = new SymbolTableBT();
		st.put(30,"");
		st.put(45,"");
		st.put(34,"");
		st.put(29,"");
		st.put(14,"");
		st.put(18,"");
		st.put(23,"");
		st.inorder();
		System.out.println(st.floorValue(20));
	}
}
