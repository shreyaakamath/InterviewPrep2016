package array.operations;

import java.util.Arrays;

public class Kadane {

	int[] maxSubArray(int[] a){
		int max_so_far =0;
		int max_ending_here=0;
		int start=0;
		int end=0;
		for(int i=0;i<a.length;i++){
			max_ending_here+=a[i];
			if(max_ending_here < 0){
				max_ending_here=0;
				start=i+1;
			}
			if(max_so_far<max_ending_here){
				max_so_far=max_ending_here;
				end=i;
			}
		}
		System.out.println(max_so_far);
		return Arrays.copyOfRange(a,start,end+1);
	}
	
	
	public static void main(String[] args) {
		Kadane k = new Kadane();
		int a[]={-2,1,-3,4,-1,2,1,-5,4};
		int[] b=k.maxSubArray(a);
		for(int i :b) System.out.println(i);
	}

}
