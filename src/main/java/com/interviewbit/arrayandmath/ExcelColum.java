package com.interviewbit.arrayandmath;

public class ExcelColum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(titleToNumber("AA"));

	}
	
	public static int titleToNumber(String a) {
	    if(a==null || a.length() == 0)
	    {
	    	return 0;
	    }
	    int result = 0;
	    int i = a.length()-1;
	    int t = 0;
	    while(i >= 0){
	        char curr = a.charAt(i);
	        result = result + (int) Math.pow(26, t) * (curr-'A'+1);
	        t++;
	        i--;
	    }
	 
	    return result;}
}
