package com.interviewbit.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GraphClone
{
	class UndirectedGraphNode 
	{
	      int label;
	      List<UndirectedGraphNode> neighbors;
	      UndirectedGraphNode(int x) 
	      {
	    	  label = x; 
	    	  neighbors = new ArrayList<UndirectedGraphNode>(); 
	      }
	};

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) 
	  {
	        if(node == null)
	            return null;
	        LinkedList<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
	        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
	        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
	        map.put(node, head);
	        q.add(node);
	        while(!q.isEmpty())
	        {
	            UndirectedGraphNode currentNode = q.pop();
	            List<UndirectedGraphNode> currentNodeNeighbors = currentNode.neighbors; 
	            for(UndirectedGraphNode neighbor: currentNodeNeighbors)
	            {
	                if(!map.containsKey(neighbor))
	                {
	                    UndirectedGraphNode copy = new UndirectedGraphNode(neighbor.label);
	                    map.put(neighbor,copy);
	                    map.get(currentNode).neighbors.add(copy);
	                    q.add(neighbor);
	                }
	                else
	                    map.get(currentNode).neighbors.add(map.get(neighbor));
	            }
	 
	         }
	        return head;
	    }

}
