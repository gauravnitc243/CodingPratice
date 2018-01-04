package com.interviewbit.stackqueues;

import java.util.Stack;

public class SimplifyDirectoryPath
{

	public static void main(String[] args)
	{
		/*System.out.println(simplifyPath("/./.././ykt/xhp/nka/eyo/blr/emm/xxm/fuv/bjg/./qbd/./../pir/dhu/./../../wrm/grm/ach/jsy/dic/ggz/smq/mhl/./../yte/hou/ucd/vnn/fpf/cnb/ouf/hqq/upz/akr/./pzo/../llb/./tud/olc/zns/fiv/./eeu/fex/rhi/pnm/../../kke/./eng/bow/uvz/jmz/hwb/./././ids/dwj/aqu/erf/./koz/.."));
		System.out.println(simplifyPath("/../"));
		System.out.println(simplifyPath("/home/"));
		System.out.println(simplifyPath("/a/./b/../../c/"));
		System.out.println(simplifyPath("/home//foo/"));*/
		System.out.println(simplifyPath("/."));

	}
	
	public static String simplifyPath(String a) 
	{
	    Stack<String> stack = new Stack<>();
	    int start;
	    int n = a.length();
	    String str;
	    
	    for (int i = 0; i < n;) 
	    {
	       while (i < n && a.charAt(i) == '/')
	           i++;
	       start = i;
	       if (i >= n)
	           break;
	       while (i < n && a.charAt(i) != '/')
	       {
	           i++;
	       }
	       str = a.substring(start, i);
	       if (str.equalsIgnoreCase("..")) {
	            if (!stack.isEmpty())
	               stack.pop();
	       } else if (!str.equalsIgnoreCase(".")) {
	           stack.push(str);
	       }
	    }
	    String res = "";
	    if (stack.isEmpty())
	        res = "/";
	    while (!stack.isEmpty()) {
	        res = "/" + stack.pop() + res;
	    }
	    return res;
	}
}
