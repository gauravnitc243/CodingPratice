package com.interviewbit.arrayandmath;

class BinaryRepresentation {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findDigitsInBinary(6));
	}
	
	public  static  String findDigitsInBinary(int a) {
		if(a==0)
			return "0";
		
		String result =  "";
		while(a/2 >=1)
		{
			result = a%2+result;
			a = a/2;
		}
		
		return 1+result;
	}

}
