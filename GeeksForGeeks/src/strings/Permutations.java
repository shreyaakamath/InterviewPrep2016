package strings;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	//in order permutation generation -> longer , stringbuilder not needed here 
	static List<StringBuilder> getPerms(StringBuilder sb){
		int len = sb.length();
		List<StringBuilder> list = new ArrayList<StringBuilder>();
		if(len==1) {list.add(sb);return list;}
		for(int i= 0;i<sb.length();i++){
			char single = sb.charAt(i);
			StringBuilder newsb = new StringBuilder();
			if(i==0)
				for(int k=1;k<len;k++) newsb.append(sb.charAt(k)); 
			else {
				for(int k=0;k<i;k++)
					newsb.append(sb.charAt(k)); 
				for(int k=i+1;k<len;k++)
					newsb.append(sb.charAt(k));
			}
			String newStr =sb.substring(0,i) + sb.substring(i+1,len);
			List<StringBuilder> ans = getPerms(newsb);
			for(StringBuilder temp : ans){
				temp.insert(0,single);
				list.add(temp);
			}
		}
		return list;
	}
	
	//in order pemutations -> short and clean 
	static List<String> getPerms1(String sb){
		int len = sb.length();
		List<String> list = new ArrayList<String>();
		String newStr;char single;
		
		if(len==1) {list.add(sb);return list;}
		for(int i= 0;i<sb.length();i++){
			single = sb.charAt(i);
			newStr =sb.substring(0,i) + sb.substring(i+1);
			for(String temp : getPerms1(newStr)) list.add(single+temp);
		}
		return list;
	}
	
	public static void main(String[] args) {
		List<String> list = getPerms1("abcde");
		for(String sb : list)
			System.out.println(sb.toString());
	}

}
