package data.structures;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;

public class trial {
	static boolean isPalindrome(StringBuilder str){
        boolean flag = true;
        int len = str.length();
        for(int i=0;i<len;i++){
            int end = len-1-i;
            if(end == i ) break;
            if(str.charAt(i)!=str.charAt(end)) {flag = false; break;}
        }
        return flag;
    }
	 public static void main(String[] args) {
		 System.out.println(isPalindrome(new StringBuilder("caa")));
	        Scanner scan = new Scanner(System.in);
	        int T = scan.nextInt();
	        for(int i=0;i<T;i++){
	            int operations =0;
	            String input = scan.next();
	            StringBuilder word = new StringBuilder(input);
	            int len = word.length();
	            if(isPalindrome(word)){System.out.println(operations);continue;}
	            int last = len-1;
	            while(last>=0){
	                char lastChar = word.charAt(last);
	                while(lastChar!='a'){
	                    word.setCharAt(last,(char)(lastChar -1));
	                    operations++;
	                    if(isPalindrome(word)){System.out.println(operations);continue;}
	                }
	                last--;
	            }
	        }
	    }
}