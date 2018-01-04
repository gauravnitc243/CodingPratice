package com.interviewbit.binarysearch;

public class MultiplyStrings
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(multiply("125", "25"));

	}

	public static String multiply(String a, String b) {
	    String n1 = new StringBuilder(a).reverse().toString();
	    String n2 = new StringBuilder(b).reverse().toString();
	 
	    int[] d = new int[a.length()+b.length()];
	 
	    for(int i=0; i<n1.length(); i++){
	        for(int j=0; j<n2.length(); j++){
	            d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
	        }
	    }
	 
	    StringBuilder sb = new StringBuilder();
	 
	    for(int i=0; i<d.length; i++){
	        int mod = d[i]%10;
	        int carry = d[i]/10;
	        if(i+1<d.length){
	            d[i+1] += carry;
	        }
	        sb.insert(0, mod);
	    }
	 
	    while(sb.charAt(0) == '0' && sb.length()> 1){
	        sb.deleteCharAt(0);
	    }
	 
	    return sb.toString();}

}
