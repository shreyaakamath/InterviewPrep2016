package hashing.operations;

import java.util.HashMap;

public class ArrayDupKAway {
	
	static void dups(int a[],int k){
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		int count=0;
		for(int i=0;i<a.length;i++){
			if(map.containsKey(a[i]) && i-map.get(a[i])==k) count++;
			else map.put(a[i],i);
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		int[] a={1,2,3,4,1,2,3,4};
		dups(a,3);
	}

}
