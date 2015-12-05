package sorting;

public class SortingImplemented {

	int[] a;
	int[] merged;
	
	public SortingImplemented(int[] val) {
	this.a=val;
	merged = new int[a.length];
	}
	
	public void insertionSort(){
		int key;
		for (int i =1; i< a.length; i++){
			key = a[i];
			int j=i-1;
			while (j>=0 && a[j] > key) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1]=key;
		}
	}
	
	public void mergeSortedArray(int i , int n , int j , int m ){
	int k=0;
	
	while(i<=n && j<=m) {
		if(a[i] <= a[j]) {merged[k]=a[i]; i++ ; k++; } 
		else{merged[k]=a[j];j++;k++;}
	}
	if(i>n){for(int p=j; p<=m;p++){merged[k]=a[p];k++;}}
	if(j>m) {for(int p=i;p<=n;p++){merged[k]=a[p];k++;}}
	
	/*for(int num : merged){
		System.out.print(num);
	}*/
	}
	
	public void mergeSort(int i , int j ){
		if(i==j) return;
		int m = (i+j)/2;
		mergeSort(i,m);
		mergeSort(m+1,j+1);
		mergeSortedArray(i, m, m+1, j);
	}
	
	public void printMerged(){
		for(int i : merged) {
			System.out.print(i+",");
		}
	}
	
	public void bubbleSort(){
		for(int i =0;i<a.length;i++)
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]){
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		for(int i :a) System.out.print(i+",");
				
	}
	public int binarySearch(int val){
		//using binary search on sorted array
		insertionSort();
		int first = 0;
		int last = a.length -1;
		int mid=0;
		while (first <= last ){
			mid = (last + first) /2 ; 
			if(val == a[mid]){break;}
			if(val < a[mid]) {last = mid-1; }
			else {first = mid+1;}
		}
		return mid;
	}
	
	public void printArray(){
		for (int num : a) {
			System.out.print(num);
		}
	}

	
	public static void main(String[] args) {
		int[] array = {5,2,4,7,1,3,2,6};
		SortingImplemented obj = new SortingImplemented(array );
		//obj.insertionSort();
		//System.out.println("exists at index = "+(obj.binarySearch(0)+1));
		//obj.mergeSortedArray(0, 2, 3, 5);
		//obj.bubbleSort();
		
		obj.mergeSort(0, array.length -1);
		//obj.printMerged();
		
		
		
	}

}
