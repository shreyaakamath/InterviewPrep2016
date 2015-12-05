package spoj.most.solved.probs;

import java.util.Scanner;

public class NumberSteps {

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
			if(m[i]>10000||n[i]>10000) {continue;}
			if(n[i]<0 || m[i]<0) {continue;}
			
			if(n[i]>m[i]) {System.out.println("No Number");continue;}
			if(n[i]%2==0 && m[i]%2==0){
				System.out.println(n[i]+m[i]);continue;
			} else if(n[i]%2!=0 && m[i]%2!=0){
				System.out.println(n[i]+m[i]-1);continue;
			} else {
				System.out.println("No Number");continue;
			}
		}
	}
}

/*if(n[i]==m[i]){
if(n[i]%2==0){
	//same and even 
	System.out.println(n[i]+m[i]);continue;
} else {
	//same and odd 
	System.out.println(m[i]+m[i]-1);continue;
}
}else {
if(n[i]%2==0 && m[i]%2==0){
	//diff and both even
	System.out.println(n[i]+m[i]);continue;
}else if (n[i]%2!=0 && m[i]%2!=0){
	//diff and odd
	System.out.println(m[i]+n[i]-1);continue;
} else{
	//diff and both not even/odd
	System.out.println("No Number");continue;
}
}*/