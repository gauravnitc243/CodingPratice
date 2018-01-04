package com.interviewbit.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class TusharBirthdayBombs {

	public static void main(String[] args) {
		System.out.println(new TusharBirthdayBombs().solve(11, new ArrayList<>(Arrays.asList(6, 8, 5, 4, 7))));

	}

	public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
		int n = B.size();
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (n == 0)
			return result;
		int minStrengthKick = B.get(0);
		int minStrengthKickIndex = 0;
		for (int i = 1; i < n && (B.get(i) < minStrengthKick) ; i++) 
		{
				minStrengthKick = B.get(i);
				minStrengthKickIndex = i;
		}

		int maxPossibleKickCount = A / minStrengthKick;
		if (maxPossibleKickCount == 0)
			return result;

		int limitUsed = minStrengthKick * maxPossibleKickCount;
		int limitLeft = A - limitUsed;
		for (int i = 0; i < maxPossibleKickCount; i++)
			result.add(minStrengthKickIndex);

		int index = 0;
		for (int i = 0; i < minStrengthKickIndex;) 
		{
			int x = B.get(i);
			int diff = x - minStrengthKick;
			if (limitLeft >= diff) 
			{
				limitLeft -= diff;
				result.set(index, i);
				index++;
				if (index == maxPossibleKickCount) 
					break;
			} 
			else
				i++;
		}
		return result;
	}
}
