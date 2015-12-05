package spoj.most.solved.probs;

import java.util.*;

/*
 * http://www.spoj.com/problems/TOANDFRO/
 */

public class ToAndFro {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		while(scan.hasNext()){
			int val = scan.nextInt();
			if(val==0) break;
			String str = scan.next();
			map.put(val, str);
		}
		
		for(int column : map.keySet()){
			String str = map.get(column);
			int length = str.length();
			int row = length/column;
			for(int i =0;i<column;i++){
				int ptr =i;
				System.out.print(str.charAt(ptr));
				int oneWayDiff;
				int totalDiff;
				for(int round =2;round<=row;round++){
					if(round%2!=0){
						oneWayDiff = i;
						totalDiff = (oneWayDiff*2) +1;
						ptr+=totalDiff;
						System.out.print(str.charAt(ptr));
					} else{
						oneWayDiff =column -(i+1);
						totalDiff = (oneWayDiff*2) +1;
						ptr +=totalDiff;
						System.out.print(str.charAt(ptr));
					}
				}
			}
			System.out.println();
		}
		
	}

}
