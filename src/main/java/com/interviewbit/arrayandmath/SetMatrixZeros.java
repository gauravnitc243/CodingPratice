package com.interviewbit.arrayandmath;

import java.util.ArrayList;

public class SetMatrixZeros {

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);a.add(0);
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(1);b.add(0);
		ArrayList<ArrayList<Integer>> re  =new ArrayList<ArrayList<Integer>>();
		re.add(a);
		re.add(b);
		
		SetMatrixZeros ss = new SetMatrixZeros();
		ss.setZeroes(re);
		for(int i=0 ;i < re.size(); i++)
		{
			for(int j = 0; j<re.get(i).size(); j++)
			{
				System.out.print(re.get(i).get(j) +" ");
			}
			System.out.println();
		}
	}
	
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		int[] xPoints = new int[a.size()];
		for(int i =0;i<xPoints.length;i++)
		{
			xPoints[i] = 1;
		}
		int[] yPoints = new int[a.get(0).size()];
		for(int i =0;i<yPoints.length;i++)
		{
			yPoints[i] = 1;
		}
		for(int i=0 ;i < a.size(); i++)
		{
			for(int j = 0; j<a.get(i).size(); j++)
			{
				if(a.get(i).get(j)==0)
				{
					xPoints[i] =0;
					yPoints[j]=0;
				}
			}
		}
		for(int i=0 ;i < a.size(); i++)
		{
			for(int j = 0; j<a.get(i).size(); j++)
			{
					a.get(i).set(j, a.get(i).get(j)*xPoints[i]*yPoints[j]);
			}
		}
	}
	

}
