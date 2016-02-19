package sorting.searching;

/**
 * bble the big selection :
 * ->concept: repeatedly find the minimum element and put it at the beginnning . maintain two subarrays in the main array.
 * ->complexity o(n2)
 * 
 * bubbleSort:
 * ->concept:two loops .keep comparing the neighbouring items. swap if a[j]>a[j+1] . 
 * -> complexity o(n2)
 * 
 * @author shreyakamath
 *
 */
public class SimpleSort {
	
	static void swap(int[] a , int i, int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	static void selSort(int[] a){
		int min =a[0];int index=0;
		for(int i=0;i<a.length;i++){
			min=a[i];index=i;
			for(int j=i+1;j<a.length;j++){
				if(a[j]<=min) {min=a[j];index=j;}
			}
			swap(a,i,index);
		}
	}
	
	static void bubbleSort(int[] a){
		for(int i=0;i<a.length-1;i++){
			for(int j=0;j<a.length-1-i;j++){
				if(a[j]>a[j+1]) swap(a,j,j+1);
			}
		}
	}
	
	static void insertionSort(int[] a){
		for(int i=1;i<a.length;i++){
			int val = a[i];int j;
			for(j=i-1;j>=0;j--){
				if(a[j]>val) a[j+1]=a[j];
				else break;
			}
			a[j+1]=val;
		}
	}
	
	public static void main(String[] args) {
		int[] a ={5,4,8,1,3};
		bubbleSort(a);
		for(int i:a) System.out.print(i+" ");
	}

}
