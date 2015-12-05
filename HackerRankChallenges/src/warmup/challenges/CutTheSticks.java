package warmup.challenges;

import java.util.Scanner;

public class CutTheSticks {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] arr = new int[num];
        for(int i =0;i<num;i++) arr[i]= scan.nextInt();
        cutMin(arr);
        }
    static void cutMin(int[] arr){
        int count=0;
        
        int min =arr[0];
        for(int i=1;i<arr.length;i++){
        	if(min == 0 ) min = arr[i];
        	else if(arr[i]<min && arr[i]!=0) min = arr[i];
        }
         
        for(int i=0;i<arr.length;i++) {
            if(arr[i]!=0){
            count++;
            arr[i]=arr[i]-min;
            }
        }
        if(count==0) return;
        System.out.println(count);
        cutMin(arr);
    }

    static int getMinNotZero(int[] array){
    	int length = array.length;
    	for(int i=0;i<length;i++){
    			
    	}
    	return 0;
    }
}
