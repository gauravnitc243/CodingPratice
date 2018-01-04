package com.princeton;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxPQHeapImpl<Key extends Comparable>{
	private Key[] pq;
	private int N;
	
	
	public void insert(Key x)
	{
		if(N>+pq.length-1)
			throw new NoSuchElementException("pq overflow , no space left");
		else
		{
			pq[++N] = x;
			swim(N);
		}
		assert isMaxHeap();
	}
	
	public Key delMax()
	{
		if(isEmpty())
			throw new NoSuchElementException("pq underflow , no more elementsss");
		Key max = pq[1];
		pq[1] = pq[N--];
		pq[N+1] = null;
		sink(1);
		assert isMaxHeap();
		return max;
	}
	
	private boolean isMaxHeap()
	{
		return isMaxHeap(1);
	}
	
	private boolean isMaxHeap(int i)
	{
		if(i>N) return true;
		else
		{
			int left = 2*i,right =2*i+1;
			if(left <= N && less(pq[i],pq[left])) return false;
			if(right <= N && less(pq[i],pq[right])) return false;
			return isMaxHeap(left) && isMaxHeap(right);
		}
	}
	
	private void sink(int k)
	{
		while(2*k <= N)
		{
			int j = k*2;
			if(j<N && less(pq[j],pq[j+1]))j++;
			if(!less(pq[k],pq[j])) break;
			exch(pq, j, k);
			k = j;
		}
	}
	private void swim(int n)
	{
		while(n>1 && less(pq[n/2],pq[n]))
		{
			exch(pq,n/2,n);
			n = n/2;
		}
	}
	
	
	private void exch(Object[] pq, int i , int j)
	{
		Object temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}
	
	private boolean less(Comparable a, Comparable b)
	{
		if(a.compareTo(b) < 0 )
			return true;
		return false;
	}
	public MaxPQHeapImpl(int size)
	{
		pq = (Key[]) new Object[size+1];
		N = 0;
	}
	
	private boolean isEmpty()
	{
		return N==0;
	}
	
	public int size()
	{
		return N;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
