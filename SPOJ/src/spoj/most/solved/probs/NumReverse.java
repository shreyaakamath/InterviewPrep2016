package spoj.most.solved.probs;

import java.util.*;

/* 
* http://www.spoj.com/problems/ADDREV/
*/

public class NumReverse {

	static int getReverse(int n){
		int reverse = 0;
		int digits =0;
		int remainder = n%10;
		int num=n;
		while(num >0){
			digits++;
			num = num/10;
			remainder = num%10;
		}

		int i=1;remainder = n%10;num=n;
		while(num>0){
			reverse += remainder*(int)Math.pow(10, digits-i);
			i++;
			num = num/10;
			remainder = num%10;
		}
		return reverse;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		int[]n = new int[test];
		int[] m = new int[test];
		for(int i=0;i<test;i++){
			n[i] = scan.nextInt();
			m[i] = scan.nextInt();
		}
		
		for(int i=0;i<test;i++){
			int sum = getReverse(getReverse(n[i]) + getReverse(m[i]));
			System.out.println(sum);
		}
	}
}

