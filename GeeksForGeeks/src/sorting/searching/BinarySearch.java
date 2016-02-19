package sorting.searching;

public class BinarySearch {
	
	static int  search(int[] a ,int key, int start , int end){
		if(start>end) return -1;
		int mid=(start+end)/2;
		if(a[mid]==key) return mid;
		if(key<a[mid]) return search(a,key,start,mid);
		else return search(a,key,mid+1,end);
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		System.out.println(search(a,4,0,a.length));
	}

}
