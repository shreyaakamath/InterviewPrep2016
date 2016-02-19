package Backtracking;

import java.util.Arrays;

public class PermStr {

	static void swap(StringBuilder str , int l ,int r){
		char right = str.charAt(r);
		char left = str.charAt(l);
		str.setCharAt(l,right);
		str.setCharAt(r,left);
	}
	static void perm(StringBuilder str, int l , int r){
		if(l==r) System.out.println(str);
		else{
			for(int i=l;i<=r;i++){
				swap(str,l,i);
				perm(str,l+1,r);
				swap(str,l,i);
			}
		}
	}
	
	static void sort(StringBuilder str , int left , int right){
		String sub = str.substring(left,right);
		char[] arr = sub.toCharArray();
		Arrays.sort(arr);
		int k=0;
		for(int i=left;i<right;i++){
			{str.setCharAt(left,arr[k]);k++;}
		}
		return;
	}
	
	static int findCeil(StringBuilder str, int first){
		int max=(int)Double.POSITIVE_INFINITY;
		int right=first;
		for(int j=first;j<str.length();j++){
			int diff = str.charAt(j) - str.charAt(first);	
			if(diff<max) {
				max =diff;
				right=j;
			}
		}
		return right;
	}
	static void permLex(StringBuilder str){
		/*first lexicographic permutation is the sorted string*/
		char[] arr = str.toString().toCharArray();
		Arrays.sort(arr);
		int k=0;
		for(int i=0;i<str.length();i++)
			{str.setCharAt(i,arr[k]);k++;}
		System.out.println(str);
		boolean finished=false;
		while(!finished){
			System.out.println(str);
			int i;
			for(i=str.length()-2;i>=0;--i){
				if(str.charAt(i)<str.charAt(i+1)) break;
			}
			if(i==-1) finished=true;
			else{
				int first=i;
				int right=findCeil(str,first);
				swap(str,first,right);
				sort(str,first+1,right+1);
			}
			
		}
		/*keep finding next permutations until no more possible */
//		for(int i=str.length()-2;i>=0;i--){
//			int first=0;int right=0;
//			int max=(int)Double.POSITIVE_INFINITY;
//			if(str.charAt(i)<str.charAt(i+1)){
//				first=i;
//				for(int j=first;j<str.length();j++){
//					int diff = str.charAt(j) - str.charAt(first);	
//					if(diff<max) {
//						max =diff;
//						right=j;
//					}
//				}
//				swap(str,first,right);
//				sort(str,first+1,right+1);
//				System.out.println(str);
//			}
//		}
	}
	public static void main(String[] args) {
		String str ="abc";
//		perm(new StringBuilder(str),0,str.length()-1);
		permLex(new StringBuilder("cba"));
	}

}
