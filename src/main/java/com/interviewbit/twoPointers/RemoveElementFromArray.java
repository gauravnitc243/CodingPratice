package com.interviewbit.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveElementFromArray
{

	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(4,1,1,2,1,3));
		System.out.println(removeElement(a,1));
	}
	
	public static int removeElement(ArrayList<Integer> A, int B) 
	{
	    int count = 0;
	    for (int i = 0; i < A.size(); i++)
	    {
	        if (A.get(i) == B) {
                count++;
	        } else {
	            A.set(i - count, A.get(i));
	        }
	    }
	    for (int i = 0; i < count; i++)
	        A.remove(A.size() - 1);
	    return A.size();
	}
}
