package linked.list.operations;

public class ArrayInsertionSort {
	public static void main(String[] args) {

		int[] a ={ 7,1,2,4,5,6};
		int j=1;
		int i =j;
		int val;
		while(j<a.length){
			val = a[j];
			for(i=j-1;i>=0;i--){
				if(a[i]>val) a[i+1]=a[i];
				else break;
			}
			a[i+1]=val;
			j++;
		}
		for(i=0;i<a.length;i++)System.out.print(a[i]+" ");
	}
	
}
