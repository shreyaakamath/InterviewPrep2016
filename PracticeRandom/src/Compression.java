
public class Compression {
	
	static void compress(String str){
		for(int i=0;i<str.length();i++){
			char c=str.charAt(i);
			int k=i+1;
			int cnt=1;
			while(k<str.length() && str.charAt(k)==c){k++;cnt++;}
			if(k-i!=1) str=str.substring(0,i+1)+cnt+str.substring(k);
		}
		System.out.println(str);
	}
	public static void main(String[] args) {
		compress("aabbbbbbbbcc");
	}

}
