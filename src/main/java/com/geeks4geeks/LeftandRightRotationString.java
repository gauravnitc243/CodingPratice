package com.geeks4geeks;

public class LeftandRightRotationString {

	public static void main(String[] args) {
		LeftandRightRotationString l = new LeftandRightRotationString();
		l.rotateString("GeeksforGeeks", 2, 3);

	}
	
	public void rotateString(String s , int l , int r)
	{
		l = l% s.length();
		r = r% s.length();
		char[] input = s.toCharArray();
		leftrotate(input, l);
		rightrotate(input, r);
		s = String.valueOf(input);
		System.out.println(s);
		
	}
	void rightrotate(char[] source, int d)
	{
	   leftrotate(source, source.length-d);
	}
	void leftrotate(char[] source, int d)
	{
	    reverse(source,0, d-1);
	    reverse(source,d, source.length-1);
	    reverse(source,0, source.length-1);
	}
	
	void reverse(char arr[], int start, int end)
	{
		char temp;
	    while (start < end)
	    {
	        temp = arr[start];
	        arr[start] = arr[end];
	        arr[end] = temp;
	        start++;
	        end--;
	    }
	}
	 
	
}
