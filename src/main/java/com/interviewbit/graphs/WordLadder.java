package com.interviewbit.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder
{
	 class Sequence
	 {
		 List<String> path ;
		 int length;
		 private String lastWord; 
		 public Sequence(List<String> path, int length, String lastWord) 
		 {
			 this.path=path;
			 this.length=length;
			 this.lastWord=lastWord;
		 }
		 public List<String> getPath() 
		 {
			  return path;
		 }
		 public String getLastWord() 
		 {
			  return lastWord;
		 }
		 public int getLength() 
		 {
			  return length;
		}
	}

	public static void main(String[] args)
	{
		WordLadder w = new WordLadder();
		ArrayList<String> set = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
		System.out.println(w.ladderLength("hit", "cog", set));
	}
	public int ladderLength(String start, String end, ArrayList<String> dictV) 
	{
			  dictV.add(start);
			  dictV.add(end);
			  List<String> path = new LinkedList<String>();
			  path.add(start);
			  Queue<Sequence> queue = new LinkedList<Sequence>(); 
			  queue.add(new Sequence(path, 1, start));
			  dictV.remove(start);
			  while(!queue.isEmpty())
			  {
				  Sequence currSeq = queue.remove();
				  if(end.equals(currSeq.getLastWord()))
					  return currSeq.length;
				  Iterator<String> i = dictV.iterator();
				  while (i.hasNext()) 
				  {
					  String string = i.next(); 
					  if(isWordsWithOneDiff(string, currSeq.getLastWord()))
					  {
						  List<String> list = new LinkedList<String>(currSeq.getPath());
						  list.add(string);
						  queue.add(new Sequence(list, currSeq.getLength()+1, string));
						  i.remove();
					  }
				  }
			  }
		    
		   if(!queue.isEmpty())
			   return queue.peek().length;
		  return 0;
		 }
	
	public boolean isWordsWithOneDiff(String first,String second)
	{
		if(second.length()!=first.length())
				return false;
		int count = 0;
		for(int i =0;i<first.length();i++)
		{
				if(first.charAt(i)!=second.charAt(i))
					count++;
		}
		return count==1?true:false;
	}
	

}
