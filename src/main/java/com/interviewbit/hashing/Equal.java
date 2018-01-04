package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Equal
{

	static class Pair
    {
        int first, second;
        Pair(int f,int s)
        {
            first = f; second = s;
        }
    };
    static class listComparator implements Comparator<ArrayList<Integer>>
    {
        public int compare(ArrayList<Integer> c1, ArrayList<Integer> c2)
        {
        	int i = c1.get(0).compareTo(c2.get(0));
            if(i!=0)
            	return i;
            else
            {
            	i = c1.get(1).compareTo(c2.get(1));
            }
            if(i!=0)
            	return i;
            else
            {
            	i = c1.get(2).compareTo(c2.get(2));
            }
            if(i!=0)
            	return i;
            else
            	return c1.get(3).compareTo(c2.get(3));
        }
    }
	public static void main(String[] args)
	{
		System.out.println(equal(new ArrayList<Integer>(Arrays.asList( 1, 1, 1, 1, 1))));

	}
	
	public static ArrayList<Integer> equal(ArrayList<Integer> a) 
	{
        HashMap<Integer,Pair> map = new HashMap<Integer,Pair>();
        ArrayList<ArrayList<Integer>> allRes = new ArrayList<ArrayList<Integer>>();
        int n=a.size();
        for (int i=0; i<n; ++i)	
        {
            for (int j=i+1; j<n; ++j)
            {
            	int sum = a.get(i)+a.get(j);
            	if(!map.containsKey(sum))
            	{
            		map.put(sum, new Pair(i,j));
            	}
            	else if((i!=map.get(sum).first && i!=map.get(sum).second) && (j!=map.get(sum).first && j!=map.get(sum).second))
            	{
            		ArrayList<Integer> res = new ArrayList<Integer>();
            		res.add(map.get(sum).first);
            		res.add(map.get(sum).second);
            		res.add(i);
            		res.add(j);
            		allRes.add(res);
            	}
            }
        }
        Collections.sort(allRes,new listComparator());
        return allRes.get(0);
        
       
    }

}
