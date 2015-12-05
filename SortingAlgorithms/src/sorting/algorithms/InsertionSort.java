package sorting.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InsertionSort {
	int[] array;
	
	InsertionSort(int[] array){
		this.array = array;
	}
	public void sort(){
		int n = array.length;
		int key;
		for(int j =1;j<n;j++){
			key = array[j];
			int i = j-1;
			while(i>=0 && array[i]>key){
				array[i+1] = array[i];
				i-=1;
			}
			array[i+1] = key;
		}
	}
	
	public void printArray(){
		for(int i : array) System.out.print(i+" ");
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
			InsertionSort isort = new InsertionSort(getArrValues());
			isort.sort();
			isort.printArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
