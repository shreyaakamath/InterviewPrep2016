package spoj.most.solved.probs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Byteland {

	public static void main(String[] args) throws IOException {
		List<Long> input = new ArrayList<Long>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String val = br.readLine();
		while(val!=null){
			input.add(new Long(val));
			val = br.readLine();
		} 
		LinkedHashMap<Long, Long> memory = new LinkedHashMap<Long, Long>();
		/*for(long i : input) {
			System.out.println(getTotal(i,memory));
		}*/
		}
	
	static long getTotal(long n,LinkedHashMap<Long, Long> memory){
		long total;
		if(n<12) return n;
		if(memory.containsKey(n)) return memory.get(n);
		else {
			long total2,total3,total4;
			total2 = memory.containsKey(n/2) == true ? memory.get(n/2) : getTotal(n/2, memory);
			total3 = memory.containsKey(n/3) == true ? memory.get(n/3) : getTotal(n/3, memory);
			total4 = memory.containsKey(n/4) == true ? memory.get(n/4) : getTotal(n/4, memory);
			total = Math.max(n,total2+total3+total4);
			memory.put(n, total);
		}
		return total;
	}
}


/*
//Scanner scan = new Scanner(System.in).useDelimiter("\\z");
 * //while(scan.hasNext()) {Long n = scan.nextLong(); input.add(n);}
 */
