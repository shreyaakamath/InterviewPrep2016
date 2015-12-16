package Sorting;
/**
 * MergeSort -> using extra space and in-place merge sort. time complexity -> o(n logn) space ->constant
 * @author shreyakamath
 *
 */
public class Sort {
	
	void mergeSort(int[] a,int start,int end){
		if(end-start==1) return;
		int mid=(end+start)/2;
		mergeSort(a,start,mid);
		mergeSort(a,mid,end);
		merge(a,start,mid,end);
	}
	
	void mergeExtraSpace(int[] a , int s1, int e1 , int s2 , int e2){
		int[] m= new int[e2-s1];
		int i=s1;int j=s2;int k=0;
		while(i!=e1 && j!=e2){
			if(a[i]<a[j]) {
				m[k]=a[i];k++;i++;continue;
			}else{
				m[k]=a[j];k++;j++;continue;
			}
		}
		
		if(i==e1){
			for(int u=j;u<e2;u++){
				m[k]=a[u];k++;
			}
		}else if(j==e2){
			for(int u=i;u<e1;u++){
				m[k]=a[u];k++;
			}
		}
	}
	
	//merge without extra space . simple and clean.
	void merge(int[] a , int s1, int e1 , int e2){
		int s2=e1;
		int[] m= new int[e2-s1];
		int i=s1;int j=s2;
		while(i!=e1 && j!=e2){
			if(a[i]<a[j]) {
				i++;continue;
			}else{
				int tmp=a[j];
				for(int k=e1-1;k>=i;k--) a[k+1]=a[k];
				e1=e1+1;
				j++;
				a[i] = tmp;
				i++;
			}
		}
	}
	public static void main(String[] args) {
		Sort s = new Sort();
		int[] a ={1,10,2,8,7,3,4,12};
		s.mergeSort(a,0,8);
		for(int n : a) System.out.println(n);
	}

}
