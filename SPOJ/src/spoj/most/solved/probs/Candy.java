package spoj.most.solved.probs;

import java.util.*;
public class Candy {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> ans = new ArrayList<Integer>();
		while(scan.hasNext()){
			Integer num = scan.nextInt();
			if(num==-1) break;
			int [] arr = new int[num];
			for(int i=0;i<num;i++){
				arr[i] = scan.nextInt();
			}
			int length = arr.length;
			int total=0;
			for(int i:arr) total+=i;
			if(total%length !=0) {ans.add(-1);continue;}
			int ideal = total/length;
			int additions=0;
			for(int i:arr){
				if(i>ideal) {additions += (i-ideal);}
			}
			ans.add(additions);
		}
		for(int i :ans)
		System.out.println(i);
	}
}
