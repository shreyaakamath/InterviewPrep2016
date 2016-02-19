package dynamic.programming;

public class MinCostPath {
	
	static int min(int a, int b , int c){
		return Math.min(a,Math.min(b,c));
	}
	
	static int minCost(int[][] cost , int m , int n){
		if(m==0 && n==0) return cost[m][n];
		if(m<0||n<0) return (int)Double.POSITIVE_INFINITY;
		else return cost[m][n]+min(minCost(cost,m-1,n),minCost(cost,m,n-1),minCost(cost,m-1,n-1)); 
	}
	
	static int minCostMem(int[][] cost , int m , int n,int[][] dp){
		if(dp[m][n]==0){
			if(m==0 && n==0) dp[m][n]=cost[m][n];
			if(m<0||n<0) dp[m][n]= (int)Double.POSITIVE_INFINITY;
			else dp[m][n]= cost[m][n]+min(minCost(cost,m-1,n),minCost(cost,m,n-1),minCost(cost,m-1,n-1));
		}
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		int[][] a={{1,2,3},{4,8,2},{1,5,3}};
		int[][] dp=new int[3][3];
//		System.out.println(minCost(a,2,2));
		System.out.println(minCostMem(a,2,2,dp));
	}

}
