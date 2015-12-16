package array.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
 * complexity -> depends on the sorting algo . merge sort O(nlogn)+O(n)=O(nlogn)
 * 
 * @author shreyakamath
 *
 */
class pair{
	int n;
	int m;
	pair(int n , int m ){
		this.n=n;
		this.m=m;
	}
	
	void print(){
		System.out.println(m+" , "+n);
	}
}
public class SumPairs {
	List<pair> calc(int[] a, int sum){
		List<pair> list = new ArrayList<pair>();
		int i=0;
		int j=a.length-1;
		int temp;
		while(i<j){
			temp=a[i]+a[j];
			if(temp==sum){
				list.add(new pair(a[i],a[j]));
				i++;j--;continue;
			}else if(temp<sum){
				i++;
			}else {
				j--;
			}
		}
		return list;
	}
	
	List<pair> calcRotated(int[] a, int sum){
		
		int n = a.length;int k;
		for(k=0;k<n;k++){
			if(a[k+1]<a[k]) break;
		}
		
		List<pair> list = new ArrayList<pair>();
		int i=(k+1)%n;
		int j=k;
		int temp;
		
		while(j!=i){
			temp=a[i]+a[j];
			if(temp==sum){
				list.add(new pair(a[i],a[j]));
				j=(j+n-1)%n;
				i=(i+1)%n;
			}else if(temp<sum){
				i=(i+1)%n;
			}else {
				j=(j+n-1)%n;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		SumPairs s = new SumPairs();
		int[] a = {4,5,6,7,0,1,2,3};
//		Arrays.sort(a);
		List<pair> list = s.calcRotated(a,5);
		for(pair p : list){
			p.print();
		}
	}

}
