package heap.operations;
/**
 * @author shreyakamath
 */
public class MinHeap {

	int[] a;
	int size;
	
	MinHeap(int[] a,int size){
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
	 void minHeapify(int id, int size){
		int smallest = id;
		int left = left(id,size);
		int right = right(id,size);
		if(left>0 && a[left]<a[smallest]) smallest=left;
		if(right>0 && a[right]<a[smallest]) smallest=right;
		if(smallest!=id){
			swap(smallest,id);
			minHeapify(smallest,size);
		}
	}
	
	//bottom up
	 void buildMinHeap(int[] a){
		int len = size;
		for(int i=len/2-1;i>=0;i--)
			minHeapify(i,len);
	}
	
	
	 //o(1) complexity
	 int getMin(){
		 return a[0];
	 }
	 //log(n) complexity
	 int extractMin(){
		 int val = a[0];
		 swap(0,size-1);
		 minHeapify(0,size-1);
		 size--;
		 return val;
	 }
	 
	 //o(logn) time complexity DIFFERENT have to heapifiy upwards
	 void decreaseKey(int pos){
		 if(pos>(a.length/2)) a[pos]-=1;
		 else{
			 a[pos]-=1;
			 insert(a[pos],pos,false);
	 	}
	 }
	 
	 //log(n) time complexity TODO
	 int insert(int val, int put,boolean newVal){
		 if(size>=a.length) return -1;
		 a[put]=val;
		 int index=put;
		 if(newVal)size++;
		 while(index!=0){
			 int parent=parent(index);
			 if(val<a[parent]) {
				 swap(index,parent);
			 }
			 index=parent;
		 }
		 return 0;
	 }
	 
	 //o(logn) time complexity TODO
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
		int[] a ={24,15,2,11,6,30,1,0,0,0};
		MinHeap minh = new MinHeap(a,7);
		minh.buildMinHeap(a);
//		minh.extractMin();
//		minh.decreaseKey(2);
		minh.insert(0,minh.size,true);
		minh.print();
	}

}
