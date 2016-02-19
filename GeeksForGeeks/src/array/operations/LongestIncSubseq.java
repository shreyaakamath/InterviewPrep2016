package array.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestIncSubseq {

	//complexity is o(n) -> longest consecutive increasing subseq not longest increasing subseq
	static void longestConsIncSubseq(int[] a){
		HashMap<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		int maxKey=0;int max=0;
		for(int i=0;i<a.length;i++){
			int prev=a[i]-1;
			if(map.containsKey(prev)){
				List<Integer> list = map.get(prev);
				int cnt=list.size()+1;
				list.add(a[i]);
				map.put(a[i],list);
				map.remove(prev);
				if(cnt>max){ max=cnt;maxKey=a[i];}
			}else{
				List<Integer> list = new ArrayList<Integer>();
				list.add(a[i]);
				map.put(a[i],list);
			}
		}
		System.out.println("length of list= "+max);
		for(int i: map.get(maxKey)) System.out.print(i+" ");
	}
	
	public static void main(String[] args) {
		int[] a = {2,5,3,7,11,8,10,13,6};
		longestConsIncSubseq(a);
	}

}
