package sorting.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickSort {

	int[] arr;
	
	QuickSort(int[] arr){
		this.arr = arr;
	}
	
	void sort(int start , int end){
		if(start>=end) return;
		int p = partition (start,end);
		sort(start,p-1);
		sort(p+1,end);
	}
	
	int partition(int start , int end){
		int x = arr[end];
		int i=start-1;	
		int j = start;
		
		while(j<end){
			if(arr[j]<x){
				swap(j,i+1);
				j=j+1;i=i+1;
				
			} else if (arr[j]>x){
				j=j+1;
			}
		}
		swap(i+1,end);
		return i+1;
	}
	
	void swap(int i , int j ){
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public void printArray(){
		for(int i : arr) System.out.print(i+" ");
	}
	
	public static int[] getArrValues() throws FileNotFoundException{
		
		Scanner scan = new Scanner(new File("C:\\Users\\shreyak.NETAPP\\Documents\\personal\\algorithms\\SortingAlgorithms\\src\\sorting\\algorithms\\arrayValues.txt"));
		int n = scan.nextInt();
		int[] arr = new int[n];
		for(int i =0;i<n;i++) arr[i] = scan.nextInt();
		return arr;
	
}

	public static void main(String[] args) {
		try {
			QuickSort qsort = new QuickSort(getArrValues());
			qsort.sort(0, getArrValues().length-1);
			qsort.printArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
