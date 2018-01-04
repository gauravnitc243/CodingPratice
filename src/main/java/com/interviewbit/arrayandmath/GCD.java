package com.interviewbit.arrayandmath;

public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(6,9));

	}
	
	public static  int gcd(int a, int b) {
		if(a==0 && b==0)
			return 1;
		if(a==0 && b!=0)
			return b;
		if(a!=0 && b==0)
			return a;
        int r=0, max, min;
        max = (a > b) ? a : b;
        min = (a < b) ? a : b;
        r = min;
        while(max % min != 0)
        {
            r = max % min;
            max = min;
            min = r;
        }
        return r;
      }

}
