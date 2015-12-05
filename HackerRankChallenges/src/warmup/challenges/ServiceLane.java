package warmup.challenges;

import java.util.Scanner;

public class ServiceLane {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan  = new Scanner(System.in);
        int segments = scan.nextInt();
        int cases = scan.nextInt();
        int[] width = new int[segments];
        for(int i=0;i<segments;i++)
            width[i] = scan.nextInt();
        for(int m =0;m<cases;m++){
            int i = scan.nextInt();
            int j = scan.nextInt();
            int min = width[i];
            for(int n=i;n<=j;n++){
                if(width[n]<min) min = width[n];
            }
            System.out.println(min);
        }
    }
}
