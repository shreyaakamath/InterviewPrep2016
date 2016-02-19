package sorting.searching;

import java.util.ArrayList;
import java.util.List;

/**
 * worst case(pivot always smallest or largest) : t(n)=t(0)+t(n-1)+o(n) -> o(n2)
 * best case(pivot is the middle element): t(n/2)+t(n/2-1)+o(n) -> o(nlogn)
 * average case :t(n/9)+t(9n/10)+o(n) -> o(nlogn)
 * @author shreyakamath
 *
 */
public class QuickSort {

	static void swap(int[] a , int i, int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	static int partition(int[] a , int start, int end){
		if(end-start ==1) return start;
		int i=start;int j=end-2;
		int pivot=a[end-1];
		while(true){
			while(j>i && a[j]>pivot) j--;
			while(j>i && a[i]<pivot) i++;
			if(i>=j){ swap(a,j+1,end-1); break; }
			else{ swap(a,i,j); i++;j--;}
		}
		return j+1;
	}
	
	static void quicksort(int[] a , int start , int end){
		if(end-start ==0) return;
		int pivot = partition(a,start,end);
		quicksort(a,start,pivot);
		quicksort(a,pivot+1,end);
	}
	public static void main(String[] args) {
		int[] a ={7,1,2,12,5,3,8,10,4};
//		System.out.println(partition(a,0,1));
		quicksort(a,0,a.length);
		for(int i:a) System.out.println(i);
	}

}
