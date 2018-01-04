package com.princeton;

import java.util.Random;

public class MonteCarloSimulation {
	private int[] systemArray;
	private int count;
	private int elementsPerRow ;
	private int size;
	private int upperBound ;
	private int lowerBound;

	public MonteCarloSimulation(int rows,int column) {
		size = rows*column;
		elementsPerRow = column;
		upperBound = size;
		lowerBound = size+1;
		systemArray = new int[size+2];
		count = size;
		for (int i = 0; i < size+2; i++)
			systemArray[i] = i;
	}

	public int count() {
		return count;
	}

	public void connectRandomSites() {
		Random random = new Random();
		int firstSite = random.nextInt(size);
		int secondSite = random.nextInt(size);
		union(firstSite,secondSite);

	}

	private void union(int i, int j) {
		int p = find(i);
		int q = find(j);
		if (p == q)
			return;
		systemArray[p] = q;
		count--;

	}

	private int find(int i) {
		validate(i);
		while (i != systemArray[i])
			i = systemArray[i];
		return i;
	}

	private void validate(int i) {
		if (i < 0 || i >= size+2)
			throw new IndexOutOfBoundsException("index " + i
					+ " is not between 0 and " + (size - 1));
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public double simulationProbResult()
	{
		createVirtualBound();
		while(!connected(upperBound, lowerBound))
			connectRandomSites();
		double ratio = Double.valueOf(count)/size;
		return ratio;
			
	}
	
	private void createVirtualBound()
	{
		for(int i =0;i<elementsPerRow;i++)
			union(i,upperBound);
		for(int i=size-1;i>size-elementsPerRow;i--)
			union(i,lowerBound);
	}
	

	public static void main(String[] args) {
		int rows=512;
		int column=512;
		double result=0 ;
		for(int i = 0;i<256;i++)
		{
			MonteCarloSimulation simulationClient = new MonteCarloSimulation(rows, column);
			result += simulationClient.simulationProbResult();
		}
		System.out.println("probablity of precolation with monte carlo simulation : "+result/256);
	}

}
