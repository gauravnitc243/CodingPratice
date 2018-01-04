package com.interviewbit.greedy;

public class Seats
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	
	public static int seats(String a) 
	{
		int i = findMedian(a.toCharArray());
		if (i == -1) {
			return 0;
		}
		return shift(a.toCharArray(), i);
	}
	public static int shift(char s[], int i) 
	{
		int count = 0;
		int j = 0;
		int k = i;
		while (j < k)
		{
			if (s[j] == '.') 
				j++;
			else if (s[k] == 'x') 
				k--;
			else 
			{
				s[k] = s[j];
				s[j] = '.';
				count = (count+(k-j))%10000003;
				j++;
				k--;
			}
		}
		j = s.length - 1;
		k = i;
		while (j > k) {
			if (s[j] == '.') 
				j--;
			else if (s[k] == 'x') 
				k = (k+1)%10000003;
			else 
			{
				s[k] = s[j];
				s[j] = '.';
				count = (count +(j-k))%10000003;
				j--;
				k++;
			}
		}
		return count%10000003;
	}
	
	
	public static int findMedian(char s[]) {
		int count1 = 0;
		for (char c : s) {
			if (c == 'x') {
				count1++;
			}
		}
		if (count1 == 0) {
			return -1;
		}
		count1 = (count1 + 1) / 2;
		int count2 = 0;
		for (int i = 0; i < s.length; ++i) {
			if (s[i] == 'x') {
				count2++;
				if (count2 == count1) {
					return i;
				}
			}
		}
		return -1;
	}

}
