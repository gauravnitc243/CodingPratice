package com.interviewbit.tree;/*package com.interviewbit.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class ShortestUniquePrefix
{
	public static void main(String[] args)
	{
		prefix(new ArrayList<>(Arrays.asList("zebra", "dog", "duck", "dove")));
	}

	public static class TriePrefix 
	{
	    private Node root;
	    private class Node
	    {
	        private int count;
	        private boolean isEnd;
	        private Node next[] = new Node[256];
	        public Node()
	        {
	            count = 0;
	            isEnd = false;
	        }
	        public Node(int count, boolean isEnd)
	        {
	            this.count = count;
	            this.isEnd = isEnd;
	        }
	    }
	    
	    public void insertIntoTrie(String str)
	    {
	    	if(root == null)
	    		root = new Node();
	    	Node currentNode = root;
	    	for(int i =0;i<str.length();i++)
	    	{
	    		int c = str.charAt(i);
	    		if(currentNode.next[c]==null)
	    			currentNode.next[c]= new Node(1, false);
	    		else
	    			currentNode.next[c].count++;
	    		currentNode = currentNode.next[c];
	    	}
	    	currentNode.isEnd = false;
	    }
	    
	    public String shortestPrefix(String str)
	    {
	    	Node currentNode = root;
	    	int len = 0;
	    	for(int i =0;i<str.length();i++)
	    	{
	    		int c = str.charAt(i);
	    		currentNode = currentNode.next[c];
	    		len ++;
	    		if(currentNode==null || currentNode.count==1)
	    			break;
	    	}
	    	return str.substring(0,len);
	    }
	}
	public static ArrayList<String> prefix(ArrayList<String> a)
	{
		 TriePrefix trie = new TriePrefix();
		 ArrayList<String> result = new ArrayList<String>();
	     for(String word : a)
	         trie.insertIntoTrie(word);
	     String[] res = new String[a.size()];
	     for(int i = 0; i < a.size(); i++)
	     {
            res[i] = trie.shortestPrefix(a.get(i));
            result.add(res[i]);
	     }
	     return result;
	}

}
*/