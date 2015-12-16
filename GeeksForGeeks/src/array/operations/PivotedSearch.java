package array.operations;
/**
 * http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 * O(nlogn)
 * @author shreyakamath
 *
 */
public class PivotedSearch {

	boolean search(int[] a , int n){
		int prev=a[0];
		int start1=0;int end1=0;
		int end2=a.length;int start2=0;
		for(int i=1;i<a.length;i++){
			if(a[i]-prev < 0){
				end1=i;
				start2=i;
				break;
			}
		}
		return binarySearch(a,start1,end1,n)|| binarySearch(a,start2,end2,n);
	}
	
	boolean binarySearch(int[] a ,int start , int end , int n){
		if(start==end) return false;
		int mid=(end+start)/2;
		if(a[mid]==n) {System.out.println("found");return true;}
		return binarySearch(a,start,mid,n)||binarySearch(a,mid+1,end,n);
	}
	public static void main(String[] args) {
		int a[]={3,4,5,1,2};
		PivotedSearch p = new PivotedSearch();
		System.out.println(p.search(a,9));
//		p.binarySearch(a,0,a.length,4);
	}

}
