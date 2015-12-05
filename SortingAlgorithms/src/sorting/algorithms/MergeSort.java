package sorting.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MergeSort {
	int[] arr;
	int n ;
	
	MergeSort(int[] arr){
		this.arr = arr;
		n = arr.length;
	}
	void sort(int start , int end){
		int mid = (start+end)/2;
		if(start >= mid || end <=mid) return;
		sort(start,mid);
		sort(mid+1,end);
		merge(start,mid,mid+1,end);
		
	}
	
	void merge(int start1, int end1 , int start2 , int end2) {
		int k=0;
		/*create left and right sub-arrays by copying from main array*/
		int lenLeft = end1-start1+1;
		int lenRight = end2-start2+1;
		int[] left = new int[lenLeft];
		int[] right = new int[lenRight];
		for(int m=start1;m<=end1;m++) left[k++] = arr[m];k=0;
		for(int m=start2;m<=end2;m++) right[k++] = arr[m];k=0;
		
		/*merge the arrays back into Arr*/
		int i =0,j=0;k=start1;
		while( i<lenLeft && j<lenRight){
			if(left[i]<=right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}
		if(i>=lenLeft){
			for(int m = j; m<=lenRight-1;m++) arr[k++] = right[m];
		} else {
			for(int m =i;m<=lenLeft-1;m++) arr[k++] = left[m];
		}
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
			MergeSort msort = new MergeSort(getArrValues());
			msort.sort(0, getArrValues().length-1);
			msort.printArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
