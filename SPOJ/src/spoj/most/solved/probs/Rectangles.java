package spoj.most.solved.probs;

import java.util.Scanner;

public class Rectangles {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count =0;
		for(int i=1;i<=Math.sqrt(n);i++)
			for(int j=i+1;i*j<=n;j++)
				count++;
		count+=Math.sqrt(n);
		System.out.println(count);
	}
}
