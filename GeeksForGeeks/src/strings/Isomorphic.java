package strings;

import java.util.HashMap;

public class Isomorphic {

	static boolean isomorphic(String str1,String str2){
		HashMap<Character,Character> map = new HashMap<Character,Character>();
		boolean flag=true;
		for(int i=0;i<str1.length();i++){
			char c1 = str1.charAt(i);
			char c2 = str2.charAt(i);
			if(map.containsKey(c1)){
				if(map.get(c1)==c2) continue;
				else{flag=false;break;}
			}
			else {
				map.put(c1,c2);
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		System.out.println(isomorphic("aab","xyz"));
	}

}
