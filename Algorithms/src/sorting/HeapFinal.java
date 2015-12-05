package sorting;

import java.util.ArrayList;

public class HeapFinal {

	int[] a ; 
	int heapsize;
	
	HeapFinal(int[] a){
		this.a=a;
		heapsize = a.length;
	}
	
	protected int getLeft(int parent){
		return parent*2;
	}
	
	protected int getRight(int parent){
		return parent*2+1;
	}
	
	protected int getParent(int child){
		return child/2;
	}
	
	protected void swap(int n , int m){
		int temp = a[n];
		a[n]=a[m];
		a[m]=temp;
	}
	
	protected void printHeap(){
		for(int num : a ) System.out.print(num +",");
	}
	
	/**
	 * 
	 * @param parent
	 * @param heapsize
	 * 
	 * This method will move the parent element to the correct position in the heap . down propagation.
	 * if we include this statement then it will build the heap
	 * if(parent > 1) {maxHeapify(getParent(parent), heapsize);}
	 */
	protected void maxHeapify(int parent, int heapsize){
	int left = getLeft(parent);
	int right = getRight(parent);
	
	if(left >= heapsize) return;
	if(right >= heapsize) return;
	
	if(a[parent] < a[left]){swap(parent,left);maxHeapify(left, heapsize);}
	if(a[parent] < a[right]){swap(parent , right);maxHeapify(right, heapsize); }
	}

	/**
	 * 
	 * @param heapSize
	 * This method will build the heap . it will choose the last non leaf element and call heapify on it . heapify works in a top down approach .
	 * This logic is a bottom up approach . 
	 * so between build-heap and heapify the heap gets formed. 
	 */
	protected void buildHeap(int heapSize){
		int lastNonLeaf = heapSize/2;
		for(int i = lastNonLeaf;i>=1;i--)
			maxHeapify(i, heapSize);
	}
	
	/**
	 * uses build heap to initially build the heap . after this it uses heapify to move the root element to the correct position
	 */
	protected void heapSort(){
		buildHeap(a.length);
		int heapSize = a.length;

		while(heapSize>2){
			swap(1,heapSize-1);
			heapSize--;
			maxHeapify(1, heapSize);
		}
	}
	
	protected int extractMax(){
		int maxValue = a[1];
		swap(1,heapsize-1);
		heapsize--;
		maxHeapify(1, heapsize);
		return maxValue;
	}
	
	protected void increaseKey(int index , int newValue ){
		a[index]=newValue; 
		
		int parent = getParent(index);
		if(parent >=1){
			if(newValue > a[parent]) {swap(index , parent);increaseKey(parent, a[parent]);}
		}
	}
	
	protected void insertNewElement(int value){
		int lastIndex=a.length;
		int[] newA = new int[a.length+1];
		System.arraycopy(a, 0, newA, 0, a.length);
		a=newA;
		a[lastIndex] = value;
		increaseKey(lastIndex, value);
		
	}
	public static void main(String[] args) {
		int[] a = {0,10,20,14,9,30};
		HeapFinal h1 = new HeapFinal(a);
		h1.buildHeap(a.length);
		//h1.maxHeapify(1, a.length);
		//h1.heapSort();
		//h1.printHeap();
		//System.out.println(h1.extractMax());
		//h1.increaseKey(4, 21);
		h1.insertNewElement(40);
		h1.printHeap();
	}

}
