package linked.list.operations;

public class ArrayQuickSort {
	int[] a ={10,9,8,7,6,5};
	//int[] a={7,4,1,8,10};
	
	void swap(int i,int j){
		int tmp=a[i];
		a[i]=a[j];
		a[j]=tmp;
	}
	int partition(int low ,int hi){
		int elem=a[low];
		int i=low+1;
		int j=hi;
		while(true){
			while(a[i]<elem){
				if(i==hi) break;
				System.out.println("less");
				i++;
			}
			while(a[j]>=elem){
				if(j==low) break;
				j--;
				System.out.println("more");
			}
			if(j<i) break;//will happen for array with random vals
			if(i==j) break;//will happen for reverse sorted array 
			swap(i,j);
		}
		swap(low,j);
		return j;
	}
	
	void quickSort(int m , int n){
		if(n<=m) return;
		int p = partition(m,n);
		quickSort(m,p-1);
		quickSort(p+1,n);
	}
	
	void print(){
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
	public static void main(String[] args) {
		ArrayQuickSort q1 = new ArrayQuickSort();
		q1.quickSort(0,q1.a.length-1);
		q1.print();
	}
	
}
