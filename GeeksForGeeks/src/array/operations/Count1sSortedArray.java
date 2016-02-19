package array.operations;

public class Count1sSortedArray {
	 
	static int count(int[] a , int start,int end){
		if(start>end) return 0;//TODO
		int mid=(start+end)/2;
		if(a[mid]==0) return count(a,start,mid-1);
		if(a[mid]==1 && a[mid+1]==0) return mid+1;
		return count(a,mid+1,end);
	}
	public static void main(String[] args) {
		int[] a ={0,0,0,0,0,0,0};
		System.out.println(count(a,0,a.length));
	}

}
