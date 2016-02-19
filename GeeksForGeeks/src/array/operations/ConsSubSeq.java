package array.operations;

import java.util.HashMap;

public class ConsSubSeq {
	/*first add all elements to a hash. then traverse array if you find any num which can be the start of a subseq (when no cal smaller exists) then count forward a
	check how long the subseq is, do max calculation along side.
	*/
	static void find1(int[] a){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<a.length;i++){
			map.put(a[i],1);
		}
		int ans=0;
		for(int i=0;i<a.length;i++){
			if(!map.containsKey(a[i]-1)){
				int j =a[i];
				while(map.containsKey(j)) j++;
				int cnt=j-a[i];
				if(cnt>ans) ans=cnt;
			}
		}
		System.out.println(ans);
	}
	public static void main(String[] args) {
		int[] a ={1,24,9,3,22,4,21,10,20,2,23};
		find1(a);
	}

}
