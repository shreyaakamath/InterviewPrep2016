package spoj.most.solved.probs;

import java.util.Scanner;

public class SquareCount {

	public static void main(String[] args) {
		int[] num = new int[100];
		Scanner scan = new Scanner(System.in);
		int val,i=0;
		while(scan.hasNext()){
			val = scan.nextInt();
			if(val==0) break;
			num[i++] = val;
		}
		int n, ans;
		for(int j=0;j<i;j++){
			n = num[j];
			ans = (n*(n+1)*(2*n+1))/6;
			System.out.println(ans);
		}
	}
}
