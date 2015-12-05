package com.java.algorithms;

import java.util.Scanner;
import java.util.regex.Pattern;

 class FileInfo {
	String fileName;
	String fileExt;
	
	FileInfo(String fileName, String fileExt) {
		this.fileName=fileName;
		this.fileExt=fileExt;
	}
	
	public void printDetails(){
		System.out.println("name="+fileName);
		System.out.println("extention="+fileExt);
	}
	
	}
public class StringOperations {
	
	private static boolean palindrome(String a){
		int n=a.length();
	
		for (int i=0;i<n/2;i++){
			if(a.charAt(i) != a.charAt(n-1-i)) return false ;
		}
		
		return true;
	}
	
	private static FileInfo fileDetails(String fileName) {
		
		String[] fileDetails= fileName.split(Pattern.quote("."));
	
		FileInfo obj = new FileInfo(fileDetails[0],fileDetails[1]);
		return obj;
		
	}
	
	private static boolean printMatching (String args , String[] input){
		int n = input.length;
		
		for( int i =0; i<n;i++){
			if(input[i].contains(args)) return true;
		}
		return false;
	}
	
	private static boolean alphabetical(String[] input){
		for(int i=1;i<input.length;i++){
			if(input[i-1].compareTo(input[i]) > 0 ) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		//check if string is palindrome 
		/*System.out.println("enter string");
		Scanner sc = new Scanner(System.in);
		String a=sc.nextLine();
		System.out.println(palindrome(a));

		//print file name and extention 
		FileInfo obj=fileDetails(a);
		obj.printDetails();*/
		
		
		//check if value specified in args exists in arrays of strings
	/*	Scanner sc = new Scanner(System.in);
		System.out.println("enter the no of lines");
		int num=sc.nextInt();
		String[] input = new String[num];
		System.out.println("enter the string to be matched");
		sc.nextLine();
		for (int i=0;i<num;i++){
			input[i]=sc.nextLine();
		}
		
		if(printMatching(args[0], input)) System.out.println("exists");
		else System.out.println("does not");*/
		
		//check if array of strings is in alphabetical order 
		/*if(alphabetical(args)) System.out.println("in alphabetical order ");
		else System.out.println("not in order ");*/
		
		//create array of strings from StdIn . delimited by whitespace 
		System.out.println("enter space delimitted strings");
		String input = sc.nextLine();
		String afterSplit[]=input.split("\\s+");
		for(int i=0;i< afterSplit.length;i++) System.out.println(afterSplit[i]);
				
			
			
		
		
		
		
		
	}

}
