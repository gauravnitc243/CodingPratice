package com.princeton;

public class KMPSearchImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	printLPSOfStrting("ABCDABCA");
		printLPSOfStrting("ABABABCA");
		printLPSOfStrting("AAAA");
		printLPSOfStrting("ABCDE");
		printLPSOfStrting("AABAACAABAA");*/
		//printLPSOfStrting("AAACAAAAAC");
	//	printLPSOfStrting("AAABAAA");
		System.out.println(getLPSArrayfromPattern("AAACAAAAAC"));;
	}

	public void KMPSearch(String pat,String txt)
	{
		int M = pat.length();
	    int N = txt.length();
	    int[] lps = getLPSArrayfromPattern(pat);
	    int i = 0;  // index for txt[]
	    int j  = 0;  // index for pat[]
	    while (i < N)
	    {
	        if (pat.charAt(j) == txt.charAt(i))
	        {
	            j++;
	            i++;
	        }
	 
	        if (j == M)
	        {
	            System.out.println("Found pattern at index %d \n"+(i-j));
	            j = lps[j-1];
	        }
	 
	        // mismatch after j matches
	        else if (i < N && (pat.charAt(j) !=txt.charAt(i)))
	        {
	            // Do not match lps[0..lps[j-1]] characters,
	            // they will match anyway
	            if (j != 0)
	                j = lps[j-1];
	            else
	                i = i+1;
	        }
	    }
	    
	}
	public static int[] getLPSArrayfromPattern(String s) {
		int[] lpsArr = new int[s.length()];
		int currIndex = 0;
		int i = 1;
		while (i < s.length()) {
			if (s.charAt(i) == s.charAt(currIndex)) {
				lpsArr[i++] = ++currIndex;
			} else{
				if (currIndex != 0) 
					currIndex = lpsArr[currIndex - 1];
				else
					lpsArr[i++] = 0;
			}
		}
		return lpsArr;
	}

}
