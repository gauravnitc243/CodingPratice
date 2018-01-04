package com.interviewbit.strings;

import java.util.ArrayList;

public class PreetyJson
{

	public static void main(String[] args)
	{
//		ArrayList<String> res = prettyJSON("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}");
		ArrayList<String> res = prettyJSON("[\"foo\",{\"bar\":[\"baz\",null,1.0,2]}]");
		for(String a:res)
			System.out.println(a);
	}
	
	public static ArrayList<String> prettyJSON(String a) 
	{
		ArrayList<StringBuilder> result = new ArrayList<StringBuilder>();
		ArrayList<String> ret = new ArrayList<String>();
		int currentIndent = 0;
		for(int i =0;i<a.length();i++)
		{
			if(a.charAt(i)=='{')
			{
				int k = currentIndent;
				result.add(new StringBuilder());
				while(k-->0)
				{
					result.get(result.size()-1).append("\t");
				}
				result.get(result.size()-1).append("{");
				result.add(new StringBuilder());
				currentIndent++;
				
			}
			else if(a.charAt(i)=='[')
			{
				int k = currentIndent;
				result.add(new StringBuilder());
				while(k-->0)
				{
					result.get(result.size()-1).append("\t");
				}
				result.get(result.size()-1).append("[");
				result.add(new StringBuilder());
				currentIndent++;
				
			}
			else if(a.charAt(i)==']')
			{
				int k = --currentIndent;
				result.add(new StringBuilder());
				while(k-->0)
				{
					result.get(result.size()-1).append("\t");
				}
				result.get(result.size()-1).append("]");
			}
			else if(a.charAt(i)=='}')
			{
				int k = --currentIndent;
				result.add(new StringBuilder());
				while(k-->0)
				{
					result.get(result.size()-1).append("\t");
				}
				result.get(result.size()-1).append("}");
			}
			else if(a.charAt(i)==',')
			{
				result.get(result.size()-1).append(',');
				result.add(new StringBuilder());
			}
			else
			{
				if(result.get(result.size()-1).length()==0)
				{
					int k = currentIndent;
					while(k-->0)
					{
						result.get(result.size()-1).append("\t");
					}
				}
				result.get(result.size()-1).append(a.charAt(i));
			}
		}
		
		for(int i = 0;i<result.size();i++)
		{
			if((result.get(i)).toString().trim().equals(""))
				continue;
			ret.add((result.get(i)).toString());
		}
		return ret;
	}

}
