package com.java.algorithms;

import java.util.Scanner;

public class ArrayOperations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the no of elemens");
		int n=sc.nextInt();
		System.out.println("enter the values");
		int a[]= new int[n];
		
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		
		
		System.out.println("array");
		printArray(a, n);
		
		int temp;
		for(int i=0,j=n-1;i<n && j>0;i++,j--) {
			if(i==j) break;
			temp=a[i];a[i]=a[j];a[j]=temp;

		}
		
		System.out.println("reverse:");
		printArray(a, n);

	}
	
	private static void printArray (int[] a , int n ) {
		for(int i=0;i<n;i++) System.out.println(a[i]);
	}

}
 