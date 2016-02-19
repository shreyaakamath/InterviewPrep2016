package dynamic.programming;

public class Fibonacci {

	static int fibNormal(int n){
		if(n==0) return 0;
		if(n==1) return 1;
		return fibNormal(n-1)+ fibNormal(n-2);
	}
	//dynamic programming using memorization method -> fill table on demand 
	static int fibMem(int n ,  int[] a){
		if(n<=1) a[n]=n;
		else if(a[n]==0) a[n]=fibMem(n-1,a)+fibMem(n-2,a);
		return a[n];
	}
	
	//dynamic programming using tabulation method -> fill all values in table 
	static int fibTab(int n){
		int[] a = new int[n+1];
		a[0]=0;a[1]=1;
		for(int i=2;i<=n;i++){
			a[i]=a[i-1]+a[i-2];
		}
		return a[n];
	}
	public static void main(String[] args) {
//		System.out.println(fibMem(4,new int[5]));
		System.out.println(fibTab(4));
	}

}
