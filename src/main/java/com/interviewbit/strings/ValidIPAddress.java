package com.interviewbit.strings;

import java.util.ArrayList;

public class ValidIPAddress
{

	public static void main(String[] args)
	{
		System.out.println(restoreIpAddresses("25525511135"));

	}
	
public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result=new ArrayList<String>();
        if (s==null||s.length()>12|| s.length()<4){
            return result;
        }
        String ip="";
        // record current index of s
        int currentIndexofInputString=0;
        // ip can be split into 4 parts, parNum is indicated which part it is
        int partNum=0;
       // DFS
        buildResult(s, currentIndexofInputString,ip, partNum, result);
        return result;
    }
    private static void buildResult(String inputString, int currentIndexofInputString, String ip, int partNum, ArrayList<String> result){
         
        if (currentIndexofInputString==inputString.length() && partNum==4){
            StringBuilder sb=new StringBuilder(ip);
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
            return;
        }
        
        int num=0;
        for (int j=currentIndexofInputString; j<currentIndexofInputString+3 && j<inputString.length(); j++){
           if (inputString.length()-j<4-partNum){
                // left letter number less than the need to fill all left parts
                return;
            }
            
            if (inputString.length()-j>(4-partNum)*3){
              // left parts can not hold all left letters
                return;
            }
            num=num*10+(inputString.charAt(j)-'0');
            if (num<=255){
                ip+=inputString.charAt(j);
                buildResult(inputString, j+1, ip+'.', partNum+1, result );
            }
            // skill all situation that the head of each part is start with 0, except only 0 
            // at this section.
            /*
            example:
            
            Input:	"010010"
            Output:	["0.1.0.0110","0.1.00.110","0.1.001.0","0.110.0.110","0.110.01.0","0.110100.1.0","01.0.0.110","01.0.01.0","01.00.1.0","0110.0.1.0"]
            Expected:	["0.10.0.10","0.100.1.0"]
            */
            if (num==0){
                break;
            }
        }
    }
}
