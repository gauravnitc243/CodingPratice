package com.interviewbit.arrayandmath;

public class ExcellColumTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(convertToTitle(943566));
System.out.println((int)'@');
	}
	
	public static String convertToTitle(int a) {
		StringBuilder result=new StringBuilder();
		while(a>0)
		{
			a--;
			char tem  =(char) (a%26+'A');
			a = a/26;
			result.append(tem);
			
		}
		return result.reverse().toString();
	}

}
