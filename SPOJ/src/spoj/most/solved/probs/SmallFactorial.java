package spoj.most.solved.probs;

import java.math.BigInteger;
import java.util.Scanner;

public class SmallFactorial {

	static void getFactorial(int n){
		BigInteger factorial = new BigInteger("1");
		for(int i =2;i<=n;i++)
			factorial = factorial.multiply(new BigInteger(i+""));
		System.out.println(factorial.toString());
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		int[]n = new int[test];
		for(int i=0;i<test;i++){
			n[i] = scan.nextInt();
		}
		for(int i=0;i<test;i++) getFactorial(n[i]);
	}
}