package dynamic.programming;

public class RodCutting {


	static int rodCut(int[] p , int n, int[] dp ){
		if(n==0) dp[n]= 0;
		else if(dp[n]==0){
			int q = (int)Double.NEGATIVE_INFINITY;
			for(int i=1;i<=n;i++){
				dp[n] = Math.max(dp[n],p[i]+rodCut(p,n-i,dp));
			}
		}
		return dp[n];
	}
	
	
	static int rodCutTab(int[] p , int n ){
		int[] dp = new int[n+1];
		for(int i=1;i<=n;i++){
			int min=(int)Double.NEGATIVE_INFINITY;
			for(int j=0;j<i;j++){
				if(j==0) dp[j]=0;
				min=Math.max(min,p[j+1]+dp[i-j-1]);
			}
			dp[i]=min;
		}
		return dp[n];
	}
	public static void main(String[] args) {
		int p[] = {0,1, 5, 8, 9, 10, 17, 17, 20};
		int[] dp = new int[p.length];
		System.out.println(rodCut(p,8,dp));
		System.out.println(rodCutTab(p,8));
	}

}
