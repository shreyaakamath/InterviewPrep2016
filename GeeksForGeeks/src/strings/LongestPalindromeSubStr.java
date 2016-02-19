package strings;

import java.util.HashSet;
import java.util.Set;

/**
 *1) http://www.geeksforgeeks.org/longest-palindromic-substring-set-2/ 
 * complexity time o(n2) space o(1)
 * 
 * 2)http://www.geeksforgeeks.org/find-number-distinct-palindromic-sub-strings-given-string/
 * @author shreyakamath
 *
 */
public class LongestPalindromeSubStr {
	

	static void set2(String str){
		int low;
		int high;
		int len=str.length();
		int pal=0;
		int start=0; int end=0;
		Set<String> set = new HashSet<String>();
		for(int i=0;i<len;i++){
			//find palindrome of odd length
			low=i-1;
			high=i+1;
			StringBuilder sb = new StringBuilder();
			while(low>=0 && high<len && str.charAt(low)==str.charAt(high)){
				if(high-low+1 > pal){
					pal = high-low+1;
					start=low;end=high;
				}
				low--;high++;
			}
			
			//find palindrome of even length
			low =i-1;
			high=i;
			while(low>=0 && high<=len && str.charAt(low)==str.charAt(high)){
				if(high-low+1 > pal){
					pal = high-low+1;
					start=low;end=high;
				}
				low--;high++;
			}
		}
		System.out.println("length ="+pal);
		for(int i=start;i<=end;i++)
			System.out.print(str.charAt(i));
	}
	
	static void uniquePalSubstr(String str){
		int low;
		int high;
		int len=str.length();
		int pal=0;
		int start=0; int end=0;
		Set<String> set = new HashSet<String>();
		for(int i=0;i<len;i++){
			set.add(""+str.charAt(i));
			//find palindrome of odd length
			low=i-1;
			high=i+1;
			StringBuilder sb = new StringBuilder();
			while(low>=0 && high<len && str.charAt(low)==str.charAt(high)){
				for(int j=low;j<=high;j++)
					sb.append(str.charAt(j));
				set.add(sb.toString());
				
				if(high-low+1 > pal){
					pal = high-low+1;
					start=low;end=high;
				}
				low--;high++;
			}
			
			//find palindrome of even length
			low =i-1;
			high=i;
			while(low>=0 && high<=len && str.charAt(low)==str.charAt(high)){
				for(int j=low;j<=high;j++)
					sb.append(str.charAt(j));
				set.add(sb.toString());
				
				if(high-low+1 > pal){
					pal = high-low+1;
					start=low;end=high;
				}
				low--;high++;
			}
		}
		
		for(String s : set)
			System.out.println(s);
	}
	
	public static void main(String[] args) {
//		set2("geeksskeeg");
		uniquePalSubstr("aba");
		
	}

}
