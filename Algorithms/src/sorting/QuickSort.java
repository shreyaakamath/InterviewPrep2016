package sorting;

import javax.naming.PartialResultException;

public class QuickSort {
	int[] a; 
	
	QuickSort(int[] a){
		this.a=a;
	}
	
	void swap(int i , int j ){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	int partition(int p , int r){
	int i=0;
	int j=0;
	int k=0;
	int pivot = a[r];
	
	while(i<r && j<r){
		if(a[k] <= pivot ){
			swap(i,k);i++;j++;k++;
		} else{
			j++;k++;
		}
	}
	swap(i,r);
	return i;
	}
	
	void printArray(){
		for(int i:a)System.out.print(i+",");
	}
	
	void quickSort(int p , int r){
	if(p > r) return;
	int pivot = partition(p, r);
	quickSort(p, pivot-1);
	quickSort(pivot+1, r);
	}
	
	public static void main(String[] args) {
		int[] a = {2,8,7,1,3,5,0,1};
		QuickSort q1 = new QuickSort(a);
		//q1.partition(0, a.length-1);
		q1.quickSort(0, a.length-1);
		q1.printArray();
		}

}
