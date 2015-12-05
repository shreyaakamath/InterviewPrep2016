package sorting.algorithms;

public class HeapSort {
	static int heapSize = 0;
	/*assume left and right child of i are heaps . ensure value at i is moved to correct place in heap*/
	static void max_heapify(int[] ar , int i ) {
		int left = left(i);
		int right = right(i);
		int largest = i;
		if(left <= heapSize && ar[left] > ar[i]) largest = left;
		if(right <= heapSize && ar[right] > ar[largest]) largest = right;
		if(largest !=i) {
			swap (ar,i,largest);
			max_heapify(ar, largest);
		}
	}
	
	static void build_heap(int[] ar){
		int len = ar.length; 
		for(int i = len/2;i>0;i--)
			max_heapify(ar, i);
	}
	
	static void heapsort(int[] ar ){
		build_heap(ar);
		for(int i = ar.length-1;i>=2 ; i--){
		int temp = ar[1];ar[1]=ar[i];ar[i] = temp;
		heapSize -=1;
		max_heapify(ar, 1);
		}
		
	}
	static int left( int i ){
		return 2*i;
	}
	
	static int right( int i ){
		return 2*i+1;
	}
	
	static int parent(int i ){
		return i/2;
	}
	
	static void swap(int[] arr, int i , int j ){
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	static int heap_maximum(int[] ar){
		return ar[1];
	}
	
	/*returns -1 for heap underflow*/
	static int extractHeapMax(int[] ar){
		if(heapSize<1) return -1;
		int max = ar[1];
		swap(ar,1,heapSize);
		heapSize-=1;
		max_heapify(ar, 1);
		return max;
	}
	
	/*key provided cannot be smaller than existing array value*/
	static void heapIncreaseKey(int[]ar , int i , int key){
		if(i>heapSize || i<1 ) {System.out.println("array index is wrong");return;}
		if(ar[i] > key ) {System.out.println("key cannot be smaller than existing value");return;}
		ar[i] = key;
		while(i>0 && ar[parent(i)] < ar[i]) {
			swap(ar,parent(i),i);
			i = parent(i);
		}
	}
	
	public static void main(String args[]){
		//int[] arr = {0,27,17,3,16,13,10,1,5,7,12,4,8,9,0};
		int[] arr = {0,4,1,3,2,16,9,10,14,8,7};
		heapSize = arr.length-1;
		//max_heapify(arr, 3);
		//build_heap(arr);
		heapsort(arr);
		for(int n : arr) System.out.print(n+" ");
	}
}
