package heap.operations;
/**
 * heapify -> o(logn)
 * 
 * @author shreyakamath
 *
 */
public class MaxHeap {

	int[] a;
	int size;
	
	MaxHeap(int[] a,int size){
		this.a=a;
		this.size=size;
	}
	
	 void swap(int i, int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	 int left(int id,int size){
		int val =id*2+1;
		if(val<size) return val;
		else return -1;
	}
	 int right(int id, int size){
		int val =id*2+2;
		if(val<size) return val;
		else return -1;
	}
	
	 int parent(int id){
		 return (id-1)/2;
	 }
	//top down 
	 void maxHeapify(int id, int size){
		int largest = id;
		int left = left(id,size);
		int right = right(id,size);
		if(left>0 && a[left]>a[largest]) largest=left;
		if(right>0 && a[right]>a[largest]) largest=right;
		if(largest!=id){
			swap(largest,id);
			maxHeapify(largest,size);
		}
	}
	
	//bottom up
	 void buildMaxHeap(int[] a){
		int len = size;
		for(int i=len/2-1;i>=0;i--)
			maxHeapify(i,a.length);
	}
	
	//top down
	 void heapSort(){
		buildMaxHeap(a);
		int size=a.length;
		while(size>0){
			swap(size-1,0);
			size-=1;
			maxHeapify(0,size);
		}
	}
	
	 //o(1) complexity
	 int getMax(){
		 return a[0];
	 }
	 //log(n) complexity
	 int extractMax(){
		 int val = a[0];
		 swap(0,size-1);
		 maxHeapify(0,size-1);
		 size--;
		 return val;
	 }
	 
	 //o(logn) time complexity DIFFERENT have to heapify downwards
	 void decreaseKey(int pos){
		 if(pos>(a.length/2)) a[pos]-=1;
		 else{
			 a[pos]-=1;
			 maxHeapify(pos,a.length);
		 }
		 System.out.println("pos---"+pos);
	 }
	 
	 //log(n) time complexity
	 int insert(int val){
		 if(size>=a.length) return -1;
		 a[size]=val;
		 int index=size;
		 size++;
		 while(index!=0){
			 int parent=parent(index);
			 if(val>a[parent]) {
				 swap(index,parent);
			 }
			 index=parent;
		 }
		 return 0;
	 }
	 
	 //o(logn) time complexity
	 void delete(int index){
		 if(index==size-1){ 
			 size--;
			 return;
		 }
		 if(index>size/2){
			 for(int i=index;i<size-1;i++)
				 a[index]=a[index+1];
			 return;
		 }
		 int left=left(index,size);
		 int right=right(index,size);
		 int swapIn=0;
		 if(left==-1 && right==-1) {swapIn=index;}
		 else if(left==-1){swapIn=right;}
		 else if(right==-1){swapIn=left;}
		 else if(a[left]>a[right]) swapIn=left;
		 else swapIn=right;
		 a[index] =a[swapIn];
		 delete(swapIn);
	 }
	 
	 void print(){
			for(int i=0;i<size;i++) System.out.println(a[i]);
	 }
	 
	public static void main(String[] args) {
//		int[] a =new int[10];
//		for(int i=0;i<5;i++){
//			a[i]=10-i;
//		}
		int[] a ={24,15,2,11,6,30,1,0,0,0};
		MaxHeap mxh = new MaxHeap(a,7);
		mxh.buildMaxHeap(a);
//		System.out.println("get max ---"+mxh.getMax());
//		System.out.println("extract max ----"+mxh.extractMax());
//		mxh.decreaseKey(0);
//		mxh.insert(30);
		mxh.print();
		System.out.println();
//		mxh.delete(2);
//		mxh.print();
//		System.out.println("get max after decrease key---"+mxh.getMax());
	}

}
