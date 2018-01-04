package com.geeks4geeks;

public class AllCombinations {

	public static void main(String[] args) {
		getAllCombinationsOfString(3, "12345");
	}
	
	
	public static void getAllCombinationsOfString(int combinationLength,String src){
		char[] input = src.toCharArray();
		char[] temp = new char[combinationLength];
		combinationUtil(input, temp, 0, src.length(), 0, combinationLength);
	}
	
	public static void combinationUtil(char[] input, char[] temp,int start,int end, int index,int combinationLen){
		if(index==combinationLen){
			for(char c : temp)
				System.out.print(c);
			System.out.println();
			return;
		}
		for(int i = start ;i<end;i++){
			temp[index] = input[i];
			combinationUtil(input,temp,start+1,end,index+1,combinationLen);
		}
	}

}
