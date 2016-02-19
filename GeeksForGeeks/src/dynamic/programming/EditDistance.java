package dynamic.programming;

public class EditDistance {
	static int min(int a, int b , int c){
		return Math.min(a,Math.min(b,c));
	}

	static int editDist(String x , String y , int m , int n){
		if(m==0) return n;
		if(n==0) return m;
		if(x.charAt(m-1) == y.charAt(n-1)) return editDist(x,y,m-1,n-1);
		return 1+ min(editDist(x,y,m-1,n),
					  editDist(x,y,m,n-1),
					  editDist(x,y,m-1,n-1));
	}
	
	static int editDistMem(String x , String y , int m , int n,int[][] dp){
		if(dp[m][n]==0){
			if(m==0) dp[m][n]= n;
			else if(n==0) dp[m][n]= m;
			else if(x.charAt(m) == y.charAt(n)){
				dp[m][n]= editDistMem(x,y,m-1,n-1,dp);
			}
			else {
				dp[m][n]= 1+ min(editDistMem(x,y,m-1,n,dp),
						  editDistMem(x,y,m,n-1,dp),
						  editDistMem(x,y,m-1,n-1,dp));
			}
		}
		return dp[m][n];
	}
	
	static int editDistTab(String x , String y,int m, int n ){
		int[][] dp=new int[x.length()][y.length()];
		for(int i=0;i<x.length();i++){
			for(int j=0;j<y.length();j++){
				if(i==0) dp[i][j]=j;
				else if(j==0) dp[i][j]=i;
				else if(x.charAt(i)==x.charAt(j)) dp[i][j]=dp[i-1][j-1];
				else dp[i][j] = 1+ min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]);
			}
		}
		return dp[m-1][n-1]+1;
	}
	public static void main(String[] args) {
		String x= "saturday";
		String y="sunday";
//		int[][] dp=new int[x.length()][y.length()];
//		System.out.println(editDistMem(x,y,x.length()-1,y.length()-1,dp));
		System.out.println(editDistTab(x,y,x.length(),y.length()));

	}

}
