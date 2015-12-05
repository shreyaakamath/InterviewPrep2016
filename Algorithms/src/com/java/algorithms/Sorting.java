package com.java.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;


public class Sorting {
	private static Comparable aux[];
	/*
	 * move the smallest element to the beginning of the array by comparing ith element with all others 
	 */
	public static void selectionSort (Comparable[] a) {
		
		int min ;
		for (int i =0; i < a.length; i++ ) {
			min =i ;
			for (int j = i+1 ; j < a.length; j++) {
				if (less (a[j] , a[min])) {
					min = j;
				}
			}
			exchg(a, i, min);
		
		}
	}
	
	/*
	 * insert the ith element to the correct position to the left. 
	 */
	public static void insertionSort(Comparable [] a ) {
		for (int i =1; i< a.length; i++) {
			for (int j =i; j> 0 && less(a[j] , a[j-1]) ; j--) {
				exchg(a, j, j-1);
			}
		}
		
	}
/*
 * similar to insertion sort but instead of comparing elements seperated by 1 the elements will be seperated by h 	
 */
	public static void shellSort(Comparable[] a){
		int h =1;
		int n = a.length;
		while(h < n/3 )  h= 3*h + 1 ; 
		while (h >= 1 ) {
			for ( int i = h ; i< n ; i++)
				for (int j=i; j>=h && less(a[j],a[j-h]);j-=h) {
					exchg(a, j, j-h);
				}
			h/=3;
		}
			
	}
	
	public static void merge(Comparable[] a , int lo ,int mid , int hi) {
		
		int i=lo; int j =mid+1;
		for(int k=lo;k<=hi;k++){
			aux[k]=a[k];
		}
		
		for(int k=lo; k<=hi ;k++) {
			if(i>mid) { 
				a[k]=aux[j++];
			} else if (j > hi ){
				a[k]=aux[i++];
			} else if(less(aux[i],aux[j])) {
				a[k]=aux[i++];
			} else {
				a[k]=aux[j++];
			}
		}
	}
	
	public static void recursiveMergeSort(Comparable[] a){
		//allocate memory for auxillary array only once in this function . 
		aux = new Comparable[a.length];
		mergerSort(a, 0 , a.length-1);
	}
	
	public static void mergerSort (Comparable[] a , int lo,  int hi) {

		if(hi <= lo) return ;
		int mid = lo+(hi-lo)/2;
		
		mergerSort(a, lo, mid);
		mergerSort(a, mid+1, hi);
		merge(a, lo, mid, hi);
		
	}
	
	private static void recursiveQuickSort(Comparable[] a ) {
		//shuffle the input values to eliminate dependence on input
		quickSort(a, 0, a.length-1);
	}
	
	private static int partitition (Comparable[] a , int lo , int hi ) {
		int k = lo; 
		int i =lo;
		int j = hi+1;
		
		while (true) {
			while ( less (a[++i],a[k]))
				if(i == hi ) break ; 
			while ( less (a[k],a[--j]))
				if(j == lo) break;
			if ( i >= j ) break ;
			exchg(a, i, j);
		}
		
		exchg(a, k, j);
		return k;
	}
	
	private static void quickSort (Comparable[] a , int lo , int hi ) {
		if ( hi <= lo ) return ; 
		int partition = partitition(a, lo, hi);
		quickSort (a ,lo , partition);
		quickSort ( a , partition+1 , hi );
	}
	
	private static int selection (Comparable a[] ,int k) {
		int lo =0; 
		int hi = a.length-1;
		
		int part = partitition(a, lo, hi); 
		if(k < part ) partitition(a, lo, part);
		if (k > part) partitition(a, part+1, hi);
		//return a[part];
		
		
		
		return 0 ;
	}
	private static boolean less (Comparable v , Comparable w ) {
		return v.compareTo(w) <0 ;
	}
	
	private static void exchg (Comparable[]  a , int i , int j ) {
		Comparable temp = a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	private static void show (Comparable[] a ) {
		for (int i =0; i < a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
	
	
	public static void isSorted (Comparable[] a) {
		for (int i =1; i < a.length;i++) {
			if(less(a[i] , a[i-1])){
				System.out.println("not sorted");
				return;
			}
		}
		System.out.println("sorted");
	}
	
	public static void main (String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("number of elements in the array :");
		final int number = sc.nextInt();
		final String a[]=new String[number];		
		sc.nextLine();
		for (int i =0; i< number ; i++ ) {
			a[i]=sc.nextLine();
		}
		
		//selectionSort(a);
		//insertionSort(a);
		//shellSort(a);
		//recursiveMergeSort(a);
		recursiveQuickSort(a);
		isSorted(a);
		show(a);
		
		
	}
}
