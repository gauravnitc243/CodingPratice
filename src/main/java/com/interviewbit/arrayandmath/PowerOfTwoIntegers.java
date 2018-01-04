package com.interviewbit.arrayandmath;

public class PowerOfTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isPower(4));
	}
	
	public static boolean isPower(int n) {
		if (n == 1) {
        return true;
    }
    
    final int LIMIT = (int) (Math.sqrt(n));
    for (int a = 2; a <= LIMIT; a++) {
    	int p = 2;
    	int powerResult = (int) (Math.pow(a, p));

    	while (powerResult < n) {
    		powerResult = (int) (Math.pow(a, ++p));
    	}
    	
    	if (powerResult == n) {
    		return true;
    	}
    }
    
    return false;
    }

	
	 public boolean isPower1(int A) {
	        double x=2;
		    double i;
		    if(A==1)
		    	return true;
		    for(i=2;(i<33)&&(x<=(double)(Math.pow(2,16)));i++)
		    {   
		        if(Math.pow(x,i)==(double)A) return true;
		        if(Math.pow(x,i) >= (Math.pow(2,32))) {i=1;x++;}
		    }
		    return false;
	    }
}
