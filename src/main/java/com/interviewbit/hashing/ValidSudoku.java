package com.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidSudoku
{

	public static void main(String[] args)
	{
		System.out.println(isValidSudoku(new ArrayList<String>(Arrays.asList( "..5.....6", "....14...", ".........", ".....92..", "5....2...", ".......3.", "...54....", "3.....42.", "...27.6.." ))));

	}
	public static int isValidSudoku(final List<String> a) 
	{
		if (a == null || a.size() != 9 )
			return 0;
		int[][]	sudokuBoard = new int[9][9];
		int k =0;
		for(String in:a)
		{
			for(int j = 0;j<a.size();j++)
				sudokuBoard[k][j] =Character.getNumericValue(in.charAt(j));
			k++;
		}
		for (int i = 0; i < 9; i++) {
			boolean[] m = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (sudokuBoard[i][j] != -1) {
					if (m[(int) (sudokuBoard[i][j])-1]) {
						return 0;
					}
					m[(int) (sudokuBoard[i][j])-1] = true;
				}
			}
		}
		for (int j = 0; j < 9; j++) {
			boolean[] m = new boolean[9];
			for (int i = 0; i < 9; i++) {
				if (sudokuBoard[i][j] != -1) {
					if (m[(int) (sudokuBoard[i][j])-1]) {
						return 0;
					}
					m[(int) (sudokuBoard[i][j])-1] = true;
				}
			}
		}
		for (int block = 0; block < 9; block++) {
			boolean[] m = new boolean[9];
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
					if (sudokuBoard[i][j] != -1) {
						if (m[(int) (sudokuBoard[i][j])-1]) {
							return 0;
						}
						m[(int) (sudokuBoard[i][j])-1] = true;
					}
				}
			}
		}
	 
		return 1;
	}

}
