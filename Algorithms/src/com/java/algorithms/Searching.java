package com.java.algorithms;

public class Searching {
	
	/*
	 * 1)binary search doesnt work if key is the last element 
	 * 2)generic method for sum2 , sum3 
	 */

	private static int rank (int key , int a[] , int lo , int hi){
		if(lo>=hi) return -1;
		int mid=lo+(hi-lo)/2;
		if(key < a[mid]) return rank(key,a,lo,mid);
		if(key > a[mid]) return rank(key, a, mid+1, hi);
		if(key==a[mid]) return mid;
		return 0 ;
	}

	//generic method 
	/*
	private static<T> void sum2(T[] a ){

		//find the number of pairs which add up to 0 
		int count=0, position; 
		for(int i=0;i<a.length;i++){
			if(a[i] == 0) continue; 
			//value zero is a marker that the number has been processed .
			 //when calling rank with -0 (0) might incorrectly match a marker as a number 
			  position = a[i]>0 ? rank(-a[i],a,0,i-1):rank(-a[i],a,i+1,a.length-1);
			if(position > 0 ){ count ++; a[position] =0; a[i]=0;}
		}
		System.out.println("count is " +count );
		
	}
	
	private static <T> void sum3(T[] a ){
		int count=0, position;
		T sum=0;
	
		for(int i=0;i<a.length;i++)
		{
			for(int k=i+1;k<a.length;k++)
			{
				sum=-(a[i]+a[k]);
				position = sum>0 ? rank(-sum,a,0,k-1):rank(-sum,a,k+1,a.length-1);
				if(position > 0 ){ count ++; a[position] =0; a[k]=0;}
				
			}
			a[i]=0;
		}
		System.out.println("3 sum count is " + count);
	}
	*/
	
	
	public static void main(String[] args) {
		int a[]= {-2,1,2};
		//Sorting.recursiveMergeSort(a);
		int n=a.length;
		int key=2;
		int rank = rank (key , a , 0 , n-1);
		if(rank>=0) System.out.println("position="+(rank+1));
		else System.out.println("not present");
		
				
	}
}	
	

