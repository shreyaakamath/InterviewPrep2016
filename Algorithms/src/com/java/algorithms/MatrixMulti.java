package com.java.algorithms;

import java.util.Scanner;

public class MatrixMulti {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("number of elements of array ");
		int n =sc.nextInt();
		
		int a[][]= new int[n][n];
		int b[][]= new int[n][n];
		int c[][]=new int[n][n];
		
		System.out.println("elements array ");
		for (int i=0;i<n;i++) 
			for(int j=0;j<n;j++)
					a[i][j]=sc.nextInt();
		
		
		int sum=0;
		for (int i=0;i<n;i++)
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++)
				c[i][j]+=a[i][k]*b[j][k];
			}
			
		
		
		

	}

}
