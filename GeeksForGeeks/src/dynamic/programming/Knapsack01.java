package dynamic.programming;

public class Knapsack01 {

	
	static int knapsack(int[]v , int[]w , int weight, int n ){ 
		if(n==0|| weight==0) return 0;
		if(w[n-1]>weight) return knapsack(v,w,weight,n-1);
		return Math.max(v[n-1]+knapsack(v,w,weight-w[n-1],n-1), knapsack(v,w,weight,n-1));
	}
	
	static int knapsackMem(int[]v , int[]w , int weight, int n , int[] dp){ 
		if(n==0|| weight==0) dp[n]=0;
		else if(dp[n-1]==0){
			if(w[n-1]>weight) dp[n-1]= knapsack(v,w,weight,n-1);
			else dp[n-1]= Math.max(v[n-1]+knapsack(v,w,weight-w[n-1],n-1), knapsack(v,w,weight,n-1));
		}
		return dp[n-1];
	}
	
	//why is this not working ? looks perfect!
	static int knapsackTab(int[]v , int[]w , int wt, int n ){
		int[][] dp=new int[n+1][wt+1];
		for(int i=0;i<=n;i++)
			for(int j=0;j<=wt;j++){
				if(i==0||j==0) dp[i][j]=0;
				else if(w[i-1]<=wt) dp[i][j]=Math.max(v[i-1]+dp[i-1][wt-w[i-1]],dp[i-1][wt]); 
				else dp[i][j]=dp[i-1][j];
			}
		return dp[n][wt];
	}
	public static void main(String[] args) {
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
//	    int[] dp= new int[val.length];
	    System.out.println(knapsackTab(val,wt,W,val.length));
	}

}
