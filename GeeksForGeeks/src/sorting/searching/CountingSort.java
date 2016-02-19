package sorting.searching;
/**
 * Time Complexity: O(n+k) where n is the number of elements in input array and k is the range of input.
 *	Auxiliary Space: O(n+k)
 * @author shreyakamath
 *
 */
public class CountingSort {

	static void simpleCountSort(int[] a, int k){
		int[] cnt = new int[k+1];//range is 0-7 so cnt should be able to store from 0 upto 7 so k+1
		int[] b = new int[a.length+1];// same for b. basically indexing from 1. 
		
		for(int i=0;i<a.length;i++) cnt[a[i]]+=1;
		for(int i=1;i<cnt.length;i++) cnt[i]=cnt[i]+cnt[i-1];
		for(int i=0;i<a.length;i++){
			int val = a[i];
			int pos = cnt[val];
			b[pos]=val;
			cnt[val]-=1;
		}
		for(int i=0;i<a.length;i++)
			a[i]=b[i+1];//because a is indexed from 0 and b is indexed 
	}
	
	static void countSortForRadix(int[] a, int k, int e){
		int[] cnt = new int[k+1];//range is 0-7 so cnt should be able to store from 0 upto 7 so k+1
		int[] b = new int[a.length+1];// same for b. basically indexing from 1. 
		
		for(int i=0;i<a.length;i++) cnt[(a[i]/e )%10]+=1;
		for(int i=1;i<cnt.length;i++) cnt[i]=cnt[i]+cnt[i-1];
		for(int i=0;i<a.length;i++){
			int val = (a[i]/e)%10;
			int pos = cnt[val];
			b[pos]=val;
			cnt[val]-=1;
		}
		for(int i=0;i<a.length;i++)
			a[i]=b[i+1];//because a is indexed from 0 and b is indexed 
	}
	static int getMax(int[] a){
		int max=a[0];
		for(int i=1;i<a.length;i++){
			if(a[i]>max) max=a[i];
		}
		return max;
	}
	static void radixSort(int[] a,int k){
		int max = getMax(a);
		for(int i=1;max/i>0;i*=10){
			countSortForRadix(a,k,i);
		}
	}
	public static void main(String[] args) {
		int[] a ={1,4,1,2,7,5,2};
		radixSort(a,7);
		for(int i:a) System.out.println(i);
	}

}
