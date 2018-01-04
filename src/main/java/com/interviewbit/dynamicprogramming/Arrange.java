package com.interviewbit.dynamicprogramming;

public class Arrange
{

	public static void main(String[] args)
	{
		Arrange a = new Arrange();
		System.out.println(a.arrange("WWWB", 2));
	}
	
	
	public int arrange(String a, int b) 
	{
		if(a.length() < b) return -1;
        int[][] dp = new int[a.length() + 1][b + 1];
        
        for(int i = 1; i <= a.length(); i++)
            dp[i][1] = product(a, 0, i - 1);
        
        for(int k = 2; k <= b; k++)
        {
            for(int j = k; j <= a.length(); j++)
            {
                int min = Integer.MAX_VALUE;
                for(int i = k - 1; i <= j - 1; i++)
                {
                    dp[j][k] =  Math.min((dp[i][k - 1] + product(a, i, j - 1)), min);//i = 2 j = 4
                    min = dp[j][k];
                }
            }
         }
        return dp[a.length()][b];
     }
	
	 public int product(String A, int start, int end)
	 {
	        int W = 0, B = 0;
	        for(int i = start; i <= end; i++)
	        {
	            if(A.charAt(i) == 'W')
	            	W++;
	            else if(A.charAt(i) == 'B') 
	            	B++;
	        }
	        return W * B;
	  }
}
