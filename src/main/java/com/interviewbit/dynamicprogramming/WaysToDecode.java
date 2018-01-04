package com.interviewbit.dynamicprogramming;

public class WaysToDecode
{

	public static void main(String[] args)
	{
		System.out.println(numDecodings("2611055971756562"));

	}
	//2611055971756562
	static int numDecodings(String a) {
	    if(a==null||a.length()==0||a.equals("0"))
	        return 0;
	    int[] t = new int[a.length()+1];
	    t[0] = 1;
	    if(isValid(a.substring(0,1)))
	        t[1]=1;
	    else
	        t[1]=0;
	    for(int i=2; i<=a.length(); i++){
	        if(isValid(a.substring(i-1,i))){
	            t[i]+=t[i-1];
	        }
	        if(isValid(a.substring(i-2,i))){
	            t[i]+=t[i-2];
	        }
	    }
	    return t[a.length()];
	}
	public static boolean isValid(String s){
		//System.out.println(s);
	    if(s.charAt(0)=='0')
	        return false;
	    int value = Integer.parseInt(s);
	    return value>=1&&value<=26;
	}
}
