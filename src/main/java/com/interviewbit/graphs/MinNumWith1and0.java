package com.interviewbit.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MinNumWith1and0
{
    private static class Node 
    {
        public final boolean isDigitOne;
        public final int val;
        public final Node parent;
        public Node(boolean isDigitOne, int val, Node parent) {
            this.isDigitOne = isDigitOne;
            this.val = val;
            this.parent = parent;
        }
    }
    

    public static String multiple(int A) {
        if (A <= 0) 
        	return "";
        String result = "0";
        if (A > 0) 
        {
            boolean[] isVisited = new boolean[A];
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(new Node(true, 1%A, null));
            isVisited[1%A] = true;
            Node resultNode = null;
            while (!queue.isEmpty()) 
            {
                Node currNode = queue.remove();
                if (currNode.val == 0)
                {
                    resultNode = currNode;
                    break;
                } 
                else
                {
                    int val1 = (currNode.val * 10) % A;
                    if (!isVisited[val1]) 
                    {
                        queue.add(new Node(false, val1, currNode));
                        isVisited[val1] = true;
                    }
                    int val2 = (val1 + 1) % A;
                    if (!isVisited[val2]) {
                        queue.add(new Node(true, val2, currNode));
                        isVisited[val2] = true;
                    }
                }
            }
            if (resultNode == null) 
            	return "";
            else 
            {
                StringBuilder sb = new StringBuilder();
                Node currNode = resultNode;
                while (currNode != null) 
                {
                    sb.append(currNode.isDigitOne ? '1' : '0');
                    currNode = currNode.parent;
                }
                result = sb.reverse().toString();
            }
        }
        return result;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(multiple(28));
	}

}
