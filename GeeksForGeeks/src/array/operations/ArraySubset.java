package array.operations;

import java.util.Arrays;

/**
 * main array a[1,2,3...m] sub array b[1,2,3...n]
 * Sol1) use two loops -> o(n2) time comlexity 
 * sol2) sorting + binary search -> O(mlogm +nlogm)
 * sol3) sorting + merging -> O(mlogm + nlogn) <---- this is better than 2 
 * sol4) hashing -> not correct because cannot detect dups
 * @author shreyakamath
 *
 */
public class ArraySubset {
	
	//complexity O(mlogm + nlogn)
	static void isSubset(int[] a, int[] b){
		Arrays.sort(a);
		Arrays.sort(b);
		
		int j=0;int i=0;
		while(i<a.length){
			if(j==b.length){System.out.println("found");break;}
			if(a[i]<b[j]) i++;
			else if(a[i]==b[j]) j++;
			else {System.out.println("not found");break;}
		}
	}
	public static void main(String[] args) {
		int[] a={11,1,13,21,7};
		int[] b={11,3,7,1};
		isSubset(a,b);
	}

}
