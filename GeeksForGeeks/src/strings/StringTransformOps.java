package strings;

import java.util.HashMap;
import java.util.Map;

public class StringTransformOps {
	
	static boolean canTransform(String str1 , String str2){
		HashMap<Character,Integer> map1= new HashMap<Character,Integer>();
		HashMap<Character,Integer> map2= new HashMap<Character,Integer>();
		if(str1.length()!=str2.length()) return false;
		//add all chars and counts to a hashmap 
		for(int i=0;i<str1.length();i++){
			char c1=str1.charAt(i);
			char c2=str2.charAt(i);
			if(map1.containsKey(c1)) map1.put(c1,map1.get(c1)+1);
			else map1.put(c1,1);
			if(map2.containsKey(c2)) map1.put(c2,map1.get(c2)+1);
			else map2.put(c2,1);
		}
		
		//check if chars and counts match
		for(Map.Entry<Character,Integer> e : map1.entrySet()){
			char key = e.getKey();
			int val = e.getValue();
			if(map2.containsKey(key)){ 
				if(val==map2.get(key)) continue;
				else return false;
			}
		}
		return true;
	}
	
	//transform one string to another . can only move characters of str1 to the left.
	static boolean transform(String str1 , String str2){
		if(!canTransform(str1,str2)) return false;

		boolean flag=true;
		StringBuilder sb = new StringBuilder(str1);
		int count=0;
		
		for(int i=sb.length()-1;i>=0;i--){
			char c1=sb.charAt(i);
			char c2=str2.charAt(i);
			
			if(c1==c2) continue;
			else{
				int j=i-1;
				while(j>=0 && sb.charAt(j)!=c2) j--;
				if(j<0) return false;
				for(int k=i-1;k>=j;k--) sb.setCharAt(k+1,sb.charAt(k));
				sb.setCharAt(j,c1);
				count++;
			}
		}
		if(flag){
			System.out.println(sb.toString());
			System.out.println(count);
		}	
		return flag;
		
	}
	public static void main(String[] args) {
		transform("eacbd","eabcd");
	}

}
