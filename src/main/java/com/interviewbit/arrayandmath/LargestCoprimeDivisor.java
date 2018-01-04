package com.interviewbit.arrayandmath;

public class LargestCoprimeDivisor {

	public static void main(String[] args) {
		System.out.println(cpFact(74,22));

	}
	
	
	public static int cpFact(int A, int B) {
        while(gcd(A,B)!=1){
            A = A/gcd(A,B);
        }
		return A;
    }
	public static int gcd(int a, int b){
		if(a==0 && b==0)
			return 1;
		else if(a==0 && b!=0)
			return b;
		else if(a!=0 && b==0)
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
