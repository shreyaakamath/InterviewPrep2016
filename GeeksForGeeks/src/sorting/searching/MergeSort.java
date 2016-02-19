package sorting.searching;
/**
 * Merge Sort:
 * ->concept:
 * ->complexity: o(nlogn) best , worst, average. in all cases splits in half , sorts , merges. 
 * @author shreyakamath
 *
 */
public class MergeSort {
	
	static void mergeSort(int[] a , int start , int end){
		if(end-start ==1) return;
		int mid=(start+end)/2;
		mergeSort(a,start,mid);
		mergeSort(a,mid,end);
		merge(a,start,mid,end);
	}
	
	static void merge(int[] a , int start , int mid , int end){
		int len=end-start;
		int[] b = new int[len];
		System.arraycopy(a,start,b,0,len);
		int i=start; int j=mid;int k=0;
		while(i<mid && j<end){
			if(a[i]<a[j])b[k++]=a[i++];
			else b[k++]=a[j++];
		}
		if(i>=mid){
			for(int y=j;y<len;y++) b[k++] = a[y];
		} else if (j>=end){
			for(int y=i;y<mid;y++) b[k++]=a[y];
		}
		j=0;
		for(i=start;i<end;i++){
			a[i]=b[j++];
		}
	}
	public static void main(String[] args) {
		int[] a ={5,4,8,1,3};
		mergeSort(a,0,a.length);
		for(int i:a) System.out.println(i);
	}

}
