import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NutanixCompression {
	static void splitAndAppend(String word , StringBuilder sb){
		char[] arr=word.toCharArray();
		for(int i=0;i<arr.length;i++){
			sb.append(arr[i]+",");
		}
	}
	static String compress(String[] arr ){
		int j=0;
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<arr.length;i++){
			String str=arr[i];//www.apple.com
			String[] split=str.split("\\.");//www apple com
			int len1=split[0].length();
			int len2=split[0].length();
			int len3=split[0].length();
			int index1=j;
			int index2=index1+len1+1;
			String wordCombo=split[1]+"."+split[2];
			boolean flag=false;
			if(hm.containsKey(str)){
				sb.append("0xc0"+hm.get(str));
				flag=true;
			}else{
				sb.append(len1+",");
				splitAndAppend(split[0],sb);
			}
			if(!flag){
				if(hm.containsKey(wordCombo)){
					sb.append("0xc0"+hm.get(wordCombo));
				}else{
					sb.append(len2+",");
					splitAndAppend(split[1],sb);
					sb.append(len3+",");
					splitAndAppend(split[2],sb);
					hm.put(str,index1);
					hm.put(wordCombo,index2);
				}
			}
			sb.append("$,");
			j+=str.length()+3;
		}
		
		System.out.println(sb.toString());
		for(Map.Entry<String,Integer> e:hm.entrySet()){
			System.out.println(e.getKey());
			System.out.println(e.getValue());
		}
		return sb.toString();
	}
	
	static void decompress(String str){
		str=str.replace(",","");
		
		String[] arr=str.split("\\$");
		System.out.println(arr[0]);
		String regex="^[0-9]+(a-zA-Z)+[0-9]+(a-zA-Z)+[0-9]+(a-zA-Z)+";
		Pattern r = Pattern.compile(regex);
		Matcher m = r.matcher(arr[0]);
		if(m.find()){
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}
		
		/*
		String[] arr=str.split("$");
		StringBuilder op = new StringBuilder();
		int j=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i].substring(0,4)=="0xc0"){
				//get it out of hash
			}else{
				int index1=j;
				String regex="^[0-9]+(a-zA-Z)+[0-9]+(a-zA-Z)+[0-9]+(a-zA-Z)+";
				Pattern r = Pattern.compile(regex);
				Matcher m = r.matcher(arr[i]);
				if(m.find()){
					System.out.println(m.group(0));
					System.out.println(m.group(1));
					System.out.println(m.group(2));
				}
				StringBuilder local = new StringBuilder();
				char[] cArr = arr[i].toCharArray();
				for(int k=0;k<cArr.length;k++){
					if(Character.isDigit(cArr[k])){
						if(k!=0) local.append(".");
					}else{
						local.append(cArr[k]);
					}
				}
			}
		}*/
		
	}
	public static void main(String[] args) {
		String[] arr={"www.apple.com","eng.apple.com"};
//		decompress(compress(arr));
		
	}

}
