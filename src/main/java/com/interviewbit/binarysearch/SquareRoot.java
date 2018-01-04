package com.interviewbit.binarysearch;

public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt1(64));
	}
	
	public static int sqrt(int a) 
	{
		if(a==0)
			return 0;
		long lo = 0;
		long hi = a-1;
		while(lo<=hi)
		{
			long mid = lo +(hi-lo)/2;
			if(mid*mid==a ||((mid*mid)<a && (mid+1)*(mid+1)>a))
				return (int) mid;
			if((mid*mid)<a)
				lo = mid+1;
			else if((mid*mid)>a)
				hi = mid-1;
		}
		return 1;
	}
	
	public static int sqrt1(int A) {
	    int mid;
	    int low = 1;
	    int high = A;
	    int root = 0;
	    while (low <= high) {
	        mid = (low + high) / 2;
	        if (mid == A / mid && (A % mid == 0))
	            return mid;
	        if (mid <= A / mid) {
	            root = mid;
	            low = mid + 1;
	        } else {
	            high = mid - 1;
	        }
	    }
	    
	    return root;
	}

}
