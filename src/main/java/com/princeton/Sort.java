package com.princeton;

public class Sort<Item> {
	
	public int[] countSort(int[] inputArray,int upperLimit)
	{
		int N = inputArray.length;
		int[] countArray = new int[upperLimit+1];
		int[] sortedArray = new int[N];
		for(int i =0; i<N;i++ )
		{
			countArray[(int) inputArray[i]] +=1;
		}
		
		for(int i = 1;i<=upperLimit;i++)
		{
			countArray[i] += countArray[i-1];
		}
		
		for(int i=N-1;i>=0;i--)
		{
			sortedArray[countArray[inputArray[i]]-1] = inputArray[i];
			countArray[inputArray[i]]--;
		}
		return sortedArray;
	}
	
	
	public void heapSort(Comparable[] inputArray)
	{
		int N = inputArray.length-1;
		for(int i = N/2; i > 0;i--)
		{
			sink(inputArray,i,N);
		}
		
		while(N > 1)
		{
			exch(inputArray, 1, N--);
			sink(inputArray, 1, N);
		}
	}
	
	private void sink(Comparable[] inputArray, int n, int length)
	{
		while(2*n <= length)
		{
			int j = 2*n;
			if(j<length && less(inputArray[j],inputArray[j+1])) j++;
			if(!less(inputArray[n],inputArray[j])) break;
			exch(inputArray, n, j);
			n = j;
		}
	}
	

	public void threeWayQuickSort(Comparable[] inputArray)
	{
		int length = inputArray.length-1;
		threeWayQuickSort(inputArray,0,length);
	}
	
	private void threeWayQuickSort(Comparable[] inputArray,int lo, int hi)
	{
		if(hi<= lo) return;
		Comparable k = inputArray[lo];
		int lt = lo;
		int gt = hi;
		int i = lo;
		while(i<=gt)
		{
			if(less(inputArray[i],k))
			{
				exch(inputArray, i++, lt++);
			}
			else if (less(k,inputArray[i]))
			{
				exch(inputArray, i, gt--);
			}
			else
				i++;
		}
		threeWayQuickSort(inputArray,lo,lt-1);
		threeWayQuickSort(inputArray,gt+1,hi);
	}
	
	public void quickSort(Comparable[] inputArray)
	{
		int length = inputArray.length-1;
		quickSort(inputArray,0,length);
	}
	
	private void quickSort(Comparable[] inputArray,int lo, int hi)
	{
		if(hi<= lo) return;
		int k = partition(inputArray,lo,hi);
		quickSort(inputArray,lo,k-1);
		quickSort(inputArray,k+1,hi);
	}
	
	public int partition(Comparable[] inputArray,int lo, int hi)
	{
		int i = lo,j=hi+1;
		while(true)
		{
			while(less(inputArray[++i],inputArray[lo]))
				if(i>=hi) break;
			while(less(inputArray[lo],inputArray[--j]))
				if(j<=lo)break;
			if(i>=j)break;
			exch(inputArray, i, j);
		}
		exch(inputArray,lo,j);
		return j;
		
	}
	
	
	
	public void mergeSort(Comparable[] inputArray)
	{
		Comparable[] auxArray = new Comparable[inputArray.length];
		mergeSort(inputArray,auxArray,0,inputArray.length-1);
	}
	
	private void mergeSort(Comparable[] inputArray,Comparable[] auxArray,int lo,int high)
	{
		if(high<=lo)
			return;
		int mid = lo +(high-lo)/2;
		mergeSort(inputArray,auxArray,lo,mid);
		mergeSort(inputArray,auxArray,mid+1,high);
		merge(inputArray,auxArray,lo,mid,high);
	}
	
	private void merge(Comparable[] inputArray,Comparable[] auxArray,int lo, int mid, int high)
	{
		for(int i =lo;i<=high;i++)
			auxArray[i] = inputArray[i];
		int i =lo;
		int j = mid+1;
		for(int k = lo;k<=high;k++)
		{
			if(j>high)  inputArray[k] = auxArray[i++];
			else if(i>mid)	inputArray[k] = auxArray[j++];
			else if(less(auxArray[j],auxArray[i])) inputArray[k] = auxArray[j++];
			else inputArray[k] = auxArray[i++];
		}
	}
	
	public void shellSort(Comparable[] inputArray)
	{
		int length = inputArray.length;
		int h = 1;
		while(h<length/3)
			h = h*3 +1;
		
		while(h>=1)
		{
			for(int i =h ;i<length;i++)
			{
				for(int j = i;j >=h ; j=j-h)
				{
					if(less(inputArray[j],inputArray[j-h]))
						exch(inputArray, j, j-h);
				}
			}
			h = h/3;
		}
	}
	
	public void selectionSort(Comparable[] inputArray)
	{
		for(int i =0; i<inputArray.length;i++)
		{
			int min = i;
			for(int j=i+1;j<inputArray.length;j++)
			{
				if(less(inputArray[j],inputArray[min]))
					min = j;
			}
			exch(inputArray,i,min);
		}
		assert isSorted(inputArray);
	}
	
	
	public void insertionSort(Comparable[] inputArray)
	{
		int length = inputArray.length;
		for(int i =0 ; i<length;i++)
		{
			for(int j=i;j>0;j--)
			{
				if(less(inputArray[j],inputArray[j-1]))
					exch(inputArray,j,j-1);
			}
		}
		assert isSorted(inputArray);
	}
	
	private boolean less(Comparable a, Comparable b)
	{
		return a.compareTo(b) < 0;
	}
	
	private void exch(Object[] inputArray,int i,int j)
	{
		Object temp = inputArray[i];
		inputArray[i] = inputArray[j];
		inputArray[j] = temp;
	}
	
	public boolean isSorted(Comparable[] inputArray)
	{
		for(int i=1;i<inputArray.length;i++)
			if(less(inputArray[i],inputArray[i-1]))
				return false;
		return true;
	}

	public static void main(String[] args) {
		Integer[] inputArray = {-90,45,43,23,54,65,3,2,54,345,-3,43,7};
		int[] inputCountArray={5,4,0,1,0,1,3,4};
		Sort sort = new Sort<Integer>();
		inputCountArray =sort.countSort(inputCountArray, 5);
		//sort.heapSort(inputArray);
		for(int i : inputCountArray)
			System.out.print(i+" ");
		System.out.println(sort.isSorted(inputArray));

	}

}
