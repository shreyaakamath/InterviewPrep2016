package spoj.most.solved.probs;
import java.util.Scanner;

/*
 * http://www.spoj.com/problems/TEST/
 */

public class Universe {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int val;
		while(scan.hasNext()){
			val = scan.nextInt();
			if(val==42) break;
			else System.out.println(val);
		}
	}

}
