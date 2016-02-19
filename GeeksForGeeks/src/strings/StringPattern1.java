package strings;

import java.util.ArrayList;
import java.util.List;
public class StringPattern1 {

	//simple naive implementation. slide pattern one element at a time and check for match . complexity o(m*(n-m+1))
	static  List<Integer> pattern(String m , String n){
		List<Integer> list = new ArrayList<Integer>();
		int lenM=m.length();
		int lenN=n.length();
		for(int i=0;i<=lenM-lenN;i++){
			int j;
			for(j=0;j<lenN;j++){
				if(m.charAt(i+j) != n.charAt(j)) break;
			}
			if(j==lenN) list.add(i);
		}
		return list;
	}
	public static void main(String[] args) {
		
		for(int n : pattern("AABAACAADAABAABAA","AABA"))
			System.out.println(n);
	}

}
