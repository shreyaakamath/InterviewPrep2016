package sorting;

public class Heap {
	int[] a;
	int count;
	static int nodeIndex = 1;
	Heap(int[] a){
		this.a=a;
		count =0;
	}
	private int getLeft(int parent){
		return parent*2;
	}
	
	private int getRight(int parent){
		return parent*2+1;
	}
	
	private int getParent(int child){
		return child/2;
	}
	
	private void swap(int i , int j){
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private void heapifyFromCoreman(int i){
		count++;
		int left = getLeft(i);
		int right = getRight(i);
		int largest;
		
		if(left < a.length && a[left]>a[i]) largest = left;
		else largest = i;
		if(right < a.length && a[right]>a[i]) largest = right;
		else largest = i;
		if(largest !=i){
			swap(i,largest);
			heapifyFromCoreman(largest);
		}
	}
	
	
	private void maxHeapifyTopDown(int parent){
		count++;
		int left = getLeft(parent);
		int right = getRight(parent);
		if(left >= a.length) return;
		if(right >= a.length) return;
		if(a[left]>0 ){
		if(a[parent] < a[left] ) {
			swap (parent , left);
			if(parent!=1){
				maxHeapifyTopDown(getParent(parent));
			}
		}
		if(a[parent] < a[right]) {
			swap(parent,right);
			if(parent!=1){
				maxHeapifyTopDown(getParent(parent));
			}
		}
		maxHeapifyTopDown(left);
		maxHeapifyTopDown(right);
		}
		
	}
	
	private void maxHeapifyBottomUp(int parent , int heapSize){
		int left = getLeft(parent);
		int right = getRight(parent);
		
		//prevents npe when the last non leaf element does not have children 
		if(left >= heapSize) return;
		if(right >= heapSize) return;

		//at the end maxHeapify will be called on parent of node which does not exist
		if(parent>= nodeIndex ){
		if(a[parent] < a[left] ) {
			swap (parent , left);
			maxHeapifyBottomUp(left,heapSize);
		}
		if(a[parent] < a[right]) {
			swap(parent,right);
			maxHeapifyBottomUp(right,heapSize);
		}
		maxHeapifyBottomUp(getParent(parent),heapSize);
		} else {
			return;
		}
	}
	
	private void buildMaxHeapBottomUp(int heapSize){
		int lastNonLeaf = heapSize/2;
		for (int i= lastNonLeaf;i>=1;i--){
			maxHeapifyBottomUp(i,heapSize);
		}
	}
	private void heapSort(){
		int heapSize = a.length;
		buildMaxHeapBottomUp(heapSize);
		while(heapSize>nodeIndex){
		swap(nodeIndex,heapSize-1);
		heapSize--;
		maxHeapifyBottomUp(nodeIndex, heapSize);
		}
	}
	private void printHeap(){
		for (int i : a) System.out.println(i+",");
	}
	public static void main(String[] args) {
		int[] completeBinTree = {0,10,14,16,15,12};
		Heap h1 = new Heap(completeBinTree);
		//h1.maxHeapifyTopDown(nodeIndex);
		//h1.heapifyFromCoreman(nodeIndex);
		//h1.maxHeapifyBottomUp(nodeIndex);
	    //h1.buildMaxHeapBottomUp(completeBinTree.length);
		h1.heapSort();
		h1.printHeap();
	}

}
