package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumK {

	void subset(int[] arr , int start, int sum , int k , List<Integer> list,int n){
		for(int i=start;i<n;i++){
			int val = arr[i];
			sum+=val;list.add(val);
			if(sum<k) subset(arr,start+1,sum,k ,list,n);
			else if (sum>k){//backtrack
				sum-=val;
				list.remove(new Integer(val));
//				return;
			}else{
				System.out.println("sum="+sum);
				System.out.println("found sol");
				for(int num :list)
					System.out.println(num);
				System.out.println();
				list.remove(new Integer(val));
				return;
			}
		}
	}
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		int[] arr ={1,2,3,4};
		SubsetSumK s = new SubsetSumK();
		s.subset(arr,0,0,6,list,4);
		
	}

}
