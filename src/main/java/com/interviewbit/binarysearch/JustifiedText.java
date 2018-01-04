package com.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class JustifiedText
{

	public static void main(String[] args)
	{
		JustifiedText j = new JustifiedText();
		 ArrayList<String> out = j.fullJustify(new ArrayList<String>(Arrays.asList("This", "is", "an", "example", "of", "text", "justification.")), 16);
		
		for(String i : out)
		{
			System.out.println(i);
		}

	}
	
	public ArrayList<String> fullJustify(ArrayList<String> a, int b)
	{
	    ArrayList<String> list=new ArrayList<String>();
	    for(int i=0,w;i<a.size();i=w)
	    {
	        int l=-1;
	        for(w=i;w<a.size()&&a.get(w).length()+1+l<=b;w++)
	            l+=a.get(w).length()+1;
	        StringBuilder sb=new StringBuilder(a.get(i));
	        int spaces=1,extra=0;
	        if(w!=i+1&&w!=a.size()){
	            spaces=(b-l)/(w-i-1)+1;
	            extra=(b-l)%(w-i-1);
	        }
	        for(int j=i+1;j<w;j++){
	            for(int s=0;s<spaces;s++)  
	                sb.append(' ');
	            if(extra-->0)
	                sb.append(' ');
	            sb.append(a.get(j));
	        }
	        int remaining=b-sb.length();
	        while(remaining-->0)sb.append(' ');
	        list.add(sb.toString());
	    }
	    return list;
	}
     
    
}