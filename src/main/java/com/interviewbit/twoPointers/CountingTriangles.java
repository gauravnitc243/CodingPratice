package com.interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Collections;

public class CountingTriangles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	 public int nTriang(ArrayList<Integer> A) {
		 	int size = A.size();
	        Collections.sort(A);
	        int triangleCount = 0;
	        for (int i = 0; i < size-2; ++i)
	        {
	            int k = i + 2;
	            for (int j = i+1; j < size; ++j)
	            {
	                while (k < size && A.get(i) +A.get(j)  > A.get(k)){
	                	++k;
	                }
	                triangleCount += k - j - 1;
	                if(triangleCount >= 1000000007) 
	                	triangleCount %= 1000000007;
	            }
	        }
	        return triangleCount;
	    }

}
