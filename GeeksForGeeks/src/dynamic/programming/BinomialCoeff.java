package dynamic.programming;

public class BinomialCoeff {

	static int binomial(int n , int k){
		if(k==0) return 1;
		if(n==k) return 1;
		return binomial(n-1,k-1)+binomial(n-1,k);
	}
	

	static int binomialTab(int n , int k){
		int[][] dp = new int[n+1][k+1];
		
		////fill base cases in table 
		for(int i=0;i<=n;i++){
			dp[i][0]=1;
			if(i<=k) dp[i][i]=1;
		}
		
		//check the trace of the binomial function. the value of j is never greater than k(obvious)
		//but for each iteration the value should not go up till k (can see this in the trace) it should go only up till the min(i,k)
		for(int i=1;i<=n;i++){
			for(int j=1;j<=Math.min(i,k);j++){
				dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
			}
		}
		return dp[n][k];
	}

	public static void main(String[] args) {
		System.out.println(binomialTab(3,2));
	}

}
