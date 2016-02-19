package sorting.searching;
/**
 * heapify -> o(logn)
 * 
 * @author shreyakamath
 *
 */
public class HeapSort {

	static void swap(int[] a , int i, int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	static int left(int[] a , int id,int size){
		int val =id*2+1;
		if(val<size) return val;
		else return -1;
	}
	static int right(int[] a , int id, int size){
		int val =id*2+2;
		if(val<size) return val;
		else return -1;
	}
	
	//top down 
	static void maxHeapify(int[] a , int id, int size){
		int largest = id;
		int left = left(a,id,size);
		int right = right(a,id,size);
		if(left>0 && a[left]>a[largest]) largest=left;
		if(right>0 && a[right]>a[largest]) largest=right;
		if(largest!=id){
			swap(a,largest,id);
			maxHeapify(a,largest,size);
		}
	}
	
	//bottom up
	static void buildMaxHeap(int[] a){
		int len = a.length;
		for(int i=len/2;i>=0;i--)
			maxHeapify(a,i,a.length);
	}
	
	//top down
	static void heapSort(int[] a){
		buildMaxHeap(a);
		int size=a.length;
		while(size>0){
			swap(a,size-1,0);
			size-=1;
			maxHeapify(a,0,size);
		}
	}
	
	public static void main(String[] args) {
		int[] a ={5,4,8,10,3};
//		maxHeapify(a,1);
//		buildMaxHeap(a);
		heapSort(a);
		for(int i:a) System.out.println(i);
	}

}
