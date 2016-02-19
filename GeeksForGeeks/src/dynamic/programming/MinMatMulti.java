package dynamic.programming;

public class MinMatMulti {
	
	static int minMatMult(int[] p,int i , int j,int[][] dp){
		if(i==j) dp[i][j]= 0;
		else if(dp[i][j]==0){
			int min=(int)Double.POSITIVE_INFINITY;
			int count=0;
			for(int k=i;k<j;k++){
				count = minMatMult(p,i,k,dp)+minMatMult(p,k+1,j,dp)+(p[i-1]*p[k]*p[j]);
				if(count<min) min=count;
				dp[i][j]=min;
			}
		}
		return dp[i][j];
	}
	public static void main(String[] args) {
		int[] p={10,30,50,60};
		int len = p.length;
		int[][] dp= new int[len+1][len+1];
		System.out.println(minMatMult(p,1,p.length-1,dp));
	}

}
