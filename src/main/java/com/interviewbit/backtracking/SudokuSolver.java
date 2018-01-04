package com.interviewbit.backtracking;

import java.util.ArrayList;

public class SudokuSolver
{

	public static void main(String[] args)
	{

	}
	
	public void solveSudoku(ArrayList<ArrayList<Character>> a) 
	{
        if (a==null||a.size()==0)
            return;
        solved(a);
	}
	  private boolean solved(ArrayList<ArrayList<Character>>  board){
	        for(int i=0; i<board.size(); i++){
	            for (int j=0; j<board.get(0).size(); j++)
	            {
	                if (board.get(i).get(j)=='.')
	                {
	                    for (char num='1'; num<='9'; num++)
	                    {
	                        if(isValid(board, i, j, num))
	                        {
	                        	board.get(i).set(j, num);
	                            if (solved(board))
	                                return true;
	                            else
	                            	board.get(i).set(j, '.');
	                        }
	                    }
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	  private boolean isValid(ArrayList<ArrayList<Character>>  board, int i, int j, char c)
	  {
	        for (int row=0; row<9; row++){
	            if (board.get(row).get(j)==c)
	                return false;
	        }
	        for (int col=0; col<9; col++){
	            if (board.get(i).get(col)==c)
	                return false;
	        }
	        for(int row=i/3*3; row<i/3*3+3; row++){
	            for (int col=j/3*3; col<j/3*3+3; col++){
	                if (board.get(row).get(col)==c){
	                    return false;
	                }
	            }
	        }
	        return true;
	        
	    }

}
