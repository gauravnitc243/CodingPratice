
package com.hackerrank.tree;

public class HuffManDecoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Node{
	    int freq;
	    char data;
	    Node  left;
	    Node  right;

	}
	
	void decode(String S ,Node root)
    {
        if(S.length()==0)
        	return;
        Node h = root;
        for(int i =0;i<S.length();i++){
        	char c = S.charAt(i);
        	if(c=='0')
        		h = h.left;
        	else if(c=='1')
        		h = h.right;
        	if(h.left==null && h.right==null){
        		System.out.print(h.data);
        		h = root;
        	}
        }
       
    }

}
