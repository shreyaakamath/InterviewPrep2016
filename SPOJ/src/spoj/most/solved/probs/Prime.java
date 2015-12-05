package spoj.most.solved.probs;
import java.util.Scanner;

/*
 * http://www.spoj.com/problems/PRIME1/
 */

public class Prime {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		int[] m = new int[test];
		int[] n = new int[test];
		for(int i =0;i<test;i++){
			m[i] = scan.nextInt();
			n[i] = scan.nextInt();
		}
		for(int i =0;i<test;i++){
			numberOfPrimes(m[i], n[i]);
			System.out.println();
		}
		
	}
		
	static void numberOfPrimes(int m ,int n){
		for(double i =m ;i<=n;i++){
			if(i==1) continue;
			if(i==2||i==3){System.out.println((int)i); continue;}
			int half =(int) Math.sqrt(i); boolean prime = true;;
			for(int j=2;j<=half;j++){
				if(i%j==0) {
					prime = false;break;
				}
			}
			if(prime) System.out.println((int)i);
		}
	}
	
	/*
	 * sieve of erasthmus -> print all prime numbers below n 
	 */
	static void primeSieve(int m){
		if(m>2){
			int[] nums = new int[m];
			boolean[] marked = new boolean[m];
			
			for(int i=0;i<m;i++)
				nums[i] = i;
			
			for(int i =2;i<m;i++){
				int j =2;
				while(j*i < m ){
					marked[j*i] = true;
					j++;
				}
			}
			
			for(int i =2;i<m;i++){
				if(!marked[i]) System.out.println(i);
			}
		
		}
			
	}
}

/**
 * ARCHIVED FUNCTIONS
 * 
 * static boolean isPrime(int n){
		boolean prime = false;
		if(n<=3) return n>1;
		if(n%2==0 || n%3==0) prime = false;
		else if((n+1)%6==0) prime= true;
		else if((n-1)%6==0) prime= true;
		return prime;
	}
 * */

