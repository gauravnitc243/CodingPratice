package com.interviewbit.arrayandmath;

public class ReverseInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String temp = "-9";
		int i = Integer.parseInt(temp);
		System.out.println(i);

	}
	
	
	public int reverse(int a) {
		int reverse = 0;
		boolean isNegative = false;
		if(a<0)
		{
			isNegative = true;
			a = a*-1;
		}
		
		int degit = 0;
		while(a>0)
		{
			degit = a%10;
			
			if((Integer.MAX_VALUE/10 < reverse) || (Integer.MAX_VALUE/10==reverse && degit>Integer.MAX_VALUE%10))
				return 0;
			reverse = reverse*10 + degit;
			a = a/10;
		}
		if(isNegative)
			reverse = -1 * reverse;
		if(reverse==Integer.MIN_VALUE)
			return 0;
		return reverse;
	}

}
