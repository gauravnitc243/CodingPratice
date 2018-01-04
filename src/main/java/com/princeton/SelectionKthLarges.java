package com.princeton;

public class SelectionKthLarges<Item> {
	Sort sort = new Sort<Integer>();
	public Integer findKthLargestNumber(Comparable[] inputArray,int k)
	{
		int lo =0,hi=inputArray.length-1;
		while(lo<hi)
		{
			int temp = sort.partition(inputArray, lo, hi);
			if(temp < k)
				lo = temp+1;
			else if(temp > k)
				hi = temp-1;
			else 
				return (Integer) inputArray[k];
		}
		return (Integer) inputArray[k];
		
	}
	
	public static void main(String[] args) {
	
		Integer[] inputArray = {45,43,23,54,65,3,2,54,345,-3,43,7};
		SelectionKthLarges<Integer> kthLargest = new SelectionKthLarges<Integer>();
		System.out.println(kthLargest.findKthLargestNumber(inputArray, 5));
		kthLargest.sort.quickSort(inputArray);
		for(int i : inputArray)
			System.out.print(i+" ");
		System.out.println(kthLargest.sort.isSorted(inputArray));			
	}
}
