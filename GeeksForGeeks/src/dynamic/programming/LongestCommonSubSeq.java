package dynamic.programming;

import java.util.Arrays;

public class LongestCommonSubSeq {

	static int lcsMem(String x,int l1, String y,int l2,int[][] dp){
		if(l1==0||l2==0) {dp[l1][l2]=0;}
		if(dp[l1][l2]==-1){
			if(x.charAt(l1)==y.charAt(l2)) dp[l1][l2]=1+lcsMem(x,l1-1,y,l2-1,dp);
			else dp[l1][l2]= Math.max(lcsMem(x,l1,y,l2-1,dp),lcsMem(x,l1-1,y,l2,dp));
		}
		return dp[l1][l2];
	}
	
	static int lcsTab(String x,int l1, String y,int l2){
		int[][] dp=new int[x.length()][y.length()];
		for(int i=0;i<l1;i++){
			for(int j=0;j<l2;j++){
				if(i==0||j==0) dp[i][j]=0;
				else if(x.charAt(i-1)==y.charAt(j-1)) dp[i][j]=dp[i-1][j-1]+1;
				else dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
			}
		}
		return dp[l1-1][l2-1];
	}
	public static void main(String[] args) {
		String x="AGGTAB";
		String y="GXTXAYB";
		int[][] dp=new int[x.length()][y.length()];
		for(int[] a :dp)
			Arrays.fill(a,-1);
//		System.out.println(lcsMem(x,x.length()-1,y,y.length()-1,dp)+1);
		System.out.println(lcsTab(x,x.length(),y,y.length()));
	}

}
