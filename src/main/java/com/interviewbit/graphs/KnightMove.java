package com.interviewbit.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class KnightMove
{
	 private static final int dx[] = new int[] {-2, -2, 1, -1, 2, 2, 1, -1};
	 private static final int dy[] = new int[] {1, -1, 2, 2, 1, -1, -2, -2};
	 public static void main(String[] args)
	 {
		KnightMove k = new KnightMove();
		System.out.println(k.knight(8 ,8, 1, 1, 8 ,8));
	 }
	
public int knight(int N, int M, int x1, int y1, int x2, int y2)
{
	    Queue<Node> queue = new LinkedList<>();
	    Node node = new Node(x1, y1);
	    HashSet<Node> marked = new HashSet<>();
	    queue.add(node);
	    queue.add(null);
	    int level = 0;
	    marked.add(node);
	    while (!queue.isEmpty()) 
	    {
	        Node n = queue.remove();
	        if (n == null) 
	        {
	            level++;
	            if (!queue.isEmpty()) 
	            {
	                queue.add(null);
	            }
	            continue;
	        }
	        
	        if (n.x == x2 && n.y == y2)
	            return level;
	        
	        for (int k = 0; k < 8; k++) 
	        {
	            int x = n.x + dx[k];
	            int y = n.y + dy[k];
	            if (isValid(x, y, N, M)) 
	            {
	                Node nn = new Node(x, y);
	                if (!marked.contains(nn)) 
	                {
	                    marked.add(nn);
	                    queue.add(nn);
	                }
	            }
	        }
	    }
	    return -1;
	}
	
	public boolean isValid(int x, int y, int N, int M) {
	    if (x < 1 || x > N || y < 1 || y > M)
	        return false;
	    
	    return true;
	}
	
	class Node {
	    int x, y;
	    public Node(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}
	

	
	/*public boolean isValid(int x , int y , int[][] sol,int N,int M){
		return (x>=0 && x< N && y >=0 && y<M && sol[x][y]==-1);
	}*/

}
