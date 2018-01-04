package com.princeton;

public class ThreeSum {

	public static void main(String[] args) {

		int[] inputArray = {30,-40,-20,-10,40,0,10,5};
		int length = inputArray.length;
		int count =0;
		for(int i = 0; i<length; i++ )
		{
			for(int j = i+1;j<length;j++)
			{
				for(int k =j+1;k<length;k++)
				{
					if(inputArray[i]+inputArray[j]+inputArray[k]==0)
					{
						System.out.println(inputArray[i]+" "+inputArray[j]+" "+inputArray[k]+" ");
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}

}

