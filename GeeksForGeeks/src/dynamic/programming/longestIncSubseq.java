package dynamic.programming;

import java.util.Arrays;

import stack.operations.Stack;

public class longestIncSubseq {
	
	static void lisPartial(int[] a){
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<a.length;i++){
			int val = a[i];
			if(stack.isEmpty()) stack.push(val);
			else if(stack.peek() < val) stack.push(val);
		}
		
		System.out.println(stack.size());
		stack.print();
	}
	
	static void lisDP(int[] a){
		int[] dp = new int[a.length];
		int[] prev = new int[a.length];
		Arrays.fill(prev,-1);
		for(int i=0;i<a.length;i++){
			for(int j=0;j<i;j++){
				if(dp[j]+1>dp[i] && a[j]<a[i]){
					dp[i]=dp[j]+1;
					prev[i]=j;
				}
			}
		}
		int max=0;int maxi=0;
		for(int i=0;i<dp.length;i++){
			if(dp[i]>max) {
				max=dp[i];
				maxi=i;
			}
		}
		if(max>0) max+=1;
		System.out.println("lis length is "+max);
		System.out.println("lis is :");
		while(maxi!=-1){
			System.out.print(a[maxi]+" ");
			maxi=prev[maxi];
		}
		
		
	}
	public static void main(String[] args) {
		int[] a = {10,22,9,33,21,50,41,60,80};
//		lis(a);
		lisDP(a);
	}

}
